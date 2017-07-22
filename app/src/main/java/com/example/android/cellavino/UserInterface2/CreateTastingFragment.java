package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.cellavino.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Andrew on 15/07/2017.
 */

public class CreateTastingFragment extends Fragment {

    private ListView mListView;
    private WineInformationAdapter mWineInformationAdapter;
    private String mWineId;
    public FirebaseAuth mFirebaseAuth;

    public CreateTastingFragment() {
        //This is the required empty class
    }

    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static CreateTastingFragment newInstance() {
        CreateTastingFragment fragment = new CreateTastingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {


        }
        //TODO: Add a message that says 'no wines found' if the list items equal zero.
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //this will initialise the UI view elements, allow the wine details to be populated into the list view.
        View rootView = inflater.inflate(R.layout.my_wines_list, container, false);
        initializeScreen(rootView);


        return rootView;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.my_wine_list_view);
    }

}
