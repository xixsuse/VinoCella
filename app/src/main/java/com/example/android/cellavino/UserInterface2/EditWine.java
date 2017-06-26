package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.MainActivity;
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
 * Created by Andrew on 25/06/2017.
 */

public class EditWine extends MainActivity {

    public FirebaseAuth mFirebaseAuth;
    private Firebase mWineInformationRef;
    private ValueEventListener mUpdateWineInformation;
    private Firebase mWineNameRef;

    private static final String LOG_TAG = EditWine.class.getSimpleName();
    private String mWinePushID;
    public TextView mUpdateWineName;
    public TextView mUpdateWineWinery;
    public TextView mUpdateWineVintage;
    public TextView mUpdateWineVariety;
    public TextView mUpdateWineTastingDate;
    public TextView mUpdateWineDescription;
    public Button mUpdateWine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        mWinePushID = bundle.getString("thisWinePushID");
        setContentView(R.layout.create_new_wine);
        setTitle("Edit Wine");

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();

        Firebase wineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID);
        mWineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID);
        Firebase myWinesRefLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_WINES).child(mWinePushID);


        mUpdateWineVintage = (TextView) findViewById(R.id.create_wine_year);
        mUpdateWineName = (TextView) findViewById(R.id.create_wine_name);
        mUpdateWineWinery = (TextView) findViewById(R.id.create_wine_winery);
        mUpdateWineVariety = (TextView) findViewById(R.id.create_wine_variety);
        mUpdateWineTastingDate = (TextView) findViewById(R.id.create_wine_tasting_date);
        mUpdateWineDescription = (TextView) findViewById(R.id.create_wine_description);
        mUpdateWine = (Button) findViewById(R.id.create_new_wine_button);

        //set the click listener on the button that  pushes wine into the database
        mUpdateWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWineToDatabase();
            }
        });

        mUpdateWineInformation = mWineNameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                WinePojo winePojo = snapshot.getValue(WinePojo.class);
                if (winePojo == null) {
                    finish();
                    return;
                }

                mUpdateWineVintage.setText(winePojo.getWineVintage());
                mUpdateWineName.setText(winePojo.getWineName());
                mUpdateWineWinery.setText(winePojo.getWineWinery());
                mUpdateWineVariety.setText(winePojo.getWineVariety());
                mUpdateWineTastingDate.setText(winePojo.getWineTastingDate());
                mUpdateWineDescription.setText(winePojo.getWineDescription());
                mUpdateWine.setText("Update Wine");

            }


            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(LOG_TAG,
                        getString(R.string.app_not_available) + firebaseError.getMessage());
            }
        });


    }


    public void addWineToDatabase() {
        //get the reference to the Firebase URL, then get the string that user has entered and push that into the Database.
        // Get the dtails that the user has entered and pass them into a string.
        String updatedWineName = mUpdateWineName.getText().toString();
        String updatedWineWinery = mUpdateWineWinery.getText().toString();
        String updatedWineVintage = mUpdateWineVintage.getText().toString();
        String updatedWineVariety = mUpdateWineVariety.getText().toString();
        String updatedWineTastingDate = mUpdateWineTastingDate.getText().toString();
        String updatedWineDescription = mUpdateWineDescription.getText().toString();

        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();
        //String userName = user.getDisplayName().toString();
        //String taster = user.getDisplayName().toString();

        if (!mUpdateWineName.equals("")) {
            //Write the wine details to the main wine database.

            Firebase wineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID);
            Firebase myWinesRefLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_WINES).child(mWinePushID);

            mWineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID);

            HashMap<String, Object> updatedWineDetailsMap = new HashMap<String, Object>();

            // Add the new name to the update map
            updatedWineDetailsMap.put("/" + Constants.FIREBASE_PROPERTY_WINE_NAME, updatedWineName);

            //Replace this bit with the updated date, vintage, grape type etc.
            // Add the new vintage to the update map
            updatedWineDetailsMap.put("/" + Constants.FIREBASE_PROPERTY_WINE_VINTAGE, updatedWineVintage);
            updatedWineDetailsMap.put("/" + Constants.FIREBASE_PROPERTY_WINE_VARIETY, updatedWineVariety);
            updatedWineDetailsMap.put("/" + Constants.FIREBASE_PROPERTY_WINE_WINERY, updatedWineWinery);
            updatedWineDetailsMap.put("/" + Constants.FIREBASE_PROPERTY_WINE_TASTING_DATE, updatedWineTastingDate);
            updatedWineDetailsMap.put("/" + Constants.FIREBASE_PROPERTY_WINE_DESCRIPTION, updatedWineDescription);

            //Add the time Changed to the map
            HashMap<String, Object> changedTimestampMap = new HashMap<>();
            changedTimestampMap.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);
            // Add the updated timestamp
            updatedWineDetailsMap.put("/" + Constants.FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED, changedTimestampMap);


            wineNameRef.updateChildren(updatedWineDetailsMap, new Firebase.CompletionListener() {
                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    if (firebaseError != null) {
                        Log.e(LOG_TAG, "Error updating name in master list: " + firebaseError.getMessage());
                    }
                }
            });

            myWinesRefLocation.updateChildren(updatedWineDetailsMap, new Firebase.CompletionListener() {
                @Override
                public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                    if (firebaseError != null) {
                        Log.e(LOG_TAG, "Error updating name in my wines: " + firebaseError.getMessage());
                    }
                }
            });

            //This then resets the text to blank.
            mUpdateWineName.setText("");
            mUpdateWineWinery.setText("");
            mUpdateWineVintage.setText("");
            mUpdateWineVariety.setText("");
            mUpdateWineTastingDate.setText("");
            mUpdateWineDescription.setText("");


        } else {
            Toast.makeText(EditWine.this, "At least give us a name!", Toast.LENGTH_SHORT).show();
        }


        //Send the user back the the wine list.  They'll be able to see all the wines they're recently added.


        Intent MyWinesList = new Intent(EditWine.this, MyWinesList.class);
        // Start the new activity
        startActivity(MyWinesList);

    }

}
