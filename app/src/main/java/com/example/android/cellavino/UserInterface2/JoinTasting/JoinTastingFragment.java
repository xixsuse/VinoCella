package com.example.android.cellavino.UserInterface2.JoinTasting;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.WineTastingListPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface2.CreateTasting.MyTastingsAdapter;
import com.example.android.cellavino.UserInterface2.CreateTasting.TastingWines;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_MY_TASTINGS;


/**
 * Created by Andrew on 13/08/2017.
 */

public class JoinTastingFragment extends Fragment {

    private String mWineTastingId;
    public FirebaseAuth mFirebaseAuth;
    private Firebase myWinesTastingReference;
    private MyTastingsAdapter mMyTastingsAdapter;
    private ListView mListView;


    //This is the required empty class
    public JoinTastingFragment() {
    }

    public static JoinTastingFragment newInstance() {
        JoinTastingFragment fragment = new JoinTastingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getActivity().getIntent();
        mWineTastingId = intent.getStringExtra(Constants.TASTING_ID);
        if (mWineTastingId == null) {
            //finish();
            //getActivity().finish();
            //return;
        }
        if (mWineTastingId != null) {
            return;
        }

        //TODO: Add a message that says 'no wines found' if the list items equal zero.


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.my_tastings_list, container, false);
        initializeScreen(rootView);

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();

        myWinesTastingReference = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_TASTINGS);
        final Firebase tastingRef = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(FIREBASE_MY_TASTINGS);

        mMyTastingsAdapter = new MyTastingsAdapter(getActivity(), WineTastingListPojo.class, R.layout.tasting_details, tastingRef, mWineTastingId);
        mListView.setAdapter(mMyTastingsAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WineTastingListPojo selectedTasting = mMyTastingsAdapter.getItem(position);
                if (selectedTasting != null) {
                    Intent intent = new Intent(getActivity(), JoinTastingWines.class);
                    String tasting_listId = mMyTastingsAdapter.getRef(position).getKey();
                    Toast.makeText(getActivity(), tasting_listId, Toast.LENGTH_SHORT).show();
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
