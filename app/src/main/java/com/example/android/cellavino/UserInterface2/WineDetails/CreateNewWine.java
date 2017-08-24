package com.example.android.cellavino.UserInterface2.WineDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastePojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.ServerValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Andrew on 25/04/2017.
 */

public class CreateNewWine extends AppCompatActivity {

    public TextView mCreateWineName;
    public TextView mCreateWineWinery;
    public TextView mCreateWineVintage;
    public String mCreateWineVintageYear;
    public TextView mCreateWineVariety;
    public TextView mCreateWineTastingDate;
    public TextView mCreateWineDescription;
    public Button mCreateNewWine;
    public Toast mToastMessage;

    public FirebaseAuth mFirebaseAuth;

    private RatingBar mCreateNewWineRating;

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
    public SeekBar mBanana;
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
    public SeekBar mHoneysuckle;
    public SeekBar mRubberband;
    public SeekBar mEgg;
    public SeekBar mOnion;
    public SeekBar mCorn;
    public SeekBar mGeranium;
    public SeekBar mAppleblossum;
    public SeekBar mOrangeblossum;
    public SeekBar mViolet;
    public SeekBar mLavender;
    public SeekBar mRose;
    public SeekBar mCutgrass;
    public SeekBar mRosemary;
    public SeekBar mThyme;
    public SeekBar mEucalyptus;
    public SeekBar mFlint;
    public SeekBar mBread;
    public SeekBar mCream;
    public SeekBar mSmoke;
    public SeekBar mNutmeg;
    public SeekBar mPine;
    public SeekBar mCedar;
    public SeekBar mFig;
    public SeekBar mFloral;
    public SeekBar mRaspberry;
    public SeekBar mJam;
    public SeekBar mKiwifruit;
    public SeekBar mMango;
    public SeekBar mChili;
    public SeekBar mPomegranate;
    public SeekBar mWatermelon;
    public SeekBar mSaffron;
    public SeekBar mWalnut;
    public SeekBar mPeach;
    public SeekBar mCantelope;
    public SeekBar mBlueberry;
    public SeekBar mCaramel;
    public SeekBar mBlueCheese;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_wine);

        mFirebaseAuth = FirebaseAuth.getInstance();

        /*
        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        // Create an adapter that knows which fragment should be shown on each page
        AromaFragmentPagerAdapter aromaAdapter = new AromaFragmentPagerAdapter(getSupportFragmentManager());
        // Set the adapter onto the view pager
        viewPager.setAdapter(aromaAdapter);
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        */
        mCreateNewWineRating = (RatingBar) findViewById(R.id.create_new_wine_rating);

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
        mBanana = (SeekBar) findViewById(R.id.seekBar_banana);
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
        mHoneysuckle = (SeekBar) findViewById(R.id.seekBar_as_honeysuckle_20);
        mGeranium = (SeekBar) findViewById(R.id.seekBar_at_geranium_21);
        mAppleblossum = (SeekBar) findViewById(R.id.seekBar_aw_apple_blossum_24);
        mOrangeblossum = (SeekBar) findViewById(R.id.seekBar_au_orange_blossum_22);
        mViolet = (SeekBar) findViewById(R.id.seekBar_ay_violet_26);
        mLavender = (SeekBar) findViewById(R.id.seekBar_az_lavendar_27);
        mRose = (SeekBar) findViewById(R.id.seekBar_ba_rose_28);
        mCutgrass = (SeekBar) findViewById(R.id.seekBar_bd_cut_grass_31);
        mRosemary = (SeekBar) findViewById(R.id.seekBar_be_rosemary_32);
        mThyme = (SeekBar) findViewById(R.id.seekBar_bf_thyme_33);
        mEucalyptus = (SeekBar) findViewById(R.id.seekBar_bk_eucalyptus_38);
        mFlint = (SeekBar) findViewById(R.id.seekBar_bl_flint_39);
        mBread = (SeekBar) findViewById(R.id.seekBar_bo_bread_42);
        mCream = (SeekBar) findViewById(R.id.seekBar_bp_cream_44);
        mSmoke = (SeekBar) findViewById(R.id.seekBar_bt_smoke_47);
        mNutmeg = (SeekBar) findViewById(R.id.seekBar_by_nutmeg_52);
        mPine = (SeekBar) findViewById(R.id.seekBar_cf_pine_59);
        mCedar = (SeekBar) findViewById(R.id.seekBar_cg_cedar_60);
        mFig = (SeekBar) findViewById(R.id.seekBar_db_fig);
        mFloral = (SeekBar) findViewById(R.id.seekBar_dc_floral);
        mRaspberry = (SeekBar) findViewById(R.id.seekBar_dd_raspberry);
        mJam = (SeekBar) findViewById(R.id.seekBar_de_jam);
        mKiwifruit = (SeekBar) findViewById(R.id.seekBar_df_kiwifruit);
        mMango = (SeekBar) findViewById(R.id.seekBar_dg_mango);
        mChili = (SeekBar) findViewById(R.id.seekBar_dh_chili);
        mPomegranate = (SeekBar) findViewById(R.id.seekBar_di_pomegranate);
        mWatermelon = (SeekBar) findViewById(R.id.seekBar_dj_watermelon);
        mSaffron = (SeekBar) findViewById(R.id.seekBar_dk_saffron);
        mWalnut = (SeekBar) findViewById(R.id.seekBar_dl_walnut);
        mPeach = (SeekBar) findViewById(R.id.seekBar_dm_peach);
        mCantelope = (SeekBar) findViewById(R.id.seekBar_dn_cantelope);
        mBlueberry = (SeekBar) findViewById(R.id.seekBar_dp_blueberry);
        mCaramel = (SeekBar) findViewById(R.id.seekBar_dq_caramel);
        mBlueCheese = (SeekBar) findViewById(R.id.seekBar_dr_blue_cheese);

        mCreateWineName = (TextView) findViewById(R.id.create_wine_name);
        mCreateWineWinery = (TextView) findViewById(R.id.create_wine_winery);
        mCreateWineVariety = (TextView) findViewById(R.id.create_wine_variety);
        mCreateWineTastingDate = (TextView) findViewById(R.id.create_wine_tasting_date);
        mCreateWineDescription = (TextView) findViewById(R.id.create_wine_description);
        mCreateNewWine = (Button) findViewById(R.id.create_new_wine_button);

        mCreateNewWineRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar myWineRating, float wineRating, boolean fromUser) {

            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        // Specify the layout to use when the list of choices appears
        // Apply the adapter to the spinner
        Spinner spinner = (Spinner) findViewById(R.id.create_wine_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.wine_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Create an ArrayAdapter using the string array and a default spinner layout
        // Specify the layout to use when the list of choices appears
        // Apply the adapter to the spinner
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = thisYear; i >= 1900; i--) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> vintageAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, years);
        Spinner spinVintage = (Spinner) findViewById(R.id.create_wine_vintage_spinner);
        spinVintage.setAdapter(vintageAdapter);
        mCreateWineVintageYear = spinVintage.getSelectedItem().toString();

        mCreateWineVintage = (TextView) findViewById(R.id.create_wine_year);


        //set the click listener on the button that  pushes wine into the database
        mCreateNewWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWineToDatabase();
            }
        });

        mGrapefuit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int grapefruitValue = 0;

            public void onProgressChanged(SeekBar mGrapefuit, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Grapefruit: " + grapefruitValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mLemon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lemonValue = 0;

            public void onProgressChanged(SeekBar mLemon, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Lemon: " + lemonValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mLime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int limeValue = 0;

            public void onProgressChanged(SeekBar mLime, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Lime: " + limeValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mOrange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int orangeValue = 0;

            public void onProgressChanged(SeekBar mOrange, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Orange: " + orangeValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPear.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pearValue = 0;

            public void onProgressChanged(SeekBar mPear, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Pear: " + pearValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mApple.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int appleValue = 0;

            public void onProgressChanged(SeekBar mApple, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Apple: " + appleValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mGrannysmith.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int grannysmithValue = 0;

            public void onProgressChanged(SeekBar mGrannysmith, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Grannysmith: " + grannysmithValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mApricot.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int apricotValue = 0;

            public void onProgressChanged(SeekBar mApricot, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Apricot: " + apricotValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mMelon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int melonValue = 0;

            public void onProgressChanged(SeekBar mMelon, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Melon: " + melonValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mGuava.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int guavaValue = 0;

            public void onProgressChanged(SeekBar mGuava, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Guava: " + guavaValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mBanana.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int bananaValue = 0;

            public void onProgressChanged(SeekBar mBanana, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Banana: " + bananaValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPineapple.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pineappleValue = 0;

            public void onProgressChanged(SeekBar mPineapple, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Pineapple: " + pineappleValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPassionfruit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int passionfruitValue = 0;

            public void onProgressChanged(SeekBar mPassionfruit, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Passionfruit: " + passionfruitValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mLychee.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lycheeValue = 0;

            public void onProgressChanged(SeekBar mLychee, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Lychee: " + lycheeValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mRedcurrant.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int redcurrantValue = 0;

            public void onProgressChanged(SeekBar mRedcurrant, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Redcurrant: " + redcurrantValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mBlackcurrant.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int blackcurrantValue = 0;

            public void onProgressChanged(SeekBar mBlackcurrant, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Blackcurrant: " + blackcurrantValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mStrawberry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int strawberryValue = 0;

            public void onProgressChanged(SeekBar mStrawberry, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Strawberry: " + strawberryValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mBlackberry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int blackberryValue = 0;

            public void onProgressChanged(SeekBar mBlackberry, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Blackberry: " + blackberryValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCherry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cherryValue = 0;

            public void onProgressChanged(SeekBar mCherry, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Cherry: " + cherryValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPlum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int plumValue = 0;

            public void onProgressChanged(SeekBar mPlum, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Plum: " + plumValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mGreenpepper.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int greenpepperValue = 0;

            public void onProgressChanged(SeekBar mGreenpepper, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Green Pepper: " + greenpepperValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mTomato.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int tomatoValue = 0;

            public void onProgressChanged(SeekBar mTomato, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Tomato: " + tomatoValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mMint.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mintValue = 0;

            public void onProgressChanged(SeekBar mMint, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Mint: " + mintValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mTobacco.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int tobaccoValue = 0;

            public void onProgressChanged(SeekBar mTobacco, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Tobacco: " + tobaccoValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mHay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int hayValue = 0;

            public void onProgressChanged(SeekBar mHay, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Hay: " + hayValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mKerosene.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int keroseneValue = 0;

            public void onProgressChanged(SeekBar mKerosene, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Kerosene: " + keroseneValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mButter.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int butterValue = 0;

            public void onProgressChanged(SeekBar mButter, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Butter: " + butterValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mToastedbread.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int toastedbreadValue = 0;

            public void onProgressChanged(SeekBar mToastedbread, int progress, boolean fromUser) {
                toastedbreadValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(CreateNewWine.this, "Toasted Bread: " + toastedbreadValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCoffee.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int coffeeValue = 0;

            public void onProgressChanged(SeekBar mCoffee, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Blackberry: " + coffeeValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mVanila.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int vanilaValue = 0;

            public void onProgressChanged(SeekBar mVanila, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Vanila: " + vanilaValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPepper.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pepperValue = 0;

            public void onProgressChanged(SeekBar mPepper, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Pepper: " + pepperValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCinnamon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cinnanmonValue = 0;

            public void onProgressChanged(SeekBar mCinnamon, int progress, boolean fromUser) {
                cinnanmonValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(CreateNewWine.this, "Cinnamon: " + cinnanmonValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mLicorice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int licoriceValue = 0;

            public void onProgressChanged(SeekBar mLicorice, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Licorice: " + licoriceValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mClove.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cloveValue = 0;

            public void onProgressChanged(SeekBar mClove, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Clove: " + cloveValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCoconut.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int coconutValue = 0;

            public void onProgressChanged(SeekBar mCoconut, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Coconut: " + coconutValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mHazelnut.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int hazelnutValue = 0;

            public void onProgressChanged(SeekBar mHazelnut, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Hazelnut: " + hazelnutValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mAlmond.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int almondValue = 0;

            public void onProgressChanged(SeekBar mAlmond, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Almond: " + almondValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mOak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int oakValue = 0;

            public void onProgressChanged(SeekBar mOak, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Oak: " + oakValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mOrangepeel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int orangepeelValue = 0;

            public void onProgressChanged(SeekBar mOrangepeel, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Orange peel: " + orangepeelValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mDriedapricot.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int driedapricotValue = 0;

            public void onProgressChanged(SeekBar mDriedapricot, int progress, boolean fromUser) {
                driedapricotValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(CreateNewWine.this, "Dried Apricot: " + driedapricotValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPrune.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pruneValue = 0;

            public void onProgressChanged(SeekBar mPrune, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Prune: " + pruneValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mHoney.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int honeyValue = 0;

            public void onProgressChanged(SeekBar mHoney, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Honey: " + honeyValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mChocolate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int chocolateValue = 0;

            public void onProgressChanged(SeekBar mChocolate, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Chocolate: " + chocolateValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mLeather.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int leatherValue = 0;

            public void onProgressChanged(SeekBar mLeather, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Leather: " + leatherValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mMushroom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mushroomValue = 0;

            public void onProgressChanged(SeekBar mMushroom, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Mushroom: " + mushroomValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mTruffle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int truffleValue = 0;

            public void onProgressChanged(SeekBar mTruffle, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Truffle: " + truffleValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCork.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int corkValue = 0;

            public void onProgressChanged(SeekBar mCork, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Cork: " + corkValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mRubberband.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int rubberbandValue = 0;

            public void onProgressChanged(SeekBar mRubberband, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Rubberband: " + rubberbandValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mEgg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int eggValue = 0;

            public void onProgressChanged(SeekBar mEgg, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Egg: " + eggValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mOnion.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int onionValue = 0;

            public void onProgressChanged(SeekBar mOnion, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Onion: " + onionValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCorn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cornValue = 0;

            public void onProgressChanged(SeekBar mCorn, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Corn: " + cornValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mHoneysuckle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int honeysuckleValue = 0;

            public void onProgressChanged(SeekBar mHoneysuckle, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Honeysuckle: " + honeysuckleValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mGeranium.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int geraniumValue = 0;

            public void onProgressChanged(SeekBar mGeranium, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Geranium: " + geraniumValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mAppleblossum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int appleblossumValue = 0;

            public void onProgressChanged(SeekBar mAppleblossum, int progress, boolean fromUser) {
                appleblossumValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(CreateNewWine.this, "Appleblossum: " + appleblossumValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mOrangeblossum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int orangeblossumValue = 0;

            public void onProgressChanged(SeekBar mOrangeblossum, int progress, boolean fromUser) {
                orangeblossumValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (mToastMessage != null) {
                    mToastMessage.cancel();
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mToastMessage = Toast.makeText(CreateNewWine.this, "Orangeblossum: " + orangeblossumValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mViolet.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int violetValue = 0;

            public void onProgressChanged(SeekBar mViolet, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Violet: " + violetValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mLavender.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lavenderValue = 0;

            public void onProgressChanged(SeekBar mLavender, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Lavender: " + lavenderValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mRose.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int roseValue = 0;

            public void onProgressChanged(SeekBar mRose, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Rose: " + roseValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCutgrass.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cutgrassValue = 0;

            public void onProgressChanged(SeekBar mCutgrass, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Cutgrass: " + cutgrassValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mRosemary.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int rosemaryValue = 0;

            public void onProgressChanged(SeekBar mRosemary, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Rosemary: " + rosemaryValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mThyme.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int thymeValue = 0;

            public void onProgressChanged(SeekBar mThyme, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Thyme: " + thymeValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mEucalyptus.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int eucalyptusValue = 0;

            public void onProgressChanged(SeekBar mEucalyptus, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Eucalyptus: " + eucalyptusValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mFlint.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int flintValue = 0;

            public void onProgressChanged(SeekBar mFlint, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Flint: " + flintValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mBread.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int breadValue = 0;

            public void onProgressChanged(SeekBar mBread, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Bread: " + breadValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCream.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int creamValue = 0;

            public void onProgressChanged(SeekBar mCream, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Cream: " + creamValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mSmoke.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int smokeValue = 0;

            public void onProgressChanged(SeekBar mSmoke, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Smoke: " + smokeValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mNutmeg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int nutmegValue = 0;

            public void onProgressChanged(SeekBar mNutmeg, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Nutmeg: " + nutmegValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPine.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pineValue = 0;

            public void onProgressChanged(SeekBar mPine, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Pine: " + pineValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCedar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cedarValue = 0;

            public void onProgressChanged(SeekBar mCedar, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Cedar: " + cedarValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mFig.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int figValue = 0;

            public void onProgressChanged(SeekBar mFig, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Fig: " + figValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mFloral.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int floralValue = 0;

            public void onProgressChanged(SeekBar mFloral, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Floral: " + floralValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mRaspberry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int raspberryValue = 0;

            public void onProgressChanged(SeekBar mRaspberry, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Raspberry: " + raspberryValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mJam.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int jamValue = 0;

            public void onProgressChanged(SeekBar mJam, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Jam: " + jamValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCorn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int kiwifruitValue = 0;

            public void onProgressChanged(SeekBar mKiwifruit, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Kiwifruit: " + kiwifruitValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mMango.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mangoValue = 0;

            public void onProgressChanged(SeekBar mMango, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Mango: " + mangoValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mChili.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int chiliValue = 0;

            public void onProgressChanged(SeekBar mChili, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Chili: " + chiliValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPomegranate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pomegranateValue = 0;

            public void onProgressChanged(SeekBar mPomegranate, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Pomegranate: " + pomegranateValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mWatermelon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int watermelonValue = 0;

            public void onProgressChanged(SeekBar mWatermelon, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Watermelon: " + watermelonValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mSaffron.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int saffronValue = 0;

            public void onProgressChanged(SeekBar mSaffron, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Saffron: " + saffronValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mWalnut.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int walnutValue = 0;

            public void onProgressChanged(SeekBar mWalnut, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Walnut: " + walnutValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mPeach.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int peachValue = 0;

            public void onProgressChanged(SeekBar mPeach, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Peach: " + peachValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCantelope.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cantelopeValue = 0;

            public void onProgressChanged(SeekBar mCantelope, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Cantelope: " + cantelopeValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mBlueberry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int blueberryValue = 0;

            public void onProgressChanged(SeekBar mBlueberry, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Blueberry: " + blueberryValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mCaramel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int caramelValue = 0;

            public void onProgressChanged(SeekBar mCaramel, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "Caramel: " + caramelValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

        mBlueCheese.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int bluecheeseValue = 0;

            public void onProgressChanged(SeekBar mBlueCheese, int progress, boolean fromUser) {
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
                mToastMessage = Toast.makeText(CreateNewWine.this, "BlueCheese: " + bluecheeseValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });

    }


    //This part here adds a wine to the wineName details part of the Firebase database.
    //First by taking the Firebase URL from CONSTANTS, then by taking the details the user has entered and passing them into a String.
    //These details are passed into a POJO, along with the time created TIMESTAMP.

    public void addWineToDatabase() {
        //get the reference to the Firebase URL, then get the string that user has entered and push that into the Database.
        // Get the dtails that the user has entered and pass them into a string.
        String newWineToAdd = mCreateWineName.getText().toString();
        String newWineToAddWinery = mCreateWineWinery.getText().toString();
        //String newWineToAddVintage = mCreateWineVintage.getText().toString();
        //TODO fix up this wineVintage code
        String newWineToAddVintage = mCreateWineVintageYear;
        String newWineToAddVariety = mCreateWineVariety.getText().toString();
        String newWineToAddTastingDate = mCreateWineTastingDate.getText().toString();
        String newWineToAddDescription = mCreateWineDescription.getText().toString();

        int ratingGrapefruitTaste = mGrapefuit.getProgress();
        int ratingLemonTaste = mLemon.getProgress();
        int ratingLimeTaste = mLime.getProgress();
        int ratingOrangeTaste = mOrange.getProgress();
        int ratingPearTaste = mPear.getProgress();
        int ratingAppleTaste = mApple.getProgress();
        int ratingGrannysmithTaste = mGrannysmith.getProgress();
        int ratingApricotTaste = mApricot.getProgress();
        int ratingMelonTaste = mMelon.getProgress();
        int ratingGuavaTaste = mGuava.getProgress();
        int ratingBananaTaste = mBanana.getProgress();
        int ratingPineappleTaste = mPineapple.getProgress();
        int ratingPassionfruitTaste = mPassionfruit.getProgress();
        int ratingLycheeTaste = mLychee.getProgress();
        int ratingRedcurrantTaste = mRedcurrant.getProgress();
        int ratingBlackcurrantTaste = mBlackcurrant.getProgress();
        int ratingStrawberryTaste = mStrawberry.getProgress();
        int ratingBlackberryTaste = mBlackberry.getProgress();
        int ratingCherryTaste = mCherry.getProgress();
        int ratingPlumTaste = mPlum.getProgress();
        int ratingGreenpepperTaste = mGreenpepper.getProgress();
        int ratingTomatoTaste = mTomato.getProgress();
        int ratingMintTaste = mMint.getProgress();
        int ratingTobaccoTaste = mTobacco.getProgress();
        int ratingHayTaste = mHay.getProgress();
        int ratingKeroseneTaste = mKerosene.getProgress();
        int ratingButterTaste = mButter.getProgress();
        int ratingToastedbreadTaste = mToastedbread.getProgress();
        int ratingCoffeeTaste = mCoffee.getProgress();
        int ratingVanilaTaste = mVanila.getProgress();
        int ratingPepperTaste = mPepper.getProgress();
        int ratingCinnamonTaste = mCinnamon.getProgress();
        int ratingLicoriceTaste = mLicorice.getProgress();
        int ratingCloveTaste = mClove.getProgress();
        int ratingCoconutTaste = mCoconut.getProgress();
        int ratingHazelnutTaste = mHazelnut.getProgress();
        int ratingAlmondTaste = mAlmond.getProgress();
        int ratingOakTaste = mOak.getProgress();
        int ratingOrangepeelTaste = mOrangepeel.getProgress();
        int ratingDriedapricotTaste = mDriedapricot.getProgress();
        int ratingPruneTaste = mPrune.getProgress();
        int ratingHoneyTaste = mHoney.getProgress();
        int ratingChocolateTaste = mChocolate.getProgress();
        int ratingLeatherTaste = mLeather.getProgress();
        int ratingMushroomTaste = mMushroom.getProgress();
        int ratingTruffleTaste = mTruffle.getProgress();
        int ratingCorkTaste = mCork.getProgress();
        int ratingHoneysuckleTaste = mHoneysuckle.getProgress();
        int ratingRubberbandTaste = mRubberband.getProgress();
        int ratingEggTaste = mEgg.getProgress();
        int ratingOnionTaste = mOnion.getProgress();
        int ratingCornTaste = mCorn.getProgress();
        int ratingGeraniumTaste = mGeranium.getProgress();
        int ratingAppleblossumTaste = mAppleblossum.getProgress();
        int ratingOrangeblossumTaste = mOrangeblossum.getProgress();
        int ratingVioletTaste = mViolet.getProgress();
        int ratingLavenderTaste = mLavender.getProgress();
        int ratingRoseTaste = mRose.getProgress();
        int ratingCutgrassTaste = mCutgrass.getProgress();
        int ratingRosemaryTaste = mRosemary.getProgress();
        int ratingThymeTaste = mThyme.getProgress();
        int ratingEucalyptusTaste = mEucalyptus.getProgress();
        int ratingFlintTaste = mFlint.getProgress();
        int ratingBreadTaste = mBread.getProgress();
        int ratingCreamTaste = mCream.getProgress();
        int ratingSmokeTaste = mSmoke.getProgress();
        int ratingNutmegTaste = mNutmeg.getProgress();
        int ratingPineTaste = mPine.getProgress();
        int ratingCedarTaste = mCedar.getProgress();
        int ratingFigTaste = mFig.getProgress();
        int ratingFloralTaste = mFloral.getProgress();
        int ratingRaspberryTaste = mRaspberry.getProgress();
        int ratingJamTaste = mJam.getProgress();
        int ratingKiwifruitTaste = mKiwifruit.getProgress();
        int ratingMangoTaste = mMango.getProgress();
        int ratingChiliTaste = mChili.getProgress();
        int ratingPomegranateTaste = mPomegranate.getProgress();
        int ratingWatermelonTaste = mWatermelon.getProgress();
        int ratingSaffronTaste = mSaffron.getProgress();
        int ratingWalnutTaste = mWalnut.getProgress();
        int ratingPeachTaste = mPeach.getProgress();
        int ratingCantelopeTaste = mCantelope.getProgress();
        int ratingBlueberryTaste = mBlueberry.getProgress();
        int ratingCaramelTaste = mCaramel.getProgress();
        int ratingBlueCheeseTaste = mBlueCheese.getProgress();

        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();
        String userName = user.getDisplayName().toString();
        String taster = user.getDisplayName().toString();
        //String taster = "Andrew Marshall".toString();

        if (!mCreateWineName.equals("")) {
            //Write the wine details to the main wine database.
            Firebase wineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS);
            Firebase wineNameFirebaseRef = wineNameRef.push();
            final String winePushID = wineNameFirebaseRef.getKey();
            HashMap<String, Object> timestampCreated = new HashMap<>();
            timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP_CREATED, ServerValue.TIMESTAMP);

            //Building the wine POJO so that it can be added to Firebase.
            WinePojo winePojo = new WinePojo(newWineToAdd, newWineToAddWinery, newWineToAddVintage, newWineToAddVariety, taster, userName, uid, newWineToAddTastingDate, newWineToAddDescription, mCreateNewWineRating.getRating(), timestampCreated);
            // Go to the "WineListName" child node of the root node.  This will create the node for you if it doesn't already exist.
            // Then using the setValue menu it will set value the node to WineName.
            //wineNameFirebaseRef.setValue(winePojo);

            Firebase wineSummaryFirebaseRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(winePushID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);
            wineSummaryFirebaseRef.setValue(winePojo);


            //this will attempt to write the tasting profile to the database
            WineTastePojo wineTastePojo = new WineTastePojo(ratingGrapefruitTaste, ratingLemonTaste, ratingLimeTaste,
                    ratingOrangeTaste, ratingPearTaste, ratingAppleTaste, ratingGrannysmithTaste, ratingApricotTaste, ratingMelonTaste,
                    ratingGuavaTaste, ratingBananaTaste, ratingPineappleTaste, ratingPassionfruitTaste, ratingLycheeTaste, ratingRedcurrantTaste,
                    ratingBlackcurrantTaste, ratingStrawberryTaste, ratingBlackberryTaste, ratingCherryTaste, ratingPlumTaste,
                    ratingGreenpepperTaste, ratingTomatoTaste, ratingMintTaste, ratingTobaccoTaste, ratingHayTaste, ratingKeroseneTaste,
                    ratingButterTaste, ratingToastedbreadTaste, ratingCoffeeTaste, ratingVanilaTaste, ratingPepperTaste, ratingCinnamonTaste,
                    ratingLicoriceTaste, ratingCloveTaste, ratingCoconutTaste, ratingHazelnutTaste, ratingAlmondTaste, ratingOakTaste,
                    ratingOrangepeelTaste, ratingDriedapricotTaste, ratingPruneTaste, ratingHoneyTaste, ratingChocolateTaste,
                    ratingLeatherTaste, ratingMushroomTaste, ratingTruffleTaste, ratingCorkTaste, ratingRubberbandTaste, ratingEggTaste,
                    ratingOnionTaste, ratingCornTaste, ratingHoneysuckleTaste, ratingGeraniumTaste, ratingAppleblossumTaste, ratingOrangeblossumTaste, ratingVioletTaste, ratingLavenderTaste, ratingRoseTaste,
                    ratingCutgrassTaste, ratingRosemaryTaste, ratingThymeTaste, ratingEucalyptusTaste, ratingFlintTaste, ratingBreadTaste,
                    ratingCreamTaste, ratingSmokeTaste, ratingNutmegTaste, ratingPineTaste, ratingCedarTaste, ratingFigTaste, ratingFloralTaste,
                    ratingRaspberryTaste, ratingJamTaste, ratingKiwifruitTaste, ratingMangoTaste, ratingChiliTaste,
                    ratingPomegranateTaste, ratingWatermelonTaste, ratingSaffronTaste, ratingWalnutTaste, ratingPeachTaste, ratingCantelopeTaste,
                    ratingBlueberryTaste, ratingCaramelTaste, ratingBlueCheeseTaste);


            Firebase myWineTasteLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(winePushID).child(Constants.FIREBASE_WINE_FLAVOR_DETAILS);
            myWineTasteLocation.setValue(wineTastePojo);


            // then this part of the code will write the details that are needed to be put into the card under the uid.
            //myWineSummary

            Firebase myWinesRefLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_WINES).child(winePushID);
            myWinesRefLocation.setValue(winePojo);


            //This then resets the text to lank.
            mCreateWineName.setText("");
            mCreateWineWinery.setText("");
            mCreateWineVintage.setText("");
            mCreateWineVariety.setText("");
            mCreateWineTastingDate.setText("");
            mCreateWineDescription.setText("");

            //Send the user back the the wine list.  They'll be able to see all the wines they're recently added.
            Intent MyWinesList = new Intent(CreateNewWine.this, com.example.android.cellavino.UserInterface2.WineDetails.MyWinesList.class);
            // Start the new activity
            startActivity(MyWinesList);
        }

    }
}
