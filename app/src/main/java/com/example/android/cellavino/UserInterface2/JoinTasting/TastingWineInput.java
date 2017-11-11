package com.example.android.cellavino.UserInterface2.JoinTasting;

import android.content.DialogInterface;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.app.AlertDialog;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.android.cellavino.PojoDirectory.UI2.PublicUserDetailsPojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastePojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastingPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface2.CreateTasting.CreateNewTasting;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Andrew on 17/08/2017.
 */

public class TastingWineInput extends AppCompatActivity {

    public FirebaseAuth mFirebaseAuth;

    private ValueEventListener mTastingWineAnswer;

    public FloatingActionButton mFloatingActionButtonPicture;

    private Toast mToastMessage;

    public SeekBar mGrapefruitInput;
    public SeekBar mLemonInput;
    public SeekBar mLimeInput;
    public SeekBar mOrangeInput;
    public SeekBar mOrangepeelInput;
    public SeekBar mAppleInput;
    public SeekBar mGrannysmithInput;
    public SeekBar mPearInput;
    public SeekBar mApricotInput;
    public SeekBar mBananaInput;
    public SeekBar mFigInput;
    public SeekBar mPomegranateInput;
    public SeekBar mMelonInput;
    public SeekBar mCantelopeInput;
    public SeekBar mMangoInput;
    public SeekBar mGuavaInput;
    public SeekBar mKiwifruitInput;
    public SeekBar mLycheeInput;
    public SeekBar mPassionfruitInput;
    public SeekBar mPineappleInput;
    public SeekBar mWatermelonInput;
    public SeekBar mDriedApricotInput;
    public SeekBar mPruneInput;
    public SeekBar mPeachInput;
    public SeekBar mCherryInput;
    public SeekBar mPlumInput;
    public SeekBar mJamInput;
    public SeekBar mRedcurrantInput;
    public SeekBar mBlackcurrantInput;
    public SeekBar mStrawberryInput;
    public SeekBar mBlackberryInput;
    public SeekBar mRaspberryInput;
    public SeekBar mBlueberryInput;
    public SeekBar mAppleblossomInput;
    public SeekBar mOrangeblossomInput;
    public SeekBar mFloralInput;
    public SeekBar mHoneysuckleInput;
    public SeekBar mGeraniumInput;
    public SeekBar mVioletInput;
    public SeekBar mLavenderInput;
    public SeekBar mRoseInput;
    public SeekBar mEucalyptusInput;
    public SeekBar mCutgrassInput;
    public SeekBar mRosemaryInput;
    public SeekBar mThymeInput;
    public SeekBar mMintInput;
    public SeekBar mHayInput;
    public SeekBar mMushroomInput;
    public SeekBar mTruffleInput;
    public SeekBar mLeatherInput;
    public SeekBar mGreenpepperInput;
    public SeekBar mTomatoInput;
    public SeekBar mCornInput;
    public SeekBar mOnionInput;
    public SeekBar mPineInput;
    public SeekBar mCedarInput;
    public SeekBar mOakInput;
    public SeekBar mHazelnutInput;
    public SeekBar mAlmondInput;
    public SeekBar mNutmegInput;
    public SeekBar mWalnutInput;
    public SeekBar mPepperInput;
    public SeekBar mCinnamonInput;
    public SeekBar mVanilaInput;
    public SeekBar mCloveInput;
    public SeekBar mChiliInput;
    public SeekBar mLicoriceInput;
    public SeekBar mSaffronInput;
    public SeekBar mTobaccoInput;
    public SeekBar mCoffeeInput;
    public SeekBar mBreadInput;
    public SeekBar mToastedBreadInput;
    public SeekBar mButterInput;
    public SeekBar mCreamInput;
    public SeekBar mBlueCheeseInput;
    public SeekBar mCoconutInput;
    public SeekBar mKeroseneInput;
    public SeekBar mHoneyInput;
    public SeekBar mChocolateInput;
    public SeekBar mCorkInput;
    public SeekBar mRubberbandInput;
    public SeekBar mEggInput;
    public SeekBar mFlintInput;
    public SeekBar mSmokeInput;
    public SeekBar mCaramelInput;


    public int mGrapefruitAnswer;
    public int mLemonAnswer;
    public int mLimeAnswer;
    public int mOrangeAnswer;
    public int mOrangepeelAnswer;
    public int mAppleAnswer;
    public int mGrannysmithAnswer;
    public int mPearAnswer;
    public int mApricotAnswer;
    public int mBananaAnswer;
    public int mFigAnswer;
    public int mPomegranateAnswer;
    public int mMelonAnswer;
    public int mCantelopeAnswer;
    public int mMangoAnswer;
    public int mGuavaAnswer;
    public int mKiwifruitAnswer;
    public int mLycheeAnswer;
    public int mPassionfruitAnswer;
    public int mPineappleAnswer;
    public int mWatermelonAnswer;
    public int mDriedApricotAnswer;
    public int mPruneAnswer;
    public int mPeachAnswer;
    public int mCherryAnswer;
    public int mPlumAnswer;
    public int mJamAnswer;
    public int mRedcurrantAnswer;
    public int mBlackcurrantAnswer;
    public int mStrawberryAnswer;
    public int mBlackberryAnswer;
    public int mRaspberryAnswer;
    public int mBlueberryAnswer;
    public int mAppleblossomAnswer;
    public int mOrangeblossomAnswer;
    public int mFloralAnswer;
    public int mHoneysuckleAnswer;
    public int mGeraniumAnswer;
    public int mVioletAnswer;
    public int mLavenderAnswer;
    public int mRoseAnswer;
    public int mEucalyptusAnswer;
    public int mCutgrassAnswer;
    public int mRosemaryAnswer;
    public int mThymeAnswer;
    public int mMintAnswer;
    public int mHayAnswer;
    public int mMushroomAnswer;
    public int mTruffleAnswer;
    public int mLeatherAnswer;
    public int mGreenpepperAnswer;
    public int mTomatoAnswer;
    public int mCornAnswer;
    public int mOnionAnswer;
    public int mPineAnswer;
    public int mCedarAnswer;
    public int mOakAnswer;
    public int mHazelnutAnswer;
    public int mAlmondAnswer;
    public int mNutmegAnswer;
    public int mWalnutAnswer;
    public int mPepperAnswer;
    public int mCinnamonAnswer;
    public int mVanilaAnswer;
    public int mCloveAnswer;
    public int mChiliAnswer;
    public int mLicoriceAnswer;
    public int mSaffronAnswer;
    public int mTobaccoAnswer;
    public int mCoffeeAnswer;
    public int mBreadAnswer;
    public int mToastedBreadAnswer;
    public int mButterAnswer;
    public int mCreamAnswer;
    public int mBlueCheeseAnswer;
    public int mCoconutAnswer;
    public int mKeroseneAnswer;
    public int mHoneyAnswer;
    public int mChocolateAnswer;
    public int mCorkAnswer;
    public int mRubberbandAnswer;
    public int mEggAnswer;
    public int mFlintAnswer;
    public int mSmokeAnswer;
    public int mCaramelAnswer;


    public int mGrapefruitValueNo;
    public int mGrapefruitDifference;
    public int mGrapefruitResult;
    public int mLemonValueNo;
    public int mLemonDifference;
    public int mLemonResult;
    public int mLimeValueNo;
    public int mLimeDifference;
    public int mLimeResult;
    public int mOrangeValueNo;
    public int mOrangeDifference;
    public int mOrangeResult;
    public int mOrangepeelValueNo;
    public int mOrangepeelDifference;
    public int mOrangepeelResult;
    public int mAppleValueNo;
    public int mAppleDifference;
    public int mAppleResult;
    public int mGrannysmithValueNo;
    public int mGrannysmithDifference;
    public int mGrannysmithResult;
    public int mPearValueNo;
    public int mPearDifference;
    public int mPearResult;
    public int mApricotValueNo;
    public int mApricotDifference;
    public int mApricotResult;
    public int mBananaValueNo;
    public int mBananaDifference;
    public int mBananaResult;
    public int mFigValueNo;
    public int mFigDifference;
    public int mFigResult;
    public int mPomegranateValueNo;
    public int mPomegranateDifference;
    public int mPomegranateResult;
    public int mMelonValueNo;
    public int mMelonDifference;
    public int mMelonResult;
    public int mCantelopeValueNo;
    public int mCantelopeDifference;
    public int mCantelopeResult;
    public int mMangoValueNo;
    public int mMangoDifference;
    public int mMangoResult;
    public int mGuavaValueNo;
    public int mGuavaDifference;
    public int mGuavaResult;
    public int mKiwifruitValueNo;
    public int mKiwifruitDifference;
    public int mKiwifruitResult;
    public int mLycheeValueNo;
    public int mLycheeDifference;
    public int mLycheeResult;
    public int mPassionfruitValueNo;
    public int mPassionfruitDifference;
    public int mPassionfruitResult;
    public int mPineappleValueNo;
    public int mPineappleDifference;
    public int mPineappleResult;
    public int mWatermelonValueNo;
    public int mWatermelonDifference;
    public int mWatermelonResult;

    public int mDriedApricotValueNo;
    public int mPruneValueNo;
    public int mPeachValueNo;
    public int mCherryValueNo;
    public int mPlumValueNo;
    public int mJamValueNo;
    public int mRedcurrantValueNo;
    public int mBlackcurrantValueNo;
    public int mStrawberryValueNo;
    public int mBlackberryValueNo;
    public int mRaspberryValueNo;
    public int mBlueberryValueNo;
    public int mAppleblossomValueNo;
    public int mOrangeblossomValueNo;
    public int mFloralValueNo;
    public int mHoneysuckleValueNo;
    public int mGeraniumValueNo;
    public int mVioletValueNo;
    public int mLavenderValueNo;
    public int mRoseValueNo;
    public int mEucalyptusValueNo;
    public int mCutgrassValueNo;
    public int mRosemaryValueNo;
    public int mThymeValueNo;
    public int mMintValueNo;
    public int mHayValueNo;
    public int mMushroomValueNo;
    public int mTruffleValueNo;
    public int mLeatherValueNo;
    public int mGreenpepperValueNo;
    public int mTomatoValueNo;
    public int mCornValueNo;
    public int mOnionValueNo;
    public int mPineValueNo;
    public int mCedarValueNo;
    public int mOakValueNo;
    public int mHazelnutValueNo;
    public int mAlmondValueNo;
    public int mNutmegValueNo;
    public int mWalnutValueNo;
    public int mPepperValueNo;
    public int mCinnamonValueNo;
    public int mVanilaValueNo;
    public int mCloveValueNo;
    public int mChiliValueNo;
    public int mLicoriceValueNo;
    public int mSaffronValueNo;
    public int mTobaccoValueNo;
    public int mCoffeeValueNo;
    public int mBreadValueNo;
    public int mToastedBreadValueNo;
    public int mButterValueNo;
    public int mCreamValueNo;
    public int mBlueCheeseValueNo;
    public int mCoconutValueNo;
    public int mKeroseneValueNo;
    public int mHoneyValueNo;
    public int mChocolateValueNo;
    public int mCorkValueNo;
    public int mRubberbandValueNo;
    public int mEggValueNo;
    public int mFlintValueNo;
    public int mSmokeValueNo;
    public int mCaramelValueNo;

    public int mDriedApricotDifference;
    public int mPruneDifference;
    public int mPeachDifference;
    public int mCherryDifference;
    public int mPlumDifference;
    public int mJamDifference;
    public int mRedcurrantDifference;
    public int mBlackcurrantDifference;
    public int mStrawberryDifference;
    public int mBlackberryDifference;
    public int mRaspberryDifference;
    public int mBlueberryDifference;
    public int mAppleblossomDifference;
    public int mOrangeblossomDifference;
    public int mFloralDifference;
    public int mHoneysuckleDifference;
    public int mGeraniumDifference;
    public int mVioletDifference;
    public int mLavenderDifference;
    public int mRoseDifference;
    public int mEucalyptusDifference;
    public int mCutgrassDifference;
    public int mRosemaryDifference;
    public int mThymeDifference;
    public int mMintDifference;
    public int mHayDifference;
    public int mMushroomDifference;
    public int mTruffleDifference;
    public int mLeatherDifference;
    public int mGreenpepperDifference;
    public int mTomatoDifference;
    public int mCornDifference;
    public int mOnionDifference;
    public int mPineDifference;
    public int mCedarDifference;
    public int mOakDifference;
    public int mHazelnutDifference;
    public int mAlmondDifference;
    public int mNutmegDifference;
    public int mWalnutDifference;
    public int mPepperDifference;
    public int mCinnamonDifference;
    public int mVanilaDifference;
    public int mCloveDifference;
    public int mChiliDifference;
    public int mLicoriceDifference;
    public int mSaffronDifference;
    public int mTobaccoDifference;
    public int mCoffeeDifference;
    public int mBreadDifference;
    public int mToastedBreadDifference;
    public int mButterDifference;
    public int mCreamDifference;
    public int mBlueCheeseDifference;
    public int mCoconutDifference;
    public int mKeroseneDifference;
    public int mHoneyDifference;
    public int mChocolateDifference;
    public int mCorkDifference;
    public int mRubberbandDifference;
    public int mEggDifference;
    public int mFlintDifference;
    public int mSmokeDifference;
    public int mCaramelDifference;

    public int mDriedApricotResult;
    public int mPruneResult;
    public int mPeachResult;
    public int mCherryResult;
    public int mPlumResult;
    public int mJamResult;
    public int mRedcurrantResult;
    public int mBlackcurrantResult;
    public int mStrawberryResult;
    public int mBlackberryResult;
    public int mRaspberryResult;
    public int mBlueberryResult;
    public int mAppleblossomResult;
    public int mOrangeblossomResult;
    public int mFloralResult;
    public int mHoneysuckleResult;
    public int mGeraniumResult;
    public int mVioletResult;
    public int mLavenderResult;
    public int mRoseResult;
    public int mEucalyptusResult;
    public int mCutgrassResult;
    public int mRosemaryResult;
    public int mThymeResult;
    public int mMintResult;
    public int mHayResult;
    public int mMushroomResult;
    public int mTruffleResult;
    public int mLeatherResult;
    public int mGreenpepperResult;
    public int mTomatoResult;
    public int mCornResult;
    public int mOnionResult;
    public int mPineResult;
    public int mCedarResult;
    public int mOakResult;
    public int mHazelnutResult;
    public int mAlmondResult;
    public int mNutmegResult;
    public int mWalnutResult;
    public int mPepperResult;
    public int mCinnamonResult;
    public int mVanilaResult;
    public int mCloveResult;
    public int mChiliResult;
    public int mLicoriceResult;
    public int mSaffronResult;
    public int mTobaccoResult;
    public int mCoffeeResult;
    public int mBreadResult;
    public int mToastedBreadResult;
    public int mButterResult;
    public int mCreamResult;
    public int mBlueCheeseResult;
    public int mCoconutResult;
    public int mKeroseneResult;
    public int mHoneyResult;
    public int mChocolateResult;
    public int mCorkResult;
    public int mRubberbandResult;
    public int mEggResult;
    public int mFlintResult;
    public int mSmokeResult;
    public int mCaramelResult;



    private String mTastingWineInput;
    private String mTastingListID;
    private String mTastingWineName;
    private String mTastingWineVintage;
    private String winePushID;
    private Button mSaveFinish;
    private Button mSaveAddNext;
    private CardView mWineItemSummaryCard;
    private TextView mWineName;
    private TextView mWineVintage;
    private TextView mWineVariety;

    public int tastingNegativePoints;
    public int grapefruitNegativePoints;
    public int lemonNegativePoints;
    public int limeNegativePoints;
    public int orangeNegativePoints;
    public int orangepeelNegativePoints;
    public int appleNegativePoints;
    public int grannysmithNegativePoints;
    public int pearNegativePoints;
    public int apricotNegativePoints;
    public int bananaNegativePoints;
    public int figNegativePoints;
    public int pomegranateNegativePoints;
    public int melonNegativePoints;
    public int cantelopeNegativePoints;
    public int mangoNegativePoints;
    public int guavaNegativePoints;
    public int kiwifruitNegativePoints;
    public int lycheeNegativePoints;
    public int passionfruitNegativePoints;
    public int pineappleNegativePoints;
    public int watermelonNegativePoints;
    public int driedApricotNegativePoints;
    public int pruneNegativePoints;
    public int peachNegativePoints;
    public int cherryNegativePoints;
    public int plumNegativePoints;
    public int jamNegativePoints;
    public int redcurrantNegativePoints;
    public int blackcurrantNegativePoints;
    public int strawberryNegativePoints;
    public int blackberryNegativePoints;
    public int raspberryNegativePoints;
    public int blueberryNegativePoints;
    public int appleblossomNegativePoints;
    public int orangeblossomNegativePoints;
    public int floralNegativePoints;
    public int honeysuckleNegativePoints;
    public int geraniumNegativePoints;
    public int violetNegativePoints;
    public int lavenderNegativePoints;
    public int roseNegativePoints;
    public int eucalyptusNegativePoints;
    public int cutgrassNegativePoints;
    public int rosemaryNegativePoints;
    public int thymeNegativePoints;
    public int mintNegativePoints;
    public int hayNegativePoints;
    public int mushroomNegativePoints;
    public int truffleNegativePoints;
    public int leatherNegativePoints;
    public int greenpepperNegativePoints;
    public int tomatoNegativePoints;
    public int cornNegativePoints;
    public int onionNegativePoints;
    public int pineNegativePoints;
    public int cedarNegativePoints;
    public int oakNegativePoints;
    public int hazelnutNegativePoints;
    public int almondNegativePoints;
    public int nutmegNegativePoints;
    public int walnutNegativePoints;
    public int pepperNegativePoints;
    public int cinnamonNegativePoints;
    public int vanilaNegativePoints;
    public int cloveNegativePoints;
    public int chiliNegativePoints;
    public int licoriceNegativePoints;
    public int saffronNegativePoints;
    public int tobaccoNegativePoints;
    public int coffeeNegativePoints;
    public int breadNegativePoints;
    public int toastedBreadNegativePoints;
    public int butterNegativePoints;
    public int creamNegativePoints;
    public int blueCheeseNegativePoints;
    public int coconutNegativePoints;
    public int keroseneNegativePoints;
    public int honeyNegativePoints;
    public int chocolateNegativePoints;
    public int corkNegativePoints;
    public int rubberbandNegativePoints;
    public int eggNegativePoints;
    public int flintNegativePoints;
    public int smokeNegativePoints;
    public int caramelNegativePoints;

    public double tastingPoints;
    public int mScore;

    public int scoreDenominator;
    public int grapefruitDenominator;
    public int lemonDenominator;
    public int limeDenominator;
    public int orangeDenominator;
    public int orangepeelDenominator;
    public int appleDenominator;
    public int grannysmithDenominator;
    public int pearDenominator;
    public int apricotDenominator;
    public int bananaDenominator;
    public int figDenominator;
    public int pomegranateDenominator;
    public int melonDenominator;
    public int cantelopeDenominator;
    public int mangoDenominator;
    public int guavaDenominator;
    public int kiwifruitDenominator;
    public int lycheeDenominator;
    public int passionfruitDenominator;
    public int pineappleDenominator;
    public int watermelonDenominator;
    public int driedApricotDenominator;
    public int pruneDenominator;
    public int peachDenominator;
    public int cherryDenominator;
    public int plumDenominator;
    public int jamDenominator;
    public int redcurrantDenominator;
    public int blackcurrantDenominator;
    public int strawberryDenominator;
    public int blackberryDenominator;
    public int raspberryDenominator;
    public int blueberryDenominator;
    public int appleblossomDenominator;
    public int orangeblossomDenominator;
    public int floralDenominator;
    public int honeysuckleDenominator;
    public int geraniumDenominator;
    public int violetDenominator;
    public int lavenderDenominator;
    public int roseDenominator;
    public int eucalyptusDenominator;
    public int cutgrassDenominator;
    public int rosemaryDenominator;
    public int thymeDenominator;
    public int mintDenominator;
    public int hayDenominator;
    public int mushroomDenominator;
    public int truffleDenominator;
    public int leatherDenominator;
    public int greenpepperDenominator;
    public int tomatoDenominator;
    public int cornDenominator;
    public int onionDenominator;
    public int pineDenominator;
    public int cedarDenominator;
    public int oakDenominator;
    public int hazelnutDenominator;
    public int almondDenominator;
    public int nutmegDenominator;
    public int walnutDenominator;
    public int pepperDenominator;
    public int cinnamonDenominator;
    public int vanilaDenominator;
    public int cloveDenominator;
    public int chiliDenominator;
    public int licoriceDenominator;
    public int saffronDenominator;
    public int tobaccoDenominator;
    public int coffeeDenominator;
    public int breadDenominator;
    public int toastedBreadDenominator;
    public int butterDenominator;
    public int creamDenominator;
    public int blueCheeseDenominator;
    public int coconutDenominator;
    public int keroseneDenominator;
    public int honeyDenominator;
    public int chocolateDenominator;
    public int corkDenominator;
    public int rubberbandDenominator;
    public int eggDenominator;
    public int flintDenominator;
    public int smokeDenominator;
    public int caramelDenominator;

    public int mUserFirebaseTotalPoints;
    public int mNewUserTotalPoints;
    public int mUserFirebaseMostRecentTastingPoints;
    public int mUserFirebaseTotalWinesTasted;
    public int mNewUserTotalWinesTasted;
    public int mUserWineTastingLevelNumber;


    public Firebase mUserPublicDetails;
    public Firebase mUserPublicDetailsTwo;
    public Firebase mTastingWineDetails;

    public RelativeLayout expandCollapseCitrusFruits;
    public CardView citrusFruitContainer;
    public RelativeLayout expandCollapseTropicalFruits;
    public CardView tropicalFruitContainer;
    public RelativeLayout expandCollapseTreeFruits;
    public CardView treeFruitContainer;
    public RelativeLayout expandCollapseDriedFruits;
    public CardView driedFruitContainer;
    public RelativeLayout expandCollapseStoneFruits;
    public CardView stoneFruitContainer;
    public RelativeLayout expandCollapseBerriesandJam;
    public CardView berriesandjamContainer;
    public RelativeLayout expandCollapseBlossom;
    public CardView blossomContainer;
    public RelativeLayout expandCollapseFloral;
    public CardView floralContainer;
    public RelativeLayout expandCollapseHerb;
    public CardView herbContainer;
    public RelativeLayout expandCollapseEarthy;
    public CardView earthyContainer;
    public RelativeLayout expandCollapseLeather;
    public CardView leatheryContainer;
    public RelativeLayout expandCollapseVegetable;
    public CardView vegetableContainer;
    public RelativeLayout expandCollapseWoody;
    public CardView woodyContainer;
    public RelativeLayout expandCollapseNutty;
    public CardView nuttyContainer;
    public RelativeLayout expandCollapseSpicy;
    public CardView spicyContainer;
    public RelativeLayout expandCollapseToasty;
    public CardView toastyContainer;
    public RelativeLayout expandCollapseBakery;
    public CardView bakeryContainer;
    public RelativeLayout expandCollapseDairy;
    public CardView dairyContainer;
    public RelativeLayout expandCollapseOther;
    public CardView otherContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        mTastingWineInput = bundle.getString(Constants.WINE_LIST_ID);
        mTastingListID = bundle.getString(Constants.TASTING_LIST_ID);

        setContentView(R.layout.create_new_tasting);

        mTastingWineDetails = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(mTastingListID).child(mTastingWineInput);

        mTastingWineDetails.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                WineTastingPojo wineTastingPojo = dataSnapshot.getValue(WineTastingPojo.class);

                if (wineTastingPojo == null) {
                    return;
                }

                mTastingWineName = wineTastingPojo.getWineName();
                mTastingWineVintage = wineTastingPojo.getWineVintage();

                setTitle(mTastingWineVintage + " " + mTastingWineName);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }

        });

        mFirebaseAuth = FirebaseAuth.getInstance();

        expandCollapseCitrusFruits = (RelativeLayout) findViewById(R.id.expand_collapse_citrus_fruits);
        citrusFruitContainer = (CardView) findViewById(R.id.citrus_fruit_container);
        citrusFruitContainer.setVisibility(View.GONE);

        expandCollapseTreeFruits = (RelativeLayout) findViewById(R.id.expand_collapse_tree_fruits);
        treeFruitContainer = (CardView) findViewById(R.id.tree_fruit_container);
        treeFruitContainer.setVisibility(View.GONE);

        expandCollapseTropicalFruits = (RelativeLayout) findViewById(R.id.expand_collapse_tropical_fruits);
        tropicalFruitContainer = (CardView) findViewById(R.id.tropical_fruit_container);
        tropicalFruitContainer.setVisibility(View.GONE);

        expandCollapseDriedFruits = (RelativeLayout) findViewById(R.id.expand_collapse_dried_fruits);
        driedFruitContainer = (CardView) findViewById(R.id.dried_fruit_container);
        driedFruitContainer.setVisibility(View.GONE);

        expandCollapseStoneFruits = (RelativeLayout) findViewById(R.id.expand_collapse_stone_fruits);
        stoneFruitContainer = (CardView) findViewById(R.id.stone_fruit_container);
        stoneFruitContainer.setVisibility(View.GONE);

        expandCollapseBerriesandJam = (RelativeLayout) findViewById(R.id.expand_collapse_berry_and_jam);
        berriesandjamContainer = (CardView) findViewById(R.id.berry_and_jam_container);
        berriesandjamContainer.setVisibility(View.GONE);

        expandCollapseBlossom = (RelativeLayout) findViewById(R.id.expand_collapse_blossom);
        blossomContainer = (CardView) findViewById(R.id.blossom_container);
        blossomContainer.setVisibility(View.GONE);

        expandCollapseFloral = (RelativeLayout) findViewById(R.id.expand_collapse_floral);
        floralContainer = (CardView) findViewById(R.id.floral_container);
        floralContainer.setVisibility(View.GONE);

        expandCollapseHerb = (RelativeLayout) findViewById(R.id.expand_collapse_herbs);
        herbContainer = (CardView) findViewById(R.id.herb_container);
        herbContainer.setVisibility(View.GONE);

        expandCollapseEarthy = (RelativeLayout) findViewById(R.id.expand_collapse_earthy);
        earthyContainer = (CardView) findViewById(R.id.earthy_container);
        earthyContainer.setVisibility(View.GONE);

        expandCollapseLeather = (RelativeLayout) findViewById(R.id.expand_collapse_leathery);
        leatheryContainer = (CardView) findViewById(R.id.leathery_container);
        leatheryContainer.setVisibility(View.GONE);

        expandCollapseVegetable = (RelativeLayout) findViewById(R.id.expand_collapse_vegetable);
        vegetableContainer = (CardView) findViewById(R.id.vegetable_container);
        vegetableContainer.setVisibility(View.GONE);

        expandCollapseWoody = (RelativeLayout) findViewById(R.id.expand_collapse_woody);
        woodyContainer = (CardView) findViewById(R.id.woody_container);
        woodyContainer.setVisibility(View.GONE);

        expandCollapseNutty = (RelativeLayout) findViewById(R.id.expand_collapse_nutty);
        nuttyContainer = (CardView) findViewById(R.id.nutty_container);
        nuttyContainer.setVisibility(View.GONE);

        expandCollapseSpicy = (RelativeLayout) findViewById(R.id.expand_collapse_spicy);
        spicyContainer = (CardView) findViewById(R.id.spicy_container);
        spicyContainer.setVisibility(View.GONE);

        expandCollapseToasty = (RelativeLayout) findViewById(R.id.expand_collapse_toasty);
        toastyContainer = (CardView) findViewById(R.id.toasty_container);
        toastyContainer.setVisibility(View.GONE);

        expandCollapseBakery = (RelativeLayout) findViewById(R.id.expand_collapse_bakery);
        bakeryContainer = (CardView) findViewById(R.id.bakery_container);
        bakeryContainer.setVisibility(View.GONE);

        expandCollapseDairy = (RelativeLayout) findViewById(R.id.expand_collapse_dairy);
        dairyContainer = (CardView) findViewById(R.id.dairy_container);
        dairyContainer.setVisibility(View.GONE);

        expandCollapseOther = (RelativeLayout) findViewById(R.id.expand_collapse_other);
        otherContainer = (CardView) findViewById(R.id.other_flavours_container);
        otherContainer.setVisibility(View.GONE);

        mWineItemSummaryCard = (CardView) findViewById(R.id.wine_list_item_details);
        mWineItemSummaryCard.setVisibility(View.GONE);
        mWineName = (TextView) findViewById(R.id.create_wine_name);
        mWineVintage = (TextView) findViewById(R.id.create_wine_vintage);
        mWineVariety = (TextView) findViewById(R.id.create_wine_variety);
        //TODO: Set the text here to the actual WineName, Vintage and Variety

        //Hide the Save Finish button, and then change the text to "Submit"
        mSaveFinish = (Button) findViewById(R.id.save_finish);
        mSaveFinish.setVisibility(View.GONE);
        mSaveAddNext = (Button) findViewById(R.id.save_add_next);
        mSaveAddNext.setText("Submit");

        mFloatingActionButtonPicture = (FloatingActionButton) findViewById(R.id.addTastingWineBottlePictureFab);
        mFloatingActionButtonPicture.setVisibility(View.GONE);


        //initialise the points value for this tasting.
        tastingNegativePoints = 0;
        scoreDenominator = 0;
        grapefruitDenominator = 0;
        lemonDenominator = 0;
        limeDenominator = 0;
        orangeDenominator = 0;
        orangepeelDenominator = 0;
        appleDenominator = 0;
        grannysmithDenominator = 0;
        pearDenominator = 0;
        apricotDenominator = 0;
        bananaDenominator = 0;
        figDenominator = 0;
        pomegranateDenominator = 0;
        melonDenominator = 0;
        cantelopeDenominator = 0;
        mangoDenominator = 0;
        guavaDenominator = 0;
        kiwifruitDenominator = 0;
        lycheeDenominator = 0;
        passionfruitDenominator = 0;
        pineappleDenominator = 0;
        watermelonDenominator = 0;
        driedApricotDenominator = 0;
        pruneDenominator = 0;
        peachDenominator = 0;
        cherryDenominator = 0;
        plumDenominator = 0;
        jamDenominator = 0;
        redcurrantDenominator = 0;
        blackcurrantDenominator = 0;
        strawberryDenominator = 0;
        blackberryDenominator = 0;
        raspberryDenominator = 0;
        blueberryDenominator = 0;
        appleblossomDenominator = 0;
        orangeblossomDenominator = 0;
        floralDenominator = 0;
        honeysuckleDenominator = 0;
        geraniumDenominator = 0;
        violetDenominator = 0;
        lavenderDenominator = 0;
        roseDenominator = 0;
        eucalyptusDenominator = 0;
        cutgrassDenominator = 0;
        rosemaryDenominator = 0;
        thymeDenominator = 0;
        mintDenominator = 0;
        hayDenominator = 0;
        mushroomDenominator = 0;
        truffleDenominator = 0;
        leatherDenominator = 0;
        greenpepperDenominator = 0;
        tomatoDenominator = 0;
        cornDenominator = 0;
        onionDenominator = 0;
        pineDenominator = 0;
        cedarDenominator = 0;
        oakDenominator = 0;
        hazelnutDenominator = 0;
        almondDenominator = 0;
        nutmegDenominator = 0;
        walnutDenominator = 0;
        pepperDenominator = 0;
        cinnamonDenominator = 0;
        vanilaDenominator = 0;
        cloveDenominator = 0;
        chiliDenominator = 0;
        licoriceDenominator = 0;
        saffronDenominator = 0;
        tobaccoDenominator = 0;
        coffeeDenominator = 0;
        breadDenominator = 0;
        toastedBreadDenominator = 0;
        butterDenominator = 0;
        creamDenominator = 0;
        blueCheeseDenominator = 0;
        coconutDenominator = 0;
        keroseneDenominator = 0;
        honeyDenominator = 0;
        chocolateDenominator = 0;
        corkDenominator = 0;
        rubberbandDenominator = 0;
        eggDenominator = 0;
        flintDenominator = 0;
        smokeDenominator = 0;
        caramelDenominator = 0;



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
                if (grapefruitValue <= 25) {
                    mToastMessage = Toast.makeText(TastingWineInput.this, "Hints of grapefruit", Toast.LENGTH_SHORT);
                }
                if (grapefruitValue >= 26 && grapefruitValue <= 50) {
                    mToastMessage = Toast.makeText(TastingWineInput.this, "Subtle grapefruit flavours", Toast.LENGTH_SHORT);
                }
                if (grapefruitValue >= 51 && grapefruitValue <= 75) {
                    mToastMessage = Toast.makeText(TastingWineInput.this, "Strong flavours of grapefruit", Toast.LENGTH_SHORT);
                }
                if (grapefruitValue >= 76) {
                    mToastMessage = Toast.makeText(TastingWineInput.this, "Intense grapefruit flavours", Toast.LENGTH_SHORT);
                }
                mGrapefruitValueNo = grapefruitValue;
                mToastMessage.show();
            }
        });

        mLemonInput = (SeekBar) findViewById(R.id.seekBar_lemon);
        mLemonInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lemonValue = 0;

            public void onProgressChanged(SeekBar mLemonInput, int progress, boolean fromUser) {
                lemonValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Lemon: " + lemonValue, Toast.LENGTH_SHORT);
                mLemonValueNo = lemonValue;
                mToastMessage.show();
            }
        });


        mLimeInput = (SeekBar) findViewById(R.id.seekBar_lime);
        mLimeInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int limeValue = 0;

            public void onProgressChanged(SeekBar mLimeInput, int progress, boolean fromUser) {
                limeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Lime: " + limeValue, Toast.LENGTH_SHORT);
                mLimeValueNo = limeValue;
                mToastMessage.show();
            }
        });

        mOrangeInput = (SeekBar) findViewById(R.id.seekBar_orange);
        mOrangeInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int orangeValue = 0;

            public void onProgressChanged(SeekBar mOrangeInput, int progress, boolean fromUser) {
                orangeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Orange: " + orangeValue, Toast.LENGTH_SHORT);
                mOrangeValueNo = orangeValue;
                mToastMessage.show();
            }
        });

        mOrangepeelInput = (SeekBar) findViewById(R.id.seekBar_ch_orangepeel);
        mOrangepeelInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int orangepeelValue = 0;

            public void onProgressChanged(SeekBar mOrangepeelInput, int progress, boolean fromUser) {
                orangepeelValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Orangepeel: " + orangepeelValue, Toast.LENGTH_SHORT);
                mOrangepeelValueNo = orangepeelValue;
                mToastMessage.show();
            }
        });


        mAppleInput = (SeekBar) findViewById(R.id.seekBar_apple);
        mAppleInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int appleValue = 0;

            public void onProgressChanged(SeekBar mAppleInput, int progress, boolean fromUser) {
                appleValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Apple: " + appleValue, Toast.LENGTH_SHORT);
                mAppleValueNo = appleValue;
                mToastMessage.show();
            }
        });

        mGrannysmithInput = (SeekBar) findViewById(R.id.seekBar_grannysmith);
        mGrannysmithInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int grannysmithValue = 0;

            public void onProgressChanged(SeekBar mGrannysmithInput, int progress, boolean fromUser) {
                grannysmithValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Grannysmith: " + grannysmithValue, Toast.LENGTH_SHORT);
                mGrannysmithValueNo = grannysmithValue;
                mToastMessage.show();
            }
        });

        mPearInput = (SeekBar) findViewById(R.id.seekBar_pear);
        mPearInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pearValue = 0;

            public void onProgressChanged(SeekBar mPearInput, int progress, boolean fromUser) {
                pearValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Pear: " + pearValue, Toast.LENGTH_SHORT);
                mPearValueNo = pearValue;
                mToastMessage.show();
            }
        });

        mApricotInput = (SeekBar) findViewById(R.id.seekBar_apricot);
        mApricotInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int apricotValue = 0;

            public void onProgressChanged(SeekBar mApricotInput, int progress, boolean fromUser) {
                apricotValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Apricot: " + apricotValue, Toast.LENGTH_SHORT);
                mApricotValueNo = apricotValue;
                mToastMessage.show();
            }
        });

        mBananaInput = (SeekBar) findViewById(R.id.seekBar_banana);
        mBananaInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int bananaValue = 0;

            public void onProgressChanged(SeekBar mBananaInput, int progress, boolean fromUser) {
                bananaValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Banana: " + bananaValue, Toast.LENGTH_SHORT);
                mBananaValueNo = bananaValue;
                mToastMessage.show();
            }
        });

        mFigInput = (SeekBar) findViewById(R.id.seekBar_db_fig);
        mFigInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int figValue = 0;

            public void onProgressChanged(SeekBar mFigInput, int progress, boolean fromUser) {
                figValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Fig: " + figValue, Toast.LENGTH_SHORT);
                mFigValueNo = figValue;
                mToastMessage.show();
            }
        });

        mPomegranateInput = (SeekBar) findViewById(R.id.seekBar_di_pomegranate);
        mPomegranateInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pomegranateValue = 0;

            public void onProgressChanged(SeekBar mPomegranateInput, int progress, boolean fromUser) {
                pomegranateValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Pomegranate: " + pomegranateValue, Toast.LENGTH_SHORT);
                mPomegranateValueNo = pomegranateValue;
                mToastMessage.show();
            }
        });

        mMelonInput = (SeekBar) findViewById(R.id.seekBar_melon);
        mMelonInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int melonValue = 0;

            public void onProgressChanged(SeekBar mMelonInput, int progress, boolean fromUser) {
                melonValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Melon: " + melonValue, Toast.LENGTH_SHORT);
                mMelonValueNo = melonValue;
                mToastMessage.show();
            }
        });

        mCantelopeInput = (SeekBar) findViewById(R.id.seekBar_dn_cantelope);
        mCantelopeInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cantelopeValue = 0;

            public void onProgressChanged(SeekBar mCantelopeInput, int progress, boolean fromUser) {
                cantelopeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Cantelope: " + cantelopeValue, Toast.LENGTH_SHORT);
                mCantelopeValueNo = cantelopeValue;
                mToastMessage.show();
            }
        });

        mMangoInput = (SeekBar) findViewById(R.id.seekBar_dg_mango);
        mMangoInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mangoValue = 0;

            public void onProgressChanged(SeekBar mMangoInput, int progress, boolean fromUser) {
                mangoValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Mango: " + mangoValue, Toast.LENGTH_SHORT);
                mMangoValueNo = mangoValue;
                mToastMessage.show();
            }
        });

        mGuavaInput = (SeekBar) findViewById(R.id.seekBar_guava);
        mGuavaInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int guavaValue = 0;

            public void onProgressChanged(SeekBar mGuavaInput, int progress, boolean fromUser) {
                guavaValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Guava: " + guavaValue, Toast.LENGTH_SHORT);
                mGuavaValueNo = guavaValue;
                mToastMessage.show();
            }
        });

        mKiwifruitInput = (SeekBar) findViewById(R.id.seekBar_df_kiwifruit);
        mKiwifruitInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int kiwifruitValue = 0;

            public void onProgressChanged(SeekBar mKiwifruitInput, int progress, boolean fromUser) {
                kiwifruitValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Kiwifruit: " + kiwifruitValue, Toast.LENGTH_SHORT);
                mKiwifruitValueNo = kiwifruitValue;
                mToastMessage.show();
            }
        });

        mLycheeInput = (SeekBar) findViewById(R.id.seekBar_am_lychee);
        mLycheeInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lycheeValue = 0;

            public void onProgressChanged(SeekBar mLycheeInput, int progress, boolean fromUser) {
                lycheeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Lychee: " + lycheeValue, Toast.LENGTH_SHORT);
                mLycheeValueNo = lycheeValue;
                mToastMessage.show();
            }
        });

        mPassionfruitInput = (SeekBar) findViewById(R.id.seekBar_passionfruit);
        mPassionfruitInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int passionfruitValue = 0;

            public void onProgressChanged(SeekBar mPassionfruitInput, int progress, boolean fromUser) {
                passionfruitValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Passionfruit: " + passionfruitValue, Toast.LENGTH_SHORT);
                mPassionfruitValueNo = passionfruitValue;
                mToastMessage.show();
            }
        });

        mPineappleInput = (SeekBar) findViewById(R.id.seekBar_pineapple);
        mPineappleInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pineappleValue = 0;

            public void onProgressChanged(SeekBar mPineappleInput, int progress, boolean fromUser) {
                pineappleValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Pineapple: " + pineappleValue, Toast.LENGTH_SHORT);
                mPineappleValueNo = pineappleValue;
                mToastMessage.show();
            }
        });

        mWatermelonInput = (SeekBar) findViewById(R.id.seekBar_dj_watermelon);
        mWatermelonInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int watermelonValue = 0;

            public void onProgressChanged(SeekBar mWatermelonInput, int progress, boolean fromUser) {
                watermelonValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Watermelon: " + watermelonValue, Toast.LENGTH_SHORT);
                mWatermelonValueNo = watermelonValue;
                mToastMessage.show();
            }
        });

        mDriedApricotInput = (SeekBar) findViewById(R.id.seekBar_ci_driedapricot);
        mDriedApricotInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int driedApricotValue = 0;

            public void onProgressChanged(SeekBar mDriedApricotInput, int progress, boolean fromUser) {
                driedApricotValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Dried Apricot: " + driedApricotValue, Toast.LENGTH_SHORT);
                mDriedApricotValueNo = driedApricotValue;
                mToastMessage.show();
            }
        });

        mPruneInput = (SeekBar) findViewById(R.id.seekBar_cj_prune);
        mPruneInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pruneValue = 0;

            public void onProgressChanged(SeekBar mPruneInput, int progress, boolean fromUser) {
                pruneValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Prune: " + pruneValue, Toast.LENGTH_SHORT);
                mPruneValueNo = pruneValue;
                mToastMessage.show();
            }
        });

        mPeachInput = (SeekBar) findViewById(R.id.seekBar_dm_peach);
        mPeachInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int peachValue = 0;

            public void onProgressChanged(SeekBar mPeachInput, int progress, boolean fromUser) {
                peachValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Peach: " + peachValue, Toast.LENGTH_SHORT);
                mPeachValueNo = peachValue;
                mToastMessage.show();
            }
        });

        mCherryInput = (SeekBar) findViewById(R.id.seekBar_ar_cherry);
        mCherryInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cherryValue = 0;

            public void onProgressChanged(SeekBar mCherryInput, int progress, boolean fromUser) {
                cherryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Cherry: " + cherryValue, Toast.LENGTH_SHORT);
                mCherryValueNo = cherryValue;
                mToastMessage.show();
            }
        });

        mPlumInput = (SeekBar) findViewById(R.id.seekBar_as_plum);
        mPlumInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int plumValue = 0;

            public void onProgressChanged(SeekBar mPlumInput, int progress, boolean fromUser) {
                plumValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Plum: " + plumValue, Toast.LENGTH_SHORT);
                mPlumValueNo = plumValue;
                mToastMessage.show();
            }
        });

        mJamInput = (SeekBar) findViewById(R.id.seekBar_de_jam);
        mJamInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int jamValue = 0;

            public void onProgressChanged(SeekBar mJamInput, int progress, boolean fromUser) {
                jamValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Jam: " + jamValue, Toast.LENGTH_SHORT);
                mJamValueNo = jamValue;
                mToastMessage.show();
            }
        });

        mRedcurrantInput = (SeekBar) findViewById(R.id.seekBar_an_redcurrant);
        mRedcurrantInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int redcurrantValue = 0;

            public void onProgressChanged(SeekBar mRedcurrantInput, int progress, boolean fromUser) {
                redcurrantValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Redcurrant: " + redcurrantValue, Toast.LENGTH_SHORT);
                mRedcurrantValueNo = redcurrantValue;
                mToastMessage.show();
            }
        });

        mBlackcurrantInput = (SeekBar) findViewById(R.id.seekBar_ao_blackcurrant);
        mBlackcurrantInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int blackcurrantValue = 0;

            public void onProgressChanged(SeekBar mBlackcurrantInput, int progress, boolean fromUser) {
                blackcurrantValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Blackcurrant: " + blackcurrantValue, Toast.LENGTH_SHORT);
                mBlackcurrantValueNo = blackcurrantValue;
                mToastMessage.show();
            }
        });

        mStrawberryInput = (SeekBar) findViewById(R.id.seekBar_ap_strawberry);
        mStrawberryInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int strawberryValue = 0;

            public void onProgressChanged(SeekBar mStrawberryInput, int progress, boolean fromUser) {
                strawberryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Strawberry: " + strawberryValue, Toast.LENGTH_SHORT);
                mStrawberryValueNo = strawberryValue;
                mToastMessage.show();
            }
        });

        mBlackberryInput = (SeekBar) findViewById(R.id.seekBar_aq_blackberry);
        mBlackberryInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int blackberryValue = 0;

            public void onProgressChanged(SeekBar mBlackberryInput, int progress, boolean fromUser) {
                blackberryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Blackberry: " + blackberryValue, Toast.LENGTH_SHORT);
                mBlackberryValueNo = blackberryValue;
                mToastMessage.show();
            }
        });

        mRaspberryInput = (SeekBar) findViewById(R.id.seekBar_dd_raspberry);
        mRaspberryInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int raspberryValue = 0;

            public void onProgressChanged(SeekBar mRaspberryInput, int progress, boolean fromUser) {
                raspberryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Raspberry: " + raspberryValue, Toast.LENGTH_SHORT);
                mRaspberryValueNo = raspberryValue;
                mToastMessage.show();
            }
        });

        mBlueberryInput = (SeekBar) findViewById(R.id.seekBar_dp_blueberry);
        mBlueberryInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int blueberryValue = 0;

            public void onProgressChanged(SeekBar mBlueberryInput, int progress, boolean fromUser) {
                blueberryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Blueberry: " + blueberryValue, Toast.LENGTH_SHORT);
                mBlueberryValueNo = blueberryValue;
                mToastMessage.show();
            }
        });

        mAppleblossomInput = (SeekBar) findViewById(R.id.seekBar_aw_apple_blossum_24);
        mAppleblossomInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int appleblossomValue = 0;

            public void onProgressChanged(SeekBar mAppleblossomInput, int progress, boolean fromUser) {
                appleblossomValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Appleblossom: " + appleblossomValue, Toast.LENGTH_SHORT);
                mAppleblossomValueNo = appleblossomValue;
                mToastMessage.show();
            }
        });

        mOrangeblossomInput = (SeekBar) findViewById(R.id.seekBar_au_orange_blossum_22);
        mOrangeblossomInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int orangeblossomValue = 0;

            public void onProgressChanged(SeekBar mOrangeblossomInput, int progress, boolean fromUser) {
                orangeblossomValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Orangeblossom: " + orangeblossomValue, Toast.LENGTH_SHORT);
                mOrangeblossomValueNo = orangeblossomValue;
                mToastMessage.show();
            }
        });

        mFloralInput = (SeekBar) findViewById(R.id.seekBar_dc_floral);
        mFloralInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int floralValue = 0;

            public void onProgressChanged(SeekBar mFloralInput, int progress, boolean fromUser) {
                floralValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Floral: " + floralValue, Toast.LENGTH_SHORT);
                mFloralValueNo = floralValue;
                mToastMessage.show();
            }
        });

        mHoneysuckleInput = (SeekBar) findViewById(R.id.seekBar_as_honeysuckle_20);
        mHoneysuckleInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int honeysuckleValue = 0;

            public void onProgressChanged(SeekBar mHoneysuckleInput, int progress, boolean fromUser) {
                honeysuckleValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Honeysuckle: " + honeysuckleValue, Toast.LENGTH_SHORT);
                mHoneysuckleValueNo = honeysuckleValue;
                mToastMessage.show();
            }
        });

        mGeraniumInput = (SeekBar) findViewById(R.id.seekBar_at_geranium_21);
        mGeraniumInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int geraniumValue = 0;

            public void onProgressChanged(SeekBar mGeraniumInput, int progress, boolean fromUser) {
                geraniumValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Geranium: " + geraniumValue, Toast.LENGTH_SHORT);
                mGeraniumValueNo = geraniumValue;
                mToastMessage.show();
            }
        });

        mVioletInput = (SeekBar) findViewById(R.id.seekBar_ay_violet_26);
        mVioletInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int violetValue = 0;

            public void onProgressChanged(SeekBar mVioletInput, int progress, boolean fromUser) {
                violetValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Violet: " + violetValue, Toast.LENGTH_SHORT);
                mFigValueNo = violetValue;
                mToastMessage.show();
            }
        });

        mLavenderInput = (SeekBar) findViewById(R.id.seekBar_az_lavendar_27);
        mLavenderInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lavenderValue = 0;

            public void onProgressChanged(SeekBar mLavenderInput, int progress, boolean fromUser) {
                lavenderValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Llavender: " + lavenderValue, Toast.LENGTH_SHORT);
                mLavenderValueNo = lavenderValue;
                mToastMessage.show();
            }
        });

        mRoseInput = (SeekBar) findViewById(R.id.seekBar_ba_rose_28);
        mRoseInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int roseValue = 0;

            public void onProgressChanged(SeekBar mRoseInput, int progress, boolean fromUser) {
                roseValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Rose: " + roseValue, Toast.LENGTH_SHORT);
                mRoseValueNo = roseValue;
                mToastMessage.show();
            }
        });

        mEucalyptusInput = (SeekBar) findViewById(R.id.seekBar_bk_eucalyptus_38);
        mEucalyptusInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int eucalyptusValue = 0;

            public void onProgressChanged(SeekBar mEucalyptusInput, int progress, boolean fromUser) {
                eucalyptusValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Eucalyptus: " + eucalyptusValue, Toast.LENGTH_SHORT);
                mEucalyptusValueNo = eucalyptusValue;
                mToastMessage.show();
            }
        });

        mCutgrassInput = (SeekBar) findViewById(R.id.seekBar_bd_cut_grass_31);
        mCutgrassInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cutgrassValue = 0;

            public void onProgressChanged(SeekBar mCutgrassInput, int progress, boolean fromUser) {
                cutgrassValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Freshly Cut Grass: " + cutgrassValue, Toast.LENGTH_SHORT);
                mCutgrassValueNo = cutgrassValue;
                mToastMessage.show();
            }
        });

        mRosemaryInput = (SeekBar) findViewById(R.id.seekBar_be_rosemary_32);
        mRosemaryInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int rosemaryValue = 0;

            public void onProgressChanged(SeekBar mRosemaryInput, int progress, boolean fromUser) {
                rosemaryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Rosemary: " + rosemaryValue, Toast.LENGTH_SHORT);
                mRosemaryValueNo = rosemaryValue;
                mToastMessage.show();
            }
        });

        mThymeInput = (SeekBar) findViewById(R.id.seekBar_bf_thyme_33);
        mThymeInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int thymeValue = 0;

            public void onProgressChanged(SeekBar mThymeInput, int progress, boolean fromUser) {
                thymeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Thyme: " + thymeValue, Toast.LENGTH_SHORT);
                mThymeValueNo = thymeValue;
                mToastMessage.show();
            }
        });

        mMintInput = (SeekBar) findViewById(R.id.seekBar_bg_mint);
        mMintInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mintValue = 0;

            public void onProgressChanged(SeekBar mMintInput, int progress, boolean fromUser) {
                mintValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Mint: " + mintValue, Toast.LENGTH_SHORT);
                mMintValueNo = mintValue;
                mToastMessage.show();
            }
        });

        mHayInput = (SeekBar) findViewById(R.id.seekBar_bi_hay);
        mHayInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int hayValue = 0;

            public void onProgressChanged(SeekBar mHayInput, int progress, boolean fromUser) {
                hayValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Hay: " + hayValue, Toast.LENGTH_SHORT);
                mHayValueNo = hayValue;
                mToastMessage.show();
            }
        });

        mMushroomInput = (SeekBar) findViewById(R.id.seekBar_co_mushroom);
        mMushroomInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mushroomValue = 0;

            public void onProgressChanged(SeekBar mMushroomInput, int progress, boolean fromUser) {
                mushroomValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Mushroom: " + mushroomValue, Toast.LENGTH_SHORT);
                mMushroomValueNo = mushroomValue;
                mToastMessage.show();
            }
        });

        mTruffleInput = (SeekBar) findViewById(R.id.seekBar_cp_truffle);
        mTruffleInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int truffleValue = 0;

            public void onProgressChanged(SeekBar mTruffleInput, int progress, boolean fromUser) {
                truffleValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Truffle: " + truffleValue, Toast.LENGTH_SHORT);
                mTruffleValueNo = truffleValue;
                mToastMessage.show();
            }
        });

        mLeatherInput = (SeekBar) findViewById(R.id.seekBar_cn_leather);
        mLeatherInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int leatherValue = 0;

            public void onProgressChanged(SeekBar mLeatherInput, int progress, boolean fromUser) {
                leatherValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Leather: " + leatherValue, Toast.LENGTH_SHORT);
                mLeatherValueNo = leatherValue;
                mToastMessage.show();
            }
        });

        mGreenpepperInput = (SeekBar) findViewById(R.id.seekBar_bb_greenpepper);
        mGreenpepperInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int greenpepperValue = 0;

            public void onProgressChanged(SeekBar mGreenpepperInput, int progress, boolean fromUser) {
                greenpepperValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Greenpepper: " + greenpepperValue, Toast.LENGTH_SHORT);
                mGreenpepperValueNo = greenpepperValue;
                mToastMessage.show();
            }
        });

        mTomatoInput = (SeekBar) findViewById(R.id.seekBar_bc_tomato);
        mTomatoInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int tomatoValue = 0;

            public void onProgressChanged(SeekBar mTomatoInput, int progress, boolean fromUser) {
                tomatoValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Tomato: " + tomatoValue, Toast.LENGTH_SHORT);
                mTomatoValueNo = tomatoValue;
                mToastMessage.show();
            }
        });

        mCornInput = (SeekBar) findViewById(R.id.seekBar_cy_corn);
        mCornInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cornValue = 0;

            public void onProgressChanged(SeekBar mCornInput, int progress, boolean fromUser) {
                cornValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Corn: " + cornValue, Toast.LENGTH_SHORT);
                mCornValueNo = cornValue;
                mToastMessage.show();
            }
        });

        mOnionInput = (SeekBar) findViewById(R.id.seekBar_cx_onion);
        mOnionInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int onionValue = 0;

            public void onProgressChanged(SeekBar mOnionInput, int progress, boolean fromUser) {
                onionValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Onion: " + onionValue, Toast.LENGTH_SHORT);
                mOnionValueNo = onionValue;
                mToastMessage.show();
            }
        });

        mPineInput = (SeekBar) findViewById(R.id.seekBar_cf_pine_59);
        mPineInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pineValue = 0;

            public void onProgressChanged(SeekBar mPineInput, int progress, boolean fromUser) {
                pineValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Pine: " + pineValue, Toast.LENGTH_SHORT);
                mPineValueNo = pineValue;
                mToastMessage.show();
            }
        });

        mCedarInput = (SeekBar) findViewById(R.id.seekBar_cg_cedar_60);
        mCedarInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cedarValue = 0;

            public void onProgressChanged(SeekBar mCedarInput, int progress, boolean fromUser) {
                cedarValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Cedar: " + cedarValue, Toast.LENGTH_SHORT);
                mCedarValueNo = cedarValue;
                mToastMessage.show();
            }
        });

        mOakInput = (SeekBar) findViewById(R.id.seekBar_cd_oak);
        mOakInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int oakValue = 0;

            public void onProgressChanged(SeekBar mOakInput, int progress, boolean fromUser) {
                oakValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Oak: " + oakValue, Toast.LENGTH_SHORT);
                mOakValueNo = oakValue;
                mToastMessage.show();
            }
        });

        mHazelnutInput = (SeekBar) findViewById(R.id.seekBar_cb_hazelnut);
        mHazelnutInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int hazelnutValue = 0;

            public void onProgressChanged(SeekBar mHazelnutInput, int progress, boolean fromUser) {
                hazelnutValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Hazelnut: " + hazelnutValue, Toast.LENGTH_SHORT);
                mHazelnutValueNo = hazelnutValue;
                mToastMessage.show();
            }
        });

        mAlmondInput = (SeekBar) findViewById(R.id.seekBar_cc_almond);
        mAlmondInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int almondValue = 0;

            public void onProgressChanged(SeekBar mAlmondInput, int progress, boolean fromUser) {
                almondValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Almond: " + almondValue, Toast.LENGTH_SHORT);
                mFigValueNo = almondValue;
                mToastMessage.show();
            }
        });

        mNutmegInput = (SeekBar) findViewById(R.id.seekBar_by_nutmeg_52);
        mNutmegInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int nutmegValue = 0;

            public void onProgressChanged(SeekBar mNutmegInput, int progress, boolean fromUser) {
                nutmegValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Nutmeg: " + nutmegValue, Toast.LENGTH_SHORT);
                mNutmegValueNo = nutmegValue;
                mToastMessage.show();
            }
        });

        mWalnutInput = (SeekBar) findViewById(R.id.seekBar_dl_walnut);
        mWalnutInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int walnutValue = 0;

            public void onProgressChanged(SeekBar mWalnutInput, int progress, boolean fromUser) {
                walnutValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Walnut: " + walnutValue, Toast.LENGTH_SHORT);
                mWalnutValueNo = walnutValue;
                mToastMessage.show();
            }
        });

        mPepperInput = (SeekBar) findViewById(R.id.seekBar_bv_pepper);
        mPepperInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pepperValue = 0;

            public void onProgressChanged(SeekBar mFigInput, int progress, boolean fromUser) {
                pepperValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Pepper: " + pepperValue, Toast.LENGTH_SHORT);
                mPepperValueNo = pepperValue;
                mToastMessage.show();
            }
        });

        mCinnamonInput = (SeekBar) findViewById(R.id.seekBar_bw_cinnamon);
        mCinnamonInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cinnamonValue = 0;

            public void onProgressChanged(SeekBar mCinnamonInput, int progress, boolean fromUser) {
                cinnamonValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Cinnamon: " + cinnamonValue, Toast.LENGTH_SHORT);
                mCinnamonValueNo = cinnamonValue;
                mToastMessage.show();
            }
        });

        mVanilaInput = (SeekBar) findViewById(R.id.seekBar_bu_vanilla);
        mVanilaInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int vanilaValue = 0;

            public void onProgressChanged(SeekBar mVanilaInput, int progress, boolean fromUser) {
                vanilaValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Vanila: " + vanilaValue, Toast.LENGTH_SHORT);
                mVanilaValueNo = vanilaValue;
                mToastMessage.show();
            }
        });

        mCloveInput = (SeekBar) findViewById(R.id.seekBar_bz_clove);
        mCloveInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cloveValue = 0;

            public void onProgressChanged(SeekBar mCloveInput, int progress, boolean fromUser) {
                cloveValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Clove: " + cloveValue, Toast.LENGTH_SHORT);
                mCloveValueNo = cloveValue;
                mToastMessage.show();
            }
        });

        mChiliInput = (SeekBar) findViewById(R.id.seekBar_dh_chili);
        mChiliInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int chiliValue = 0;

            public void onProgressChanged(SeekBar mChiliInput, int progress, boolean fromUser) {
                chiliValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Chili: " + chiliValue, Toast.LENGTH_SHORT);
                mChiliValueNo = chiliValue;
                mToastMessage.show();
            }
        });

        mLicoriceInput = (SeekBar) findViewById(R.id.seekBar_bx_licorice);
        mLicoriceInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int licoriceValue = 0;

            public void onProgressChanged(SeekBar mLicoriceInput, int progress, boolean fromUser) {
                licoriceValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Licorice: " + licoriceValue, Toast.LENGTH_SHORT);
                mLicoriceValueNo = licoriceValue;
                mToastMessage.show();
            }
        });

        mSaffronInput = (SeekBar) findViewById(R.id.seekBar_dk_saffron);
        mSaffronInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int saffronValue = 0;

            public void onProgressChanged(SeekBar mSaffronInput, int progress, boolean fromUser) {
                saffronValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Saffron: " + saffronValue, Toast.LENGTH_SHORT);
                mSaffronValueNo = saffronValue;
                mToastMessage.show();
            }
        });

        mTobaccoInput = (SeekBar) findViewById(R.id.seekBar_bh_tobacco);
        mTobaccoInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int tobaccoValue = 0;

            public void onProgressChanged(SeekBar mTobaccoInput, int progress, boolean fromUser) {
                tobaccoValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Tobacco: " + tobaccoValue, Toast.LENGTH_SHORT);
                mTobaccoValueNo = tobaccoValue;
                mToastMessage.show();
            }
        });

        mCoffeeInput = (SeekBar) findViewById(R.id.seekBar_bs_coffee);
        mCoffeeInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int coffeeValue = 0;

            public void onProgressChanged(SeekBar mCoffeeInput, int progress, boolean fromUser) {
                coffeeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Coffee: " + coffeeValue, Toast.LENGTH_SHORT);
                mCoffeeValueNo = coffeeValue;
                mToastMessage.show();
            }
        });

        mBreadInput = (SeekBar) findViewById(R.id.seekBar_bo_bread_42);
        mBreadInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int breadValue = 0;

            public void onProgressChanged(SeekBar mBreadInput, int progress, boolean fromUser) {
                breadValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Bread: " + breadValue, Toast.LENGTH_SHORT);
                mBreadValueNo = breadValue;
                mToastMessage.show();
            }
        });

        mToastedBreadInput = (SeekBar) findViewById(R.id.seekBar_br_toastedbread);
        mToastedBreadInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int toastedBreadValue = 0;

            public void onProgressChanged(SeekBar mToastedBreadInput, int progress, boolean fromUser) {
                toastedBreadValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Toasted Bread: " + toastedBreadValue, Toast.LENGTH_SHORT);
                mToastedBreadValueNo = toastedBreadValue;
                mToastMessage.show();
            }
        });

        mButterInput = (SeekBar) findViewById(R.id.seekBar_bq_butter);
        mButterInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int butterValue = 0;

            public void onProgressChanged(SeekBar mButterInput, int progress, boolean fromUser) {
                butterValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Butter: " + butterValue, Toast.LENGTH_SHORT);
                mButterValueNo = butterValue;
                mToastMessage.show();
            }
        });

        mCreamInput = (SeekBar) findViewById(R.id.seekBar_bp_cream_44);
        mCreamInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int creamValue = 0;

            public void onProgressChanged(SeekBar mCreamInput, int progress, boolean fromUser) {
                creamValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Cream: " + creamValue, Toast.LENGTH_SHORT);
                mCreamValueNo = creamValue;
                mToastMessage.show();
            }
        });

        mBlueCheeseInput = (SeekBar) findViewById(R.id.seekBar_dr_blue_cheese);
        mBlueCheeseInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int bluecheeseValue = 0;

            public void onProgressChanged(SeekBar mBlueCheeseInput, int progress, boolean fromUser) {
                bluecheeseValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Blue Cheese: " + bluecheeseValue, Toast.LENGTH_SHORT);
                mBlueCheeseValueNo = bluecheeseValue;
                mToastMessage.show();
            }
        });

        mCoconutInput = (SeekBar) findViewById(R.id.seekBar_ca_coconut);
        mCoconutInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int coconutValue = 0;

            public void onProgressChanged(SeekBar mCoconutInput, int progress, boolean fromUser) {
                coconutValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Coconut: " + coconutValue, Toast.LENGTH_SHORT);
                mCoconutValueNo = coconutValue;
                mToastMessage.show();
            }
        });

        mKeroseneInput = (SeekBar) findViewById(R.id.seekBar_bm_kerosene);
        mKeroseneInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int keroseneValue = 0;

            public void onProgressChanged(SeekBar mKeroseneInput, int progress, boolean fromUser) {
                keroseneValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Kerosene: " + keroseneValue, Toast.LENGTH_SHORT);
                mKeroseneValueNo = keroseneValue;
                mToastMessage.show();
            }
        });

        mHoneyInput = (SeekBar) findViewById(R.id.seekBar_ck_honey);
        mHoneyInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int honeyValue = 0;

            public void onProgressChanged(SeekBar mHoneyInput, int progress, boolean fromUser) {
                honeyValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Honey: " + honeyValue, Toast.LENGTH_SHORT);
                mHoneyValueNo = honeyValue;
                mToastMessage.show();
            }
        });

        mChocolateInput = (SeekBar) findViewById(R.id.seekBar_cl_chocolate);
        mChocolateInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int chocolateValue = 0;

            public void onProgressChanged(SeekBar mChocolateInput, int progress, boolean fromUser) {
                chocolateValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Chocolate: " + chocolateValue, Toast.LENGTH_SHORT);
                mChocolateValueNo = chocolateValue;
                mToastMessage.show();
            }
        });

        mCorkInput = (SeekBar) findViewById(R.id.seekBar_cq_cork);
        mCorkInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int corkValue = 0;

            public void onProgressChanged(SeekBar mCorkInput, int progress, boolean fromUser) {
                corkValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Cork: " + corkValue, Toast.LENGTH_SHORT);
                mCorkValueNo = corkValue;
                mToastMessage.show();
            }
        });

        mRubberbandInput = (SeekBar) findViewById(R.id.seekBar_cv_rubberband);
        mRubberbandInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int rubberbandValue = 0;

            public void onProgressChanged(SeekBar mRubberbandInput, int progress, boolean fromUser) {
                rubberbandValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Rubberband: " + rubberbandValue, Toast.LENGTH_SHORT);
                mRubberbandValueNo = rubberbandValue;
                mToastMessage.show();
            }
        });

        mEggInput = (SeekBar) findViewById(R.id.seekBar_cw_egg);
        mEggInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int eggValue = 0;

            public void onProgressChanged(SeekBar mEggInput, int progress, boolean fromUser) {
                eggValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Fig: " + eggValue, Toast.LENGTH_SHORT);
                mEggValueNo = eggValue;
                mToastMessage.show();
            }
        });

        mFlintInput = (SeekBar) findViewById(R.id.seekBar_bl_flint_39);
        mFlintInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int flintValue = 0;

            public void onProgressChanged(SeekBar mFlintInput, int progress, boolean fromUser) {
                flintValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Flint: " + flintValue, Toast.LENGTH_SHORT);
                mFlintValueNo = flintValue;
                mToastMessage.show();
            }
        });

        mSmokeInput = (SeekBar) findViewById(R.id.seekBar_bt_smoke_47);
        mSmokeInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int smokeValue = 0;

            public void onProgressChanged(SeekBar mSmokeInput, int progress, boolean fromUser) {
                smokeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Smoke: " + smokeValue, Toast.LENGTH_SHORT);
                mSmokeValueNo = smokeValue;
                mToastMessage.show();
            }
        });

        mCaramelInput = (SeekBar) findViewById(R.id.seekBar_dq_caramel);
        mCaramelInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int caramelValue = 0;

            public void onProgressChanged(SeekBar mCaramelInput, int progress, boolean fromUser) {
                caramelValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(TastingWineInput.this, "Caramel: " + caramelValue, Toast.LENGTH_SHORT);
                mCaramelValueNo = caramelValue;
                mToastMessage.show();
            }
        });

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

    private void onSubnmitAnswer(final String winePushID) {
        Firebase tastingWineFirebaseFlavourRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(winePushID).child(Constants.FIREBASE_WINE_FLAVOR_DETAILS);
        String stringTastingRef = tastingWineFirebaseFlavourRef.toString();
        tastingWineFirebaseFlavourRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WineTastePojo wineTastePojo = dataSnapshot.getValue(WineTastePojo.class);
                if (wineTastePojo != null) {
                    mGrapefruitAnswer = wineTastePojo.getmGrapefruitTaste();
                    mLemonAnswer = wineTastePojo.getmLemonTaste();
                    mLimeAnswer = wineTastePojo.getmLimeTaste();
                    mOrangeAnswer = wineTastePojo.getmOrangeTaste();
                    mOrangepeelAnswer = wineTastePojo.getmOrangepeelTaste();
                    mAppleAnswer = wineTastePojo.getmAppleTaste();
                    mGrannysmithAnswer = wineTastePojo.getmGrannysmithTaste();
                    mPearAnswer = wineTastePojo.getmPearTaste();
                    mApricotAnswer = wineTastePojo.getmApricotTaste();
                    mBananaAnswer = wineTastePojo.getmBananaTaste();
                    mFigAnswer = wineTastePojo.getmFigTaste();
                    mPomegranateAnswer = wineTastePojo.getmPomegranateTaste();
                    mMelonAnswer = wineTastePojo.getmMelonTaste();
                    mCantelopeAnswer = wineTastePojo.getmCantelopeTaste();
                    mMangoAnswer = wineTastePojo.getmMangoTaste();
                    mGuavaAnswer = wineTastePojo.getmGuavaTaste();
                    mKiwifruitAnswer = wineTastePojo.getmKiwifruitTaste();
                    mLycheeAnswer = wineTastePojo.getmLycheeTaste();
                    mPassionfruitAnswer = wineTastePojo.getmPassionfruitTaste();
                    mPineappleAnswer = wineTastePojo.getmPineappleTaste();
                    mWatermelonAnswer = wineTastePojo.getmWatermelonTaste();
                    mDriedApricotAnswer = wineTastePojo.getmDriedapricotTaste();
                    mPruneAnswer = wineTastePojo.getmPruneTaste();
                    mPeachAnswer = wineTastePojo.getmPeachTaste();
                    mCherryAnswer = wineTastePojo.getmCherryTaste();
                    mPlumAnswer = wineTastePojo.getmPlumTaste();
                    mJamAnswer = wineTastePojo.getmJamTaste();
                    mRedcurrantAnswer = wineTastePojo.getmRedcurrantTaste();
                    mBlackcurrantAnswer = wineTastePojo.getmBlackcurrantTaste();
                    mStrawberryAnswer = wineTastePojo.getmStrawberryTaste();
                    mBlackberryAnswer = wineTastePojo.getmBlackberryTaste();
                    mRaspberryAnswer = wineTastePojo.getmRaspberryTaste();
                    mBlueberryAnswer = wineTastePojo.getmBlueberryTaste();
                    mAppleblossomAnswer = wineTastePojo.getmAppleblossumTaste();
                    mOrangeblossomAnswer = wineTastePojo.getmOrangeblossumTaste();
                    mFloralAnswer = wineTastePojo.getmFloralTaste();
                    mHoneysuckleAnswer = wineTastePojo.getmHoneysuckleTaste();
                    mGeraniumAnswer = wineTastePojo.getmGeraniumTaste();
                    mVioletAnswer = wineTastePojo.getmVioletTaste();
                    mLavenderAnswer = wineTastePojo.getmLavenderTaste();
                    mRoseAnswer = wineTastePojo.getmRoseTaste();
                    mEucalyptusAnswer = wineTastePojo.getmEucalyptusTaste();
                    mCutgrassAnswer = wineTastePojo.getmCutgrassTaste();
                    mRosemaryAnswer = wineTastePojo.getmRosemaryTaste();
                    mThymeAnswer = wineTastePojo.getmThymeTaste();
                    mMintAnswer = wineTastePojo.getmMintTaste();
                    mHayAnswer = wineTastePojo.getmHayTaste();
                    mMushroomAnswer = wineTastePojo.getmMushroomTaste();
                    mTruffleAnswer = wineTastePojo.getmTruffleTaste();
                    mLeatherAnswer = wineTastePojo.getmLeatherTaste();
                    mGreenpepperAnswer = wineTastePojo.getmGreenpepperTaste();
                    mTomatoAnswer = wineTastePojo.getmTomatoTaste();
                    mCornAnswer = wineTastePojo.getmCornTaste();
                    mOnionAnswer = wineTastePojo.getmOnionTaste();
                    mPineAnswer = wineTastePojo.getmPineTaste();
                    mCedarAnswer = wineTastePojo.getmCedarTaste();
                    mOakAnswer = wineTastePojo.getmOakTaste();
                    mHazelnutAnswer = wineTastePojo.getmHazelnutTaste();
                    mAlmondAnswer = wineTastePojo.getmAlmondTaste();
                    mNutmegAnswer = wineTastePojo.getmNutmegTaste();
                    mWalnutAnswer = wineTastePojo.getmWalnutTaste();
                    mPepperAnswer = wineTastePojo.getmPepperTaste();
                    mCinnamonAnswer = wineTastePojo.getmCinnamonTaste();
                    mVanilaAnswer = wineTastePojo.getmVanilaTaste();
                    mCloveAnswer = wineTastePojo.getmCloveTaste();
                    mChiliAnswer = wineTastePojo.getmChiliTaste();
                    mLicoriceAnswer = wineTastePojo.getmLicoriceTaste();
                    mSaffronAnswer = wineTastePojo.getmSaffronTaste();
                    mTobaccoAnswer = wineTastePojo.getmTobaccoTaste();
                    mCoffeeAnswer = wineTastePojo.getmCoffeeTaste();
                    mBreadAnswer = wineTastePojo.getmBreadTaste();
                    mToastedBreadAnswer = wineTastePojo.getmToastedbreadTaste();
                    mButterAnswer = wineTastePojo.getmButterTaste();
                    mCreamAnswer = wineTastePojo.getmCreamTaste();
                    mBlueCheeseAnswer = wineTastePojo.getmBlueCheeseTaste();
                    mCoconutAnswer = wineTastePojo.getmCoconutTaste();
                    mKeroseneAnswer = wineTastePojo.getmKeroseneTaste();
                    mHoneyAnswer = wineTastePojo.getmHoneyTaste();
                    mChocolateAnswer = wineTastePojo.getmChocolateTaste();
                    mCorkAnswer = wineTastePojo.getmCorkTaste();
                    mRubberbandAnswer = wineTastePojo.getmRubberbandTaste();
                    mEggAnswer = wineTastePojo.getmEggTaste();
                    mFlintAnswer = wineTastePojo.getmFlintTaste();
                    mSmokeAnswer = wineTastePojo.getmSmokeTaste();
                    mCaramelAnswer = wineTastePojo.getmCaramelTaste();

                }
                calculateScore(mGrapefruitAnswer, mLemonAnswer, mLimeAnswer, mOrangeAnswer,
                        mOrangepeelAnswer, mAppleAnswer, mGrannysmithAnswer, mPearAnswer,
                        mApricotAnswer, mBananaAnswer, mFigAnswer, mPomegranateAnswer,
                        mMelonAnswer, mCantelopeAnswer, mMangoAnswer, mGuavaAnswer, mKiwifruitAnswer,
                        mLycheeAnswer, mPassionfruitAnswer, mPineappleAnswer, mWatermelonAnswer,
                        mDriedApricotAnswer, mPruneAnswer, mPeachAnswer, mCherryAnswer, mPlumAnswer, mJamAnswer,
                        mRedcurrantAnswer, mBlackcurrantAnswer, mStrawberryAnswer, mBlackberryAnswer, mRaspberryAnswer,
                        mBlueberryAnswer, mAppleblossomAnswer, mOrangeblossomAnswer, mFloralAnswer, mHoneysuckleAnswer, mGeraniumAnswer,
                        mVioletAnswer, mLavenderAnswer, mRoseAnswer, mEucalyptusAnswer, mCutgrassAnswer,
                        mRosemaryAnswer, mThymeAnswer, mMintAnswer, mHayAnswer, mMushroomAnswer, mTruffleAnswer, mLeatherAnswer,
                        mGreenpepperAnswer, mTomatoAnswer, mCornAnswer, mOnionAnswer, mPineAnswer, mCedarAnswer, mOakAnswer,
                        mHazelnutAnswer, mAlmondAnswer, mNutmegAnswer, mWalnutAnswer, mPepperAnswer, mCinnamonAnswer, mVanilaAnswer,
                        mCloveAnswer, mChiliAnswer, mLicoriceAnswer, mSaffronAnswer, mTobaccoAnswer, mCoffeeAnswer, mBreadAnswer,
                        mToastedBreadAnswer, mButterAnswer, mCreamAnswer, mBlueCheeseAnswer, mCoconutAnswer, mKeroseneAnswer,
                        mHoneyAnswer, mChocolateAnswer, mCorkAnswer, mRubberbandAnswer, mEggAnswer, mFlintAnswer,
                        mSmokeAnswer, mCaramelAnswer);

            }

            //TODO: add code to change work out the score for the rest of the flavours.
            //TODO: add a boolean value to each of the flavours so that an 'out of' calculation can be made

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });

    }

    public void answerAlertDialog(int mScore, int mGrapefruitAnswer, int mLemonAnswer,
                                  int mLimeAnswer, int mOrangeAnswer, int mOrangepeelAnswer,
                                  int mAppleAnswer, int mGrannysmithAnswer, int mPearAnswer, int mApricotAnswer,
                                  int mBananaAnswer, int mFigAnswer, int mPomegranateAnswer, int mMelonAnswer, int mCantelopeAnswer,
                                  int mMangoAnswer, int mGuavaAnswer, int mKiwifruitAnswer, int mLycheeAnswer,
                                  int mPassionfruitAnswer, int mPineappleAnswer, int mWatermelonAnswer, int mDriedApricotAnswer,
                                  int mPruneAnswer, int mPeachAnswer, int mCherryAnswer, int mPlumAnswer, int mJamAnswer,
                                  int mRedcurrantAnswer, int mBlackcurrantAnswer, int mStrawberryAnswer, int mBlackberryAnswer,
                                  int mRaspberryAnswer, int mBlueberryAnswer, int mAppleblossomAnswer, int mOrangeblossomAnswer,
                                  int mFloralAnswer, int mHoneysuckleAnswer, int mGeraniumAnswer, int mVioletAnswer, int mLavenderAnswer,
                                  int mRoseAnswer, int mEucalyptusAnswer, int mCutgrassAnswer, int mRosemaryAnswer, int mThymeAnswer,
                                  int mMintAnswer, int mHayAnswer, int mMushroomAnswer, int mTruffleAnswer, int mLeatherAnswer, int mGreenpepperAnswer,
                                  int mTomatoAnswer, int mCornAnswer, int mOnionAnswer, int mPineAnswer, int mCedarAnswer, int mOakAnswer,
                                  int mHazelnutAnswer, int mAlmondAnswer, int mNutmegAnswer, int mWalnutAnswer, int mPepperAnswer,
                                  int mCinnamonAnswer, int mVanilaAnswer, int mCloveAnswer, int mChiliAnswer, int mLicoriceAnswer, int mSaffronAnswer,
                                  int mTobaccoAnswer, int mCoffeeAnswer, int mBreadAnswer, int mToastedBreadAnswer, int mButterAnswer, int mCreamAnswer,
                                  int mBlueCheeseAnswer, int mCoconutAnswer, int mKeroseneAnswer, int mHoneyAnswer, int mChocolateAnswer,
                                  int mCorkAnswer, int mRubberbandAnswer, int mEggAnswer, int mFlintAnswer, int mSmokeAnswer,
                                  int mCaramelAnswer) {


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TastingWineInput.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_create_tasting, null);
        final TextView mTastingResult = (TextView) mView.findViewById(R.id.dialog_points_scored);

        final int tastingPoints = mScore;
        mTastingResult.setText(

                /*
                "Your results: " + mScore + " points"
                + "\n" +
                "\nCitrus Negative Points:" + grapefruitNegativePoints + lemonNegativePoints + limeNegativePoints + orangeNegativePoints + orangepeelNegativePoints +
                "\nGrapefruit: " + grapefruitNegativePoints +
                ", Lemon: " + lemonNegativePoints +
                ", Lime: " + limeNegativePoints +
                ", Orange: " + orangeNegativePoints +
                ", Orange Peel: " + orangepeelNegativePoints +
                "\nTree fruits: " +
                "\nApple: " + appleNegativePoints +
                ", Grannysmith: " + grannysmithNegativePoints +
                ", Pear: " + pearNegativePoints +
                ", Apricot: " + apricotNegativePoints +
                ", Banana: " + bananaNegativePoints +
                ", Fig: " + figNegativePoints +
                ", Pomegranate: " + pomegranateNegativePoints +
                "\nTropical fruits" +
                "\nMelon: " + melonNegativePoints +
                ", Cantelope: " + cantelopeNegativePoints +
                ", Mango: " + mangoNegativePoints +
                ", Guava: " + guavaNegativePoints +
                ", Kiwifruit: " + kiwifruitNegativePoints +
                ", Lychee: " + lycheeNegativePoints +
                ", Passionfruit: " + passionfruitNegativePoints +
                ", Pineapple: " + pineappleNegativePoints +
                ", Watermelon: " + watermelonNegativePoints +
                "\nDried fruits" +
                "\nDried Apricot: " + driedApricotNegativePoints +
                ", Prune: " + pruneNegativePoints +
                "\nStone fuits" +
                "\nPeach: " + peachNegativePoints +
                ", Cherry: " + cherryNegativePoints +
                ", Plum: " + plumNegativePoints +
                "\nBerries and Jams" +
                "\nJam: " + jamNegativePoints +
                ", Redcurrant: " + redcurrantNegativePoints +
                ", Blackcurrant: " + blackcurrantNegativePoints +
                ", Strawberry: " + strawberryNegativePoints +
                ", Blackberry: " + blackberryNegativePoints +
                ", Raspberry: " + raspberryNegativePoints +
                ", Blueberry:" + blueberryNegativePoints +
                "\nBlossom" +
                "\nAppleblossom: " + appleblossomNegativePoints +
                ", Orangeblossom: " + orangeblossomNegativePoints +
                "\nFloral" +
                "\nFloral: " + floralNegativePoints +
                ", Honeysuckle: " + honeysuckleNegativePoints +
                ", Geranium: " + geraniumNegativePoints +
                ", Violet: " + violetNegativePoints +
                ", Lavender: " + lavenderNegativePoints +
                ", Rose: " + roseNegativePoints +
                ", Eucalyptus: " + eucalyptusNegativePoints +
                "\nHerb" +
                "\nCutgrass: " + cutgrassNegativePoints +
                ", Rosemary: " + rosemaryNegativePoints +
                ", Thyme: " + thymeNegativePoints +
                ", Mint: " + mintNegativePoints +
                "\nEarthy" +
                "\nHay: " + hayNegativePoints +
                ", Mushroom: " + mushroomNegativePoints +
                ", Truffle: " + truffleNegativePoints +
                "\nLeather" +
                "\nLeather: " + leatherNegativePoints +
                ", Green Pepper: " + greenpepperNegativePoints +
                ", Tomato: " + tomatoNegativePoints +
                ", Corn: " + cornNegativePoints +
                ", Onion: " + onionNegativePoints +
                "\nWoody" +
                "\nPine: " + pineNegativePoints +
                ", Cedar: " + cedarNegativePoints +
                ", Oak" + oakNegativePoints +
                "\nNutty" +
                "\nHazelnut: " + hazelnutNegativePoints +
                ", Almond" + almondNegativePoints +
                ", Nutmeg" + nutmegNegativePoints +
                ", Walnut: " + walnutNegativePoints +
                "\nSpicy" +
                "\nPepper: " + pepperNegativePoints +
                ", Cinnamon: " + cinnamonNegativePoints +
                ", Vanila: " + vanilaNegativePoints +
                ", Clove: " + cloveNegativePoints +
                ", Chili: " + chiliNegativePoints +
                ", Licorice: " + licoriceNegativePoints +
                ", Saffron: " + saffronNegativePoints +
                "\nToasty" +
                "\nTobacco" + tobaccoNegativePoints +
                ", Coffee: " + coffeeNegativePoints +
                "\nBakery" +
                "\nBread: " + breadNegativePoints +
                ", Toasted Bread: " + toastedBreadNegativePoints +
                "\nDairy" +
                "\nButter: " + butterNegativePoints +
                ", Cream: " + creamNegativePoints +
                ", Blue Cheese" + blueCheeseNegativePoints +
                "\nOther" +
                "\nCoconut" + coconutNegativePoints +
                ", Kerosene" + keroseneNegativePoints +
                ", Honey" + honeyNegativePoints +
                ", Chocolate" + chocolateNegativePoints +
                ", Cork" + corkNegativePoints +
                ", Rubber Band" + rubberbandNegativePoints +
                ", Egg" + eggNegativePoints +
                ", Flint" + flintNegativePoints +
                ", Smoke" + smokeNegativePoints +
                ", Caramel" + caramelNegativePoints +

                "\n" + "\n Your total tasting points: " + mScore

                */

                "Congratulations your scored " + mScore + " points!"
        );

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                writeScoreToDatabase(tastingPoints);
            }
        });

        alertDialogBuilder.setView(mView);
        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();

    }


    public void writeScoreToDatabase(final int tastingPoints) {
        //TODO: Write the points just earned to the total points their database and set their level of mastery

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        final String uid = user.getUid();

        Toast.makeText(TastingWineInput.this, "This Tasting Points: " + tastingPoints, Toast.LENGTH_SHORT).show();

        //Take a snapshot off what the users current public information is, and then work out what needs to be updated.
        mUserPublicDetails = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.PUBLIC);
        mUserPublicDetails.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                PublicUserDetailsPojo publicUserDetailsPojo = dataSnapshot.getValue(PublicUserDetailsPojo.class);

                if (publicUserDetailsPojo == null) {
                    //TODO: Set the value of wine tastings to 0, set the value of the total points to 0, set the level to 0 and set anything else to 0
                    Toast.makeText(TastingWineInput.this, "publicUserDetailsPojo == null ", Toast.LENGTH_SHORT).show();

                    int mUserFirebaseTotalPoints = 0;
                    int mUserFirebaseMostRecentTastingPoints = 0;
                    int mUserFirebaseTotalWinesTasted = 0;
                    int mUserFirebaseWineTastingLevel = 1;

                    //Update the Total tasting points into Firebase.
                    Firebase userTotalPoints = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.PUBLIC).child(Constants.TASTINGPOINTS);
                    mNewUserTotalPoints = mUserFirebaseTotalPoints + tastingPoints;
                    userTotalPoints.setValue(mNewUserTotalPoints);
                    Toast.makeText(TastingWineInput.this, "New Total Points: " + mNewUserTotalPoints, Toast.LENGTH_SHORT).show();

                    //Add the total number of bottles (in tastings) the user has participated in
                    Firebase userTotalWinesTasted = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.PUBLIC).child(Constants.TOTALWINESTASTED);
                    mNewUserTotalWinesTasted = mUserFirebaseTotalWinesTasted + 1;
                    userTotalWinesTasted.setValue(mNewUserTotalWinesTasted);

                    //Update the details of this specific tasting into firebase
                    Firebase userMostRecentTastingPoints = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.PUBLIC).child(Constants.MOSTRECENTTASTINGPOINTS);
                    userMostRecentTastingPoints.setValue(tastingPoints);

                }

                if (publicUserDetailsPojo != null) {
                    int mUserFirebaseTotalPoints = publicUserDetailsPojo.getTastingPoints();
                    int mUserFirebaseMostRecentTastingPoints = publicUserDetailsPojo.getMostRecentTastingPoints();
                    int mUserFirebaseTotalWinesTasted = publicUserDetailsPojo.getTotalWinesTasted();
                    int mUserFirebaseWineTastingLevel = publicUserDetailsPojo.getWineTastingLevel();

                    //Update the Total tasting points into Firebase.
                    Firebase userTotalPoints = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.PUBLIC).child(Constants.TASTINGPOINTS);
                    mNewUserTotalPoints = mUserFirebaseTotalPoints + tastingPoints;
                    userTotalPoints.setValue(mNewUserTotalPoints);
                    Toast.makeText(TastingWineInput.this, "New Total Points: " + mNewUserTotalPoints, Toast.LENGTH_SHORT).show();

                    //Add the total number of bottles (in tastings) the user has participated in
                    Firebase userTotalWinesTasted = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.PUBLIC).child(Constants.TOTALWINESTASTED);
                    mNewUserTotalWinesTasted = mUserFirebaseTotalWinesTasted + 1;
                    userTotalWinesTasted.setValue(mNewUserTotalWinesTasted);

                    //Update the details of this specific tasting into firebase
                    Firebase userMostRecentTastingPoints = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.PUBLIC).child(Constants.MOSTRECENTTASTINGPOINTS);
                    userMostRecentTastingPoints.setValue(tastingPoints);

                    /*
                    //Update the details level of the user
                    Firebase userWineTastingLevel = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.PUBLIC).child(Constants.WINETASTINGLEVELNUMBER);
                    //TODO: work out the new taster's level.
                    mNewUserWineTastingLevel = mUserFirebaseWineTastingLevel + calucation to work out what percentage they've got right and how many points they've scored
                    userWineTastingLevel.setValue(mNewUserWineTastingLevel);

                    TODO: Add time stamps for this tasting, and store the previous tastings.

                     */

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        finish();
    }

    //calculate the score the person has achieved by taking all their inputs and running them through the flavour / aroma calculations
    // to work out how many negative points a person has (difference between what they've input versus the correct answer,
    // then using those negative points to work out how far off they were.  The closer they are the less negative points they'll have,
    // which means their score will be closer to zero.  The closer they are to zero the higher the points (out of 100) they will get.

    public void calculateScore(int mGrapefruitAnswer, int mLemonAnswer, int mLimeAnswer, int mOrangeAnswer,
                               int mOrangepeelAnswer, int mAppleAnswer, int mGrannysmithAnswer, int mPearAnswer, int mApricotAnswer,
                               int mBananaAnswer, int mFigAnswer, int mPomegranateAnswer, int mMelonAnswer, int mCantelopeAnswer,
                               int mMangoAnswer, int mGuavaAnswer, int mKiwifruitAnswer, int mLycheeAnswer,
                               int mPassionfruitAnswer, int mPineappleAnswer, int mWatermelonAnswer, int mDriedApricotAnswer,
                               int mPruneAnswer, int mPeachAnswer, int mCherryAnswer, int mPlumAnswer, int mJamAnswer,
                               int mRedcurrantAnswer, int mBlackcurrantAnswer, int mStrawberryAnswer, int mBlackberryAnswer, int mRaspberryAnswer,
                               int mBlueberryAnswer, int mAppleblossomAnswer, int mOrangeblossomAnswer, int mFloralAnswer, int mHoneysuckleAnswer,
                               int mGeraniumAnswer, int mVioletAnswer, int mLavenderAnswer, int mRoseAnswer, int mEucalyptusAnswer,
                               int mCutgrassAnswer, int mRosemaryAnswer, int mThymeAnswer, int mMintAnswer, int mHayAnswer, int mMushroomAnswer,
                               int mTruffleAnswer, int mLeatherAnswer, int mGreenpepperAnswer, int mTomatoAnswer, int mCornAnswer, int mOnionAnswer,
                               int mPineAnswer, int mCedarAnswer, int mOakAnswer, int mHazelnutAnswer, int mAlmondAnswer, int mNutmegAnswer,
                               int mWalnutAnswer, int mPepperAnswer, int mCinnamonAnswer, int mVanilaAnswer, int mCloveAnswer, int mChiliAnswer,
                               int mLicoriceAnswer, int mSaffronAnswer, int mTobaccoAnswer, int mCoffeeAnswer, int mBreadAnswer, int mToastedBreadAnswer,
                               int mButterAnswer, int mCreamAnswer, int mBlueCheeseAnswer, int mCoconutAnswer, int mKeroseneAnswer, int mHoneyAnswer,
                               int mChocolateAnswer, int mCorkAnswer, int mRubberbandAnswer, int mEggAnswer, int mFlintAnswer, int mSmokeAnswer,
                               int mCaramelAnswer) {

        grapefruitCalculation();
        lemonCalculation();
        limeCalculation();
        orangeCalculation();
        orangepeelCalculation();
        appleCalculation();
        grannysmithCalculation();
        pearCalculation();
        apricotCalculation();
        bananaCalculation();
        figCalculation();
        pomegranateCalculation();
        melonCalculation();
        cantelopeCalculation();
        mangoCalculation();
        guavaCalculation();
        kiwifruitCalculation();
        lycheeCalculation();
        passionfruitCalculation();
        pineappleCalculation();
        watermelonCalculation();
        driedapricotCalculation();
        pruneCalculation();
        peachCalculation();
        cherryCalculation();
        plumCalculation();
        jamCalculation();
        redcurrantCalculation();
        blackcurrantCalculation();
        strawberryCalculation();
        blackberryCalculation();
        raspberryCalculation();
        blueberryCalculation();
        appleblossomCalculation();
        orangeblossomCalculation();
        floralCalculation();
        honeysuckleCalculation();
        geraniumCalculation();
        violetCalculation();
        lavenderCalculation();
        roseCalculation();
        eucalyptusCalculation();
        cutgrassCalculation();
        rosemaryCalculation();
        thymeCalculation();
        mintCalculation();
        hayCalculation();
        mushroomCalculation();
        truffleCalculation();
        leatherCalculation();
        greenpepperCalculation();
        tomatoCalculation();
        cornCalculation();
        onionCalculation();
        pineCalculation();
        cedarCalculation();
        oakCalculation();
        hazelnutCalculation();
        almondCalculation();
        nutmegCalculation();
        walnutCalculation();
        pepperCalculation();
        cinnamonCalculation();
        vanilaCalculation();
        cloveCalculation();
        chiliCalculation();
        licoriceCalculation();
        saffronCalculation();
        tobaccoCalculation();
        coffeeCalculation();
        breadCalculation();
        toastedbreadCalculation();
        butterCalculation();
        creamCalculation();
        bluecheeseCalculation();
        coconutCalculation();
        keroseneCalculation();
        honeyCalculation();
        chocolateCalculation();
        corkCalculation();
        rubberbandCalculation();
        eggCalculation();
        flintCalculation();
        smokeCalculation();
        caramelCalculation();

        scoreDenominator = grapefruitDenominator + lemonDenominator + limeDenominator + orangeDenominator +
                orangepeelDenominator + appleDenominator + grannysmithDenominator + pearDenominator
                + apricotDenominator + bananaDenominator + figDenominator + pomegranateDenominator + melonDenominator + cantelopeDenominator
                + mangoDenominator + guavaDenominator + kiwifruitDenominator + lycheeDenominator + passionfruitDenominator
                + pineappleDenominator + watermelonDenominator + driedApricotDenominator + pruneDenominator + peachDenominator +
                cherryDenominator + plumDenominator + jamDenominator + redcurrantDenominator + blackcurrantDenominator +
                strawberryDenominator + blackberryDenominator + raspberryDenominator + blueberryDenominator +
                appleblossomDenominator + orangeblossomDenominator + floralDenominator + honeysuckleDenominator +
                geraniumDenominator + violetDenominator + lavenderDenominator + roseDenominator +
                eucalyptusDenominator + cutgrassDenominator + rosemaryDenominator + thymeDenominator +
                mintDenominator + hayDenominator + mushroomDenominator + truffleDenominator + leatherDenominator +
                greenpepperDenominator + tomatoDenominator + cornDenominator + onionDenominator + pineDenominator +
                cedarDenominator + oakDenominator + hazelnutDenominator + almondDenominator +
                nutmegDenominator + walnutDenominator + pepperDenominator + cinnamonDenominator + vanilaDenominator +
                cloveDenominator + chiliDenominator + licoriceDenominator + saffronDenominator + tobaccoDenominator +
                coffeeDenominator + breadDenominator + toastedBreadDenominator + butterDenominator +
                creamDenominator + blueCheeseDenominator + coconutDenominator + keroseneDenominator + honeyDenominator +
                chocolateDenominator + corkDenominator + rubberbandDenominator + eggDenominator +
                flintDenominator + smokeDenominator + caramelDenominator;

        tastingNegativePoints = grapefruitNegativePoints + lemonNegativePoints + limeNegativePoints +
                orangeNegativePoints + orangepeelNegativePoints + appleNegativePoints + grannysmithNegativePoints + pearNegativePoints
                + apricotNegativePoints + bananaNegativePoints + figNegativePoints + pomegranateNegativePoints + melonNegativePoints +
                cantelopeNegativePoints + mangoNegativePoints + guavaNegativePoints + kiwifruitNegativePoints
                + lycheeNegativePoints + passionfruitNegativePoints + pineappleNegativePoints + watermelonNegativePoints +
                driedApricotNegativePoints + pruneNegativePoints + peachNegativePoints + cherryNegativePoints + plumNegativePoints +
                jamNegativePoints + redcurrantNegativePoints + blackcurrantNegativePoints + strawberryNegativePoints +
                blackberryNegativePoints + raspberryNegativePoints + blueberryNegativePoints + appleblossomNegativePoints +
                orangeblossomNegativePoints + floralNegativePoints + honeysuckleNegativePoints + geraniumNegativePoints +
                violetNegativePoints + lavenderNegativePoints + roseNegativePoints + eucalyptusNegativePoints + cutgrassNegativePoints +
                rosemaryNegativePoints + thymeNegativePoints + mintNegativePoints + hayNegativePoints + mushroomNegativePoints +
                truffleNegativePoints + leatherNegativePoints + greenpepperNegativePoints + tomatoNegativePoints + cornNegativePoints +
                onionNegativePoints + pineNegativePoints + cedarNegativePoints + oakNegativePoints + hazelnutNegativePoints +
                almondNegativePoints + nutmegNegativePoints + walnutNegativePoints + pepperNegativePoints + cinnamonNegativePoints +
                vanilaNegativePoints + cloveNegativePoints + chiliNegativePoints + licoriceNegativePoints + saffronNegativePoints +
                tobaccoNegativePoints + coffeeNegativePoints + breadNegativePoints + toastedBreadNegativePoints +
                butterNegativePoints + creamNegativePoints + blueCheeseNegativePoints + coconutNegativePoints + keroseneNegativePoints +
                honeyNegativePoints + chocolateNegativePoints + corkNegativePoints + rubberbandNegativePoints + eggNegativePoints +
                flintNegativePoints + smokeNegativePoints + caramelNegativePoints;


        double tastingpoints = (double) tastingNegativePoints / scoreDenominator;
        if (tastingpoints != 0) {
            calculateTastingPoints(tastingpoints);
        } else {
            calculateTastingPoints(tastingpoints);
        }

        answerAlertDialog(mScore, mGrapefruitAnswer, mLemonAnswer, mLimeAnswer, mOrangeAnswer, mOrangepeelAnswer,
                mAppleAnswer, mGrannysmithAnswer, mPearAnswer, mApricotAnswer, mBananaAnswer, mFigAnswer, mPomegranateAnswer,
                mMelonAnswer, mCantelopeAnswer, mMangoAnswer, mGuavaAnswer, mKiwifruitAnswer, mLycheeAnswer, mPassionfruitAnswer,
                mPineappleAnswer, mWatermelonAnswer, mDriedApricotAnswer, mPruneAnswer, mPeachAnswer, mCherryAnswer, mPlumAnswer,
                mJamAnswer, mRedcurrantAnswer, mBlackcurrantAnswer, mStrawberryAnswer, mBlackberryAnswer, mRaspberryAnswer,
                mBlueberryAnswer, mAppleblossomAnswer, mOrangeblossomAnswer, mFloralAnswer, mHoneysuckleAnswer, mGeraniumAnswer,
                mVioletAnswer, mLavenderAnswer, mRoseAnswer, mEucalyptusAnswer, mCutgrassAnswer, mRosemaryAnswer, mThymeAnswer,
                mMintAnswer, mHayAnswer, mMushroomAnswer, mTruffleAnswer, mLeatherAnswer, mGreenpepperAnswer, mTomatoAnswer, mCornAnswer,
                mOnionAnswer, mPineAnswer, mCedarAnswer, mOakAnswer, mHazelnutAnswer, mAlmondAnswer, mNutmegAnswer, mWalnutAnswer,
                mPepperAnswer, mCinnamonAnswer, mVanilaAnswer, mCloveAnswer, mChiliAnswer, mLicoriceAnswer, mSaffronAnswer, mTobaccoAnswer,
                mCoffeeAnswer, mBreadAnswer, mToastedBreadAnswer, mButterAnswer, mCreamAnswer, mBlueCheeseAnswer, mCoconutAnswer,
                mKeroseneAnswer, mHoneyAnswer, mChocolateAnswer, mCorkAnswer, mRubberbandAnswer, mEggAnswer, mFlintAnswer, mSmokeAnswer,
                mCaramelAnswer);

    }

    public void calculateTastingPoints(double tastingpoints) {
        if (tastingpoints >= 0.0 && tastingpoints <= 0.05) {
            mScore = 100;
        }
        if (tastingpoints <= 0.15 && tastingpoints > 0.05) {
            mScore = 95;
        }
        if (tastingpoints <= 0.25 && tastingpoints > 0.15) {
            mScore = 90;
        }
        if (tastingpoints <= 0.35 && tastingpoints > 0.25) {
            mScore = 80;
        }
        if (tastingpoints <= 0.45 && tastingpoints > 0.35) {
            mScore = 70;
        }
        if (tastingpoints <= 0.6 && tastingpoints > 0.45) {
            mScore = 50;
        }
        if (tastingpoints <= 0.75 && tastingpoints > 0.6) {
            mScore = 25;
        }
        if (tastingpoints > 0.75) {
            mScore = 0;
        }
    }


    public void grapefruitCalculation() {
        //Grapefruit Calculation
        mGrapefruitDifference = mGrapefruitAnswer - mGrapefruitValueNo;

        if (mGrapefruitAnswer == 0 && mGrapefruitValueNo == 0) {
            grapefruitDenominator = 0;

        } else {
            if (mGrapefruitDifference <= -31) {
                grapefruitNegativePoints = 10;
            }
            if (mGrapefruitDifference <= -11 && mGrapefruitDifference >= -30) {
                grapefruitNegativePoints = 5;
            }
            if (mGrapefruitDifference >= -10 && mGrapefruitDifference <= 10) {
                grapefruitNegativePoints = 0;
            }
            if (mGrapefruitDifference >= 11 && mGrapefruitDifference <= 30) {
                grapefruitNegativePoints = 5;
            }
            if (mGrapefruitDifference >= 31) {
                grapefruitNegativePoints = 10;
            }
            grapefruitDenominator = 10;
        }
    }

    public void lemonCalculation() {
        // Lemon Calculation
        mLemonDifference = mLemonAnswer - mLemonValueNo;
        if (mLemonAnswer == 0 && mLemonValueNo == 0) {
            lemonDenominator = 0;

        } else {
            if (mLemonDifference <= -31) {
                lemonNegativePoints = 10;
            }
            if (mLemonDifference <= -11 && mLemonDifference >= -30) {
                lemonNegativePoints = 5;
            }
            if (mLemonDifference <= -10 && mLemonDifference >= 10) {
                lemonNegativePoints = 0;
            }
            if (mLemonDifference >= 11 && mLemonDifference <= 30) {
                lemonNegativePoints = 5;
            }
            if (mLemonDifference >= 31) {
                lemonNegativePoints = 10;
            }
            lemonDenominator = 10;
        }
    }

    public void limeCalculation() {

        // Lime Calculation
        mLimeDifference = mLimeAnswer - mLimeValueNo;

        if (mLimeAnswer == 0 && mLimeValueNo == 0) {
            limeDenominator = 0;

        } else {
            if (mLimeDifference <= -31) {
                limeNegativePoints = 10;
            }
            if (mLimeDifference <= -11 && mLimeDifference >= -30) {
                limeNegativePoints = 5;
            }
            if (mLimeDifference <= -10 && mLimeDifference >= 10) {
                limeNegativePoints = 0;
            }
            if (mLimeDifference >= 11 && mLimeDifference <= 30) {
                limeNegativePoints = 5;
            }
            if (mLimeDifference >= 31) {
                limeNegativePoints = 10;
            }
            limeDenominator = 10;
        }


    }

    public void orangeCalculation() {
        //orange Calculation
        mOrangeDifference = mOrangeAnswer - mOrangeValueNo;

        if (mOrangeAnswer == 0 && mOrangeValueNo == 0) {
            orangeDenominator = 0;

        } else {

            if (mOrangeDifference <= -31) {
                orangeNegativePoints = 10;
            }
            if (mOrangeDifference <= -11 && mOrangeDifference >= -30) {
                orangeNegativePoints = 5;
            }
            if (mOrangeDifference >= -10 && mOrangeDifference <= 10) {
                orangeNegativePoints = 0;
            }
            if (mOrangeDifference >= 11 && mOrangeDifference <= 30) {
                orangeNegativePoints = 5;
            }
            if (mOrangeDifference >= 31) {
                orangeNegativePoints = 10;
            }
            orangeDenominator = 10;
        }


    }

    public void orangepeelCalculation() {
        //orangepeel Calculation
        mOrangepeelDifference = mOrangepeelAnswer - mOrangepeelValueNo;

        if (mOrangepeelAnswer == 0 && mOrangepeelValueNo == 0) {
            orangepeelDenominator = 0;

        } else {

            if (mOrangepeelDifference <= -31) {
                orangepeelNegativePoints = 10;
            }
            if (mOrangepeelDifference <= -11 && mOrangepeelDifference >= -30) {
                orangepeelNegativePoints = 5;
            }
            if (mOrangepeelDifference >= -10 && mOrangepeelDifference <= 10) {
                orangepeelNegativePoints = 0;
            }
            if (mOrangepeelDifference >= 11 && mOrangepeelDifference <= 30) {
                orangepeelNegativePoints = 5;
            }
            if (mOrangepeelDifference >= 31) {
                orangepeelNegativePoints = 10;
            }
            orangepeelDenominator = 10;
        }


    }

    public void appleCalculation() {
        //apple Calculation
        mAppleDifference = mAppleAnswer - mAppleValueNo;

        if (mAppleAnswer == 0 && mAppleValueNo == 0) {
            appleDenominator = 0;

        } else {

            if (mAppleDifference <= -31) {
                appleNegativePoints = 10;
            }
            if (mAppleDifference <= -11 && mAppleDifference >= -30) {
                appleNegativePoints = 5;
            }
            if (mAppleDifference >= -10 && mAppleDifference <= 10) {
                appleNegativePoints = 0;
            }
            if (mAppleDifference >= 11 && mAppleDifference <= 30) {
                appleNegativePoints = 5;
            }
            if (mAppleDifference >= 31) {
                appleNegativePoints = 10;
            }
            appleDenominator = 10;
        }


    }

    public void grannysmithCalculation() {
        //grannysmith Calculation
        mGrannysmithDifference = mGrannysmithAnswer - mGrannysmithValueNo;

        if (mGrannysmithAnswer == 0 && mGrannysmithValueNo == 0) {
            grannysmithDenominator = 0;

        } else {


            if (mGrannysmithDifference <= -31) {
                grannysmithNegativePoints = 10;
            }
            if (mGrannysmithDifference <= -11 && mGrannysmithDifference >= -30) {
                grannysmithNegativePoints = 5;
            }
            if (mGrannysmithDifference >= -10 && mGrannysmithDifference <= 10) {
                grannysmithNegativePoints = 0;
            }
            if (mGrannysmithDifference >= 11 && mGrannysmithDifference <= 30) {
                grannysmithNegativePoints = 5;
            }
            if (mGrannysmithDifference >= 31) {
                grannysmithNegativePoints = 10;
            }
            grannysmithDenominator = 10;
        }


    }

    public void pearCalculation() {
        //pear Calculation
        mPearDifference = mPearAnswer - mPearValueNo;

        if (mPearAnswer == 0 && mPearValueNo == 0) {
            pearDenominator = 0;

        } else {
            if (mPearDifference <= -31) {
                pearNegativePoints = 10;
            }
            if (mPearDifference <= -11 && mPearDifference >= -30) {
                pearNegativePoints = 5;
            }
            if (mPearDifference >= -10 && mPearDifference <= 10) {
                pearNegativePoints = 0;
            }
            if (mPearDifference >= 11 && mPearDifference <= 30) {
                pearNegativePoints = 5;
            }
            if (mPearDifference >= 31) {
                pearNegativePoints = 10;
            }
            pearDenominator = 10;
        }


    }

    public void apricotCalculation() {
        //apricot Calculation
        mApricotDifference = mApricotAnswer - mApricotValueNo;

        if (mApricotAnswer == 0 && mApricotValueNo == 0) {
            apricotDenominator = 0;

        } else {

            if (mApricotDifference <= -31) {
                apricotNegativePoints = 10;
            }
            if (mApricotDifference <= -11 && mApricotDifference >= -30) {
                apricotNegativePoints = 5;
            }
            if (mApricotDifference >= -10 && mApricotDifference <= 10) {
                apricotNegativePoints = 0;
            }
            if (mApricotDifference >= 11 && mApricotDifference <= 30) {
                apricotNegativePoints = 5;
            }
            if (mApricotDifference >= 31) {
                apricotNegativePoints = 10;
            }
            apricotDenominator = 10;
        }


    }

    public void bananaCalculation() {
        //banana Calculation
        mBananaDifference = mBananaAnswer - mBananaValueNo;

        if (mBananaAnswer == 0 && mBananaValueNo == 0) {
            bananaDenominator = 0;

        } else {

            if (mBananaDifference <= -31) {
                bananaNegativePoints = 10;
            }
            if (mBananaDifference <= -11 && mBananaDifference >= -30) {
                bananaNegativePoints = 5;
            }
            if (mBananaDifference >= -10 && mBananaDifference <= 10) {
                bananaNegativePoints = 0;
            }
            if (mBananaDifference >= 11 && mBananaDifference <= 30) {
                bananaNegativePoints = 5;
            }
            if (mBananaDifference >= 31) {
                bananaNegativePoints = 10;
            }
            bananaDenominator = 10;
        }


    }

    public void figCalculation() {
        //fig Calculation
        mFigDifference = mFigAnswer - mFigValueNo;

        if (mFigAnswer == 0 && mFigValueNo == 0) {
            figDenominator = 0;

        } else {

            if (mFigDifference <= -31) {
                figNegativePoints = 10;
            }
            if (mFigDifference <= -11 && mFigDifference >= -30) {
                figNegativePoints = 5;
            }
            if (mFigDifference >= -10 && mFigDifference <= 10) {
                figNegativePoints = 0;
            }
            if (mFigDifference >= 11 && mFigDifference <= 30) {
                figNegativePoints = 5;
            }
            if (mFigDifference >= 31) {
                figNegativePoints = 10;
            }
            figDenominator = 10;
        }

    }

    public void pomegranateCalculation() {
        //pomegranate Calculation
        mPomegranateDifference = mPomegranateAnswer - mPomegranateValueNo;

        if (mPomegranateAnswer == 0 && mPomegranateValueNo == 0) {
            pomegranateDenominator = 0;

        } else {
            if (mPomegranateDifference <= -31) {
                pomegranateNegativePoints = 10;
            }
            if (mPomegranateDifference <= -11 && mPomegranateDifference >= -30) {
                pomegranateNegativePoints = 5;
            }
            if (mPomegranateDifference >= -10 && mPomegranateDifference <= 10) {
                pomegranateNegativePoints = 0;
            }
            if (mPomegranateDifference >= 11 && mPomegranateDifference <= 30) {
                pomegranateNegativePoints = 5;
            }
            if (mPomegranateDifference >= 31) {
                pomegranateNegativePoints = 10;
            }
            pomegranateDenominator = 10;
        }


    }

    public void melonCalculation() {
        //melon Calculation
        mMelonDifference = mMelonAnswer - mMelonValueNo;

        if (mMelonAnswer == 0 && mMelonValueNo == 0) {
            melonDenominator = 0;

        } else {

            if (mMelonDifference <= -31) {
                melonNegativePoints = 10;
            }
            if (mMelonDifference <= -11 && mMelonDifference >= -30) {
                melonNegativePoints = 5;
            }
            if (mMelonDifference >= -10 && mMelonDifference <= 10) {
                melonNegativePoints = 0;
            }
            if (mMelonDifference >= 11 && mMelonDifference <= 30) {
                melonNegativePoints = 5;
            }
            if (mMelonDifference >= 31) {
                melonNegativePoints = 10;
            }
            melonDenominator = 10;
        }

    }

    public void cantelopeCalculation() {
        //fig Calculation
        mCantelopeDifference = mCantelopeAnswer - mCantelopeValueNo;

        if (mCantelopeAnswer == 0 && mCantelopeValueNo == 0) {
            cantelopeDenominator = 0;

        } else {

            if (mCantelopeDifference <= -31) {
                cantelopeNegativePoints = 10;
            }
            if (mCantelopeDifference <= -11 && mCantelopeDifference >= -30) {
                cantelopeNegativePoints = 5;
            }
            if (mCantelopeDifference >= -10 && mCantelopeDifference <= 10) {
                cantelopeNegativePoints = 0;
            }
            if (mCantelopeDifference >= 11 && mCantelopeDifference <= 30) {
                cantelopeNegativePoints = 5;
            }
            if (mCantelopeDifference >= 31) {
                cantelopeNegativePoints = 10;
            }
            cantelopeDenominator = 10;
        }
    }

    public void mangoCalculation() {
        //mango Calculation
        mMangoDifference = mMangoAnswer - mMangoValueNo;

        if (mMangoAnswer == 0 && mMangoValueNo == 0) {
            mangoDenominator = 0;

        } else {

            if (mMangoDifference <= -31) {
                mangoNegativePoints = 10;
            }
            if (mMangoDifference <= -11 && mMangoDifference >= -30) {
                mangoNegativePoints = 5;
            }
            if (mMangoDifference >= -10 && mMangoDifference <= 10) {
                mangoNegativePoints = 0;
            }
            if (mMangoDifference >= 11 && mMangoDifference <= 30) {
                mangoNegativePoints = 5;
            }
            if (mMangoDifference >= 31) {
                mangoNegativePoints = 10;
            }
            mangoDenominator = 10;
        }
    }

    public void guavaCalculation() {
        //guava Calculation
        mGuavaDifference = mGuavaAnswer - mGuavaValueNo;

        if (mGuavaAnswer == 0 && mGuavaValueNo == 0) {
            guavaDenominator = 0;

        } else {

            if (mGuavaDifference <= -31) {
                guavaNegativePoints = 10;
            }
            if (mGuavaDifference <= -11 && mGuavaDifference >= -30) {
                guavaNegativePoints = 5;
            }
            if (mGuavaDifference >= -10 && mGuavaDifference <= 10) {
                guavaNegativePoints = 0;
            }
            if (mGuavaDifference >= 11 && mGuavaDifference <= 30) {
                guavaNegativePoints = 5;
            }
            if (mGuavaDifference >= 31) {
                guavaNegativePoints = 10;
            }
            guavaDenominator = 10;
        }
    }

    public void kiwifruitCalculation() {
        //kiwifruit Calculation
        mKiwifruitDifference = mKiwifruitAnswer - mKiwifruitValueNo;

        if (mKiwifruitAnswer == 0 && mKiwifruitValueNo == 0) {
            kiwifruitDenominator = 0;

        } else {

            if (mKiwifruitDifference <= -31) {
                kiwifruitNegativePoints = 10;
            }
            if (mKiwifruitDifference <= -11 && mKiwifruitDifference >= -30) {
                kiwifruitNegativePoints = 5;
            }
            if (mKiwifruitDifference >= -10 && mKiwifruitDifference <= 10) {
                kiwifruitNegativePoints = 0;
            }
            if (mKiwifruitDifference >= 11 && mKiwifruitDifference <= 30) {
                kiwifruitNegativePoints = 5;
            }
            if (mKiwifruitDifference >= 31) {
                kiwifruitNegativePoints = 10;
            }
            kiwifruitDenominator = 10;
        }
    }

    public void lycheeCalculation() {
        //lychee Calculation
        mLycheeDifference = mLycheeAnswer - mLycheeValueNo;

        if (mFigAnswer == 0 && mFigValueNo == 0) {
            lycheeDenominator = 0;

        } else {

            if (mLycheeDifference <= -31) {
                lycheeNegativePoints = 10;
            }
            if (mLycheeDifference <= -11 && mLycheeDifference >= -30) {
                lycheeNegativePoints = 5;
            }
            if (mLycheeDifference >= -10 && mLycheeDifference <= 10) {
                lycheeNegativePoints = 0;
            }
            if (mLycheeDifference >= 11 && mLycheeDifference <= 30) {
                lycheeNegativePoints = 5;
            }
            if (mLycheeDifference >= 31) {
                lycheeNegativePoints = 10;
            }
            lycheeDenominator = 10;
        }

    }

    public void passionfruitCalculation() {
        //passionfruit Calculation
        mPassionfruitDifference = mPassionfruitAnswer - mPassionfruitValueNo;

        if (mPassionfruitAnswer == 0 && mPassionfruitValueNo == 0) {
            passionfruitDenominator = 0;

        } else {

            if (mPassionfruitDifference <= -31) {
                passionfruitNegativePoints = 10;
            }
            if (mPassionfruitDifference <= -11 && mPassionfruitDifference >= -30) {
                passionfruitNegativePoints = 5;
            }
            if (mPassionfruitDifference >= -10 && mPassionfruitDifference <= 10) {
                passionfruitNegativePoints = 0;
            }
            if (mPassionfruitDifference >= 11 && mPassionfruitDifference <= 30) {
                passionfruitNegativePoints = 5;
            }
            if (mPassionfruitDifference >= 31) {
                passionfruitNegativePoints = 10;
            }
            passionfruitDenominator = 10;
        }

    }

    public void pineappleCalculation() {
        //fig Calculation
        mPineappleDifference = mPineappleAnswer - mPineappleValueNo;

        if (mPineappleAnswer == 0 && mPineappleValueNo == 0) {
            pineappleDenominator = 0;

        } else {

            if (mPineappleDifference <= -31) {
                pineappleNegativePoints = 10;
            }
            if (mPineappleDifference <= -11 && mPineappleDifference >= -30) {
                pineappleNegativePoints = 5;
            }
            if (mPineappleDifference >= -10 && mPineappleDifference <= 10) {
                pineappleNegativePoints = 0;
            }
            if (mPineappleDifference >= 11 && mPineappleDifference <= 30) {
                pineappleNegativePoints = 5;
            }
            if (mPineappleDifference >= 31) {
                pineappleNegativePoints = 10;
            }
            pineappleDenominator = 10;
        }

    }

    public void watermelonCalculation() {
        //watermelon Calculation
        mWatermelonDifference = mWatermelonAnswer - mWatermelonValueNo;

        if (mWatermelonAnswer == 0 && mWatermelonValueNo == 0) {
            watermelonDenominator = 0;

        } else {

            if (mWatermelonDifference <= -31) {
                watermelonNegativePoints = 10;
            }
            if (mWatermelonDifference <= -11 && mWatermelonDifference >= -30) {
                watermelonNegativePoints = 5;
            }
            if (mWatermelonDifference >= -10 && mWatermelonDifference <= 10) {
                watermelonNegativePoints = 0;
            }
            if (mWatermelonDifference >= 11 && mWatermelonDifference <= 30) {
                watermelonNegativePoints = 5;
            }
            if (mWatermelonDifference >= 31) {
                watermelonNegativePoints = 10;
            }
            watermelonDenominator = 10;
        }

    }

    public void driedapricotCalculation() {
        //DriedApricot Calculation
        mDriedApricotDifference = mDriedApricotAnswer - mDriedApricotValueNo;

        if (mDriedApricotAnswer == 0 && mDriedApricotValueNo == 0) {
            driedApricotDenominator = 0;

        } else {

            if (mDriedApricotDifference <= -31) {
                driedApricotNegativePoints = 10;
            }
            if (mDriedApricotDifference <= -11 && mDriedApricotDifference >= -30) {
                driedApricotNegativePoints = 5;
            }
            if (mDriedApricotDifference >= -10 && mDriedApricotDifference <= 10) {
                driedApricotNegativePoints = 0;
            }
            if (mDriedApricotDifference >= 11 && mDriedApricotDifference <= 30) {
                driedApricotNegativePoints = 5;
            }
            if (mDriedApricotDifference >= 31) {
                driedApricotNegativePoints = 10;
            }
            driedApricotDenominator = 10;
        }
    }

    public void pruneCalculation() {

//Prune Calculation
        mPruneDifference = mPruneAnswer - mPruneValueNo;

        if (mPruneAnswer == 0 && mPruneValueNo == 0) {
            pruneDenominator = 0;

        } else {

            if (mPruneDifference <= -31) {
                pruneNegativePoints = 10;
            }
            if (mPruneDifference <= -11 && mPruneDifference >= -30) {
                pruneNegativePoints = 5;
            }
            if (mPruneDifference >= -10 && mPruneDifference <= 10) {
                pruneNegativePoints = 0;
            }
            if (mPruneDifference >= 11 && mPruneDifference <= 30) {
                pruneNegativePoints = 5;
            }
            if (mPruneDifference >= 31) {
                pruneNegativePoints = 10;
            }
            pruneDenominator = 10;
        }

    }

    public void peachCalculation() {
//Peach Calculation
        mPeachDifference = mPeachAnswer - mPeachValueNo;

        if (mPeachAnswer == 0 && mPeachValueNo == 0) {
            peachDenominator = 0;

        } else {

            if (mPeachDifference <= -31) {
                peachNegativePoints = 10;
            }
            if (mPeachDifference <= -11 && mPeachDifference >= -30) {
                peachNegativePoints = 5;
            }
            if (mPeachDifference >= -10 && mPeachDifference <= 10) {
                peachNegativePoints = 0;
            }
            if (mPeachDifference >= 11 && mPeachDifference <= 30) {
                peachNegativePoints = 5;
            }
            if (mPeachDifference >= 31) {
                peachNegativePoints = 10;
            }
            peachDenominator = 10;
        }

    }

    public void cherryCalculation() {
        //Cherry Calculation
        mCherryDifference = mCherryAnswer - mCherryValueNo;

        if (mCherryAnswer == 0 && mCherryValueNo == 0) {
            cherryDenominator = 0;

        } else {

            if (mCherryDifference <= -31) {
                cherryNegativePoints = 10;
            }
            if (mCherryDifference <= -11 && mCherryDifference >= -30) {
                cherryNegativePoints = 5;
            }
            if (mCherryDifference >= -10 && mCherryDifference <= 10) {
                cherryNegativePoints = 0;
            }
            if (mCherryDifference >= 11 && mCherryDifference <= 30) {
                cherryNegativePoints = 5;
            }
            if (mCherryDifference >= 31) {
                cherryNegativePoints = 10;
            }
            cherryDenominator = 10;
        }


    }

    public void plumCalculation() {
//Plum Calculation
        mPlumDifference = mPlumAnswer - mPlumValueNo;

        if (mPlumAnswer == 0 && mPlumValueNo == 0) {
            plumDenominator = 0;

        } else {

            if (mPlumDifference <= -31) {
                plumNegativePoints = 10;
            }
            if (mPlumDifference <= -11 && mPlumDifference >= -30) {
                plumNegativePoints = 5;
            }
            if (mPlumDifference >= -10 && mPlumDifference <= 10) {
                plumNegativePoints = 0;
            }
            if (mPlumDifference >= 11 && mPlumDifference <= 30) {
                plumNegativePoints = 5;
            }
            if (mPlumDifference >= 31) {
                plumNegativePoints = 10;
            }
            plumDenominator = 10;
        }

    }

    public void jamCalculation() {

//Jam Calculation
        mJamDifference = mJamAnswer - mJamValueNo;

        if (mJamAnswer == 0 && mJamValueNo == 0) {
            jamDenominator = 0;

        } else {

            if (mJamDifference <= -31) {
                jamNegativePoints = 10;
            }
            if (mJamDifference <= -11 && mJamDifference >= -30) {
                jamNegativePoints = 5;
            }
            if (mJamDifference >= -10 && mJamDifference <= 10) {
                jamNegativePoints = 0;
            }
            if (mJamDifference >= 11 && mJamDifference <= 30) {
                jamNegativePoints = 5;
            }
            if (mJamDifference >= 31) {
                jamNegativePoints = 10;
            }
            jamDenominator = 10;
        }

    }

    public void redcurrantCalculation() {
//Redcurrant Calculation
        mRedcurrantDifference = mRedcurrantAnswer - mRedcurrantValueNo;

        if (mRedcurrantAnswer == 0 && mRedcurrantValueNo == 0) {
            redcurrantDenominator = 0;

        } else {

            if (mRedcurrantDifference <= -31) {
                redcurrantNegativePoints = 10;
            }
            if (mRedcurrantDifference <= -11 && mRedcurrantDifference >= -30) {
                redcurrantNegativePoints = 5;
            }
            if (mRedcurrantDifference >= -10 && mRedcurrantDifference <= 10) {
                redcurrantNegativePoints = 0;
            }
            if (mRedcurrantDifference >= 11 && mRedcurrantDifference <= 30) {
                redcurrantNegativePoints = 5;
            }
            if (mRedcurrantDifference >= 31) {
                redcurrantNegativePoints = 10;
            }
            redcurrantDenominator = 10;
        }

    }

    public void blackcurrantCalculation() {
//Blackcurrant Calculation
        mBlackcurrantDifference = mBlackcurrantAnswer - mBlackcurrantValueNo;

        if (mBlackcurrantAnswer == 0 && mBlackcurrantValueNo == 0) {
            blackcurrantDenominator = 0;

        } else {

            if (mBlackcurrantDifference <= -31) {
                blackcurrantNegativePoints = 10;
            }
            if (mBlackcurrantDifference <= -11 && mBlackcurrantDifference >= -30) {
                blackcurrantNegativePoints = 5;
            }
            if (mBlackcurrantDifference >= -10 && mBlackcurrantDifference <= 10) {
                blackcurrantNegativePoints = 0;
            }
            if (mBlackcurrantDifference >= 11 && mBlackcurrantDifference <= 30) {
                blackcurrantNegativePoints = 5;
            }
            if (mBlackcurrantDifference >= 31) {
                blackcurrantNegativePoints = 10;
            }
            blackcurrantDenominator = 10;
        }

    }

    public void strawberryCalculation() {
//Strawberry Calculation
        mStrawberryDifference = mStrawberryAnswer - mStrawberryValueNo;

        if (mStrawberryAnswer == 0 && mStrawberryValueNo == 0) {
            strawberryDenominator = 0;

        } else {

            if (mStrawberryDifference <= -31) {
                strawberryNegativePoints = 10;
            }
            if (mStrawberryDifference <= -11 && mStrawberryDifference >= -30) {
                strawberryNegativePoints = 5;
            }
            if (mStrawberryDifference >= -10 && mStrawberryDifference <= 10) {
                strawberryNegativePoints = 0;
            }
            if (mStrawberryDifference >= 11 && mStrawberryDifference <= 30) {
                strawberryNegativePoints = 5;
            }
            if (mStrawberryDifference >= 31) {
                strawberryNegativePoints = 10;
            }
            strawberryDenominator = 10;
        }

    }

    public void blackberryCalculation() {

//Blackberry Calculation
        mBlackberryDifference = mBlackberryAnswer - mBlackberryValueNo;

        if (mBlackberryAnswer == 0 && mBlackberryValueNo == 0) {
            blackberryDenominator = 0;

        } else {

            if (mBlackberryDifference <= -31) {
                blackberryNegativePoints = 10;
            }
            if (mBlackberryDifference <= -11 && mBlackberryDifference >= -30) {
                blackberryNegativePoints = 5;
            }
            if (mBlackberryDifference >= -10 && mBlackberryDifference <= 10) {
                blackberryNegativePoints = 0;
            }
            if (mBlackberryDifference >= 11 && mBlackberryDifference <= 30) {
                blackberryNegativePoints = 5;
            }
            if (mBlackberryDifference >= 31) {
                blackberryNegativePoints = 10;
            }
            blackberryDenominator = 10;
        }

    }

    public void raspberryCalculation() {
//Raspberry Calculation
        mRaspberryDifference = mRaspberryAnswer - mRaspberryValueNo;

        if (mRaspberryAnswer == 0 && mRaspberryValueNo == 0) {
            raspberryDenominator = 0;

        } else {

            if (mRaspberryDifference <= -31) {
                raspberryNegativePoints = 10;
            }
            if (mRaspberryDifference <= -11 && mRaspberryDifference >= -30) {
                raspberryNegativePoints = 5;
            }
            if (mRaspberryDifference >= -10 && mRaspberryDifference <= 10) {
                raspberryNegativePoints = 0;
            }
            if (mRaspberryDifference >= 11 && mRaspberryDifference <= 30) {
                raspberryNegativePoints = 5;
            }
            if (mRaspberryDifference >= 31) {
                raspberryNegativePoints = 10;
            }
            raspberryDenominator = 10;
        }

    }

    public void blueberryCalculation() {
        //Blueberry Calculation
        mBlueberryDifference = mBlueberryAnswer - mBlueberryValueNo;

        if (mBlueberryAnswer == 0 && mBlueberryValueNo == 0) {
            blueberryDenominator = 0;

        } else {

            if (mBlueberryDifference <= -31) {
                blueberryNegativePoints = 10;
            }
            if (mBlueberryDifference <= -11 && mBlueberryDifference >= -30) {
                blueberryNegativePoints = 5;
            }
            if (mBlueberryDifference >= -10 && mBlueberryDifference <= 10) {
                blueberryNegativePoints = 0;
            }
            if (mBlueberryDifference >= 11 && mBlueberryDifference <= 30) {
                blueberryNegativePoints = 5;
            }
            if (mBlueberryDifference >= 31) {
                blueberryNegativePoints = 10;
            }
            blueberryDenominator = 10;
        }


    }

    public void appleblossomCalculation() {
        //Appleblossom Calculation
        mAppleblossomDifference = mAppleblossomAnswer - mAppleblossomValueNo;

        if (mAppleblossomAnswer == 0 && mAppleblossomValueNo == 0) {
            appleblossomDenominator = 0;

        } else {

            if (mAppleblossomDifference <= -31) {
                appleblossomNegativePoints = 10;
            }
            if (mAppleblossomDifference <= -11 && mAppleblossomDifference >= -30) {
                appleblossomNegativePoints = 5;
            }
            if (mAppleblossomDifference >= -10 && mAppleblossomDifference <= 10) {
                appleblossomNegativePoints = 0;
            }
            if (mAppleblossomDifference >= 11 && mAppleblossomDifference <= 30) {
                appleblossomNegativePoints = 5;
            }
            if (mAppleblossomDifference >= 31) {
                appleblossomNegativePoints = 10;
            }
            appleblossomDenominator = 10;
        }
    }

    public void orangeblossomCalculation() {
//Orangeblossom Calculation
        mOrangeblossomDifference = mOrangeblossomAnswer - mOrangeblossomValueNo;

        if (mOrangeblossomAnswer == 0 && mOrangeblossomValueNo == 0) {
            orangeblossomDenominator = 0;

        } else {

            if (mOrangeblossomDifference <= -31) {
                orangeblossomNegativePoints = 10;
            }
            if (mOrangeblossomDifference <= -11 && mOrangeblossomDifference >= -30) {
                orangeblossomNegativePoints = 5;
            }
            if (mOrangeblossomDifference >= -10 && mOrangeblossomDifference <= 10) {
                orangeblossomNegativePoints = 0;
            }
            if (mOrangeblossomDifference >= 11 && mOrangeblossomDifference <= 30) {
                orangeblossomNegativePoints = 5;
            }
            if (mOrangeblossomDifference >= 31) {
                orangeblossomNegativePoints = 10;
            }
            orangeblossomDenominator = 10;
        }

    }

    public void floralCalculation() {
//Floral Calculation
        mFloralDifference = mFloralAnswer - mFloralValueNo;

        if (mFloralAnswer == 0 && mFloralValueNo == 0) {
            floralDenominator = 0;

        } else {

            if (mFloralDifference <= -31) {
                floralNegativePoints = 10;
            }
            if (mFloralDifference <= -11 && mFloralDifference >= -30) {
                floralNegativePoints = 5;
            }
            if (mFloralDifference >= -10 && mFloralDifference <= 10) {
                floralNegativePoints = 0;
            }
            if (mFloralDifference >= 11 && mFloralDifference <= 30) {
                floralNegativePoints = 5;
            }
            if (mFloralDifference >= 31) {
                floralNegativePoints = 10;
            }
            floralDenominator = 10;
        }

    }

    public void honeysuckleCalculation() {
//Honeysuckle Calculation
        mHoneysuckleDifference = mHoneysuckleAnswer - mHoneysuckleValueNo;

        if (mHoneysuckleAnswer == 0 && mHoneysuckleValueNo == 0) {
            honeysuckleDenominator = 0;

        } else {

            if (mHoneysuckleDifference <= -31) {
                honeysuckleNegativePoints = 10;
            }
            if (mHoneysuckleDifference <= -11 && mHoneysuckleDifference >= -30) {
                honeysuckleNegativePoints = 5;
            }
            if (mHoneysuckleDifference >= -10 && mHoneysuckleDifference <= 10) {
                honeysuckleNegativePoints = 0;
            }
            if (mHoneysuckleDifference >= 11 && mHoneysuckleDifference <= 30) {
                honeysuckleNegativePoints = 5;
            }
            if (mHoneysuckleDifference >= 31) {
                honeysuckleNegativePoints = 10;
            }
            honeysuckleDenominator = 10;
        }

    }

    public void geraniumCalculation() {
//Geranium Calculation
        mGeraniumDifference = mGeraniumAnswer - mGeraniumValueNo;

        if (mGeraniumAnswer == 0 && mGeraniumValueNo == 0) {
            geraniumDenominator = 0;

        } else {

            if (mGeraniumDifference <= -31) {
                geraniumNegativePoints = 10;
            }
            if (mGeraniumDifference <= -11 && mGeraniumDifference >= -30) {
                geraniumNegativePoints = 5;
            }
            if (mGeraniumDifference >= -10 && mGeraniumDifference <= 10) {
                geraniumNegativePoints = 0;
            }
            if (mGeraniumDifference >= 11 && mGeraniumDifference <= 30) {
                geraniumNegativePoints = 5;
            }
            if (mGeraniumDifference >= 31) {
                geraniumNegativePoints = 10;
            }
            geraniumDenominator = 10;
        }

    }

    public void violetCalculation() {
//Violet Calculation
        mVioletDifference = mVioletAnswer - mVioletValueNo;

        if (mVioletAnswer == 0 && mVioletValueNo == 0) {
            violetDenominator = 0;

        } else {

            if (mVioletDifference <= -31) {
                violetNegativePoints = 10;
            }
            if (mVioletDifference <= -11 && mVioletDifference >= -30) {
                violetNegativePoints = 5;
            }
            if (mVioletDifference >= -10 && mVioletDifference <= 10) {
                violetNegativePoints = 0;
            }
            if (mVioletDifference >= 11 && mVioletDifference <= 30) {
                violetNegativePoints = 5;
            }
            if (mVioletDifference >= 31) {
                violetNegativePoints = 10;
            }
            violetDenominator = 10;
        }

    }

    public void lavenderCalculation() {
//Lavender Calculation
        mLavenderDifference = mLavenderAnswer - mLavenderValueNo;

        if (mLavenderAnswer == 0 && mLavenderValueNo == 0) {
            lavenderDenominator = 0;

        } else {

            if (mLavenderDifference <= -31) {
                lavenderNegativePoints = 10;
            }
            if (mLavenderDifference <= -11 && mLavenderDifference >= -30) {
                lavenderNegativePoints = 5;
            }
            if (mLavenderDifference >= -10 && mLavenderDifference <= 10) {
                lavenderNegativePoints = 0;
            }
            if (mLavenderDifference >= 11 && mLavenderDifference <= 30) {
                lavenderNegativePoints = 5;
            }
            if (mLavenderDifference >= 31) {
                lavenderNegativePoints = 10;
            }
            lavenderDenominator = 10;
        }


    }

    public void roseCalculation() {
//Rose Calculation
        mRoseDifference = mRoseAnswer - mRoseValueNo;

        if (mRoseAnswer == 0 && mRoseValueNo == 0) {
            roseDenominator = 0;

        } else {

            if (mRoseDifference <= -31) {
                roseNegativePoints = 10;
            }
            if (mRoseDifference <= -11 && mRoseDifference >= -30) {
                roseNegativePoints = 5;
            }
            if (mRoseDifference >= -10 && mRoseDifference <= 10) {
                roseNegativePoints = 0;
            }
            if (mRoseDifference >= 11 && mRoseDifference <= 30) {
                roseNegativePoints = 5;
            }
            if (mRoseDifference >= 31) {
                roseNegativePoints = 10;
            }
            roseDenominator = 10;
        }

    }

    public void eucalyptusCalculation() {

//Eucalyptus Calculation
        mEucalyptusDifference = mEucalyptusAnswer - mEucalyptusValueNo;

        if (mEucalyptusAnswer == 0 && mEucalyptusValueNo == 0) {
            eucalyptusDenominator = 0;

        } else {

            if (mEucalyptusDifference <= -31) {
                eucalyptusNegativePoints = 10;
            }
            if (mEucalyptusDifference <= -11 && mEucalyptusDifference >= -30) {
                eucalyptusNegativePoints = 5;
            }
            if (mEucalyptusDifference >= -10 && mEucalyptusDifference <= 10) {
                eucalyptusNegativePoints = 0;
            }
            if (mEucalyptusDifference >= 11 && mEucalyptusDifference <= 30) {
                eucalyptusNegativePoints = 5;
            }
            if (mEucalyptusDifference >= 31) {
                eucalyptusNegativePoints = 10;
            }
            eucalyptusDenominator = 10;
        }

    }

    public void cutgrassCalculation() {
//Cutgrass Calculation
        mCutgrassDifference = mCutgrassAnswer - mCutgrassValueNo;

        if (mCutgrassAnswer == 0 && mCutgrassValueNo == 0) {
            cutgrassDenominator = 0;

        } else {

            if (mCutgrassDifference <= -31) {
                cutgrassNegativePoints = 10;
            }
            if (mCutgrassDifference <= -11 && mCutgrassDifference >= -30) {
                cutgrassNegativePoints = 5;
            }
            if (mCutgrassDifference >= -10 && mCutgrassDifference <= 10) {
                cutgrassNegativePoints = 0;
            }
            if (mCutgrassDifference >= 11 && mCutgrassDifference <= 30) {
                cutgrassNegativePoints = 5;
            }
            if (mCutgrassDifference >= 31) {
                cutgrassNegativePoints = 10;
            }
            cutgrassDenominator = 10;
        }

    }

    public void rosemaryCalculation() {

//Rosemary Calculation
        mRosemaryDifference = mRosemaryAnswer - mRosemaryValueNo;

        if (mRosemaryAnswer == 0 && mRosemaryValueNo == 0) {
            rosemaryDenominator = 0;

        } else {

            if (mRosemaryDifference <= -31) {
                rosemaryNegativePoints = 10;
            }
            if (mRosemaryDifference <= -11 && mRosemaryDifference >= -30) {
                rosemaryNegativePoints = 5;
            }
            if (mRosemaryDifference >= -10 && mRosemaryDifference <= 10) {
                rosemaryNegativePoints = 0;
            }
            if (mRosemaryDifference >= 11 && mRosemaryDifference <= 30) {
                rosemaryNegativePoints = 5;
            }
            if (mRosemaryDifference >= 31) {
                rosemaryNegativePoints = 10;
            }
            rosemaryDenominator = 10;
        }


    }

    public void thymeCalculation() {

//Thyme Calculation
        mThymeDifference = mThymeAnswer - mThymeValueNo;

        if (mThymeAnswer == 0 && mThymeValueNo == 0) {
            thymeDenominator = 0;

        } else {

            if (mThymeDifference <= -31) {
                thymeNegativePoints = 10;
            }
            if (mThymeDifference <= -11 && mThymeDifference >= -30) {
                thymeNegativePoints = 5;
            }
            if (mThymeDifference >= -10 && mThymeDifference <= 10) {
                thymeNegativePoints = 0;
            }
            if (mThymeDifference >= 11 && mThymeDifference <= 30) {
                thymeNegativePoints = 5;
            }
            if (mThymeDifference >= 31) {
                thymeNegativePoints = 10;
            }
            thymeDenominator = 10;
        }

    }

    public void mintCalculation() {

//Mint Calculation
        mMintDifference = mMintAnswer - mMintValueNo;

        if (mMintAnswer == 0 && mMintValueNo == 0) {
            mintDenominator = 0;

        } else {

            if (mMintDifference <= -31) {
                mintNegativePoints = 10;
            }
            if (mMintDifference <= -11 && mMintDifference >= -30) {
                mintNegativePoints = 5;
            }
            if (mMintDifference >= -10 && mMintDifference <= 10) {
                mintNegativePoints = 0;
            }
            if (mMintDifference >= 11 && mMintDifference <= 30) {
                mintNegativePoints = 5;
            }
            if (mMintDifference >= 31) {
                mintNegativePoints = 10;
            }
            mintDenominator = 10;
        }

    }

    public void hayCalculation() {

//Hay Calculation
        mHayDifference = mHayAnswer - mHayValueNo;

        if (mHayAnswer == 0 && mHayValueNo == 0) {
            hayDenominator = 0;

        } else {

            if (mHayDifference <= -31) {
                hayNegativePoints = 10;
            }
            if (mHayDifference <= -11 && mHayDifference >= -30) {
                hayNegativePoints = 5;
            }
            if (mHayDifference >= -10 && mHayDifference <= 10) {
                hayNegativePoints = 0;
            }
            if (mHayDifference >= 11 && mHayDifference <= 30) {
                hayNegativePoints = 5;
            }
            if (mHayDifference >= 31) {
                hayNegativePoints = 10;
            }
            hayDenominator = 10;
        }

    }

    public void mushroomCalculation() {

//Mushroom Calculation
        mMushroomDifference = mMushroomAnswer - mMushroomValueNo;

        if (mMushroomAnswer == 0 && mMushroomValueNo == 0) {
            mushroomDenominator = 0;

        } else {

            if (mMushroomDifference <= -31) {
                mushroomNegativePoints = 10;
            }
            if (mMushroomDifference <= -11 && mMushroomDifference >= -30) {
                mushroomNegativePoints = 5;
            }
            if (mMushroomDifference >= -10 && mMushroomDifference <= 10) {
                mushroomNegativePoints = 0;
            }
            if (mMushroomDifference >= 11 && mMushroomDifference <= 30) {
                mushroomNegativePoints = 5;
            }
            if (mMushroomDifference >= 31) {
                mushroomNegativePoints = 10;
            }
            mushroomDenominator = 10;
        }


    }

    public void truffleCalculation() {
//Truffle Calculation
        mTruffleDifference = mTruffleAnswer - mTruffleValueNo;

        if (mTruffleAnswer == 0 && mTruffleValueNo == 0) {
            truffleDenominator = 0;

        } else {

            if (mTruffleDifference <= -31) {
                truffleNegativePoints = 10;
            }
            if (mTruffleDifference <= -11 && mTruffleDifference >= -30) {
                truffleNegativePoints = 5;
            }
            if (mTruffleDifference >= -10 && mTruffleDifference <= 10) {
                truffleNegativePoints = 0;
            }
            if (mTruffleDifference >= 11 && mTruffleDifference <= 30) {
                truffleNegativePoints = 5;
            }
            if (mTruffleDifference >= 31) {
                truffleNegativePoints = 10;
            }
            truffleDenominator = 10;
        }

    }

    public void leatherCalculation() {
//Leather Calculation
        mLeatherDifference = mLeatherAnswer - mLeatherValueNo;

        if (mLeatherAnswer == 0 && mLeatherValueNo == 0) {
            leatherDenominator = 0;

        } else {

            if (mLeatherDifference <= -31) {
                leatherNegativePoints = 10;
            }
            if (mLeatherDifference <= -11 && mLeatherDifference >= -30) {
                leatherNegativePoints = 5;
            }
            if (mLeatherDifference >= -10 && mLeatherDifference <= 10) {
                leatherNegativePoints = 0;
            }
            if (mLeatherDifference >= 11 && mLeatherDifference <= 30) {
                leatherNegativePoints = 5;
            }
            if (mLeatherDifference >= 31) {
                leatherNegativePoints = 10;
            }
            leatherDenominator = 10;
        }

    }

    public void greenpepperCalculation() {
//Greenpepper Calculation
        mGreenpepperDifference = mGreenpepperAnswer - mGreenpepperValueNo;

        if (mGreenpepperAnswer == 0 && mGreenpepperValueNo == 0) {
            greenpepperDenominator = 0;

        } else {

            if (mGreenpepperDifference <= -31) {
                greenpepperNegativePoints = 10;
            }
            if (mGreenpepperDifference <= -11 && mGreenpepperDifference >= -30) {
                greenpepperNegativePoints = 5;
            }
            if (mGreenpepperDifference >= -10 && mGreenpepperDifference <= 10) {
                greenpepperNegativePoints = 0;
            }
            if (mGreenpepperDifference >= 11 && mGreenpepperDifference <= 30) {
                greenpepperNegativePoints = 5;
            }
            if (mGreenpepperDifference >= 31) {
                greenpepperNegativePoints = 10;
            }
            greenpepperDenominator = 10;
        }

    }

    public void tomatoCalculation() {
//Tomato Calculation
        mTomatoDifference = mTomatoAnswer - mTomatoValueNo;

        if (mTomatoAnswer == 0 && mTomatoValueNo == 0) {
            tomatoDenominator = 0;

        } else {

            if (mTomatoDifference <= -31) {
                tomatoNegativePoints = 10;
            }
            if (mTomatoDifference <= -11 && mTomatoDifference >= -30) {
                tomatoNegativePoints = 5;
            }
            if (mTomatoDifference >= -10 && mTomatoDifference <= 10) {
                tomatoNegativePoints = 0;
            }
            if (mTomatoDifference >= 11 && mTomatoDifference <= 30) {
                tomatoNegativePoints = 5;
            }
            if (mTomatoDifference >= 31) {
                tomatoNegativePoints = 10;
            }
            tomatoDenominator = 10;
        }

    }

    public void cornCalculation() {
//Corn Calculation
        mCornDifference = mCornAnswer - mCornValueNo;

        if (mCornAnswer == 0 && mCornValueNo == 0) {
            cornDenominator = 0;

        } else {

            if (mCornDifference <= -31) {
                cornNegativePoints = 10;
            }
            if (mCornDifference <= -11 && mCornDifference >= -30) {
                cornNegativePoints = 5;
            }
            if (mCornDifference >= -10 && mCornDifference <= 10) {
                cornNegativePoints = 0;
            }
            if (mCornDifference >= 11 && mCornDifference <= 30) {
                cornNegativePoints = 5;
            }
            if (mCornDifference >= 31) {
                cornNegativePoints = 10;
            }
            cornDenominator = 10;
        }

    }

    public void onionCalculation() {
//Onion Calculation
        mOnionDifference = mOnionAnswer - mOnionValueNo;

        if (mOnionAnswer == 0 && mOnionValueNo == 0) {
            onionDenominator = 0;

        } else {

            if (mOnionDifference <= -31) {
                onionNegativePoints = 10;
            }
            if (mOnionDifference <= -11 && mOnionDifference >= -30) {
                onionNegativePoints = 5;
            }
            if (mOnionDifference >= -10 && mOnionDifference <= 10) {
                onionNegativePoints = 0;
            }
            if (mOnionDifference >= 11 && mOnionDifference <= 30) {
                onionNegativePoints = 5;
            }
            if (mOnionDifference >= 31) {
                onionNegativePoints = 10;
            }
            onionDenominator = 10;
        }

    }

    public void pineCalculation() {
//Pine Calculation
        mPineDifference = mPineAnswer - mPineValueNo;

        if (mPineAnswer == 0 && mPineValueNo == 0) {
            pineDenominator = 0;

        } else {

            if (mPineDifference <= -31) {
                pineNegativePoints = 10;
            }
            if (mPineDifference <= -11 && mPineDifference >= -30) {
                pineNegativePoints = 5;
            }
            if (mPineDifference >= -10 && mPineDifference <= 10) {
                pineNegativePoints = 0;
            }
            if (mPineDifference >= 11 && mPineDifference <= 30) {
                pineNegativePoints = 5;
            }
            if (mPineDifference >= 31) {
                pineNegativePoints = 10;
            }
            pineDenominator = 10;
        }

    }

    public void cedarCalculation() {
//Cedar Calculation
        mCedarDifference = mCedarAnswer - mCedarValueNo;

        if (mCedarAnswer == 0 && mCedarValueNo == 0) {
            cedarDenominator = 0;

        } else {

            if (mCedarDifference <= -31) {
                cedarNegativePoints = 10;
            }
            if (mCedarDifference <= -11 && mCedarDifference >= -30) {
                cedarNegativePoints = 5;
            }
            if (mCedarDifference >= -10 && mCedarDifference <= 10) {
                cedarNegativePoints = 0;
            }
            if (mCedarDifference >= 11 && mCedarDifference <= 30) {
                cedarNegativePoints = 5;
            }
            if (mCedarDifference >= 31) {
                cedarNegativePoints = 10;
            }
            cedarDenominator = 10;
        }

    }

    public void oakCalculation() {
//Oak Calculation
        mOakDifference = mOakAnswer - mOakValueNo;

        if (mOakAnswer == 0 && mOakValueNo == 0) {
            oakDenominator = 0;

        } else {

            if (mOakDifference <= -31) {
                oakNegativePoints = 10;
            }
            if (mOakDifference <= -11 && mOakDifference >= -30) {
                oakNegativePoints = 5;
            }
            if (mOakDifference >= -10 && mOakDifference <= 10) {
                oakNegativePoints = 0;
            }
            if (mOakDifference >= 11 && mOakDifference <= 30) {
                oakNegativePoints = 5;
            }
            if (mOakDifference >= 31) {
                oakNegativePoints = 10;
            }
            oakDenominator = 10;
        }

    }

    public void hazelnutCalculation() {
//Hazelnut Calculation
        mHazelnutDifference = mHazelnutAnswer - mHazelnutValueNo;

        if (mHazelnutAnswer == 0 && mHazelnutValueNo == 0) {
            hazelnutDenominator = 0;

        } else {

            if (mHazelnutDifference <= -31) {
                hazelnutNegativePoints = 10;
            }
            if (mHazelnutDifference <= -11 && mHazelnutDifference >= -30) {
                hazelnutNegativePoints = 5;
            }
            if (mHazelnutDifference >= -10 && mHazelnutDifference <= 10) {
                hazelnutNegativePoints = 0;
            }
            if (mHazelnutDifference >= 11 && mHazelnutDifference <= 30) {
                hazelnutNegativePoints = 5;
            }
            if (mHazelnutDifference >= 31) {
                hazelnutNegativePoints = 10;
            }
            hazelnutDenominator = 10;
        }

    }

    public void almondCalculation() {
//Almond Calculation
        mAlmondDifference = mAlmondAnswer - mAlmondValueNo;

        if (mAlmondAnswer == 0 && mAlmondValueNo == 0) {
            almondDenominator = 0;

        } else {

            if (mAlmondDifference <= -31) {
                almondNegativePoints = 10;
            }
            if (mAlmondDifference <= -11 && mAlmondDifference >= -30) {
                almondNegativePoints = 5;
            }
            if (mAlmondDifference >= -10 && mAlmondDifference <= 10) {
                almondNegativePoints = 0;
            }
            if (mAlmondDifference >= 11 && mAlmondDifference <= 30) {
                almondNegativePoints = 5;
            }
            if (mAlmondDifference >= 31) {
                almondNegativePoints = 10;
            }
            almondDenominator = 10;
        }

    }

    public void nutmegCalculation() {
//Nutmeg Calculation
        mNutmegDifference = mNutmegAnswer - mNutmegValueNo;

        if (mNutmegAnswer == 0 && mNutmegValueNo == 0) {
            nutmegDenominator = 0;

        } else {

            if (mNutmegDifference <= -31) {
                nutmegNegativePoints = 10;
            }
            if (mNutmegDifference <= -11 && mNutmegDifference >= -30) {
                nutmegNegativePoints = 5;
            }
            if (mNutmegDifference >= -10 && mNutmegDifference <= 10) {
                nutmegNegativePoints = 0;
            }
            if (mNutmegDifference >= 11 && mNutmegDifference <= 30) {
                nutmegNegativePoints = 5;
            }
            if (mNutmegDifference >= 31) {
                nutmegNegativePoints = 10;
            }
            nutmegDenominator = 10;
        }

    }

    public void walnutCalculation() {
//Walnut Calculation
        mWalnutDifference = mWalnutAnswer - mWalnutValueNo;

        if (mWalnutAnswer == 0 && mWalnutValueNo == 0) {
            walnutDenominator = 0;

        } else {

            if (mWalnutDifference <= -31) {
                walnutNegativePoints = 10;
            }
            if (mWalnutDifference <= -11 && mWalnutDifference >= -30) {
                walnutNegativePoints = 5;
            }
            if (mWalnutDifference >= -10 && mWalnutDifference <= 10) {
                walnutNegativePoints = 0;
            }
            if (mWalnutDifference >= 11 && mWalnutDifference <= 30) {
                walnutNegativePoints = 5;
            }
            if (mWalnutDifference >= 31) {
                walnutNegativePoints = 10;
            }
            walnutDenominator = 10;
        }

    }

    public void pepperCalculation() {
//Pepper Calculation
        mPepperDifference = mPepperAnswer - mPepperValueNo;

        if (mPepperAnswer == 0 && mPepperValueNo == 0) {
            pepperDenominator = 0;

        } else {

            if (mPepperDifference <= -31) {
                pepperNegativePoints = 10;
            }
            if (mPepperDifference <= -11 && mPepperDifference >= -30) {
                pepperNegativePoints = 5;
            }
            if (mPepperDifference >= -10 && mPepperDifference <= 10) {
                pepperNegativePoints = 0;
            }
            if (mPepperDifference >= 11 && mPepperDifference <= 30) {
                pepperNegativePoints = 5;
            }
            if (mPepperDifference >= 31) {
                pepperNegativePoints = 10;
            }
            pepperDenominator = 10;
        }

    }

    public void cinnamonCalculation() {
//Cinnamon Calculation
        mCinnamonDifference = mCinnamonAnswer - mCinnamonValueNo;

        if (mCinnamonAnswer == 0 && mCinnamonValueNo == 0) {
            cinnamonDenominator = 0;

        } else {

            if (mCinnamonDifference <= -31) {
                cinnamonNegativePoints = 10;
            }
            if (mCinnamonDifference <= -11 && mCinnamonDifference >= -30) {
                cinnamonNegativePoints = 5;
            }
            if (mCinnamonDifference >= -10 && mCinnamonDifference <= 10) {
                cinnamonNegativePoints = 0;
            }
            if (mCinnamonDifference >= 11 && mCinnamonDifference <= 30) {
                cinnamonNegativePoints = 5;
            }
            if (mCinnamonDifference >= 31) {
                cinnamonNegativePoints = 10;
            }
            cinnamonDenominator = 10;
        }

    }

    public void vanilaCalculation() {
//Vanila Calculation
        mVanilaDifference = mVanilaAnswer - mVanilaValueNo;

        if (mVanilaAnswer == 0 && mVanilaValueNo == 0) {
            vanilaDenominator = 0;

        } else {

            if (mVanilaDifference <= -31) {
                vanilaNegativePoints = 10;
            }
            if (mVanilaDifference <= -11 && mVanilaDifference >= -30) {
                vanilaNegativePoints = 5;
            }
            if (mVanilaDifference >= -10 && mVanilaDifference <= 10) {
                vanilaNegativePoints = 0;
            }
            if (mVanilaDifference >= 11 && mVanilaDifference <= 30) {
                vanilaNegativePoints = 5;
            }
            if (mVanilaDifference >= 31) {
                vanilaNegativePoints = 10;
            }
            vanilaDenominator = 10;
        }

    }

    public void cloveCalculation() {
//Clove Calculation
        mCloveDifference = mCloveAnswer - mCloveValueNo;

        if (mCloveAnswer == 0 && mCloveValueNo == 0) {
            cloveDenominator = 0;

        } else {

            if (mCloveDifference <= -31) {
                cloveNegativePoints = 10;
            }
            if (mCloveDifference <= -11 && mCloveDifference >= -30) {
                cloveNegativePoints = 5;
            }
            if (mCloveDifference >= -10 && mCloveDifference <= 10) {
                cloveNegativePoints = 0;
            }
            if (mCloveDifference >= 11 && mCloveDifference <= 30) {
                cloveNegativePoints = 5;
            }
            if (mCloveDifference >= 31) {
                cloveNegativePoints = 10;
            }
            cloveDenominator = 10;
        }

    }

    public void chiliCalculation() {
//Chili Calculation
        mChiliDifference = mChiliAnswer - mChiliValueNo;

        if (mChiliAnswer == 0 && mChiliValueNo == 0) {
            chiliDenominator = 0;

        } else {

            if (mChiliDifference <= -31) {
                chiliNegativePoints = 10;
            }
            if (mChiliDifference <= -11 && mChiliDifference >= -30) {
                chiliNegativePoints = 5;
            }
            if (mChiliDifference >= -10 && mChiliDifference <= 10) {
                chiliNegativePoints = 0;
            }
            if (mChiliDifference >= 11 && mChiliDifference <= 30) {
                chiliNegativePoints = 5;
            }
            if (mChiliDifference >= 31) {
                chiliNegativePoints = 10;
            }
            chiliDenominator = 10;
        }

    }

    public void licoriceCalculation() {
//Licorice Calculation
        mLicoriceDifference = mLicoriceAnswer - mLicoriceValueNo;

        if (mLicoriceAnswer == 0 && mLicoriceValueNo == 0) {
            licoriceDenominator = 0;

        } else {

            if (mLicoriceDifference <= -31) {
                licoriceNegativePoints = 10;
            }
            if (mLicoriceDifference <= -11 && mLicoriceDifference >= -30) {
                licoriceNegativePoints = 5;
            }
            if (mLicoriceDifference >= -10 && mLicoriceDifference <= 10) {
                licoriceNegativePoints = 0;
            }
            if (mLicoriceDifference >= 11 && mLicoriceDifference <= 30) {
                licoriceNegativePoints = 5;
            }
            if (mLicoriceDifference >= 31) {
                licoriceNegativePoints = 10;
            }
            licoriceDenominator = 10;
        }

    }

    public void saffronCalculation() {
//Saffron Calculation
        mSaffronDifference = mSaffronAnswer - mSaffronValueNo;

        if (mSaffronAnswer == 0 && mSaffronValueNo == 0) {
            saffronDenominator = 0;

        } else {

            if (mSaffronDifference <= -31) {
                saffronNegativePoints = 10;
            }
            if (mSaffronDifference <= -11 && mSaffronDifference >= -30) {
                saffronNegativePoints = 5;
            }
            if (mSaffronDifference >= -10 && mSaffronDifference <= 10) {
                saffronNegativePoints = 0;
            }
            if (mSaffronDifference >= 11 && mSaffronDifference <= 30) {
                saffronNegativePoints = 5;
            }
            if (mSaffronDifference >= 31) {
                saffronNegativePoints = 10;
            }
            saffronDenominator = 10;
        }

    }

    public void tobaccoCalculation() {
//Tobacco Calculation
        mTobaccoDifference = mTobaccoAnswer - mTobaccoValueNo;

        if (mTobaccoAnswer == 0 && mTobaccoValueNo == 0) {
            tobaccoDenominator = 0;

        } else {

            if (mTobaccoDifference <= -31) {
                tobaccoNegativePoints = 10;
            }
            if (mTobaccoDifference <= -11 && mTobaccoDifference >= -30) {
                tobaccoNegativePoints = 5;
            }
            if (mTobaccoDifference >= -10 && mTobaccoDifference <= 10) {
                tobaccoNegativePoints = 0;
            }
            if (mTobaccoDifference >= 11 && mTobaccoDifference <= 30) {
                tobaccoNegativePoints = 5;
            }
            if (mTobaccoDifference >= 31) {
                tobaccoNegativePoints = 10;
            }
            tobaccoDenominator = 10;
        }

    }

    public void coffeeCalculation() {
//Coffee Calculation
        mCoffeeDifference = mCoffeeAnswer - mCoffeeValueNo;

        if (mCoffeeAnswer == 0 && mCoffeeValueNo == 0) {
            coffeeDenominator = 0;

        } else {

            if (mCoffeeDifference <= -31) {
                coffeeNegativePoints = 10;
            }
            if (mCoffeeDifference <= -11 && mCoffeeDifference >= -30) {
                coffeeNegativePoints = 5;
            }
            if (mCoffeeDifference >= -10 && mCoffeeDifference <= 10) {
                coffeeNegativePoints = 0;
            }
            if (mCoffeeDifference >= 11 && mCoffeeDifference <= 30) {
                coffeeNegativePoints = 5;
            }
            if (mCoffeeDifference >= 31) {
                coffeeNegativePoints = 10;
            }
            coffeeDenominator = 10;
        }

    }

    public void breadCalculation() {
//Bread Calculation
        mBreadDifference = mBreadAnswer - mBreadValueNo;

        if (mBreadAnswer == 0 && mBreadValueNo == 0) {
            breadDenominator = 0;

        } else {

            if (mBreadDifference <= -31) {
                breadNegativePoints = 10;
            }
            if (mBreadDifference <= -11 && mBreadDifference >= -30) {
                breadNegativePoints = 5;
            }
            if (mBreadDifference >= -10 && mBreadDifference <= 10) {
                breadNegativePoints = 0;
            }
            if (mBreadDifference >= 11 && mBreadDifference <= 30) {
                breadNegativePoints = 5;
            }
            if (mBreadDifference >= 31) {
                breadNegativePoints = 10;
            }
            breadDenominator = 10;
        }

    }

    public void toastedbreadCalculation() {
//ToastedBread Calculation
        mToastedBreadDifference = mToastedBreadAnswer - mToastedBreadValueNo;

        if (mToastedBreadAnswer == 0 && mToastedBreadValueNo == 0) {
            toastedBreadDenominator = 0;

        } else {

            if (mToastedBreadDifference <= -31) {
                toastedBreadNegativePoints = 10;
            }
            if (mToastedBreadDifference <= -11 && mToastedBreadDifference >= -30) {
                toastedBreadNegativePoints = 5;
            }
            if (mToastedBreadDifference >= -10 && mToastedBreadDifference <= 10) {
                toastedBreadNegativePoints = 0;
            }
            if (mToastedBreadDifference >= 11 && mToastedBreadDifference <= 30) {
                toastedBreadNegativePoints = 5;
            }
            if (mToastedBreadDifference >= 31) {
                toastedBreadNegativePoints = 10;
            }
            toastedBreadDenominator = 10;
        }

    }

    public void butterCalculation() {
//Butter Calculation
        mButterDifference = mButterAnswer - mButterValueNo;

        if (mButterAnswer == 0 && mButterValueNo == 0) {
            butterDenominator = 0;

        } else {

            if (mButterDifference <= -31) {
                butterNegativePoints = 10;
            }
            if (mButterDifference <= -11 && mButterDifference >= -30) {
                butterNegativePoints = 5;
            }
            if (mButterDifference >= -10 && mButterDifference <= 10) {
                butterNegativePoints = 0;
            }
            if (mButterDifference >= 11 && mButterDifference <= 30) {
                butterNegativePoints = 5;
            }
            if (mButterDifference >= 31) {
                butterNegativePoints = 10;
            }
            butterDenominator = 10;
        }

    }

    public void creamCalculation() {
//Cream Calculation
        mCreamDifference = mCreamAnswer - mCreamValueNo;

        if (mCreamAnswer == 0 && mCreamValueNo == 0) {
            creamDenominator = 0;

        } else {

            if (mCreamDifference <= -31) {
                creamNegativePoints = 10;
            }
            if (mCreamDifference <= -11 && mCreamDifference >= -30) {
                creamNegativePoints = 5;
            }
            if (mCreamDifference >= -10 && mCreamDifference <= 10) {
                creamNegativePoints = 0;
            }
            if (mCreamDifference >= 11 && mCreamDifference <= 30) {
                creamNegativePoints = 5;
            }
            if (mCreamDifference >= 31) {
                creamNegativePoints = 10;
            }
            creamDenominator = 10;
        }

    }

    public void bluecheeseCalculation() {
//BlueCheese Calculation
        mBlueCheeseDifference = mBlueCheeseAnswer - mBlueCheeseValueNo;

        if (mBlueCheeseAnswer == 0 && mBlueCheeseValueNo == 0) {
            blueCheeseDenominator = 0;

        } else {

            if (mBlueCheeseDifference <= -31) {
                blueCheeseNegativePoints = 10;
            }
            if (mBlueCheeseDifference <= -11 && mBlueCheeseDifference >= -30) {
                blueCheeseNegativePoints = 5;
            }
            if (mBlueCheeseDifference >= -10 && mBlueCheeseDifference <= 10) {
                blueCheeseNegativePoints = 0;
            }
            if (mBlueCheeseDifference >= 11 && mBlueCheeseDifference <= 30) {
                blueCheeseNegativePoints = 5;
            }
            if (mBlueCheeseDifference >= 31) {
                blueCheeseNegativePoints = 10;
            }
            blueCheeseDenominator = 10;
        }

    }

    public void coconutCalculation() {
//Coconut Calculation
        mCoconutDifference = mCoconutAnswer - mCoconutValueNo;

        if (mCoconutAnswer == 0 && mCoconutValueNo == 0) {
            coconutDenominator = 0;

        } else {

            if (mCoconutDifference <= -31) {
                coconutNegativePoints = 10;
            }
            if (mCoconutDifference <= -11 && mCoconutDifference >= -30) {
                coconutNegativePoints = 5;
            }
            if (mCoconutDifference >= -10 && mCoconutDifference <= 10) {
                coconutNegativePoints = 0;
            }
            if (mCoconutDifference >= 11 && mCoconutDifference <= 30) {
                coconutNegativePoints = 5;
            }
            if (mCoconutDifference >= 31) {
                coconutNegativePoints = 10;
            }
            coconutDenominator = 10;
        }

    }

    public void keroseneCalculation() {
//Kerosene Calculation
        mKeroseneDifference = mKeroseneAnswer - mKeroseneValueNo;

        if (mKeroseneAnswer == 0 && mKeroseneValueNo == 0) {
            keroseneDenominator = 0;

        } else {

            if (mKeroseneDifference <= -31) {
                keroseneNegativePoints = 10;
            }
            if (mKeroseneDifference <= -11 && mKeroseneDifference >= -30) {
                keroseneNegativePoints = 5;
            }
            if (mKeroseneDifference >= -10 && mKeroseneDifference <= 10) {
                keroseneNegativePoints = 0;
            }
            if (mKeroseneDifference >= 11 && mKeroseneDifference <= 30) {
                keroseneNegativePoints = 5;
            }
            if (mKeroseneDifference >= 31) {
                keroseneNegativePoints = 10;
            }
            keroseneDenominator = 10;
        }

    }

    public void honeyCalculation() {
//Honey Calculation
        mHoneyDifference = mHoneyAnswer - mHoneyValueNo;

        if (mHoneyAnswer == 0 && mHoneyValueNo == 0) {
            honeyDenominator = 0;

        } else {

            if (mHoneyDifference <= -31) {
                honeyNegativePoints = 10;
            }
            if (mHoneyDifference <= -11 && mHoneyDifference >= -30) {
                honeyNegativePoints = 5;
            }
            if (mHoneyDifference >= -10 && mHoneyDifference <= 10) {
                honeyNegativePoints = 0;
            }
            if (mHoneyDifference >= 11 && mHoneyDifference <= 30) {
                honeyNegativePoints = 5;
            }
            if (mHoneyDifference >= 31) {
                honeyNegativePoints = 10;
            }
            honeyDenominator = 10;
        }

    }

    public void chocolateCalculation() {
//Chocolate Calculation
        mChocolateDifference = mChocolateAnswer - mChocolateValueNo;

        if (mChocolateAnswer == 0 && mChocolateValueNo == 0) {
            chocolateDenominator = 0;

        } else {

            if (mChocolateDifference <= -31) {
                chocolateNegativePoints = 10;
            }
            if (mChocolateDifference <= -11 && mChocolateDifference >= -30) {
                chocolateNegativePoints = 5;
            }
            if (mChocolateDifference >= -10 && mChocolateDifference <= 10) {
                chocolateNegativePoints = 0;
            }
            if (mChocolateDifference >= 11 && mChocolateDifference <= 30) {
                chocolateNegativePoints = 5;
            }
            if (mChocolateDifference >= 31) {
                chocolateNegativePoints = 10;
            }
            chocolateDenominator = 10;
        }

    }

    public void corkCalculation() {
//Cork Calculation
        mCorkDifference = mCorkAnswer - mCorkValueNo;

        if (mCorkAnswer == 0 && mCorkValueNo == 0) {
            corkDenominator = 0;

        } else {

            if (mCorkDifference <= -31) {
                corkNegativePoints = 10;
            }
            if (mCorkDifference <= -11 && mCorkDifference >= -30) {
                corkNegativePoints = 5;
            }
            if (mCorkDifference >= -10 && mCorkDifference <= 10) {
                corkNegativePoints = 0;
            }
            if (mCorkDifference >= 11 && mCorkDifference <= 30) {
                corkNegativePoints = 5;
            }
            if (mCorkDifference >= 31) {
                corkNegativePoints = 10;
            }
            corkDenominator = 10;
        }

    }

    public void rubberbandCalculation() {
//Rubberband Calculation
        mRubberbandDifference = mRubberbandAnswer - mRubberbandValueNo;

        if (mRubberbandAnswer == 0 && mRubberbandValueNo == 0) {
            rubberbandDenominator = 0;

        } else {

            if (mRubberbandDifference <= -31) {
                rubberbandNegativePoints = 10;
            }
            if (mRubberbandDifference <= -11 && mRubberbandDifference >= -30) {
                rubberbandNegativePoints = 5;
            }
            if (mRubberbandDifference >= -10 && mRubberbandDifference <= 10) {
                rubberbandNegativePoints = 0;
            }
            if (mRubberbandDifference >= 11 && mRubberbandDifference <= 30) {
                rubberbandNegativePoints = 5;
            }
            if (mRubberbandDifference >= 31) {
                rubberbandNegativePoints = 10;
            }
            rubberbandDenominator = 10;
        }

    }

    public void eggCalculation() {
//Egg Calculation
        mEggDifference = mEggAnswer - mEggValueNo;

        if (mEggAnswer == 0 && mEggValueNo == 0) {
            eggDenominator = 0;

        } else {

            if (mEggDifference <= -31) {
                eggNegativePoints = 10;
            }
            if (mEggDifference <= -11 && mEggDifference >= -30) {
                eggNegativePoints = 5;
            }
            if (mEggDifference >= -10 && mEggDifference <= 10) {
                eggNegativePoints = 0;
            }
            if (mEggDifference >= 11 && mEggDifference <= 30) {
                eggNegativePoints = 5;
            }
            if (mEggDifference >= 31) {
                eggNegativePoints = 10;
            }
            eggDenominator = 10;
        }

    }

    public void flintCalculation() {
//Flint Calculation
        mFlintDifference = mFlintAnswer - mFlintValueNo;

        if (mFlintAnswer == 0 && mFlintValueNo == 0) {
            flintDenominator = 0;

        } else {

            if (mFlintDifference <= -31) {
                flintNegativePoints = 10;
            }
            if (mFlintDifference <= -11 && mFlintDifference >= -30) {
                flintNegativePoints = 5;
            }
            if (mFlintDifference >= -10 && mFlintDifference <= 10) {
                flintNegativePoints = 0;
            }
            if (mFlintDifference >= 11 && mFlintDifference <= 30) {
                flintNegativePoints = 5;
            }
            if (mFlintDifference >= 31) {
                flintNegativePoints = 10;
            }
            flintDenominator = 10;
        }

    }

    public void smokeCalculation() {
//Smoke Calculation
        mSmokeDifference = mSmokeAnswer - mSmokeValueNo;

        if (mSmokeAnswer == 0 && mSmokeValueNo == 0) {
            smokeDenominator = 0;

        } else {

            if (mSmokeDifference <= -31) {
                smokeNegativePoints = 10;
            }
            if (mSmokeDifference <= -11 && mSmokeDifference >= -30) {
                smokeNegativePoints = 5;
            }
            if (mSmokeDifference >= -10 && mSmokeDifference <= 10) {
                smokeNegativePoints = 0;
            }
            if (mSmokeDifference >= 11 && mSmokeDifference <= 30) {
                smokeNegativePoints = 5;
            }
            if (mSmokeDifference >= 31) {
                smokeNegativePoints = 10;
            }
            smokeDenominator = 10;
        }

    }

    public void caramelCalculation() {
//Caramel Calculation
        mCaramelDifference = mCaramelAnswer - mCaramelValueNo;

        if (mCaramelAnswer == 0 && mCaramelValueNo == 0) {
            caramelDenominator = 0;

        } else {

            if (mCaramelDifference <= -31) {
                caramelNegativePoints = 10;
            }
            if (mCaramelDifference <= -11 && mCaramelDifference >= -30) {
                caramelNegativePoints = 5;
            }
            if (mCaramelDifference >= -10 && mCaramelDifference <= 10) {
                caramelNegativePoints = 0;
            }
            if (mCaramelDifference >= 11 && mCaramelDifference <= 30) {
                caramelNegativePoints = 5;
            }
            if (mCaramelDifference >= 31) {
                caramelNegativePoints = 10;
            }
            caramelDenominator = 10;
        }

    }

















































}

