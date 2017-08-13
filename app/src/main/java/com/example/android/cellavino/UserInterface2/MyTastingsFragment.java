package com.example.android.cellavino.UserInterface2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastingListPojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastingPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_LOCATION_THIS_WINE_DETAILS;
import static com.example.android.cellavino.Utils.Constants.FIREBASE_MY_TASTINGS;

/**
 * Created by Andrew on 15/07/2017.
 */


//I've copied this straight from the MyWinesListFragment and need to adjust it appropriately.

public class MyTastingsFragment extends Fragment {

    private ListView mListView;
    private MyTastingsAdapter mMyTastingsAdapter;
    private String mTastingId;
    private Firebase myTastingsReference;
    private Firebase tastingsReference;
    private String tastingPushID;
    private DatabaseReference mTastingRef;
    public FirebaseAuth mFirebaseAuth;
    public Toast mToast;

    public MyTastingsFragment() {
        //This is the required empty class
    }

    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static MyTastingsFragment newInstance() {
        MyTastingsFragment fragment = new MyTastingsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getActivity().getIntent();
        mTastingId = intent.getStringExtra(Constants.TASTING_ID);
        if (mTastingId == null) {
            //finish();
            Toast.makeText(getActivity(), "No Tasting Details", Toast.LENGTH_SHORT).show();
            //getActivity().finish();
            //return;
        }
        if (mTastingId != null) {
            Toast.makeText(getActivity(), "Tastings Found", Toast.LENGTH_SHORT).show();
            return;
        }


        //TODO: Add a message that says 'no wines found' if the list items equal zero.
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //this will initialise the UI view elements, allow the wine details to be populated into the list view.

        View rootView = inflater.inflate(R.layout.my_tastings_list, container, false);
        initializeScreen(rootView);

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();

        myTastingsReference = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_TASTINGS);
        final Firebase tastingRef = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(FIREBASE_MY_TASTINGS);

        mMyTastingsAdapter = new MyTastingsAdapter(getActivity(), WineTastingListPojo.class, R.layout.tasting_details, tastingRef, mTastingId);
        mListView.setAdapter(mMyTastingsAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WineTastingListPojo selectedTasting = mMyTastingsAdapter.getItem(position);
                if (selectedTasting != null) {
                    Intent intent = new Intent(getActivity(), TastingWines.class);
                    String tasting_listId = mMyTastingsAdapter.getRef(position).getKey();
                    intent.putExtra(Constants.TASTING_LIST_ID, tasting_listId);
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
        mMyTastingsAdapter.cleanup();
    }

    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.my_tastings_list_view);
        //mListView = (ListView) rootView.findViewById(R.id.my_wine_list_view);

    }


}
