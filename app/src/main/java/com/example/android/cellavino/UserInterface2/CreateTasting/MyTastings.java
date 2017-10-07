package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.PojoDirectory.UI2.TastingDetailsPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_MY_TASTINGS;
import static com.example.android.cellavino.Utils.Constants.FIREBASE_TASTING_NAME;
import static com.example.android.cellavino.Utils.Constants.FIREBASE_URL_EVERYONE_TASTING;
import static com.example.android.cellavino.Utils.Constants.LOCATION_PICKER_REQUEST;
import static com.example.android.cellavino.Utils.Constants.TASTING_GEO;


/**
 * Created by Andrew on 15/07/2017.
 */


public class MyTastings extends MainActivity {

    private Button mCreateTastingButton;
    private String mTastingName;
    public ImageView mTastingPicture;
    private Button addLocation;
    public FirebaseAuth mFirebaseAuth;
    EditText mTastingNameInput;
    EditText mTastingSummaryInput;
    Button mCreateTasting;
    Place place = null;

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
                setContentView(R.layout.create_new_wine_tasting_summary);
                mTastingPicture = (ImageView) findViewById(R.id.tasting_photo);
                mTastingNameInput = (EditText) findViewById(R.id.create_tasting_name);
                mTastingSummaryInput = (EditText) findViewById(R.id.create_tasting_summary);
                mCreateTasting = (Button) findViewById(R.id.create_tasting);

                mTastingPicture.setVisibility(View.GONE);

                addLocation = (Button) findViewById(R.id.add_location);
                addLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                        try {
                            startActivityForResult(builder.build(MyTastings.this), LOCATION_PICKER_REQUEST);
                        } catch (GooglePlayServicesRepairableException e) {
                            e.printStackTrace();
                        } catch (GooglePlayServicesNotAvailableException e) {
                            e.printStackTrace();
                        }

                    }
                });

                mCreateTasting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (!mTastingNameInput.getText().toString().isEmpty() && !mTastingSummaryInput.getText().toString().isEmpty()) {
                            String mTastingName = mTastingNameInput.getText().toString();
                            createTastingInFirebase(mTastingName, uid, userName);

                        } else {
                            Toast.makeText(MyTastings.this, "You've left something blank...!", Toast.LENGTH_SHORT).show();
                        }
                    }

                });


            }
        });
                /*
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
        */


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOCATION_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                place = PlacePicker.getPlace(data, this);
                mTastingSummaryInput.setText(place.getAddress().toString());
            }
        }
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


    private void createTastingInFirebase(String mTastingName, String uid, String userName) {

        Firebase tastingRef = new Firebase(Constants.FIREBASE_URL_TASTINGS);
        Firebase tastingFirebaseRef = tastingRef.push();
        final String tastingPushID = tastingFirebaseRef.getKey();


        Firebase myTastingsLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(FIREBASE_MY_TASTINGS)
                .child(tastingPushID).child(FIREBASE_TASTING_NAME);
        myTastingsLocation.setValue(mTastingName);
        Firebase myTastingsLocationOwner = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS)
                .child(uid).child(FIREBASE_MY_TASTINGS).child(tastingPushID).child(Constants.FIREBASE_OWNER);
        myTastingsLocationOwner.setValue(userName);


        // this is for everyone tasting so we can easily query them instead of going to every user
        Firebase everyoneTasting = new Firebase(FIREBASE_URL_EVERYONE_TASTING);
        TastingDetailsPojo tastingDetailsPojo =
                new TastingDetailsPojo(mTastingName, userName, place.getLatLng().latitude, place.getLatLng().longitude, uid, tastingPushID);
        everyoneTasting.child(tastingPushID).setValue(tastingDetailsPojo);

        // saving the tasting Location;
        TASTING_GEO.setLocation(tastingPushID, new GeoLocation(place.getLatLng().latitude, place.getLatLng().longitude));






        //TODO: Save details of when the tasting was created and who by etc.
        //HashMap<String, Object> myTastingName = new HashMap<>();
        //myTastingName.put(mTastingName, ServerValue.TIMESTAMP);

        //TODO: This is where I should add the second AlertDialogBuilder, a positive response will direct people
        //TODO: cont.. to upload an image, a negative response will simply dismiss the dialog.

        Intent CreateTasting = new Intent(MyTastings.this, CreateNewTasting.class);
        CreateTasting.putExtra("thisTastingName", mTastingName);
        CreateTasting.putExtra("thisTastingPushID", tastingPushID);

        startActivity(CreateTasting);


    }



}

