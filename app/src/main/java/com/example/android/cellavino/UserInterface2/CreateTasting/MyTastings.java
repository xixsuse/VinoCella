package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_MY_TASTINGS;

/**
 * Created by Andrew on 15/07/2017.
 */


public class MyTastings extends MainActivity {

    private Button mCreateTastingButton;
    private String mTastingName;

    public FirebaseAuth mFirebaseAuth;

    public MyTastings() {
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyTastingsFragment()).commit();

        mFirebaseAuth = FirebaseAuth.getInstance();

        final FirebaseUser user = mFirebaseAuth.getCurrentUser();
        final String uid = user.getUid().toString();
        final String userName = user.getDisplayName().toString();

        //initialise the Floating Action Button in this fragment.
        FloatingActionButton addWineFab = (FloatingActionButton) findViewById(R.id.addWineFab);
        addWineFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MyTastings.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_create_tasting, null);
                final EditText mTastingNameInput = (EditText) mView.findViewById(R.id.dialog_create_tasting_name_input);
                alertDialogBuilder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!mTastingNameInput.getText().toString().isEmpty()) {
                            String mTastingName = mTastingNameInput.getText().toString();
                            addWineTastingPicture(mTastingName, uid, userName);

                        } if (mTastingNameInput.getText().toString().isEmpty()) {
                            Toast.makeText(MyTastings.this, "You've got to name a tasting first!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                alertDialogBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alertDialogBuilder.setView(mView);
                AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();
            }

        });
    }


    //TODO: replace with with a create winetasting screen "create_new_wine_tasting_summary"
    //This will allow the user to add a picture of the set of wines they are about to taste
    private void addWineTastingPicture(String mTastingName, String uid, String userName) {

        final String mMTastingName = mTastingName.toString();
        final String mUid = uid.toString();
        final String mUserName = userName.toString();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MyTastings.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_add_wine_tasting_photo, null);
        alertDialogBuilder.setPositiveButton("Add Picture", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                createTastingInFirebase(mMTastingName, mUid, mUserName);
            }
        });

        alertDialogBuilder.setNegativeButton("Skip", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                createTastingInFirebase(mMTastingName, mUid, mUserName);

            }
        });

        alertDialogBuilder.setView(mView);
        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();

    }


    private void createTastingInFirebase(String mMTastingName, String mUid, String mUserName) {

        Firebase tastingRef = new Firebase(Constants.FIREBASE_URL_TASTINGS);
        Firebase tastingFirebaseRef = tastingRef.push();
        final String tastingPushID = tastingFirebaseRef.getKey();


        Firebase myTastingsLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(mUid).child(FIREBASE_MY_TASTINGS).child(tastingPushID).child(Constants.FIREBASE_TASTING_NAME);
        myTastingsLocation.setValue(mMTastingName);
        Firebase myTastingsLocationOwner = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(mUid).child(FIREBASE_MY_TASTINGS).child(tastingPushID).child(Constants.FIREBASE_OWNER);
        myTastingsLocationOwner.setValue(mUserName);


        //TODO: Save details of when the tasting was created and who by etc.
        //HashMap<String, Object> myTastingName = new HashMap<>();
        //myTastingName.put(mTastingName, ServerValue.TIMESTAMP);

        //TODO: This is where I should add the second AlertDialogBuilder, a positive response will direct people
        //TODO: cont.. to upload an image, a negative response will simply dismiss the dialog.

        Intent CreateTasting = new Intent(MyTastings.this, CreateNewTasting.class);
        CreateTasting.putExtra("thisTastingName", mMTastingName);
        CreateTasting.putExtra("thisTastingPushID", tastingPushID);

        startActivity(CreateTasting);


    }

}

