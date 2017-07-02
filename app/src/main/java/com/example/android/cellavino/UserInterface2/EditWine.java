package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
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

    public SeekBar mGrapefuit;
    public SeekBar mLemon;
    public SeekBar mLime;
    public SeekBar mOrange;
    public SeekBar mPear;
    public SeekBar mApple;
    public SeekBar mGrannysmith;
    public SeekBar mApricot;
    public SeekBar mMelon;
    public SeekBar mGuava;
    public SeekBar mPineapple;
    public SeekBar mPassionfruit;
    public SeekBar mLychee;
    public SeekBar mRedcurrant;
    public SeekBar mBlackcurrant;
    public SeekBar mStrawberry;
    public SeekBar mBlackberry;
    public SeekBar mCherry;
    public SeekBar mPlum;
    public SeekBar mGreenpepper;
    public SeekBar mTomato;
    public SeekBar mMint;
    public SeekBar mTobacco;
    public SeekBar mHay;
    public SeekBar mKerosene;
    public SeekBar mButter;
    public SeekBar mToastedbread;
    public SeekBar mCoffee;
    public SeekBar mVanila;
    public SeekBar mPepper;
    public SeekBar mCinnamon;
    public SeekBar mLicorice;
    public SeekBar mClove;
    public SeekBar mCoconut;
    public SeekBar mHazelnut;
    public SeekBar mAlmond;
    public SeekBar mOak;
    public SeekBar mOrangepeel;
    public SeekBar mDriedapricot;
    public SeekBar mPrune;
    public SeekBar mHoney;
    public SeekBar mChocolate;
    public SeekBar mLeather;
    public SeekBar mMushroom;
    public SeekBar mTruffle;
    public SeekBar mCork;
    public SeekBar mRubberband;
    public SeekBar mEgg;
    public SeekBar mOnion;
    public SeekBar mCorn;


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

        Firebase wineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);
        mWineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);
        Firebase myWinesRefLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_WINES).child(mWinePushID);


        //initialise the seekbars
        mGrapefuit = (SeekBar) findViewById(R.id.seekBar_grapefruit);
        mLemon = (SeekBar) findViewById(R.id.seekBar_lemon);
        mLime = (SeekBar) findViewById(R.id.seekBar_lime);
        mOrange = (SeekBar) findViewById(R.id.seekBar_orange);
        mPear = (SeekBar) findViewById(R.id.seekBar_pear);
        mApple = (SeekBar) findViewById(R.id.seekBar_apple);
        mGrannysmith = (SeekBar) findViewById(R.id.seekBar_grannysmith);
        mApricot = (SeekBar) findViewById(R.id.seekBar_apricot);
        mMelon = (SeekBar) findViewById(R.id.seekBar_melon);
        mGuava = (SeekBar) findViewById(R.id.seekBar_guava);
        mPineapple = (SeekBar) findViewById(R.id.seekBar_pineapple);
        mPassionfruit = (SeekBar) findViewById(R.id.seekBar_passionfruit);
        mLychee = (SeekBar) findViewById(R.id.seekBar_am_lychee);
        mRedcurrant = (SeekBar) findViewById(R.id.seekBar_an_redcurrant);
        mBlackcurrant = (SeekBar) findViewById(R.id.seekBar_ao_blackcurrant);
        mStrawberry = (SeekBar) findViewById(R.id.seekBar_ap_strawberry);
        mBlackberry = (SeekBar) findViewById(R.id.seekBar_aq_blackberry);
        mCherry = (SeekBar) findViewById(R.id.seekBar_ar_cherry);
        mPlum = (SeekBar) findViewById(R.id.seekBar_as_plum);
        mGreenpepper = (SeekBar) findViewById(R.id.seekBar_bb_greenpepper);
        mTomato = (SeekBar) findViewById(R.id.seekBar_bc_tomato);
        mMint = (SeekBar) findViewById(R.id.seekBar_bg_mint);
        mTobacco = (SeekBar) findViewById(R.id.seekBar_bh_tobacco);
        mHay = (SeekBar) findViewById(R.id.seekBar_bi_hay);
        mKerosene = (SeekBar) findViewById(R.id.seekBar_bm_kerosene);
        mButter = (SeekBar) findViewById(R.id.seekBar_bq_butter);
        mToastedbread = (SeekBar) findViewById(R.id.seekBar_br_toastedbread);
        mCoffee = (SeekBar) findViewById(R.id.seekBar_bs_coffee);
        mVanila = (SeekBar) findViewById(R.id.seekBar_bu_vanilla);
        mPepper = (SeekBar) findViewById(R.id.seekBar_bv_pepper);
        mCinnamon = (SeekBar) findViewById(R.id.seekBar_bw_cinnamon);
        mLicorice = (SeekBar) findViewById(R.id.seekBar_bx_licorice);
        mClove = (SeekBar) findViewById(R.id.seekBar_bz_clove);
        mCoconut = (SeekBar) findViewById(R.id.seekBar_ca_coconut);
        mHazelnut = (SeekBar) findViewById(R.id.seekBar_cb_hazelnut);
        mAlmond = (SeekBar) findViewById(R.id.seekBar_cc_almond);
        mOak = (SeekBar) findViewById(R.id.seekBar_cd_oak);
        mOrangepeel = (SeekBar) findViewById(R.id.seekBar_ch_orangepeel);
        mDriedapricot = (SeekBar) findViewById(R.id.seekBar_ci_driedapricot);
        mPrune = (SeekBar) findViewById(R.id.seekBar_cj_prune);
        mHoney = (SeekBar) findViewById(R.id.seekBar_ck_honey);
        mChocolate = (SeekBar) findViewById(R.id.seekBar_cl_chocolate);
        mLeather = (SeekBar) findViewById(R.id.seekBar_cn_leather);
        mMushroom = (SeekBar) findViewById(R.id.seekBar_co_mushroom);
        mTruffle = (SeekBar) findViewById(R.id.seekBar_cp_truffle);
        mCork = (SeekBar) findViewById(R.id.seekBar_cq_cork);
        mRubberband = (SeekBar) findViewById(R.id.seekBar_cv_rubberband);
        mEgg = (SeekBar) findViewById(R.id.seekBar_cw_egg);
        mOnion = (SeekBar) findViewById(R.id.seekBar_cx_onion);
        mCorn = (SeekBar) findViewById(R.id.seekBar_cy_corn);

        //initialise the fields
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

            Firebase wineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);
            Firebase myWinesRefLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_WINES).child(mWinePushID);

            mWineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);

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
