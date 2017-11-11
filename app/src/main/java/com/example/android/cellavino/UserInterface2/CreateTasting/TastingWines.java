package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_TASTING_WINE_DETAILS;

/**
 * Created by Andrew on 10/08/2017.
 */

public class TastingWines extends MainActivity {

    private String mTastingListID;
    private FirebaseAuth mFirebaseAuth;
    private String mUid;
    private Firebase mMyTastingsFirebaseRef;
    private Firebase mEveryoneTastingFirebaseRef;
    private Firebase mTastingGEOFirebaseRef;
    private Firebase mTastingWineDetailsFirebaseRef;
    private FloatingActionButton mAddWineFab;


    public TastingWines() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TastingWinesFragment()).commit();

        Bundle bundle = getIntent().getExtras();
        mTastingListID = bundle.getString(Constants.TASTING_LIST_ID);
        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        mUid = user.getUid().toString();

        mAddWineFab = (FloatingActionButton) findViewById(R.id.addWineFab);
        mAddWineFab.setVisibility(View.GONE);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tasting_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete_tasting:
                deleteTasting();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void deleteTasting() {

        AlertDialog.Builder mDeleteTastingAlert = new AlertDialog.Builder(TastingWines.this);
        //this sets the icon for the pop up.
        //mDeleteWineAlert.setIcon(android.R.drawable.sym_def_app_icon);
        mDeleteTastingAlert.setTitle("Delete Tasting");
        mDeleteTastingAlert.setMessage("Are you sure you want delete this tasting?" + "\nDeleting the tasting will delete all the tasting, its location and all the wines");
        mDeleteTastingAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Intent ArchiveWine = new Intent(WineInformation.this, com.example.android.cellavino.UserInterface2.WineDetails.ArchiveWine.class);
                //ArchiveWine.putExtra("thisWinePushID", mWinePushID);
                //ArchiveWine.putExtra("thisUserID", mUid);
                dialog.dismiss();
                deleteTastingAction();
                //startActivity(deleteTastingAction);
            }
        });
        mDeleteTastingAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = mDeleteTastingAlert.create();
        alertDialog.show();

    }

    public void deleteTastingAction() {

        /*
        Note: the nodes where the data is being delete are:
            user -> myTastings
            everyoneTasting
            Tasting_geo
            tastingWineDetails

        Currently they're all set to null when they're deleted.
         */

        Toast.makeText(TastingWines.this, "Delete Tasting", Toast.LENGTH_SHORT).show();

        //mWineInformationRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);

        mMyTastingsFirebaseRef = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(mUid).child(Constants.FIREBASE_MY_TASTINGS).child(mTastingListID);
        mEveryoneTastingFirebaseRef = new Firebase(Constants.FIREBASE_URL).child(Constants.FIREBASE_EVERYONE_TASTING).child(mTastingListID);
        mTastingGEOFirebaseRef = new Firebase(Constants.FIREBASE_URL).child("Tasting_geo").child(mTastingListID);
        mTastingWineDetailsFirebaseRef = new Firebase(Constants.FIREBASE_URL).child(Constants.FIREBASE_TASTING_WINE_DETAILS).child(mTastingListID);

        mMyTastingsFirebaseRef.removeValue();
        mEveryoneTastingFirebaseRef.removeValue();
        mTastingGEOFirebaseRef.removeValue();
        mTastingWineDetailsFirebaseRef.removeValue();
        finish();
    }

}
