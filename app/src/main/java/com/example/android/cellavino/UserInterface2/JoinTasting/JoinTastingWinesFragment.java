package com.example.android.cellavino.UserInterface2.JoinTasting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Andrew on 16/08/2017.
 */

public class JoinTastingWinesFragment extends Fragment {

    private static final String LOG_TAG = JoinTastingWinesFragment.class.getSimpleName();
    private String mTastingListId;
    public FirebaseAuth mFirebaseAuth;
    private Firebase mWineTastingReference;
    private DatabaseReference mWineTastingDatabaseReference;
    public FirebaseDatabase mTastingWineDatabase;
    public String mTastingWineDetailsString;
    private TastingWinesAdapter mTastingWinesAdapter;
    private ListView mListView;
    public ValueEventListener mTastingWineDetailsListener;

    public String mWineName;
    public String mWineVintage;


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
            //getActivity().finish();
            //return;
        }
        if (mTastingListId != null) {
            return;
        }


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.my_tastings_list, container, false);
        initializeScreen(rootView);

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();
        final String tastingListId = mTastingListId.toString();

        mWineTastingReference = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(tastingListId);
        final Firebase tastingListRef = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(tastingListId);

        mTastingWinesAdapter = new TastingWinesAdapter(getActivity(), WineTastingPojo.class, R.layout.tasting_wines_details, tastingListRef, mTastingListId);
        mListView.setAdapter(mTastingWinesAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WineTastingPojo selectedWine = mTastingWinesAdapter.getItem(position);


                if (selectedWine != null) {

                    String listId = mTastingWinesAdapter.getRef(position).getKey();


                    onItemSelected(tastingListId, listId);

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

    public void onItemSelected(String tastingListId, String listId) {


        Intent intent = new Intent(getActivity(), TastingWineInput.class);

        intent.putExtra(Constants.WINE_LIST_ID, listId);
        intent.putExtra(Constants.TASTING_LIST_ID, tastingListId);

        startActivity(intent);
    }



}

