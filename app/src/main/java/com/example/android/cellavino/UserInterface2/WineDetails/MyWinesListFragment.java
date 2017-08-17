package com.example.android.cellavino.UserInterface2.WineDetails;

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
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Andrew on 14/05/2017.
 * The MyWinesListFragment will extend the fragment class and display all the details of the wine that I'd like people to see on a summary screen.
 * When the click on a wine it will hand over to the WineInformationAdapter and use the WineInformation Class to populate it.
 */

public class MyWinesListFragment extends Fragment {

    private ListView mListView;
    private WineInformationAdapter mWineInformationAdapter;
    private String mWineId;
    public FirebaseAuth mFirebaseAuth;

    public MyWinesListFragment() {
        //This is the required empty class
    }

    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static MyWinesListFragment newInstance() {
        MyWinesListFragment fragment = new MyWinesListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Initialize instance variables with data from bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        //TODO: Add a message that says 'no wines found' if the list items equal zero.
        //Intent intent = new Intent(context, );
        //mWineId = intent.getStringExtra(Constants.WINE_LIST_ID);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //this will initialise the UI view elements, allow the wine details to be populated into the list view.
        View rootView = inflater.inflate(R.layout.my_wines_list, container, false);
        initializeScreen(rootView);

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();

        Firebase newWinesReference = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_WINES);

        mWineInformationAdapter = new WineInformationAdapter(getActivity(), WinePojo.class, R.layout.wine_details, newWinesReference, mWineId);
        // set the adapter to the actual list view in the app.
        mListView.setAdapter(mWineInformationAdapter);

        /**
         * Set interactive bits, such as click events and adapters
         */

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WinePojo selectedWine = mWineInformationAdapter.getItem(position);
                if (selectedWine != null) {
                    Toast.makeText(getActivity(), "Retrieving Wine", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), WineInformation.class);
                    String listId = mWineInformationAdapter.getRef(position).getKey();
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
        mWineInformationAdapter.cleanup();

    }

    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.my_wine_list_view);
    }


}
