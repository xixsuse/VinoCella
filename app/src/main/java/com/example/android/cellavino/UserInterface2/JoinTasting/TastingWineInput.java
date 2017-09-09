package com.example.android.cellavino.UserInterface2.JoinTasting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.WineTastePojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface2.CreateTasting.CreateNewTasting;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Andrew on 17/08/2017.
 */

public class TastingWineInput extends AppCompatActivity {

    public FirebaseAuth mFirebaseAuth;

    private ValueEventListener mTastingWineAnswer;

    public SeekBar mGrapefruitInput;

    private Toast mToastMessage;

    private int mGrapefruitAnswer;
    public int mGrapefruitValueNo;
    public int mGrapefruitDifference;
    public int mGrapefruitResult;


    private String mTastingWineInput;
    private String winePushID;
    private Button mSaveFinish;
    private Button mSaveAddNext;
    private TextView mWineName;
    private TextView mWineVintage;
    private TextView mWineVariety;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        mTastingWineInput = bundle.getString(Constants.WINE_LIST_ID);
        setContentView(R.layout.create_new_tasting);
        //TODO: Set Title as Wine Name
        // setTitle(mTastingName);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mWineName = (TextView) findViewById(R.id.create_wine_name);
        mWineVintage = (TextView) findViewById(R.id.create_wine_vintage);
        mWineVariety = (TextView) findViewById(R.id.create_wine_variety);
        //TODO: Set the text here to the actual WineName, Vintage and Variety

        //Hide the Save Finish button, and then change the text to "Submit"
        mSaveFinish = (Button) findViewById(R.id.save_finish);
        mSaveFinish.setVisibility(View.GONE);
        mSaveAddNext = (Button) findViewById(R.id.save_add_next);
        mSaveAddNext.setText("Submit");

        mSaveAddNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mTastingWineInput == null) {
                    Toast.makeText(TastingWineInput.this, "Hmmm...we're having a bit of an issue.", Toast.LENGTH_SHORT).show();
                    finish();
                    return;
                }

                if (mTastingWineInput != null) {
                    String winePushID = mTastingWineInput.toString();
                    onSubnmitAnswer(winePushID);
                    return;
                }


                //TODO: update code to send this to the onSubnmitAnswer() method;
            }
        });
        ;

        //Initialise the views.
        mGrapefruitInput = (SeekBar) findViewById(R.id.seekBar_grapefruit);

        mGrapefruitInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int grapefruitValue = 0;

            public void onProgressChanged(SeekBar mGrapefruit, int progress, boolean fromUser) {
                grapefruitValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Grapefruit: " + grapefruitValue, Toast.LENGTH_SHORT);
                mGrapefruitValueNo = grapefruitValue;
                mToastMessage.show();
            }
        });


        //Hide all the irrelevant containers

        LinearLayout mLemonAromaContainer = (LinearLayout) findViewById(R.id.ab_lemon_container);
        mLemonAromaContainer.setVisibility(View.GONE);
        LinearLayout mLimeAromaContainer = (LinearLayout) findViewById(R.id.ac_lime_container);
        mLimeAromaContainer.setVisibility(View.GONE);
        LinearLayout mOrangeAromoaContainer = (LinearLayout) findViewById(R.id.ad_orange_container);
        mOrangeAromoaContainer.setVisibility(View.GONE);
        LinearLayout mOrangepeelAromaContainer = (LinearLayout) findViewById(R.id.ch_orangepeel_container);
        mOrangepeelAromaContainer.setVisibility(View.GONE);
        CardView mTreeFruitContainer = (CardView) findViewById(R.id.tree_fruit_container);
        mTreeFruitContainer.setVisibility(View.GONE);
        CardView mTropicalFruitContainer = (CardView) findViewById(R.id.tropical_fruit_container);
        mTropicalFruitContainer.setVisibility(View.GONE);
        CardView mDriedFruitContainer = (CardView) findViewById(R.id.dried_fruit_container);
        mDriedFruitContainer.setVisibility(View.GONE);
        CardView mStoneFruitContainer = (CardView) findViewById(R.id.stone_fruit_container);
        mStoneFruitContainer.setVisibility(View.GONE);
        CardView mBerryandJamContainer = (CardView) findViewById(R.id.berry_and_jam_container);
        mBerryandJamContainer.setVisibility(View.GONE);
        CardView mBlossomContainer = (CardView) findViewById(R.id.blossom_container);
        mBlossomContainer.setVisibility(View.GONE);
        CardView mFloralContainer = (CardView) findViewById(R.id.floral_container);
        mFloralContainer.setVisibility(View.GONE);
        CardView mHerbContainer = (CardView) findViewById(R.id.herb_container);
        mHerbContainer.setVisibility(View.GONE);
        CardView mEarthyContainer = (CardView) findViewById(R.id.earthy_container);
        mEarthyContainer.setVisibility(View.GONE);
        CardView mLeatheryContainer = (CardView) findViewById(R.id.leathery_container);
        mLeatheryContainer.setVisibility(View.GONE);
        CardView mVegetableContainer = (CardView) findViewById(R.id.vegetable_container);
        mVegetableContainer.setVisibility(View.GONE);
        CardView mWoodyContainer = (CardView) findViewById(R.id.woody_container);
        mWoodyContainer.setVisibility(View.GONE);
        CardView mNuttyContainer = (CardView) findViewById(R.id.nutty_container);
        mNuttyContainer.setVisibility(View.GONE);
        CardView mSpicyContainer = (CardView) findViewById(R.id.spicy_container);
        mSpicyContainer.setVisibility(View.GONE);
        CardView mToastyContainer = (CardView) findViewById(R.id.toasty_container);
        mToastyContainer.setVisibility(View.GONE);
        CardView mBakeryContainer = (CardView) findViewById(R.id.bakery_container);
        mBakeryContainer.setVisibility(View.GONE);
        CardView mDairyContainer = (CardView) findViewById(R.id.dairy_container);
        mDairyContainer.setVisibility(View.GONE);
        CardView mOtherFlavourContainer = (CardView) findViewById(R.id.other_flavours_container);
        mOtherFlavourContainer.setVisibility(View.GONE);


    }

    private void onSubnmitAnswer(String winePushID) {
        Firebase tastingWineFirebaseFlavourRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(winePushID).child(Constants.FIREBASE_WINE_FLAVOR_DETAILS);
        String stringTastingRef = tastingWineFirebaseFlavourRef.toString();
        tastingWineFirebaseFlavourRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WineTastePojo wineTastePojo = dataSnapshot.getValue(WineTastePojo.class);
                if (wineTastePojo != null) {
                    mGrapefruitAnswer = wineTastePojo.getmGrapefruitTaste();
                    mGrapefruitDifference = mGrapefruitAnswer - mGrapefruitValueNo;
                    if (mGrapefruitDifference <= 0) {
                        mGrapefruitResult = mGrapefruitDifference * -1;
                    }

                    if (mGrapefruitDifference >= 0) {
                        mGrapefruitResult = mGrapefruitDifference;
                    }

                    Toast.makeText(TastingWineInput.this, "Difference = " + mGrapefruitResult, Toast.LENGTH_SHORT).show();


                    //TODO: add code to change work out the score.


                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

    /*

    private void onSubnmitAnswer(String winePushID){

        String mWinePushID = winePushID.toString();



        mTastingWineAnswer = tastingWineFirebaseFlavourRef.addValueEventListener((new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                WineTastePojo wineTastePojo = dataSnapshot.getValue(WineTastePojo.class);
                if (wineTastePojo == null) {
                    finish();
                    return;
                }

                mGrapefruitAnswer = wineTastePojo.getmGrapefruitTaste();
                int mGrapefruitResult =  mGrapefruitValueNo - mGrapefruitAnswer;
                Toast.makeText(TastingWineInput.this, mGrapefruitResult, Toast.LENGTH_SHORT);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        }));


     */



}
