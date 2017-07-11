package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.media.Rating;
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
import com.example.android.cellavino.UserInterface.AddWine;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.ServerValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_LOCATION_USERS;

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

    public FirebaseAuth mFirebaseAuth;

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
        setContentView(R.layout.create_new_wine);

        mFirebaseAuth = FirebaseAuth.getInstance();

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


        mCreateWineName = (TextView) findViewById(R.id.create_wine_name);
        mCreateWineWinery = (TextView) findViewById(R.id.create_wine_winery);
        mCreateWineVariety = (TextView) findViewById(R.id.create_wine_variety);
        mCreateWineTastingDate = (TextView) findViewById(R.id.create_wine_tasting_date);
        mCreateWineDescription = (TextView) findViewById(R.id.create_wine_description);
        mCreateNewWine = (Button) findViewById(R.id.create_new_wine_button);

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
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Grapefruit: " + grapefruitValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mLemon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lemonValue = 0;

            public void onProgressChanged(SeekBar mLemon, int progress, boolean fromUser) {
                lemonValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Lemon: " + lemonValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mLime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int limeValue = 0;

            public void onProgressChanged(SeekBar mLime, int progress, boolean fromUser) {
                limeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Lime: " + limeValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mOrange.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int orangeValue = 0;

            public void onProgressChanged(SeekBar mOrange, int progress, boolean fromUser) {
                orangeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Orange: " + orangeValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mPear.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pearValue = 0;

            public void onProgressChanged(SeekBar mPear, int progress, boolean fromUser) {
                pearValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Pear: " + pearValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mApple.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int appleValue = 0;

            public void onProgressChanged(SeekBar mApple, int progress, boolean fromUser) {
                appleValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Apple: " + appleValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mGrannysmith.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int grannysmithValue = 0;

            public void onProgressChanged(SeekBar mGrannysmith, int progress, boolean fromUser) {
                grannysmithValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Grannysmith: " + grannysmithValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mApricot.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int apricotValue = 0;

            public void onProgressChanged(SeekBar mApricot, int progress, boolean fromUser) {
                apricotValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Apricot: " + apricotValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mMelon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int melonValue = 0;

            public void onProgressChanged(SeekBar mMelon, int progress, boolean fromUser) {
                melonValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Melon: " + melonValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mGuava.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int guavaValue = 0;

            public void onProgressChanged(SeekBar mGuava, int progress, boolean fromUser) {
                guavaValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Guava: " + guavaValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mPineapple.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pineappleValue = 0;

            public void onProgressChanged(SeekBar mPineapple, int progress, boolean fromUser) {
                pineappleValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Pineapple: " + pineappleValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mPassionfruit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int passionfruitValue = 0;

            public void onProgressChanged(SeekBar mPassionfruit, int progress, boolean fromUser) {
                passionfruitValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Passionfruit: " + passionfruitValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mLychee.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lycheeValue = 0;

            public void onProgressChanged(SeekBar mLychee, int progress, boolean fromUser) {
                lycheeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Lychee: " + lycheeValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mRedcurrant.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int redcurrantValue = 0;

            public void onProgressChanged(SeekBar mRedcurrant, int progress, boolean fromUser) {
                redcurrantValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Redcurrant: " + redcurrantValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mBlackcurrant.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int blackcurrantValue = 0;

            public void onProgressChanged(SeekBar mBlackcurrant, int progress, boolean fromUser) {
                blackcurrantValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Blackcurrant: " + blackcurrantValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mStrawberry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int strawberryValue = 0;

            public void onProgressChanged(SeekBar mStrawberry, int progress, boolean fromUser) {
                strawberryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Strawberry: " + strawberryValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mBlackberry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int blackberryValue = 0;

            public void onProgressChanged(SeekBar mBlackberry, int progress, boolean fromUser) {
                blackberryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Blackberry: " + blackberryValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCherry.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cherryValue = 0;

            public void onProgressChanged(SeekBar mCherry, int progress, boolean fromUser) {
                cherryValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Cherry: " + cherryValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mPlum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int plumValue = 0;

            public void onProgressChanged(SeekBar mPlum, int progress, boolean fromUser) {
                plumValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Plum: " + plumValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mGreenpepper.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int greenpepperValue = 0;

            public void onProgressChanged(SeekBar mGreenpepper, int progress, boolean fromUser) {
                greenpepperValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Green Pepper: " + greenpepperValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mTomato.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int tomatoValue = 0;

            public void onProgressChanged(SeekBar mTomato, int progress, boolean fromUser) {
                tomatoValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Tomato: " + tomatoValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mMint.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mintValue = 0;

            public void onProgressChanged(SeekBar mMint, int progress, boolean fromUser) {
                mintValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Mint: " + mintValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mTobacco.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int tobaccoValue = 0;

            public void onProgressChanged(SeekBar mTobacco, int progress, boolean fromUser) {
                tobaccoValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Tobacco: " + tobaccoValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mHay.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int hayValue = 0;

            public void onProgressChanged(SeekBar mHay, int progress, boolean fromUser) {
                hayValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Hay: " + hayValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mKerosene.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int keroseneValue = 0;

            public void onProgressChanged(SeekBar mKerosene, int progress, boolean fromUser) {
                keroseneValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Kerosene: " + keroseneValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mButter.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int butterValue = 0;

            public void onProgressChanged(SeekBar mButter, int progress, boolean fromUser) {
                butterValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Butter: " + butterValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mToastedbread.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int toastedbreadValue = 0;

            public void onProgressChanged(SeekBar mToastedbread, int progress, boolean fromUser) {
                toastedbreadValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Toasted Bread: " + toastedbreadValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCoffee.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int coffeeValue = 0;

            public void onProgressChanged(SeekBar mCoffee, int progress, boolean fromUser) {
                coffeeValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Blackberry: " + coffeeValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mVanila.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int vanilaValue = 0;

            public void onProgressChanged(SeekBar mVanila, int progress, boolean fromUser) {
                vanilaValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Vanila: " + vanilaValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mPepper.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pepperValue = 0;

            public void onProgressChanged(SeekBar mPepper, int progress, boolean fromUser) {
                pepperValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Pepper: " + pepperValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCinnamon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cinnanmonValue = 0;

            public void onProgressChanged(SeekBar mCinnamon, int progress, boolean fromUser) {
                cinnanmonValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Cinnamon: " + cinnanmonValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mLicorice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int licoriceValue = 0;

            public void onProgressChanged(SeekBar mLicorice, int progress, boolean fromUser) {
                licoriceValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Licorice: " + licoriceValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mClove.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cloveValue = 0;

            public void onProgressChanged(SeekBar mClove, int progress, boolean fromUser) {
                cloveValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Clove: " + cloveValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCoconut.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int coconutValue = 0;

            public void onProgressChanged(SeekBar mCoconut, int progress, boolean fromUser) {
                coconutValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Coconut: " + coconutValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mHazelnut.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int hazelnutValue = 0;

            public void onProgressChanged(SeekBar mHazelnut, int progress, boolean fromUser) {
                hazelnutValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Hazelnut: " + hazelnutValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mAlmond.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int almondValue = 0;

            public void onProgressChanged(SeekBar mAlmond, int progress, boolean fromUser) {
                almondValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Almond: " + almondValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mOak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int oakValue = 0;

            public void onProgressChanged(SeekBar mOak, int progress, boolean fromUser) {
                oakValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Oak: " + oakValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mOrangepeel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int orangepeelValue = 0;

            public void onProgressChanged(SeekBar mOrangepeel, int progress, boolean fromUser) {
                orangepeelValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Orange peel: " + orangepeelValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mDriedapricot.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int driedapricotValue = 0;

            public void onProgressChanged(SeekBar mDriedapricot, int progress, boolean fromUser) {
                driedapricotValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Dried Apricot: " + driedapricotValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mPrune.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pruneValue = 0;

            public void onProgressChanged(SeekBar mPrune, int progress, boolean fromUser) {
                pruneValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Prune: " + pruneValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mHoney.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int honeyValue = 0;

            public void onProgressChanged(SeekBar mHoney, int progress, boolean fromUser) {
                honeyValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Honey: " + honeyValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mChocolate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int chocolateValue = 0;

            public void onProgressChanged(SeekBar mChocolate, int progress, boolean fromUser) {
                chocolateValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Chocolate: " + chocolateValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mLeather.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int leatherValue = 0;

            public void onProgressChanged(SeekBar mLeather, int progress, boolean fromUser) {
                leatherValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Leather: " + leatherValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mMushroom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int mushroomValue = 0;

            public void onProgressChanged(SeekBar mMushroom, int progress, boolean fromUser) {
                mushroomValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Mushroom: " + mushroomValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mTruffle.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int truffleValue = 0;

            public void onProgressChanged(SeekBar mTruffle, int progress, boolean fromUser) {
                truffleValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Truffle: " + truffleValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCork.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int corkValue = 0;

            public void onProgressChanged(SeekBar mCork, int progress, boolean fromUser) {
                corkValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Cork: " + corkValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mRubberband.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int rubberbandValue = 0;

            public void onProgressChanged(SeekBar mRubberband, int progress, boolean fromUser) {
                rubberbandValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Rubberband: " + rubberbandValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mEgg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int eggValue = 0;

            public void onProgressChanged(SeekBar mEgg, int progress, boolean fromUser) {
                eggValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Egg: " + eggValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mOnion.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int onionValue = 0;

            public void onProgressChanged(SeekBar mOnion, int progress, boolean fromUser) {
                onionValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Onion: " + onionValue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        mCorn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int cornValue = 0;

            public void onProgressChanged(SeekBar mCorn, int progress, boolean fromUser) {
                cornValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(CreateNewWine.this, "Corn: " + cornValue,
                        Toast.LENGTH_SHORT).show();
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
        int ratingRubberbandTaste = mRubberband.getProgress();
        int ratingEggTaste = mEgg.getProgress();
        int ratingOnionTaste = mOnion.getProgress();
        int ratingCornTaste = mCorn.getProgress();

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
            WinePojo winePojo = new WinePojo(newWineToAdd, newWineToAddWinery, newWineToAddVintage, newWineToAddVariety, taster, userName, uid, newWineToAddTastingDate, newWineToAddDescription, timestampCreated);
            // Go to the "WineListName" child node of the root node.  This will create the node for you if it doesn't already exist.
            // Then using the setValue menu it will set value the node to WineName.
            //wineNameFirebaseRef.setValue(winePojo);

            Firebase wineSummaryFirebaseRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(winePushID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);
            wineSummaryFirebaseRef.setValue(winePojo);


            //this will attempt to write the tasting profile to the database
            WineTastePojo wineTastePojo = new WineTastePojo(ratingGrapefruitTaste, ratingLemonTaste, ratingLimeTaste,

                    ratingOrangeTaste, ratingPearTaste, ratingAppleTaste, ratingGrannysmithTaste, ratingApricotTaste, ratingMelonTaste,
                    ratingGuavaTaste, ratingPineappleTaste, ratingPassionfruitTaste, ratingLycheeTaste, ratingRedcurrantTaste,
                    ratingBlackcurrantTaste, ratingStrawberryTaste, ratingBlackberryTaste, ratingCherryTaste, ratingPlumTaste,
                    ratingGreenpepperTaste, ratingTomatoTaste, ratingMintTaste, ratingTobaccoTaste, ratingHayTaste, ratingKeroseneTaste,
                    ratingButterTaste, ratingToastedbreadTaste, ratingCoffeeTaste, ratingVanilaTaste, ratingPepperTaste, ratingCinnamonTaste,
                    ratingLicoriceTaste, ratingCloveTaste, ratingCoconutTaste, ratingHazelnutTaste, ratingAlmondTaste, ratingOakTaste,
                    ratingOrangepeelTaste, ratingDriedapricotTaste, ratingPruneTaste, ratingHoneyTaste, ratingChocolateTaste,
                    ratingLeatherTaste, ratingMushroomTaste, ratingTruffleTaste, ratingCorkTaste, ratingRubberbandTaste, ratingEggTaste,
                    ratingOnionTaste, ratingCornTaste);
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
            Intent MyWinesList = new Intent(CreateNewWine.this, MyWinesList.class);
            // Start the new activity
            startActivity(MyWinesList);
        }

    }
}
