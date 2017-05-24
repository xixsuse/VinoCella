package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.PojoDirectory.UI2.SpecificWineDetailsPojo;
import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


/**
 * Created by Andrew on 14/04/2017.
 */

public class WineInformation extends MainActivity {

    private static final String LOG_TAG = WineInformation.class.getSimpleName();
    private ListView mListView;
    private WinePojo mWinePojo;
    private String mWinePushID;
    private MyWineAdapter mMyWineAdapter;
    private Firebase mWineInformation;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wine_item);

        Intent intent = this.getIntent();
        mWinePushID = intent.getStringExtra(Constants.WINE_LIST_ID);
        if (mWinePushID == null) {
            finish();
            return;
        }


        mWineInformation = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID);
        Firebase specificWineDetails = new Firebase(Constants.FIREBASE_URL_LOCATION_THIS_WINE_DETAILS).child(mWinePushID);

/*
        //TODO udpate this to run through the adapter correctly.
        mMyWineAdapter = new MyWineAdapter(this, SpecificWineDetailsPojo.class, R.layout.my_wine_item, specificWineDetails, mWinePushID);
        mListView.setAdapter(mMyWineAdapter);
*/

        mWineInformation.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //Save the most recent version of current shopping list into mShoppingList instance variable an update the UI to match the current list.

                WinePojo winePojo = snapshot.getValue(WinePojo.class);
                if (winePojo == null) {
                    finish();
                    return;
                }

                mWinePojo = winePojo;

                /*
                //TODO update this to set the wineName as what's been input
                mMyWineAdapter.setWineInformation(mWinePojo);

                /* Calling invalidateOptionsMenu causes onCreateOptionsMenu to be called*/
                invalidateOptionsMenu();

                /* Set title appropriately.*/
                setTitle(winePojo.getWineVintage() + " " + winePojo.getWineName());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(LOG_TAG,
                        getString(R.string.app_not_available) + firebaseError.getMessage());
            }


        });

    }
}

