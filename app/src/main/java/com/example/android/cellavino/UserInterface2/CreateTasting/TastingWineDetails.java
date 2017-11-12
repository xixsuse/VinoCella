package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastePojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastingPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface2.JoinTasting.TastingWineInput;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

/**
 * Created by Andrew on 1/11/2017.
 */

public class TastingWineDetails extends MainActivity {

    private String mTastingWineID;
    public String tasting_wineId;
    public Button mSaveFinish;
    public Button mSaveAddNext;
    public CardView mSubmitCard;
    public Firebase mWineInformationRef;
    public FloatingActionButton mFloatingActionButtonPicture;
    private ValueEventListener mActiveWineInformation;
    private ValueEventListener mActiveWineFlavors;
    private Firebase mWineFlavorRef;
    private ProgressDialog mLoadingTasteDialog;
    public TextView mViewWineVarietyText;
    public TextView mViewWineName;
    public TextView mViewWineVintage;
    public TextView mViewWineVariety;


    public RelativeLayout expandCollapseCitrusFruits;
    public CardView citrusFruitContainer;
    public ImageView expandCitrusImage;
    public RelativeLayout expandCollapseTropicalFruits;
    public CardView tropicalFruitContainer;
    public ImageView expandTropicalFruitImage;
    public RelativeLayout expandCollapseTreeFruits;
    public CardView treeFruitContainer;
    public ImageView expandTreeFruitImage;
    public RelativeLayout expandCollapseDriedFruits;
    public CardView driedFruitContainer;
    public ImageView expandDriedFruitImage;
    public RelativeLayout expandCollapseStoneFruits;
    public CardView stoneFruitContainer;
    public ImageView expandStoneFruitImage;
    public RelativeLayout expandCollapseBerriesandJam;
    public CardView berriesandjamContainer;
    public ImageView expandBerriesandJamImage;
    public RelativeLayout expandCollapseBlossom;
    public CardView blossomContainer;
    public ImageView expandBlossomImage;
    public RelativeLayout expandCollapseFloral;
    public CardView floralContainer;
    public ImageView expandFloralImage;
    public RelativeLayout expandCollapseHerb;
    public CardView herbContainer;
    public ImageView expandHerbImage;
    public RelativeLayout expandCollapseEarthy;
    public CardView earthyContainer;
    public ImageView expandEarthyImage;
    public RelativeLayout expandCollapseLeather;
    public CardView leatheryContainer;
    public ImageView expandLeatheryImage;
    public RelativeLayout expandCollapseVegetable;
    public CardView vegetableContainer;
    public ImageView expandVegetableImage;
    public RelativeLayout expandCollapseWoody;
    public CardView woodyContainer;
    public ImageView expandWoodyImage;
    public RelativeLayout expandCollapseNutty;
    public CardView nuttyContainer;
    public ImageView expandNuttyImage;
    public RelativeLayout expandCollapseSpicy;
    public CardView spicyContainer;
    public ImageView expandSpicyImage;
    public RelativeLayout expandCollapseToasty;
    public CardView toastyContainer;
    public ImageView expandToastyImage;
    public RelativeLayout expandCollapseBakery;
    public CardView bakeryContainer;
    public ImageView expandBakeryImage;
    public RelativeLayout expandCollapseDairy;
    public CardView dairyContainer;
    public ImageView expandDairyImage;
    public RelativeLayout expandCollapseOther;
    public CardView otherContainer;
    public ImageView expandOtherImage;
    public RatingBar mWineRating;
    public CardView mSummaryCard;
    public TextView mWineDescription;
    public EditText mWineDescriptionEditText;
    public String mTastingWinePhotoUrl;
    public ImageView winePhoto;
    public CardView mWineDescriptionCard;


    public TastingWineDetails() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_tasting);

        Bundle bundle = getIntent().getExtras();
        mTastingWineID = bundle.getString(Constants.TASTING_WINE_ID);
        tasting_wineId = mTastingWineID.toString();

        //Hide the Save Finish button, and then change the text to "Submit"
        mSaveFinish = (Button) findViewById(R.id.save_finish);
        mSaveFinish.setVisibility(View.GONE);

        mSaveAddNext = (Button) findViewById(R.id.save_add_next);
        mSaveAddNext.setText("Update");

        mSummaryCard = (CardView) findViewById(R.id.wine_photo_card);

        mWineDescriptionCard = (CardView) findViewById(R.id.wine_description_card);
        mWineDescriptionCard.setVisibility(View.GONE);

        winePhoto = (ImageView) findViewById(R.id.wine_photo);
        mWineDescription = (TextView) findViewById(R.id.wine_description_text);
        //mWineDescription.setVisibility(View.GONE);

        mWineDescriptionEditText = (EditText) findViewById(R.id.wine_description);
        mWineDescriptionEditText.setVisibility(View.GONE);

        mWineRating = (RatingBar) findViewById(R.id.tasting_wine_rating);
        mWineRating.setVisibility(View.GONE);

        mSubmitCard = (CardView) findViewById(R.id.submit_card);
        mSubmitCard.setVisibility(View.GONE);

        mFloatingActionButtonPicture = (FloatingActionButton) findViewById(R.id.addTastingWineBottlePictureFab);
        mFloatingActionButtonPicture.setVisibility(View.GONE);

        //this will get the summary wine details and channel through the WinePojo

        mViewWineVarietyText = (TextView) findViewById(R.id.create_wine_variety_text);
        mViewWineName = (TextView) findViewById(R.id.create_wine_name);
        mViewWineVintage = (TextView) findViewById(R.id.create_wine_vintage);
        mViewWineVariety = (TextView) findViewById(R.id.create_wine_variety);

        mWineInformationRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mTastingWineID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);
        mActiveWineInformation = mWineInformationRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //Save the most recent version of current shopping list into mShoppingList instance variable an update the UI to match the current list.

                WineTastingPojo wineTastingPojo = snapshot.getValue(WineTastingPojo.class);
                if (wineTastingPojo == null) {
                    finish();
                    return;
                } else

                    setTitle(wineTastingPojo.getWineVintage() + " " + wineTastingPojo.getWineName());
                mViewWineVarietyText.setText(wineTastingPojo.getWineVariety());
                mWineDescription.setText(wineTastingPojo.getWineDescription());
                mTastingWinePhotoUrl = wineTastingPojo.getWineImageUrl();
                Picasso.with(TastingWineDetails.this).load(mTastingWinePhotoUrl).placeholder(R.drawable.sample_wine_flight).into(winePhoto);

                mViewWineName.setVisibility(View.GONE);
                mViewWineVintage.setVisibility(View.GONE);
                mViewWineVariety.setVisibility(View.GONE);

                //TODO add
                // mWineImageUrl set the image located in the url to the following image in the view wine_photo


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                //Log.e(LOG_TAG, getString(R.string.app_not_available) + firebaseError.getMessage());
            }

        });

        //This is what populates the wines when someone goes into view their wine.
        mWineFlavorRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mTastingWineID).child(Constants.FIREBASE_WINE_FLAVOR_DETAILS);
        mActiveWineFlavors = mWineFlavorRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                WineTastePojo wineTastePojo = snapshot.getValue(WineTastePojo.class);
                invalidateOptionsMenu();

                if (wineTastePojo != null) {

                    CardView mCitrusFruitContainer = (CardView) findViewById(R.id.citrus_fruit_container);
                    RelativeLayout mCitrusHeader = (RelativeLayout) findViewById(R.id.expand_collapse_citrus_fruits);
                    int mGrapefruitAromaContainer = wineTastePojo.getmGrapefruitTaste();
                    int mLemonAromaContainer = wineTastePojo.getmLemonTaste();
                    int mLimeAromaContainer = wineTastePojo.getmLimeTaste();
                    int mOrangeAromoaContainer = wineTastePojo.getmOrangeTaste();
                    int mOrangepeelAromaContainer = wineTastePojo.getmOrangepeelTaste();
                    if (mGrapefruitAromaContainer + mLemonAromaContainer + mLimeAromaContainer + mOrangeAromoaContainer + mOrangepeelAromaContainer == 0) {
                        mCitrusFruitContainer.setVisibility(View.GONE);
                        mCitrusHeader.setVisibility(View.GONE);

                    }
                    if (mGrapefruitAromaContainer + mLemonAromaContainer + mLimeAromaContainer + mOrangeAromoaContainer + mOrangepeelAromaContainer != 0) {
                        mCitrusFruitContainer.setVisibility(View.VISIBLE);
                        mCitrusHeader.setVisibility(View.VISIBLE);

                    }

                    CardView mTreeFruitContainer = (CardView) findViewById(R.id.tree_fruit_container);
                    RelativeLayout mTreeFruitHeader = (RelativeLayout) findViewById(R.id.expand_collapse_tree_fruits);

                    int mAppleAromaContainer = wineTastePojo.getmAppleTaste();
                    int mGrannysmithAromaContainer = wineTastePojo.getmGrannysmithTaste();
                    int mPearAromaContainer = wineTastePojo.getmPearTaste();
                    int mApricotAromaContainer = wineTastePojo.getmApricotTaste();
                    int mBananaAromaContainer = wineTastePojo.getmBananaTaste();
                    int mFigAromaContainer = wineTastePojo.getmFigTaste();
                    int mPomegranateAromaContainer = wineTastePojo.getmPomegranateTaste();
                    if (mAppleAromaContainer + mGrannysmithAromaContainer + mPearAromaContainer + mApricotAromaContainer + mBananaAromaContainer + mFigAromaContainer + mPomegranateAromaContainer == 0) {
                        mTreeFruitContainer.setVisibility(View.GONE);
                        mTreeFruitHeader.setVisibility(View.GONE);

                    }
                    if (mAppleAromaContainer + mGrannysmithAromaContainer + mPearAromaContainer + mApricotAromaContainer + mBananaAromaContainer + mFigAromaContainer + mPomegranateAromaContainer != 0) {
                        mTreeFruitContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mTropicalFruitContainer = (CardView) findViewById(R.id.tropical_fruit_container);
                    RelativeLayout mTropicalFruitHeader = (RelativeLayout) findViewById(R.id.expand_collapse_tropical_fruits);

                    int mMelonAromaContainer = wineTastePojo.getmMelonTaste();
                    int mCantelopeAromaContainer = wineTastePojo.getmCantelopeTaste();
                    int mMangoAromaContainer = wineTastePojo.getmMangoTaste();
                    int mGuavaAromaContainer = wineTastePojo.getmGuavaTaste();
                    int mKiwifruitAromaContainer = wineTastePojo.getmKiwifruitTaste();
                    int mLycheeAromaContainer = wineTastePojo.getmLycheeTaste();
                    int mPassionruitAromaContainer = wineTastePojo.getmPassionfruitTaste();
                    int mPineappleAromaContainer = wineTastePojo.getmPineappleTaste();
                    int mWatermelonAromaContainer = wineTastePojo.getmWatermelonTaste();
                    if (mMelonAromaContainer + mCantelopeAromaContainer + mMangoAromaContainer + mGuavaAromaContainer + mKiwifruitAromaContainer + mLycheeAromaContainer + mPassionruitAromaContainer + mPineappleAromaContainer + mWatermelonAromaContainer == 0) {
                        mTropicalFruitContainer.setVisibility(View.GONE);
                        mTropicalFruitHeader.setVisibility(View.GONE);

                    }
                    if (mMelonAromaContainer + mCantelopeAromaContainer + mMangoAromaContainer + mGuavaAromaContainer + mKiwifruitAromaContainer + mLycheeAromaContainer + mPassionruitAromaContainer + mPineappleAromaContainer + mWatermelonAromaContainer != 0) {
                        mTropicalFruitContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mDriedFruitContainer = (CardView) findViewById(R.id.dried_fruit_container);
                    RelativeLayout mDriedFruitHeader = (RelativeLayout) findViewById(R.id.expand_collapse_dried_fruits);

                    int mDriedapricotAromaContainer = wineTastePojo.getmDriedapricotTaste();
                    int mPruneAromaContainer = wineTastePojo.getmPruneTaste();
                    if (mDriedapricotAromaContainer + mPruneAromaContainer == 0) {
                        mDriedFruitContainer.setVisibility(View.GONE);
                        mDriedFruitHeader.setVisibility(View.GONE);
                    }
                    if (mDriedapricotAromaContainer + mPruneAromaContainer != 0) {
                        mDriedFruitContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mStoneFruitContainer = (CardView) findViewById(R.id.stone_fruit_container);
                    RelativeLayout mStoneFruitHeader = (RelativeLayout) findViewById(R.id.expand_collapse_stone_fruits);

                    int mPeachAromaContainer = wineTastePojo.getmPeachTaste();
                    int mCherryAromaContainer = wineTastePojo.getmCherryTaste();
                    int mPlumAromaContainer = wineTastePojo.getmPlumTaste();
                    if (mPeachAromaContainer + mCherryAromaContainer + mPlumAromaContainer == 0) {
                        mStoneFruitContainer.setVisibility(View.GONE);
                        mStoneFruitHeader.setVisibility(View.GONE);
                    }
                    if (mPeachAromaContainer + mCherryAromaContainer + mPlumAromaContainer != 0) {
                        mStoneFruitContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mBerryandJamContainer = (CardView) findViewById(R.id.berry_and_jam_container);
                    RelativeLayout mBerryandJamHeader = (RelativeLayout) findViewById(R.id.expand_collapse_berry_and_jam);
                    int mJamAromaContainer = wineTastePojo.getmJamTaste();
                    int mRedcurrantAromaContainer = wineTastePojo.getmRedcurrantTaste();
                    int mBlackcurrantAromaContainer = wineTastePojo.getmBlackcurrantTaste();
                    int mStrawberryAromaContainer = wineTastePojo.getmStrawberryTaste();
                    int mBlackberryAromaContainer = wineTastePojo.getmBlackberryTaste();
                    int mRaspberryAromaContainer = wineTastePojo.getmRaspberryTaste();
                    int mBlueberryAromaContainer = wineTastePojo.getmBlueberryTaste();
                    if (mJamAromaContainer + mRedcurrantAromaContainer + mBlackcurrantAromaContainer + mStrawberryAromaContainer + mBlackberryAromaContainer + mRaspberryAromaContainer + mBlueberryAromaContainer == 0) {
                        mBerryandJamContainer.setVisibility(View.GONE);
                        mBerryandJamHeader.setVisibility(View.GONE);
                    }
                    if (mJamAromaContainer + mRedcurrantAromaContainer + mBlackcurrantAromaContainer + mStrawberryAromaContainer + mBlackberryAromaContainer + mRaspberryAromaContainer + mBlueberryAromaContainer != 0) {
                        mBerryandJamContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mBlossomContainer = (CardView) findViewById(R.id.blossom_container);
                    RelativeLayout mBlossomHeader = (RelativeLayout) findViewById(R.id.expand_collapse_blossom);
                    int mAppleBlossomAromaContainer = wineTastePojo.getmAppleblossumTaste();
                    int mOrangeBlossomAromaContainer = wineTastePojo.getmOrangeblossumTaste();
                    if (mAppleBlossomAromaContainer + mOrangeBlossomAromaContainer == 0) {
                        mBlossomContainer.setVisibility(View.GONE);
                        mBlossomHeader.setVisibility(View.GONE);
                    }
                    if (mAppleBlossomAromaContainer + mOrangeBlossomAromaContainer != 0) {
                        mBlossomContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mFloralContainer = (CardView) findViewById(R.id.floral_container);
                    RelativeLayout mFloralHeader = (RelativeLayout) findViewById(R.id.expand_collapse_floral);
                    int mFloralAromaContainer = wineTastePojo.getmFloralTaste();
                    int mHoneysuckleAromaContainer = wineTastePojo.getmHoneysuckleTaste();
                    int mGeraniumAromaContainer = wineTastePojo.getmGeraniumTaste();
                    int mVioletAromaContainer = wineTastePojo.getmVioletTaste();
                    int mLavenderAromaContainer = wineTastePojo.getmLavenderTaste();
                    int mRoseAromaContainer = wineTastePojo.getmRoseTaste();
                    int mEucalyptusAromaContainer = wineTastePojo.getmEucalyptusTaste();
                    if (mFloralAromaContainer + mHoneysuckleAromaContainer + mGeraniumAromaContainer + mVioletAromaContainer + mLavenderAromaContainer + mRoseAromaContainer + mEucalyptusAromaContainer == 0) {
                        mFloralContainer.setVisibility(View.GONE);
                        mFloralHeader.setVisibility(View.GONE);
                    }
                    if (mFloralAromaContainer + mHoneysuckleAromaContainer + mGeraniumAromaContainer + mVioletAromaContainer + mLavenderAromaContainer + mRoseAromaContainer + mEucalyptusAromaContainer != 0) {
                        mFloralContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mHerbContainer = (CardView) findViewById(R.id.herb_container);
                    RelativeLayout mHerbHeader = (RelativeLayout) findViewById(R.id.expand_collapse_herbs);

                    int mCutgrassAromaContainer = wineTastePojo.getmCutgrassTaste();
                    int mRosemaryAromaContainer = wineTastePojo.getmRosemaryTaste();
                    int mThymeAromaContainer = wineTastePojo.getmThymeTaste();
                    int mMintAromaContainer = wineTastePojo.getmMintTaste();
                    if (mCutgrassAromaContainer + mRosemaryAromaContainer + mThymeAromaContainer + mMintAromaContainer == 0) {
                        mHerbContainer.setVisibility(View.GONE);
                        mHerbHeader.setVisibility(View.GONE);
                    }
                    if (mCutgrassAromaContainer + mRosemaryAromaContainer + mThymeAromaContainer + mMintAromaContainer != 0) {
                        mHerbContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mEarthyContainer = (CardView) findViewById(R.id.earthy_container);
                    RelativeLayout mEarthyHeader = (RelativeLayout) findViewById(R.id.expand_collapse_earthy);
                    int mHayAromaContainer = wineTastePojo.getmHayTaste();
                    int mMushroomAromaContainer = wineTastePojo.getmMushroomTaste();
                    int mTruffleAromaContainer = wineTastePojo.getmTruffleTaste();
                    if (mHayAromaContainer + mMushroomAromaContainer + mTruffleAromaContainer == 0) {
                        mEarthyContainer.setVisibility(View.GONE);
                        mEarthyHeader.setVisibility(View.GONE);
                    }
                    if (mHayAromaContainer + mMushroomAromaContainer + mTruffleAromaContainer != 0) {
                        mEarthyContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mLeatheryContainer = (CardView) findViewById(R.id.leathery_container);
                    RelativeLayout mLeatheryHeader = (RelativeLayout) findViewById(R.id.expand_collapse_leathery);
                    int mLeatherAromaContainer = wineTastePojo.getmLeatherTaste();
                    if (mLeatherAromaContainer == 0) {
                        mLeatheryContainer.setVisibility(View.GONE);
                        mLeatheryHeader.setVisibility(View.GONE);
                    }
                    if (mLeatherAromaContainer != 0) {
                        mLeatheryContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mVegetableContainer = (CardView) findViewById(R.id.vegetable_container);
                    RelativeLayout mVegetableHeader = (RelativeLayout) findViewById(R.id.expand_collapse_vegetable);
                    int mGreenpepperAromaContainer = wineTastePojo.getmGreenpepperTaste();
                    int mTomatoAromaContainer = wineTastePojo.getmTomatoTaste();
                    int mCornAromaContainer = wineTastePojo.getmCornTaste();
                    int mOnionAromaContainer = wineTastePojo.getmOnionTaste();
                    if (mGreenpepperAromaContainer + mTomatoAromaContainer + mCornAromaContainer + mOnionAromaContainer == 0) {
                        mVegetableContainer.setVisibility(View.GONE);
                        mVegetableHeader.setVisibility(View.GONE);
                    }
                    if (mGreenpepperAromaContainer + mTomatoAromaContainer + mCornAromaContainer + mOnionAromaContainer != 0) {
                        mVegetableContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mWoodyContainer = (CardView) findViewById(R.id.woody_container);
                    RelativeLayout mWoodyHeader = (RelativeLayout) findViewById(R.id.expand_collapse_woody);
                    int mPineAromaContainer = wineTastePojo.getmPineTaste();
                    int mCedarAromaContainer = wineTastePojo.getmCedarTaste();
                    int mOakAromaContainer = wineTastePojo.getmOakTaste();
                    if (mPineAromaContainer + mCedarAromaContainer + mOakAromaContainer == 0) {
                        mWoodyContainer.setVisibility(View.GONE);
                        mWoodyHeader.setVisibility(View.GONE);
                    }
                    if (mPineAromaContainer + mCedarAromaContainer + mOakAromaContainer != 0) {
                        mWoodyContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mNuttyContainer = (CardView) findViewById(R.id.nutty_container);
                    RelativeLayout mNuttyHeader = (RelativeLayout) findViewById(R.id.expand_collapse_nutty);
                    int mHazelnutAromaContainer = wineTastePojo.getmHazelnutTaste();
                    int mAlmondAromaContainer = wineTastePojo.getmAlmondTaste();
                    int mNutmegAromaContainer = wineTastePojo.getmNutmegTaste();
                    int mWalnutAromaContainer = wineTastePojo.getmWalnutTaste();
                    if (mHazelnutAromaContainer + mAlmondAromaContainer + mNutmegAromaContainer + mWalnutAromaContainer == 0) {
                        mNuttyContainer.setVisibility(View.GONE);
                        mNuttyHeader.setVisibility(View.GONE);
                    }
                    if (mHazelnutAromaContainer + mAlmondAromaContainer + mNutmegAromaContainer + mWalnutAromaContainer != 0) {
                        mNuttyContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mSpicyContainer = (CardView) findViewById(R.id.spicy_container);
                    RelativeLayout mSpicyHeader = (RelativeLayout) findViewById(R.id.expand_collapse_spicy);
                    int mPepperAromaContainer = wineTastePojo.getmPepperTaste();
                    int mCinnamonAromaContainer = wineTastePojo.getmCinnamonTaste();
                    int mVanilaAromaContainer = wineTastePojo.getmVanilaTaste();
                    int mCloveAromaContainer = wineTastePojo.getmCloveTaste();
                    int mChiliAromaContainer = wineTastePojo.getmChiliTaste();
                    int mLicoriceAromaContainer = wineTastePojo.getmLicoriceTaste();
                    int mSaffronAromaContainer = wineTastePojo.getmSaffronTaste();
                    if (mPepperAromaContainer + mCinnamonAromaContainer + mVanilaAromaContainer + mCloveAromaContainer + mChiliAromaContainer + mLicoriceAromaContainer + mSaffronAromaContainer == 0) {
                        mSpicyContainer.setVisibility(View.GONE);
                        mSpicyHeader.setVisibility(View.GONE);
                    }
                    if (mPepperAromaContainer + mCinnamonAromaContainer + mVanilaAromaContainer + mCloveAromaContainer + mChiliAromaContainer + mLicoriceAromaContainer + mSaffronAromaContainer != 0) {
                        mSpicyContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mToastyContainer = (CardView) findViewById(R.id.toasty_container);
                    RelativeLayout mToastyHeader = (RelativeLayout) findViewById(R.id.expand_collapse_toasty);
                    int mTobaccoAromaContainer = wineTastePojo.getmTobaccoTaste();
                    int mCoffeeAromaContainer = wineTastePojo.getmCoffeeTaste();
                    if (mTobaccoAromaContainer + mCoffeeAromaContainer == 0) {
                        mToastyContainer.setVisibility(View.GONE);
                        mToastyHeader.setVisibility(View.GONE);
                    }
                    if (mTobaccoAromaContainer + mCoffeeAromaContainer != 0) {
                        mToastyContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mBakeryContainer = (CardView) findViewById(R.id.bakery_container);
                    RelativeLayout mBakeryHeader = (RelativeLayout) findViewById(R.id.expand_collapse_bakery);

                    int mBreadAromaContainer = wineTastePojo.getmBreadTaste();
                    int mToastedBreadAroma = wineTastePojo.getmToastedbreadTaste();
                    if (mBreadAromaContainer + mToastedBreadAroma == 0) {
                        mBakeryContainer.setVisibility(View.GONE);
                        mBakeryHeader.setVisibility(View.GONE);
                    }
                    if (mBreadAromaContainer + mToastedBreadAroma != 0) {
                        mBakeryContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mDairyContainer = (CardView) findViewById(R.id.dairy_container);
                    RelativeLayout mDairyHeader = (RelativeLayout) findViewById(R.id.expand_collapse_dairy);
                    int mButterAromaContainer = wineTastePojo.getmButterTaste();
                    int mCreamAromaContainer = wineTastePojo.getmCreamTaste();
                    int mBluecheeseAromaContainer = wineTastePojo.getmBlueCheeseTaste();
                    if (mButterAromaContainer + mCreamAromaContainer + mBluecheeseAromaContainer == 0) {
                        mDairyContainer.setVisibility(View.GONE);
                        mDairyHeader.setVisibility(View.GONE);
                    }
                    if (mButterAromaContainer + mCreamAromaContainer + mBluecheeseAromaContainer != 0) {
                        mDairyContainer.setVisibility(View.VISIBLE);
                    }

                    CardView mOtherFlavourContainer = (CardView) findViewById(R.id.other_flavours_container);
                    RelativeLayout mOtherHeader = (RelativeLayout) findViewById(R.id.expand_collapse_other);
                    int mCoconutAromaContainer = wineTastePojo.getmCoconutTaste();
                    int mKeroseneAromaContainer = wineTastePojo.getmKeroseneTaste();
                    int mHoneyAromaContainer = wineTastePojo.getmHoneyTaste();
                    int mChocolateAromaContainer = wineTastePojo.getmChocolateTaste();
                    int mCorkAromaContainer = wineTastePojo.getmCorkTaste();
                    int mRubberbandAromaContainer = wineTastePojo.getmRubberbandTaste();
                    int mEggAromaContainer = wineTastePojo.getmEggTaste();
                    int mFlintAromaContainer = wineTastePojo.getmFlintTaste();
                    int mSmokeAromaContainer = wineTastePojo.getmSmokeTaste();
                    int mCaramelAromaContainer = wineTastePojo.getmCaramelTaste();
                    if (mCoconutAromaContainer + mKeroseneAromaContainer + mHoneyAromaContainer + mChocolateAromaContainer + mCorkAromaContainer + mRubberbandAromaContainer + mEggAromaContainer + mFlintAromaContainer + mSmokeAromaContainer + mCaramelAromaContainer == 0) {
                        mOtherFlavourContainer.setVisibility(View.GONE);
                        mOtherHeader.setVisibility(View.GONE);
                    }
                    if (mCoconutAromaContainer + mKeroseneAromaContainer + mHoneyAromaContainer + mChocolateAromaContainer + mCorkAromaContainer + mRubberbandAromaContainer + mEggAromaContainer + mFlintAromaContainer + mSmokeAromaContainer + mCaramelAromaContainer != 0) {
                        mOtherFlavourContainer.setVisibility(View.VISIBLE);
                    }


                    LinearLayout mGrapefruitContainer = (LinearLayout) findViewById(R.id.aa_grapefruit_container);
                    SeekBar mGrapefruitSeekBar = (SeekBar) findViewById(R.id.seekBar_grapefruit);
                    if ((wineTastePojo.getmGrapefruitTaste()) == 0) {
                        mGrapefruitContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmGrapefruitTaste()) != 0) {
                        int mGrapefruitValue = (wineTastePojo.getmGrapefruitTaste());
                        mGrapefruitSeekBar.setProgress(mGrapefruitValue);
                    }

                    LinearLayout mLemonContainer = (LinearLayout) findViewById(R.id.ab_lemon_container);
                    SeekBar mLemonSeekBar = (SeekBar) findViewById(R.id.seekBar_lemon);
                    if ((wineTastePojo.getmLemonTaste()) == 0) {
                        mLemonContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmLemonTaste()) != 0) {
                        int mLemonValue = (wineTastePojo.getmLemonTaste());
                        mLemonSeekBar.setProgress(mLemonValue);
                    }

                    LinearLayout mLimeContainer = (LinearLayout) findViewById(R.id.ac_lime_container);
                    SeekBar mLimeSeekBar = (SeekBar) findViewById(R.id.seekBar_lime);
                    if ((wineTastePojo.getmLimeTaste()) == 0) {
                        mLimeContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmLimeTaste()) != 0) {
                        int mLimeValue = (wineTastePojo.getmLimeTaste());
                        mLimeSeekBar.setProgress(mLimeValue);
                    }

                    LinearLayout mOrangeContainer = (LinearLayout) findViewById(R.id.ad_orange_container);
                    SeekBar mOrangeSeekBar = (SeekBar) findViewById(R.id.seekBar_orange);
                    if ((wineTastePojo.getmOrangeTaste()) == 0) {
                        mOrangeContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmOrangeTaste()) != 0) {
                        int mOrangeValue = (wineTastePojo.getmOrangeTaste());
                        mOrangeSeekBar.setProgress(mOrangeValue);
                    }

                    LinearLayout mPearContainer = (LinearLayout) findViewById(R.id.ae_pear_container);
                    SeekBar mPearSeekBar = (SeekBar) findViewById(R.id.seekBar_pear);
                    if ((wineTastePojo.getmPearTaste()) == 0) {
                        mPearContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPearTaste()) != 0) {
                        int mPearValue = (wineTastePojo.getmPearTaste());
                        mPearSeekBar.setProgress(mPearValue);
                    }

                    LinearLayout mAppleContainer = (LinearLayout) findViewById(R.id.af_apple_container);
                    SeekBar mAppleSeekBar = (SeekBar) findViewById(R.id.seekBar_apple);
                    if ((wineTastePojo.getmAppleTaste()) == 0) {
                        mAppleContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmAppleTaste()) != 0) {
                        int mAppleValue = (wineTastePojo.getmAppleTaste());
                        mAppleSeekBar.setProgress(mAppleValue);
                    }


                    LinearLayout mGrannysmithContainer = (LinearLayout) findViewById(R.id.ag_grannysmith_container);
                    SeekBar mGrannysmithSeekBar = (SeekBar) findViewById(R.id.seekBar_grannysmith);
                    if ((wineTastePojo.getmGrannysmithTaste()) == 0) {
                        mGrannysmithContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmGrannysmithTaste()) != 0) {
                        int mGrannysmithValue = (wineTastePojo.getmGrannysmithTaste());
                        mGrannysmithSeekBar.setProgress(mGrannysmithValue);
                    }


                    LinearLayout mApricotContainer = (LinearLayout) findViewById(R.id.ah_apricot_container);
                    SeekBar mApricotSeekBar = (SeekBar) findViewById(R.id.seekBar_apricot);
                    if ((wineTastePojo.getmApricotTaste()) == 0) {
                        mApricotContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmApricotTaste()) != 0) {
                        int mApricotValue = (wineTastePojo.getmApricotTaste());
                        mApricotSeekBar.setProgress(mApricotValue);
                    }

                    LinearLayout mMelonContainer = (LinearLayout) findViewById(R.id.ai_melon_container);
                    SeekBar mMelonSeekBar = (SeekBar) findViewById(R.id.seekBar_melon);
                    if ((wineTastePojo.getmMelonTaste()) == 0) {
                        mMelonContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmMelonTaste()) != 0) {
                        int mMelonValue = (wineTastePojo.getmMelonTaste());
                        mMelonSeekBar.setProgress(mMelonValue);
                    }

                    LinearLayout mGuavaContainer = (LinearLayout) findViewById(R.id.aj_guava_container);
                    SeekBar mGuavaSeekBar = (SeekBar) findViewById(R.id.seekBar_guava);
                    if ((wineTastePojo.getmGuavaTaste()) == 0) {
                        mGuavaContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmGuavaTaste()) != 0) {
                        int mGuavaValue = (wineTastePojo.getmGuavaTaste());
                        mGuavaSeekBar.setProgress(mGuavaValue);
                    }

                    LinearLayout mBananaContainer = (LinearLayout) findViewById(R.id.ds_banana_container);
                    SeekBar mBananaSeekBar = (SeekBar) findViewById(R.id.seekBar_banana);
                    if ((wineTastePojo.getmBananaTaste()) == 0) {
                        mBananaContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmBananaTaste()) != 0) {
                        int mBananaValue = (wineTastePojo.getmBananaTaste());
                        mBananaSeekBar.setProgress(mBananaValue);
                    }

                    LinearLayout mPineappleContainer = (LinearLayout) findViewById(R.id.ak_pineapple_container);
                    SeekBar mPineappleSeekBar = (SeekBar) findViewById(R.id.seekBar_pineapple);
                    if ((wineTastePojo.getmPineappleTaste()) == 0) {
                        mPineappleContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPineappleTaste()) != 0) {
                        int mPineappleValue = (wineTastePojo.getmPineappleTaste());
                        mPineappleSeekBar.setProgress(mPineappleValue);
                    }

                    LinearLayout mPassionfruitContainer = (LinearLayout) findViewById(R.id.al_passionfruit_container);
                    SeekBar mPassionfruitSeekBar = (SeekBar) findViewById(R.id.seekBar_passionfruit);
                    if ((wineTastePojo.getmPassionfruitTaste()) == 0) {
                        mPassionfruitContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPassionfruitTaste()) != 0) {
                        int mPassionfruitValue = (wineTastePojo.getmPassionfruitTaste());
                        mPassionfruitSeekBar.setProgress(mPassionfruitValue);
                    }

                    LinearLayout mLycheeContainer = (LinearLayout) findViewById(R.id.am_lychee_container);
                    SeekBar mLycheeSeekBar = (SeekBar) findViewById(R.id.seekBar_am_lychee);
                    if ((wineTastePojo.getmLycheeTaste()) == 0) {
                        mLycheeContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmLycheeTaste()) != 0) {
                        int mLycheeValue = (wineTastePojo.getmLycheeTaste());
                        mLycheeSeekBar.setProgress(mLycheeValue);
                    }

                    LinearLayout mRedcurrantContainer = (LinearLayout) findViewById(R.id.an_redcurrant_container);
                    SeekBar mRedcurrantSeekBar = (SeekBar) findViewById(R.id.seekBar_an_redcurrant);
                    if ((wineTastePojo.getmRedcurrantTaste()) == 0) {
                        mRedcurrantContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmRedcurrantTaste()) != 0) {
                        int mRedcurrantValue = (wineTastePojo.getmRedcurrantTaste());
                        mRedcurrantSeekBar.setProgress(mRedcurrantValue);
                    }

                    LinearLayout mBlackcurrantContainer = (LinearLayout) findViewById(R.id.ao_blackcurrant_container);
                    SeekBar mBlackcurrantSeekBar = (SeekBar) findViewById(R.id.seekBar_ao_blackcurrant);
                    if ((wineTastePojo.getmBlackcurrantTaste()) == 0) {
                        mBlackcurrantContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmBlackcurrantTaste()) != 0) {
                        int mBlackcurrantValue = (wineTastePojo.getmBlackcurrantTaste());
                        mBlackcurrantSeekBar.setProgress(mBlackcurrantValue);
                    }

                    LinearLayout mStrawberryContainer = (LinearLayout) findViewById(R.id.ap_strawberry_container);
                    SeekBar mStrawberrySeekBar = (SeekBar) findViewById(R.id.seekBar_ap_strawberry);
                    if ((wineTastePojo.getmStrawberryTaste()) == 0) {
                        mStrawberryContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmStrawberryTaste()) != 0) {
                        int mStrawberryValue = (wineTastePojo.getmStrawberryTaste());
                        mStrawberrySeekBar.setProgress(mStrawberryValue);
                    }

                    LinearLayout mBlackberryContainer = (LinearLayout) findViewById(R.id.aq_blackberry_container);
                    SeekBar mBlackberrySeekBar = (SeekBar) findViewById(R.id.seekBar_aq_blackberry);
                    if ((wineTastePojo.getmBlackberryTaste()) == 0) {
                        mBlackberryContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmBlackberryTaste()) != 0) {
                        int mBlackberryValue = (wineTastePojo.getmBlackberryTaste());
                        mBlackberrySeekBar.setProgress(mBlackberryValue);
                    }

                    LinearLayout mCherryContainer = (LinearLayout) findViewById(R.id.ab_ar_cherry_container);
                    SeekBar mCherrySeekBar = (SeekBar) findViewById(R.id.seekBar_ar_cherry);
                    if ((wineTastePojo.getmCherryTaste()) == 0) {
                        mCherryContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCherryTaste()) != 0) {
                        int mCherryValue = (wineTastePojo.getmCherryTaste());
                        mCherrySeekBar.setProgress(mCherryValue);
                    }

                    LinearLayout mPlumContainer = (LinearLayout) findViewById(R.id.ab_as_plum_container);
                    SeekBar mPlumSeekBar = (SeekBar) findViewById(R.id.seekBar_as_plum);
                    if ((wineTastePojo.getmPlumTaste()) == 0) {
                        mPlumContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPlumTaste()) != 0) {
                        int mPlumValue = (wineTastePojo.getmPlumTaste());
                        mPlumSeekBar.setProgress(mPlumValue);
                    }

                    LinearLayout mGreenpepperContainer = (LinearLayout) findViewById(R.id.ab_bb_greenpepper_container);
                    SeekBar mGreenpepperSeekBar = (SeekBar) findViewById(R.id.seekBar_bb_greenpepper);
                    if ((wineTastePojo.getmGreenpepperTaste()) == 0) {
                        mGreenpepperContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmGreenpepperTaste()) != 0) {
                        int mGreenpepperValue = (wineTastePojo.getmGreenpepperTaste());
                        mGreenpepperSeekBar.setProgress(mGreenpepperValue);
                    }

                    LinearLayout mTomatoContainer = (LinearLayout) findViewById(R.id.bc_tomato_container);
                    SeekBar mTomatoSeekBar = (SeekBar) findViewById(R.id.seekBar_bc_tomato);
                    ///this.mTomatoTaste = mTomatoTaste;
                    if ((wineTastePojo.getmTomatoTaste()) == 0) {
                        mTomatoContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmTomatoTaste()) != 0) {
                        int mTomatoValue = (wineTastePojo.getmTomatoTaste());
                        mTomatoSeekBar.setProgress(mTomatoValue);
                    }

                    LinearLayout mMintContainer = (LinearLayout) findViewById(R.id.bg_mint_container);
                    SeekBar mMintSeekBar = (SeekBar) findViewById(R.id.seekBar_bg_mint);
                    if ((wineTastePojo.getmMintTaste()) == 0) {
                        mMintContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmMintTaste()) != 0) {
                        int mMintValue = (wineTastePojo.getmMintTaste());
                        mMintSeekBar.setProgress(mMintValue);
                    }

                    LinearLayout mTobaccoContainer = (LinearLayout) findViewById(R.id.bh_tobacco_container);
                    SeekBar mTobaccoSeekBar = (SeekBar) findViewById(R.id.seekBar_bh_tobacco);
                    if ((wineTastePojo.getmTobaccoTaste()) == 0) {
                        mTobaccoContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmTobaccoTaste()) != 0) {
                        int mTobaccoValue = (wineTastePojo.getmTobaccoTaste());
                        mTobaccoSeekBar.setProgress(mTobaccoValue);
                    }

                    LinearLayout mHayContainer = (LinearLayout) findViewById(R.id.bi_hay_container);
                    SeekBar mHaySeekBar = (SeekBar) findViewById(R.id.seekBar_bi_hay);
                    if ((wineTastePojo.getmHayTaste()) == 0) {
                        mHayContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmHayTaste()) != 0) {
                        int mHayValue = (wineTastePojo.getmHayTaste());
                        mHaySeekBar.setProgress(mHayValue);
                    }

                    LinearLayout mKeroseneContainer = (LinearLayout) findViewById(R.id.bm_kerosene_container);
                    SeekBar mKeroseneSeekBar = (SeekBar) findViewById(R.id.seekBar_bm_kerosene);
                    if ((wineTastePojo.getmKeroseneTaste()) == 0) {
                        mKeroseneContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmKeroseneTaste()) != 0) {
                        int mKeroseneValue = (wineTastePojo.getmKeroseneTaste());
                        mKeroseneSeekBar.setProgress(mKeroseneValue);
                    }

                    LinearLayout mButterContainer = (LinearLayout) findViewById(R.id.bq_butter_container);
                    SeekBar mButterSeekBar = (SeekBar) findViewById(R.id.seekBar_bq_butter);
                    if ((wineTastePojo.getmButterTaste()) == 0) {
                        mButterContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmButterTaste()) != 0) {
                        int mButterValue = (wineTastePojo.getmButterTaste());
                        mButterSeekBar.setProgress(mButterValue);
                    }

                    LinearLayout mToastedbreadContainer = (LinearLayout) findViewById(R.id.br_toastedbread_container);
                    SeekBar mToastedbreadSeekBar = (SeekBar) findViewById(R.id.seekBar_br_toastedbread);
                    if ((wineTastePojo.getmToastedbreadTaste()) == 0) {
                        mToastedbreadContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmToastedbreadTaste()) != 0) {
                        int mToastedbreadValue = (wineTastePojo.getmToastedbreadTaste());
                        mToastedbreadSeekBar.setProgress(mToastedbreadValue);
                    }

                    LinearLayout mCoffeeContainer = (LinearLayout) findViewById(R.id.bs_coffee_container);
                    SeekBar mCoffeeSeekBar = (SeekBar) findViewById(R.id.seekBar_bs_coffee);
                    if ((wineTastePojo.getmCoffeeTaste()) == 0) {
                        mCoffeeContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCoffeeTaste()) != 0) {
                        int mCoffeeValue = (wineTastePojo.getmCoffeeTaste());
                        mCoffeeSeekBar.setProgress(mCoffeeValue);
                    }

                    LinearLayout mVanilaContainer = (LinearLayout) findViewById(R.id.bu_vanilla_container);
                    SeekBar mVanilaSeekBar = (SeekBar) findViewById(R.id.seekBar_bu_vanilla);
                    if ((wineTastePojo.getmVanilaTaste()) == 0) {
                        mVanilaContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmVanilaTaste()) != 0) {
                        int mVanilaValue = (wineTastePojo.getmVanilaTaste());
                        mVanilaSeekBar.setProgress(mVanilaValue);
                    }

                    LinearLayout mPepperContainer = (LinearLayout) findViewById(R.id.bv_pepper_container);
                    SeekBar mPepperSeekBar = (SeekBar) findViewById(R.id.seekBar_bv_pepper);
                    if ((wineTastePojo.getmPepperTaste()) == 0) {
                        mPepperContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPepperTaste()) != 0) {
                        int mPepperValue = (wineTastePojo.getmPepperTaste());
                        mPepperSeekBar.setProgress(mPepperValue);
                    }

                    LinearLayout mCinnamonContainer = (LinearLayout) findViewById(R.id.bw_cinnamon_container);
                    SeekBar mCinnamonSeekBar = (SeekBar) findViewById(R.id.seekBar_bw_cinnamon);
                    if ((wineTastePojo.getmCinnamonTaste()) == 0) {
                        mCinnamonContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCinnamonTaste()) != 0) {
                        int mCinnamonValue = (wineTastePojo.getmCinnamonTaste());
                        mCinnamonSeekBar.setProgress(mCinnamonValue);
                    }

                    LinearLayout mLicoriceContainer = (LinearLayout) findViewById(R.id.bx_licorice_container);
                    SeekBar mLicoriceSeekBar = (SeekBar) findViewById(R.id.seekBar_bx_licorice);
                    if ((wineTastePojo.getmLicoriceTaste()) == 0) {
                        mLicoriceContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmLicoriceTaste()) != 0) {
                        int mLicoriceValue = (wineTastePojo.getmLicoriceTaste());
                        mLicoriceSeekBar.setProgress(mLicoriceValue);
                    }

                    LinearLayout mCloveContainer = (LinearLayout) findViewById(R.id.bz_clove_container);
                    SeekBar mCloveSeekBar = (SeekBar) findViewById(R.id.seekBar_bz_clove);
                    if ((wineTastePojo.getmCloveTaste()) == 0) {
                        mCloveContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCloveTaste()) != 0) {
                        int mCloveValue = (wineTastePojo.getmCloveTaste());
                        mCloveSeekBar.setProgress(mCloveValue);
                    }

                    LinearLayout mCoconutContainer = (LinearLayout) findViewById(R.id.ca_coconut_container);
                    SeekBar mCoconutSeekBar = (SeekBar) findViewById(R.id.seekBar_ca_coconut);
                    if ((wineTastePojo.getmCoconutTaste()) == 0) {
                        mCoconutContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCoconutTaste()) != 0) {
                        int mCoconutValue = (wineTastePojo.getmCoconutTaste());
                        mCoconutSeekBar.setProgress(mCoconutValue);
                    }


                    LinearLayout mHazelnutContainer = (LinearLayout) findViewById(R.id.cb_hazelnut_container);
                    SeekBar mHazelnutSeekBar = (SeekBar) findViewById(R.id.seekBar_cb_hazelnut);
                    if ((wineTastePojo.getmHazelnutTaste()) == 0) {
                        mHazelnutContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmHazelnutTaste()) != 0) {
                        int mHazelnutValue = (wineTastePojo.getmHazelnutTaste());
                        mHazelnutSeekBar.setProgress(mHazelnutValue);
                    }

                    LinearLayout mAlmondContainer = (LinearLayout) findViewById(R.id.cc_almond_container);
                    SeekBar mAlmondSeekBar = (SeekBar) findViewById(R.id.seekBar_cc_almond);
                    if ((wineTastePojo.getmAlmondTaste()) == 0) {
                        mAlmondContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmAlmondTaste()) != 0) {
                        int mAlmondValue = (wineTastePojo.getmAlmondTaste());
                        mAlmondSeekBar.setProgress(mAlmondValue);
                    }

                    LinearLayout mOakContainer = (LinearLayout) findViewById(R.id.cd_oak_container);
                    SeekBar mOakSeekBar = (SeekBar) findViewById(R.id.seekBar_cd_oak);
                    if ((wineTastePojo.getmOakTaste()) == 0) {
                        mOakContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmOakTaste()) != 0) {
                        int mOakValue = (wineTastePojo.getmOakTaste());
                        mOakSeekBar.setProgress(mOakValue);
                    }

                    LinearLayout mOrangepeelContainer = (LinearLayout) findViewById(R.id.ch_orangepeel_container);
                    SeekBar mOrangepeelSeekBar = (SeekBar) findViewById(R.id.seekBar_ch_orangepeel);
                    if ((wineTastePojo.getmOrangepeelTaste()) == 0) {
                        mOrangepeelContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmOrangepeelTaste()) != 0) {
                        int mOrangepeelValue = (wineTastePojo.getmOrangepeelTaste());
                        mOrangepeelSeekBar.setProgress(mOrangepeelValue);
                    }

                    LinearLayout mDriedapricotContainer = (LinearLayout) findViewById(R.id.ci_driedapricot_container);
                    SeekBar mDriedapricotSeekBar = (SeekBar) findViewById(R.id.seekBar_ci_driedapricot);
                    if ((wineTastePojo.getmDriedapricotTaste()) == 0) {
                        mDriedapricotContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmDriedapricotTaste()) != 0) {
                        int mDriedapricotValue = (wineTastePojo.getmDriedapricotTaste());
                        mDriedapricotSeekBar.setProgress(mDriedapricotValue);
                    }

                    LinearLayout mPruneContainer = (LinearLayout) findViewById(R.id.cj_prune_container);
                    SeekBar mPruneSeekBar = (SeekBar) findViewById(R.id.seekBar_cj_prune);
                    if ((wineTastePojo.getmPruneTaste()) == 0) {
                        mPruneContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPruneTaste()) != 0) {
                        int mPruneValue = (wineTastePojo.getmPruneTaste());
                        mPruneSeekBar.setProgress(mPruneValue);
                    }

                    LinearLayout mHoneyContainer = (LinearLayout) findViewById(R.id.ck_honey_container);
                    SeekBar mHoneySeekBar = (SeekBar) findViewById(R.id.seekBar_ck_honey);
                    if ((wineTastePojo.getmHoneyTaste()) == 0) {
                        mHoneyContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmHoneyTaste()) != 0) {
                        int mHoneyValue = (wineTastePojo.getmHoneyTaste());
                        mHoneySeekBar.setProgress(mHoneyValue);
                    }

                    LinearLayout mChocolateContainer = (LinearLayout) findViewById(R.id.cl_chocolate_container);
                    SeekBar mChocolateSeekBar = (SeekBar) findViewById(R.id.seekBar_cl_chocolate);
                    if ((wineTastePojo.getmChocolateTaste()) == 0) {
                        mChocolateContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmChocolateTaste()) != 0) {
                        int mChocolateValue = (wineTastePojo.getmChocolateTaste());
                        mChocolateSeekBar.setProgress(mChocolateValue);
                    }

                    LinearLayout mLeatherContainer = (LinearLayout) findViewById(R.id.cn_leather_container);
                    SeekBar mLeatherSeekBar = (SeekBar) findViewById(R.id.seekBar_cn_leather);
                    if ((wineTastePojo.getmLeatherTaste()) == 0) {
                        mLeatherContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmLeatherTaste()) != 0) {
                        int mLeatherValue = (wineTastePojo.getmLeatherTaste());
                        mLeatherSeekBar.setProgress(mLeatherValue);
                    }

                    LinearLayout mMushroomContainer = (LinearLayout) findViewById(R.id.co_mushroom_container);
                    SeekBar mMushroomSeekBar = (SeekBar) findViewById(R.id.seekBar_co_mushroom);
                    if ((wineTastePojo.getmMushroomTaste()) == 0) {
                        mMushroomContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmMushroomTaste()) != 0) {
                        int mMushroomValue = (wineTastePojo.getmMushroomTaste());
                        mMushroomSeekBar.setProgress(mMushroomValue);
                    }

                    LinearLayout mTruffleContainer = (LinearLayout) findViewById(R.id.cp_truffle_container);
                    SeekBar mTruffleSeekBar = (SeekBar) findViewById(R.id.seekBar_cp_truffle);
                    if ((wineTastePojo.getmTruffleTaste()) == 0) {
                        mTruffleContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmTruffleTaste()) != 0) {
                        int mTruffleValue = (wineTastePojo.getmTruffleTaste());
                        mTruffleSeekBar.setProgress(mTruffleValue);
                    }

                    LinearLayout mCorkContainer = (LinearLayout) findViewById(R.id.cq_cork_container);
                    SeekBar mCorkSeekBar = (SeekBar) findViewById(R.id.seekBar_cq_cork);
                    if ((wineTastePojo.getmCorkTaste()) == 0) {
                        mCorkContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCorkTaste()) != 0) {
                        int mCorkValue = (wineTastePojo.getmCorkTaste());
                        mCorkSeekBar.setProgress(mCorkValue);
                    }

                    LinearLayout mRubberbandContainer = (LinearLayout) findViewById(R.id.cv_rubberband_container);
                    SeekBar mRubberbandSeekBar = (SeekBar) findViewById(R.id.seekBar_cv_rubberband);
                    //this.mRubberbandTaste = mRubberbandTaste;
                    if ((wineTastePojo.getmRubberbandTaste()) == 0) {
                        mRubberbandContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmRubberbandTaste()) != 0) {
                        int mRubberbandValue = (wineTastePojo.getmRubberbandTaste());
                        mRubberbandSeekBar.setProgress(mRubberbandValue);
                    }

                    LinearLayout mEggContainer = (LinearLayout) findViewById(R.id.cw_egg_container);
                    SeekBar mEggSeekBar = (SeekBar) findViewById(R.id.seekBar_cw_egg);
                    //this.mEggTaste = mEggTaste;
                    if ((wineTastePojo.getmEggTaste()) == 0) {
                        mEggContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmEggTaste()) != 0) {
                        int mEggValue = (wineTastePojo.getmEggTaste());
                        mEggSeekBar.setProgress(mEggValue);
                    }

                    LinearLayout mOnionContainer = (LinearLayout) findViewById(R.id.cx_onion_container);
                    SeekBar mOnionSeekBar = (SeekBar) findViewById(R.id.seekBar_cx_onion);
                    if ((wineTastePojo.getmOnionTaste()) == 0) {
                        mOnionContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmOnionTaste()) != 0) {
                        int mOnionValue = (wineTastePojo.getmOnionTaste());
                        mOnionSeekBar.setProgress(mOnionValue);
                    }

                    LinearLayout mCornContainer = (LinearLayout) findViewById(R.id.cy_corn_container);
                    SeekBar mCornSeekBar = (SeekBar) findViewById(R.id.seekBar_cy_corn);
                    //this.mCornTaste = mCornTaste;
                    if ((wineTastePojo.getmCornTaste()) == 0) {
                        mCornContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCornTaste()) != 0) {
                        int mCornValue = (wineTastePojo.getmCornTaste());
                        mCornSeekBar.setProgress(mCornValue);
                    }

                    LinearLayout mHoneysuckleContainer = (LinearLayout) findViewById(R.id.as_honeysuckle_20_container);
                    SeekBar mHoneysuckleSeekBar = (SeekBar) findViewById(R.id.seekBar_as_honeysuckle_20);
                    //this.mHoneysuckleTaste = mHoneysuckleTaste;
                    if ((wineTastePojo.getmHoneysuckleTaste()) == 0) {
                        mHoneysuckleContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmHoneysuckleTaste()) != 0) {
                        int mHoneysuckleValue = (wineTastePojo.getmHoneysuckleTaste());
                        mHoneysuckleSeekBar.setProgress(mHoneysuckleValue);
                    }

                    LinearLayout mGeraniumContainer = (LinearLayout) findViewById(R.id.at_geranium_21_container);
                    SeekBar mGeraniumSeekBar = (SeekBar) findViewById(R.id.seekBar_at_geranium_21);
                    //this.mGeraniumTaste = mGeraniumTaste;
                    if ((wineTastePojo.getmGeraniumTaste()) == 0) {
                        mGeraniumContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmGeraniumTaste()) != 0) {
                        int mGeraniumValue = (wineTastePojo.getmGeraniumTaste());
                        mGeraniumSeekBar.setProgress(mGeraniumValue);
                    }

                    LinearLayout mOrangeblossumContainer = (LinearLayout) findViewById(R.id.au_orange_blossum_22_container);
                    SeekBar mOrangeblossumSeekBar = (SeekBar) findViewById(R.id.seekBar_au_orange_blossum_22);
                    //this.mOrangeblossumTaste = mOrangeblossumTaste;
                    if ((wineTastePojo.getmOrangeblossumTaste()) == 0) {
                        mOrangeblossumContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmOrangeblossumTaste()) != 0) {
                        int mOrangeblossumValue = (wineTastePojo.getmOrangeblossumTaste());
                        mOrangeblossumSeekBar.setProgress(mOrangeblossumValue);
                    }

                    LinearLayout mAppleblossumContainer = (LinearLayout) findViewById(R.id.aw_apple_blossum_24_container);
                    SeekBar mAppleblossumSeekBar = (SeekBar) findViewById(R.id.seekBar_aw_apple_blossum_24);
                    //this.mAppleblossumTaste = mAppleblossumTaste;
                    if ((wineTastePojo.getmAppleblossumTaste()) == 0) {
                        mAppleblossumContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmAppleblossumTaste()) != 0) {
                        int mAppleblossumValue = (wineTastePojo.getmAppleblossumTaste());
                        mAppleblossumSeekBar.setProgress(mAppleblossumValue);
                    }

                    LinearLayout mVioletContainer = (LinearLayout) findViewById(R.id.ay_violet_26_container);
                    SeekBar mVioletSeekBar = (SeekBar) findViewById(R.id.seekBar_ay_violet_26);
                    //this.mCornTaste = mCornTaste;
                    if ((wineTastePojo.getmVioletTaste()) == 0) {
                        mVioletContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmVioletTaste()) != 0) {
                        int mVioletValue = (wineTastePojo.getmVioletTaste());
                        mVioletSeekBar.setProgress(mVioletValue);
                    }


                    LinearLayout mLavenderContainer = (LinearLayout) findViewById(R.id.az_lavendar_27_container);
                    SeekBar mLavenderSeekBar = (SeekBar) findViewById(R.id.seekBar_az_lavendar_27);
                    //this.mLavenderTaste = mLavenderTaste;
                    if ((wineTastePojo.getmLavenderTaste()) == 0) {
                        mLavenderContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCornTaste()) != 0) {
                        int mLavenderValue = (wineTastePojo.getmLavenderTaste());
                        mLavenderSeekBar.setProgress(mLavenderValue);
                    }

                    LinearLayout mRoseContainer = (LinearLayout) findViewById(R.id.ba_rose_28_container);
                    SeekBar mRoseSeekBar = (SeekBar) findViewById(R.id.seekBar_ba_rose_28);
                    //this.mRoseTaste = mRoseTaste;
                    if ((wineTastePojo.getmRoseTaste()) == 0) {
                        mRoseContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmRoseTaste()) != 0) {
                        int mRoseValue = (wineTastePojo.getmRoseTaste());
                        mRoseSeekBar.setProgress(mRoseValue);
                    }

                    LinearLayout mCutgrassContainer = (LinearLayout) findViewById(R.id.bd_cut_grass_31_container);
                    SeekBar mCutgrassSeekBar = (SeekBar) findViewById(R.id.seekBar_bd_cut_grass_31);
                    //this.mCutgrassTaste = mCutgrassTaste;
                    if ((wineTastePojo.getmCutgrassTaste()) == 0) {
                        mCutgrassContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCutgrassTaste()) != 0) {
                        int mCutgrassValue = (wineTastePojo.getmCutgrassTaste());
                        mCutgrassSeekBar.setProgress(mCutgrassValue);
                    }

                    LinearLayout mRosemaryContainer = (LinearLayout) findViewById(R.id.be_rosemary_32_container);
                    SeekBar mRosemarySeekBar = (SeekBar) findViewById(R.id.seekBar_be_rosemary_32);
                    //this.mRosemaryTaste = mRosemaryTaste;
                    if ((wineTastePojo.getmRosemaryTaste()) == 0) {
                        mRosemaryContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmRosemaryTaste()) != 0) {
                        int mRosemaryValue = (wineTastePojo.getmRosemaryTaste());
                        mRosemarySeekBar.setProgress(mRosemaryValue);
                    }

                    LinearLayout mThymeContainer = (LinearLayout) findViewById(R.id.bf_thyme_33_container);
                    SeekBar mThymeSeekBar = (SeekBar) findViewById(R.id.seekBar_bf_thyme_33);
                    //this.mThymeTaste = mThymeTaste;
                    if ((wineTastePojo.getmThymeTaste()) == 0) {
                        mThymeContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmThymeTaste()) != 0) {
                        int mThymeValue = (wineTastePojo.getmThymeTaste());
                        mThymeSeekBar.setProgress(mThymeValue);
                    }

                    LinearLayout mEucalyptusContainer = (LinearLayout) findViewById(R.id.bk_eucalyptus_38_container);
                    SeekBar mEucalyptusSeekBar = (SeekBar) findViewById(R.id.seekBar_bk_eucalyptus_38);
                    //this.mEucalyptusTaste = mEucalyptusTaste;
                    if ((wineTastePojo.getmEucalyptusTaste()) == 0) {
                        mEucalyptusContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmEucalyptusTaste()) != 0) {
                        int mEucalyptusValue = (wineTastePojo.getmEucalyptusTaste());
                        mEucalyptusSeekBar.setProgress(mEucalyptusValue);
                    }

                    LinearLayout mFlintContainer = (LinearLayout) findViewById(R.id.bl_flint_39_container);
                    SeekBar mFlintSeekBar = (SeekBar) findViewById(R.id.seekBar_bl_flint_39);
                    //this.mFlintTaste = mFlintTaste;
                    if ((wineTastePojo.getmFlintTaste()) == 0) {
                        mFlintContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmFlintTaste()) != 0) {
                        int mFlintValue = (wineTastePojo.getmFlintTaste());
                        mFlintSeekBar.setProgress(mFlintValue);
                    }

                    LinearLayout mBreadContainer = (LinearLayout) findViewById(R.id.bo_bread_42_container);
                    SeekBar mBreadSeekBar = (SeekBar) findViewById(R.id.seekBar_bo_bread_42);
                    //this.mBreadTaste = mBreadTaste;
                    if ((wineTastePojo.getmBreadTaste()) == 0) {
                        mBreadContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmBreadTaste()) != 0) {
                        int mBreadValue = (wineTastePojo.getmBreadTaste());
                        mBreadSeekBar.setProgress(mBreadValue);
                    }


                    LinearLayout mCreamContainer = (LinearLayout) findViewById(R.id.bp_cream_44_container);
                    SeekBar mCreamSeekBar = (SeekBar) findViewById(R.id.seekBar_bp_cream_44);
                    //this.mCreamTaste = mCreamTaste;
                    if ((wineTastePojo.getmCreamTaste()) == 0) {
                        mCreamContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCornTaste()) != 0) {
                        int mCreamValue = (wineTastePojo.getmCreamTaste());
                        mCreamSeekBar.setProgress(mCreamValue);
                    }

                    LinearLayout mSmokeContainer = (LinearLayout) findViewById(R.id.bt_smoke_47_container);
                    SeekBar mSmokeSeekBar = (SeekBar) findViewById(R.id.seekBar_bt_smoke_47);
                    //this.mSmokeTaste = mSmokeTaste;
                    if ((wineTastePojo.getmSmokeTaste()) == 0) {
                        mSmokeContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmSmokeTaste()) != 0) {
                        int mSmokeValue = (wineTastePojo.getmSmokeTaste());
                        mSmokeSeekBar.setProgress(mSmokeValue);
                    }

                    LinearLayout mNutmegContainer = (LinearLayout) findViewById(R.id.by_nutmeg_52_container);
                    SeekBar mNutmegSeekBar = (SeekBar) findViewById(R.id.seekBar_by_nutmeg_52);
                    //this.mNutmegTaste = mNutmegTaste;
                    if ((wineTastePojo.getmNutmegTaste()) == 0) {
                        mNutmegContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmNutmegTaste()) != 0) {
                        int mNutmegValue = (wineTastePojo.getmNutmegTaste());
                        mNutmegSeekBar.setProgress(mNutmegValue);
                    }

                    LinearLayout mPineContainer = (LinearLayout) findViewById(R.id.cf_pine_59_container);
                    SeekBar mPineSeekBar = (SeekBar) findViewById(R.id.seekBar_cf_pine_59);
                    //this.mPineTaste = mPineTaste;
                    if ((wineTastePojo.getmPineTaste()) == 0) {
                        mPineContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPineTaste()) != 0) {
                        int mPineValue = (wineTastePojo.getmPineTaste());
                        mPineSeekBar.setProgress(mPineValue);
                    }

                    LinearLayout mCedarContainer = (LinearLayout) findViewById(R.id.cg_cedar_60_container);
                    SeekBar mCedarSeekBar = (SeekBar) findViewById(R.id.seekBar_cg_cedar_60);
                    //this.mCedarTaste = mCedarTaste;
                    if ((wineTastePojo.getmCedarTaste()) == 0) {
                        mCedarContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCedarTaste()) != 0) {
                        int mCedarValue = (wineTastePojo.getmCedarTaste());
                        mCedarSeekBar.setProgress(mCedarValue);
                    }

                    LinearLayout mFigContainer = (LinearLayout) findViewById(R.id.db_fig_container);
                    SeekBar mFigSeekBar = (SeekBar) findViewById(R.id.seekBar_db_fig);
                    //this.mFigTaste = mFigTaste;
                    if ((wineTastePojo.getmFigTaste()) == 0) {
                        mFigContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmFigTaste()) != 0) {
                        int mFigValue = (wineTastePojo.getmFigTaste());
                        mFigSeekBar.setProgress(mFigValue);
                    }


                    LinearLayout mFloralBoquetContainer = (LinearLayout) findViewById(R.id.dc_floral_container);
                    SeekBar mFloralSeekBar = (SeekBar) findViewById(R.id.seekBar_dc_floral);
                    //this.mFloralTaste = mFloralTaste;
                    if ((wineTastePojo.getmFloralTaste()) == 0) {
                        mFloralBoquetContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmFloralTaste()) != 0) {
                        int mFloralValue = (wineTastePojo.getmFloralTaste());
                        mFloralSeekBar.setProgress(mFloralValue);
                    }

                    LinearLayout mRaspberryContainer = (LinearLayout) findViewById(R.id.dd_raspberry_container);
                    SeekBar mRaspberrySeekBar = (SeekBar) findViewById(R.id.seekBar_dd_raspberry);
                    //this.mRaspberryTaste = mRaspberryTaste;
                    if ((wineTastePojo.getmRaspberryTaste()) == 0) {
                        mRaspberryContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmRaspberryTaste()) != 0) {
                        int mRaspberryValue = (wineTastePojo.getmRaspberryTaste());
                        mRaspberrySeekBar.setProgress(mRaspberryValue);
                    }

                    LinearLayout mJamContainer = (LinearLayout) findViewById(R.id.de_jam_container);
                    SeekBar mJamSeekBar = (SeekBar) findViewById(R.id.seekBar_de_jam);
                    //this.mJamTaste = mJamTaste;
                    if ((wineTastePojo.getmJamTaste()) == 0) {
                        mJamContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmJamTaste()) != 0) {
                        int mJamValue = (wineTastePojo.getmJamTaste());
                        mJamSeekBar.setProgress(mJamValue);
                    }

                    LinearLayout mKiwifruitContainer = (LinearLayout) findViewById(R.id.df_kiwifruit_container);
                    SeekBar mKiwifruitSeekBar = (SeekBar) findViewById(R.id.seekBar_df_kiwifruit);
                    //this.mKiwifruitTaste = mKiwifruitTaste;
                    if ((wineTastePojo.getmKiwifruitTaste()) == 0) {
                        mKiwifruitContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmKiwifruitTaste()) != 0) {
                        int mKiwifruitValue = (wineTastePojo.getmKiwifruitTaste());
                        mKiwifruitSeekBar.setProgress(mKiwifruitValue);
                    }

                    LinearLayout mMangoContainer = (LinearLayout) findViewById(R.id.dg_mango_container);
                    SeekBar mMangoSeekBar = (SeekBar) findViewById(R.id.seekBar_dg_mango);
                    //this.mMangoTaste = mMangoTaste;
                    if ((wineTastePojo.getmMangoTaste()) == 0) {
                        mMangoContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmMangoTaste()) != 0) {
                        int mMangoValue = (wineTastePojo.getmMangoTaste());
                        mMangoSeekBar.setProgress(mMangoValue);
                    }

                    LinearLayout mChiliContainer = (LinearLayout) findViewById(R.id.dh_chili_container);
                    SeekBar mChiliSeekBar = (SeekBar) findViewById(R.id.seekBar_dh_chili);
                    //this.mChiliTaste = mChiliTaste;
                    if ((wineTastePojo.getmChiliTaste()) == 0) {
                        mChiliContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmChiliTaste()) != 0) {
                        int mChiliValue = (wineTastePojo.getmChiliTaste());
                        mChiliSeekBar.setProgress(mChiliValue);
                    }

                    LinearLayout mPomegranateContainer = (LinearLayout) findViewById(R.id.di_pomegranate_container);
                    SeekBar mPomegranateSeekBar = (SeekBar) findViewById(R.id.seekBar_di_pomegranate);
                    //this.mPomegranateTaste = mPomegranateTaste;
                    if ((wineTastePojo.getmPomegranateTaste()) == 0) {
                        mPomegranateContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPomegranateTaste()) != 0) {
                        int mPomegranateValue = (wineTastePojo.getmPomegranateTaste());
                        mPomegranateSeekBar.setProgress(mPomegranateValue);
                    }

                    LinearLayout mWatermelonContainer = (LinearLayout) findViewById(R.id.dj_watermelon_container);
                    SeekBar mWatermelonSeekBar = (SeekBar) findViewById(R.id.seekBar_dj_watermelon);
                    //this.mWatermelonTaste = mWatermelonTaste;
                    if ((wineTastePojo.getmWatermelonTaste()) == 0) {
                        mWatermelonContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmWatermelonTaste()) != 0) {
                        int mWatermelonValue = (wineTastePojo.getmWatermelonTaste());
                        mWatermelonSeekBar.setProgress(mWatermelonValue);
                    }

                    LinearLayout mSaffronContainer = (LinearLayout) findViewById(R.id.dk_saffron_container);
                    SeekBar mSaffronSeekBar = (SeekBar) findViewById(R.id.seekBar_dk_saffron);
                    //this.mSaffronTaste = mSaffronTaste;
                    if ((wineTastePojo.getmSaffronTaste()) == 0) {
                        mSaffronContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmSaffronTaste()) != 0) {
                        int mSaffronValue = (wineTastePojo.getmSaffronTaste());
                        mSaffronSeekBar.setProgress(mSaffronValue);
                    }

                    LinearLayout mWalnutContainer = (LinearLayout) findViewById(R.id.dl_walnut_container);
                    SeekBar mWalnutSeekBar = (SeekBar) findViewById(R.id.seekBar_dl_walnut);
                    //this.mCornTaste = mCornTaste;
                    if ((wineTastePojo.getmWalnutTaste()) == 0) {
                        mWalnutContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmWalnutTaste()) != 0) {
                        int mWalnutValue = (wineTastePojo.getmWalnutTaste());
                        mWalnutSeekBar.setProgress(mWalnutValue);
                    }

                    LinearLayout mPeachContainer = (LinearLayout) findViewById(R.id.dm_peach_container);
                    SeekBar mPeachSeekBar = (SeekBar) findViewById(R.id.seekBar_dm_peach);
                    //this.mPeachTaste = mPeachTaste;
                    if ((wineTastePojo.getmPeachTaste()) == 0) {
                        mPeachContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmPeachTaste()) != 0) {
                        int mPeachValue = (wineTastePojo.getmPeachTaste());
                        mPeachSeekBar.setProgress(mPeachValue);
                    }

                    LinearLayout mCantelopeContainer = (LinearLayout) findViewById(R.id.dn_cantelope_container);
                    SeekBar mCantelopeSeekBar = (SeekBar) findViewById(R.id.seekBar_dn_cantelope);
                    //this.mCantelopeTaste = mCantelopeTaste;
                    if ((wineTastePojo.getmCantelopeTaste()) == 0) {
                        mCantelopeContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCantelopeTaste()) != 0) {
                        int mCantelopeValue = (wineTastePojo.getmCantelopeTaste());
                        mCantelopeSeekBar.setProgress(mCantelopeValue);
                    }

                    LinearLayout mBlueberryContainer = (LinearLayout) findViewById(R.id.dp_blueberry_container);
                    SeekBar mBlueberrySeekBar = (SeekBar) findViewById(R.id.seekBar_dp_blueberry);
                    //this.mBlueberryTaste = mBlueberryTaste;
                    if ((wineTastePojo.getmBlueberryTaste()) == 0) {
                        mBlueberryContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmBlueberryTaste()) != 0) {
                        int mBlueberryValue = (wineTastePojo.getmBlueberryTaste());
                        mBlueberrySeekBar.setProgress(mBlueberryValue);
                    }

                    LinearLayout mCaramelContainer = (LinearLayout) findViewById(R.id.dq_caramel_container);
                    SeekBar mCaramelSeekBar = (SeekBar) findViewById(R.id.seekBar_dq_caramel);
                    //this.mCaramelTaste = mCaramelTaste;
                    if ((wineTastePojo.getmCaramelTaste()) == 0) {
                        mCaramelContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmCaramelTaste()) != 0) {
                        int mCaramelValue = (wineTastePojo.getmCaramelTaste());
                        mCaramelSeekBar.setProgress(mCaramelValue);
                    }

                    LinearLayout mBlueCheeseContainer = (LinearLayout) findViewById(R.id.dr_blue_cheese_container);
                    SeekBar mBlueCheeseSeekBar = (SeekBar) findViewById(R.id.seekBar_dr_blue_cheese);
                    //this.mBlueCheeseTaste = mBlueCheeseTaste;
                    if ((wineTastePojo.getmBlueCheeseTaste()) == 0) {
                        mBlueCheeseContainer.setVisibility(View.GONE);
                    }
                    if ((wineTastePojo.getmBlueCheeseTaste()) != 0) {
                        int mBlueCheeseValue = (wineTastePojo.getmBlueCheeseTaste());
                        mBlueCheeseSeekBar.setProgress(mBlueCheeseValue);
                    }

                } else {
                    finish();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


        expandCollapseCitrusFruits = (RelativeLayout) findViewById(R.id.expand_collapse_citrus_fruits);
        expandCollapseCitrusFruits.setClickable(false);
        expandCitrusImage = (ImageView) findViewById(R.id.image_citrus_expand_less);
        expandCitrusImage.setVisibility(View.GONE);
        citrusFruitContainer = (CardView) findViewById(R.id.citrus_fruit_container);
        citrusFruitContainer.setVisibility(View.GONE);

        expandCollapseTreeFruits = (RelativeLayout) findViewById(R.id.expand_collapse_tree_fruits);
        expandCollapseTreeFruits.setClickable(false);
        expandTreeFruitImage = (ImageView) findViewById(R.id.image_tree_fruit_expand_less);
        expandTreeFruitImage.setVisibility(View.GONE);
        treeFruitContainer = (CardView) findViewById(R.id.tree_fruit_container);
        treeFruitContainer.setVisibility(View.GONE);

        expandCollapseTropicalFruits = (RelativeLayout) findViewById(R.id.expand_collapse_tropical_fruits);
        expandCollapseTropicalFruits.setClickable(false);
        expandTropicalFruitImage = (ImageView) findViewById(R.id.image_tropical_fruit_expand_less);
        expandTropicalFruitImage.setVisibility(View.GONE);
        tropicalFruitContainer = (CardView) findViewById(R.id.tropical_fruit_container);
        tropicalFruitContainer.setVisibility(View.GONE);

        expandCollapseDriedFruits = (RelativeLayout) findViewById(R.id.expand_collapse_dried_fruits);
        expandCollapseDriedFruits.setClickable(false);
        expandDriedFruitImage = (ImageView) findViewById(R.id.image_dried_fruit_expand_less);
        expandDriedFruitImage.setVisibility(View.GONE);
        driedFruitContainer = (CardView) findViewById(R.id.dried_fruit_container);
        driedFruitContainer.setVisibility(View.GONE);

        expandCollapseStoneFruits = (RelativeLayout) findViewById(R.id.expand_collapse_stone_fruits);
        expandCollapseStoneFruits.setClickable(false);
        expandStoneFruitImage = (ImageView) findViewById(R.id.image_stone_fruit_expand_less);
        expandStoneFruitImage.setVisibility(View.GONE);
        stoneFruitContainer = (CardView) findViewById(R.id.stone_fruit_container);
        stoneFruitContainer.setVisibility(View.GONE);

        expandCollapseBerriesandJam = (RelativeLayout) findViewById(R.id.expand_collapse_berry_and_jam);
        expandCollapseBerriesandJam.setClickable(false);
        expandBerriesandJamImage = (ImageView) findViewById(R.id.image_berry_and_jam_expand_less);
        expandBerriesandJamImage.setVisibility(View.GONE);
        berriesandjamContainer = (CardView) findViewById(R.id.berry_and_jam_container);
        berriesandjamContainer.setVisibility(View.GONE);

        expandCollapseBlossom = (RelativeLayout) findViewById(R.id.expand_collapse_blossom);
        expandCollapseBlossom.setClickable(false);
        expandBlossomImage = (ImageView) findViewById(R.id.image_blossom_expand_less);
        expandBlossomImage.setVisibility(View.GONE);
        blossomContainer = (CardView) findViewById(R.id.blossom_container);
        blossomContainer.setVisibility(View.GONE);

        expandCollapseFloral = (RelativeLayout) findViewById(R.id.expand_collapse_floral);
        expandCollapseFloral.setClickable(false);
        expandFloralImage = (ImageView) findViewById(R.id.image_floral_expand_less);
        expandFloralImage.setVisibility(View.GONE);
        floralContainer = (CardView) findViewById(R.id.floral_container);
        floralContainer.setVisibility(View.GONE);

        expandCollapseHerb = (RelativeLayout) findViewById(R.id.expand_collapse_herbs);
        expandCollapseHerb.setClickable(false);
        expandHerbImage = (ImageView) findViewById(R.id.image_herb_expand_less);
        expandHerbImage.setVisibility(View.GONE);
        herbContainer = (CardView) findViewById(R.id.herb_container);
        herbContainer.setVisibility(View.GONE);

        expandCollapseEarthy = (RelativeLayout) findViewById(R.id.expand_collapse_earthy);
        expandCollapseEarthy.setClickable(false);
        expandEarthyImage = (ImageView) findViewById(R.id.image_earthy_expand_less);
        expandEarthyImage.setVisibility(View.GONE);
        earthyContainer = (CardView) findViewById(R.id.earthy_container);
        earthyContainer.setVisibility(View.GONE);

        expandCollapseLeather = (RelativeLayout) findViewById(R.id.expand_collapse_leathery);
        expandCollapseLeather.setClickable(false);
        expandLeatheryImage = (ImageView) findViewById(R.id.image_leathery_expand_less);
        expandLeatheryImage.setVisibility(View.GONE);
        leatheryContainer = (CardView) findViewById(R.id.leathery_container);
        leatheryContainer.setVisibility(View.GONE);

        expandCollapseVegetable = (RelativeLayout) findViewById(R.id.expand_collapse_vegetable);
        expandCollapseVegetable.setClickable(false);
        expandVegetableImage = (ImageView) findViewById(R.id.image_vegetable_expand_less);
        expandVegetableImage.setVisibility(View.GONE);
        vegetableContainer = (CardView) findViewById(R.id.vegetable_container);
        vegetableContainer.setVisibility(View.GONE);

        expandCollapseWoody = (RelativeLayout) findViewById(R.id.expand_collapse_woody);
        expandCollapseWoody.setClickable(false);
        expandWoodyImage = (ImageView) findViewById(R.id.image_woody_expand_less);
        expandWoodyImage.setVisibility(View.GONE);
        woodyContainer = (CardView) findViewById(R.id.woody_container);
        woodyContainer.setVisibility(View.GONE);

        expandCollapseNutty = (RelativeLayout) findViewById(R.id.expand_collapse_nutty);
        expandCollapseNutty.setClickable(false);
        expandNuttyImage = (ImageView) findViewById(R.id.image_nutty_expand_less);
        expandNuttyImage.setVisibility(View.GONE);
        nuttyContainer = (CardView) findViewById(R.id.nutty_container);
        nuttyContainer.setVisibility(View.GONE);

        expandCollapseSpicy = (RelativeLayout) findViewById(R.id.expand_collapse_spicy);
        expandCollapseSpicy.setClickable(false);
        expandSpicyImage = (ImageView) findViewById(R.id.image_spicy_expand_less);
        expandSpicyImage.setVisibility(View.GONE);
        spicyContainer = (CardView) findViewById(R.id.spicy_container);
        spicyContainer.setVisibility(View.GONE);

        expandCollapseToasty = (RelativeLayout) findViewById(R.id.expand_collapse_toasty);
        expandCollapseToasty.setClickable(false);
        expandToastyImage = (ImageView) findViewById(R.id.image_toasty_expand_less);
        expandToastyImage.setVisibility(View.GONE);
        toastyContainer = (CardView) findViewById(R.id.toasty_container);
        toastyContainer.setVisibility(View.GONE);

        expandCollapseBakery = (RelativeLayout) findViewById(R.id.expand_collapse_bakery);
        expandCollapseBakery.setClickable(false);
        expandBakeryImage = (ImageView) findViewById(R.id.image_bakery_expand_less);
        expandBakeryImage.setVisibility(View.GONE);
        bakeryContainer = (CardView) findViewById(R.id.bakery_container);
        bakeryContainer.setVisibility(View.GONE);

        expandCollapseDairy = (RelativeLayout) findViewById(R.id.expand_collapse_dairy);
        expandCollapseDairy.setClickable(false);
        expandDairyImage = (ImageView) findViewById(R.id.image_dairy_expand_less);
        expandDairyImage.setVisibility(View.GONE);
        dairyContainer = (CardView) findViewById(R.id.dairy_container);
        dairyContainer.setVisibility(View.GONE);

        expandCollapseOther = (RelativeLayout) findViewById(R.id.expand_collapse_other);
        expandCollapseOther.setClickable(false);
        expandOtherImage = (ImageView) findViewById(R.id.image_other_expand_less);
        expandOtherImage.setVisibility(View.GONE);
        otherContainer = (CardView) findViewById(R.id.other_flavours_container);
        otherContainer.setVisibility(View.GONE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tasting_wine_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete_wine:
                deleteTastingWine();
                return true;
            case R.id.edit_wine:
                editTastingWine();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void deleteTastingWine() {
        Toast.makeText(TastingWineDetails.this, "This can't be deleted just yet as Andrew " +
                "hasn't written the code", Toast.LENGTH_SHORT).show();
    }

    public void editTastingWine() {
        Toast.makeText(TastingWineDetails.this, "This can't be edited just yet as Andrew " +
                "hasn't written the code", Toast.LENGTH_SHORT).show();
    }


    public void toggle_citrus_contents(View v) {
        citrusFruitContainer.setVisibility(citrusFruitContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_treefruit_contents(View v) {

        treeFruitContainer.setVisibility(treeFruitContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_tropicalfruit_contents(View v) {

        tropicalFruitContainer.setVisibility(tropicalFruitContainer.isShown()
                ? View.GONE
                : View.VISIBLE);

    }

    public void toggle_driedfruit_contents(View v) {

        driedFruitContainer.setVisibility(driedFruitContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_stonefruit_contents(View v) {

        stoneFruitContainer.setVisibility(stoneFruitContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_berry_and_jam_contents(View v) {

        berriesandjamContainer.setVisibility(berriesandjamContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_blossom_contents(View v) {

        blossomContainer.setVisibility(blossomContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_floral_contents(View v) {

        floralContainer.setVisibility(floralContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_herb_contents(View v) {

        herbContainer.setVisibility(herbContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_earthy_contents(View v) {

        earthyContainer.setVisibility(earthyContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_leathery_contents(View v) {

        leatheryContainer.setVisibility(leatheryContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_vegetable_contents(View v) {

        vegetableContainer.setVisibility(vegetableContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_woody_contents(View v) {

        woodyContainer.setVisibility(woodyContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_nutty_contents(View v) {

        nuttyContainer.setVisibility(nuttyContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_spicy_contents(View v) {

        spicyContainer.setVisibility(spicyContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_toasty_contents(View v) {

        toastyContainer.setVisibility(toastyContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_bakery_contents(View v) {

        bakeryContainer.setVisibility(bakeryContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_dairy_contents(View v) {

        dairyContainer.setVisibility(dairyContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }

    public void toggle_other_contents(View v) {

        otherContainer.setVisibility(otherContainer.isShown()
                ? View.GONE
                : View.VISIBLE);
    }


}
