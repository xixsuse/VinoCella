package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.PojoDirectory.UI2.SpecificWineDetailsPojo;
import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ServerValue;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;


/**
 * Created by Andrew on 14/04/2017.
 */

public class WineInformation extends MainActivity {

    private static final String LOG_TAG = WineInformation.class.getSimpleName();
    private String mWinePushID;
    private WineInformationAdapter mWineInformationAdapter;
    private ValueEventListener mActiveWineInformation;
    private ValueEventListener mUpdateWineInformation;
    private SpecificWineDetailsPojo mSpecificWineDetailsPojo;
    private Firebase mWineInformationRef;
    private Firebase mWineNameRef;
    private FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wine_item);

        mFirebaseAuth = FirebaseAuth.getInstance();

        Intent intent = this.getIntent();
        mWinePushID = intent.getStringExtra(Constants.WINE_LIST_ID);
        if (mWinePushID == null) {
            finish();
            return;
        }

        mWineInformationRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID);
        Firebase specificWineDetails = new Firebase(Constants.FIREBASE_URL_LOCATION_THIS_WINE_DETAILS).child(mWinePushID);

        mActiveWineInformation = mWineInformationRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //Save the most recent version of current shopping list into mShoppingList instance variable an update the UI to match the current list.

                WinePojo winePojo = snapshot.getValue(WinePojo.class);
                if (winePojo == null) {
                    finish();
                    return;
                }

                //Initialise the Views with the fields
                TextView mViewWineVariety = (TextView) findViewById(R.id.view_wine_variety);
                TextView mViewWineWinery = (TextView) findViewById(R.id.view_wine_winery);
                TextView mViewWineDateTasted = (TextView) findViewById(R.id.view_wine_date_tasted);
                TextView mViewWineDescription = (TextView) findViewById(R.id.view_wine_description);

                /* Calling invalidateOptionsMenu causes onCreateOptionsMenu to be called*/
                invalidateOptionsMenu();

                /* Set title to display the Vintage and Wine Name.*/
                setTitle(winePojo.getWineVintage() + " " + winePojo.getWineName());

                /* Set all the wine details the user will want to view.*/
                mViewWineWinery.setText(winePojo.getWineWinery());
                mViewWineVariety.setText(winePojo.getWineVariety());
                mViewWineDateTasted.setText(winePojo.getWineTastingDate());
                mViewWineDescription.setText(winePojo.getWineDescription());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(LOG_TAG,
                        getString(R.string.app_not_available) + firebaseError.getMessage());
            }

        });


        //Initialsie the Delete Item Floating Action Buttons, so that it an on click listener can be set on it.
        FloatingActionButton buttonDeleteWine = (FloatingActionButton) findViewById(R.id.delete_my_wine);
        FloatingActionButton buttonEditWine = (FloatingActionButton) findViewById(R.id.edit_my_wine);
        //final String wineToRemoveId = this.getRef(position).getKey();

        //Set the onClickListener for remove wine.
        buttonDeleteWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WineInformation.this, "Wine Deleted", Toast.LENGTH_SHORT).show();
                //TODO: Remove the Toast Message and replace with a "Are your sure" pop up.
                //TODO: Ensure the user has permission to delete.
                removeWine();
            }
        });

        buttonEditWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Add in editability functionality.
                editWine();
            }
        });
    }

    private void removeWine() {

        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();

        HashMap<String, Object> removeWineData = new HashMap<String, Object>();
        removeWineData.put("/" + Constants.FIREBASE_LOCATION_WINE_DETAILS + "/" + mWinePushID, null);

        HashMap<String, Object> removeWineDataTwo = new HashMap<String, Object>();
        removeWineDataTwo.put(("/" + Constants.FIREBASE_LOCATION_USERS + "/" + uid + "/" + Constants.FIREBASE_MY_WINES + "/" + mWinePushID), null);

        Firebase firebaseRef = new Firebase(Constants.FIREBASE_URL);
        Firebase firebaseRefTwo = new Firebase(Constants.FIREBASE_URL);

        firebaseRef.updateChildren(removeWineData, new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                if (firebaseError != null) {
                    Log.e(LOG_TAG, "Error updating Master List: " + firebaseError.getMessage());
                }
            }
        });

        firebaseRefTwo.updateChildren(removeWineDataTwo, new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                if (firebaseError != null) {
                    Log.e(LOG_TAG, "Error updating My List: " + firebaseError.getMessage());
                }
            }
        });

    }

    private void editWine() {
        Intent EditWine = new Intent(WineInformation.this, EditWine.class);
        //Toast.makeText(WineInformation.this, mWinePushID, Toast.LENGTH_SHORT).show();
        EditWine.putExtra("thisWinePushID", mWinePushID);
        // Start the new activity
        startActivity(EditWine);
    }
}

