package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.WineTastingPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Andrew on 10/08/2017.
 */

public class TastingWinesFragment extends Fragment {

    private String mTastingWineList;
    public FirebaseAuth mFirebaseAuth;
    public ListView mListView;
    private TastingWinesAdapter mTastingWinesAdapter;
    private Firebase myTastingWinesReference;

    //This is the required empty class
    public TastingWinesFragment() {
    }


    // * Create fragment and pass bundle with data as it's arguments
    // * Right now there are not arguments...but eventually there will be.
    public static TastingWinesFragment newIntance() {

        TastingWinesFragment fragment = new TastingWinesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getActivity().getIntent();
        mTastingWineList = intent.getStringExtra(Constants.TASTING_LIST_ID);
        if (mTastingWineList == null) {
            //finish();
            //getActivity().finish();
            //return;
        }

        if (mTastingWineList != null) {
            return;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //this will initialise the UI view elements, allow the wine details to be populated into the list view.

        View rootView = inflater.inflate(R.layout.tasting_wines_list, container, false);
        initializeScreen(rootView);

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();
        String userDisplayName = user.getDisplayName();
        String tastingID = mTastingWineList.toString();


        myTastingWinesReference = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(tastingID);
        final Firebase tastingWinesRef = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(tastingID);

        mTastingWinesAdapter = new TastingWinesAdapter(getActivity(), WineTastingPojo.class, R.layout.tasting_wines_details, tastingWinesRef, mTastingWineList);
        mListView.setAdapter(mTastingWinesAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WineTastingPojo selectedWine = mTastingWinesAdapter.getItem(position);
                if (selectedWine != null) {
                    String tasting_wineId = mTastingWinesAdapter.getRef(position).getKey();
                    Intent intent = new Intent(getActivity(), TastingWineDetails.class);
                    intent.putExtra(Constants.TASTING_WINE_ID, tasting_wineId);
                    startActivity(intent);

                } else
                    Toast.makeText(getActivity(), "Click Failed", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mTastingWinesAdapter.cleanup();
    }


    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.tastings_wine_view);
        //mListView = (ListView) rootView.findViewById(R.id.my_wine_list_view);
    }

}

