package com.example.android.cellavino.UserInterface2.JoinTasting;

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
import com.example.android.cellavino.UserInterface2.CreateTasting.MyTastingsAdapter;
import com.example.android.cellavino.UserInterface2.CreateTasting.TastingWinesAdapter;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Andrew on 16/08/2017.
 */

public class JoinTastingWinesFragment extends Fragment {

    private String mTastingListId;
    public FirebaseAuth mFirebaseAuth;
    private Firebase mWineTastingReference;
    private TastingWinesAdapter mTastingWinesAdapter;
    private ListView mListView;


    public JoinTastingWinesFragment() {
    }

    public static JoinTastingWinesFragment newInstance() {
        JoinTastingWinesFragment fragment = new JoinTastingWinesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new JoinTastingFragment()).commit();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getActivity().getIntent();
        //tasting_listId
        mTastingListId = intent.getStringExtra(Constants.TASTING_LIST_ID);
        if (mTastingListId == null) {
            //finish();
            Toast.makeText(getActivity(), "No Tasting Details", Toast.LENGTH_SHORT).show();
            //getActivity().finish();
            //return;
        }
        if (mTastingListId != null) {
            Toast.makeText(getActivity(), "Tastings Found", Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO: Add a message that says 'no wines found' if the list items equal zero.


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.my_tastings_list, container, false);
        initializeScreen(rootView);

        Toast.makeText(getActivity(), "The list will be on this screen", Toast.LENGTH_SHORT).show();

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();
        String tastingListId = mTastingListId.toString();

        mWineTastingReference = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(tastingListId);
        final Firebase tastingListRef = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(tastingListId);

        mTastingWinesAdapter = new TastingWinesAdapter(getActivity(), WineTastingPojo.class, R.layout.tasting_wines_details, tastingListRef, mTastingListId);
        mListView.setAdapter(mTastingWinesAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WineTastingPojo selectedWine = mTastingWinesAdapter.getItem(position);
                if (selectedWine != null) {
                    Toast.makeText(getActivity(), "Retrieving Wine: " + selectedWine, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), TastingWineInput.class);
                    String listId = mTastingWinesAdapter.getRef(position).getKey();
                    intent.putExtra(Constants.WINE_LIST_ID, listId);
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
        mListView = (ListView) rootView.findViewById(R.id.my_tastings_list_view);

    }


}

