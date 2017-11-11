package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.Interfaces.UploadImageInterface;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastePojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastingPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_WINE_FLAVOR_DETAILS;
import static com.example.android.cellavino.Utils.Constants.FIREBASE_WINE_SUMMARY_DETAILS;
import static com.example.android.cellavino.Utils.Constants.TAKE_PICTURE;

/**
 * Created by Andrew on 30/07/2017.
 */

public class CreateNewTasting extends AppCompatActivity {

    public FirebaseAuth mFirebaseAuth;

    public static final int RC_PHOTO_PICKER = 1;

    private String mTastingName;
    private String tastingPushID;
    private TextView mWineName;
    private TextView mWineVintage;
    private TextView mWineVariety;

    public FloatingActionButton mAddTastingWineBottlePictureFab;

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

    public Button mSaveAddNext;
    public Button mSaveFinish;

    public ImageView mWinePicture;
    private Bitmap imageData;
    public Toast mToastMessage;
    public String downloadUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        mTastingName = bundle.getString("thisTastingName");
        tastingPushID = bundle.getString("thisTastingPushID");
        setContentView(R.layout.create_new_tasting);

        setTitle(mTastingName);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mAddTastingWineBottlePictureFab = (FloatingActionButton) findViewById(R.id.addTastingWineBottlePictureFab);
        mWinePicture = (ImageView) findViewById(R.id.wine_photo);

        mWineName = (TextView) findViewById(R.id.create_wine_name);
        mWineVintage = (TextView) findViewById(R.id.create_wine_vintage);
        mWineVariety = (TextView) findViewById(R.id.create_wine_variety);
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

        mSaveFinish = (Button) findViewById(R.id.save_finish);
        mSaveAddNext = (Button) findViewById(R.id.save_add_next);

        //set the click listener on the button that  pushes wine into the database
        mSaveFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWineToTastingDatabaseAndFinish(imageData);
            }
        });

        //set the click listener on the button that  pushes wine into the database
        mSaveAddNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWineToTastingDatabaseAndMore(imageData);
            }
        });

        //TODO this will add the picture of the botle to the tasting.
        mAddTastingWineBottlePictureFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, Constants.TAKE_PICTURE);

                //Toast.makeText(CreateNewTasting.this, "Image Picker working", Toast.LENGTH_SHORT).show();
                //this was the code that got the photopicker to work.

                //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //intent.setType("image/jpeg");
                //intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                //startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Grapefruit: " + grapefruitValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Lemon: " + lemonValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Lime: " + limeValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Orange: " + orangeValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Pear: " + pearValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Apple: " + appleValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Grannysmith: " + grannysmithValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Apricot: " + apricotValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Melon: " + melonValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Guava: " + guavaValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Banana: " + bananaValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Pineapple: " + pineappleValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Passionfruit: " + passionfruitValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Lychee: " + lycheeValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Redcurrant: " + redcurrantValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Blackcurrant: " + blackcurrantValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Strawberry: " + strawberryValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Blackberry: " + blackberryValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Cherry: " + cherryValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Plum: " + plumValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Green Pepper: " + greenpepperValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Tomato: " + tomatoValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Mint: " + mintValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Tobacco: " + tobaccoValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Hay: " + hayValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Kerosene: " + keroseneValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Butter: " + butterValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Toasted Bread: " + toastedbreadValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Blackberry: " + coffeeValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Vanila: " + vanilaValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Pepper: " + pepperValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Cinnamon: " + cinnanmonValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Licorice: " + licoriceValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Clove: " + cloveValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Coconut: " + coconutValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Hazelnut: " + hazelnutValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Almond: " + almondValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Oak: " + oakValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Orange peel: " + orangepeelValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Dried Apricot: " + driedapricotValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Prune: " + pruneValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Honey: " + honeyValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Chocolate: " + chocolateValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Leather: " + leatherValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Mushroom: " + mushroomValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Truffle: " + truffleValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Cork: " + corkValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Rubberband: " + rubberbandValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Egg: " + eggValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Onion: " + onionValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Corn: " + cornValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Honeysuckle: " + honeysuckleValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Geranium: " + geraniumValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Appleblossum: " + appleblossumValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Orangeblossum: " + orangeblossumValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Violet: " + violetValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Lavender: " + lavenderValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Rose: " + roseValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Cutgrass: " + cutgrassValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Rosemary: " + rosemaryValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Thyme: " + thymeValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Eucalyptus: " + eucalyptusValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Flint: " + flintValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Bread: " + breadValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Cream: " + creamValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Smoke: " + smokeValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Nutmeg: " + nutmegValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Pine: " + pineValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Cedar: " + cedarValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Fig: " + figValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Floral: " + floralValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Raspberry: " + raspberryValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Jam: " + jamValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Corn: " + cornValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Mango: " + mangoValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Chili: " + chiliValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Pomegranate: " + pomegranateValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Watermelon: " + watermelonValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Saffron: " + saffronValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Walnut: " + walnutValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Peach: " + peachValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Cantelope: " + cantelopeValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Blueberry: " + blueberryValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "Caramel: " + caramelValue, Toast.LENGTH_SHORT);
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
                mToastMessage = Toast.makeText(CreateNewTasting.this, "BlueCheese: " + bluecheeseValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (
            //this needs to be changed to the image picker
                requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK) {


        }
        if (requestCode == Constants.TAKE_PICTURE && resultCode == RESULT_OK) {
            imageData = (Bitmap) data.getExtras().get("data");
            mWinePicture.setImageBitmap(imageData);
            mWinePicture.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(CreateNewTasting.this, "Not working!", Toast.LENGTH_SHORT).show();

        }
    }

    ;

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {

        ParcelFileDescriptor parcelFileDescriptor = getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();

        return image;
    }

    ;


    public void addWineToTastingDatabaseAndMore(Bitmap bitmap) {

        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();
        String userName = user.getDisplayName().toString();
        String taster = user.getDisplayName().toString();

        final int ratingGrapefruitTaste = mGrapefuit.getProgress();
        final int ratingLemonTaste = mLemon.getProgress();
        final int ratingLimeTaste = mLime.getProgress();
        final int ratingOrangeTaste = mOrange.getProgress();
        final int ratingPearTaste = mPear.getProgress();
        final int ratingAppleTaste = mApple.getProgress();
        final int ratingGrannysmithTaste = mGrannysmith.getProgress();
        final int ratingApricotTaste = mApricot.getProgress();
        final int ratingMelonTaste = mMelon.getProgress();
        final int ratingGuavaTaste = mGuava.getProgress();
        final int ratingBananaTaste = mBanana.getProgress();
        final int ratingPineappleTaste = mPineapple.getProgress();
        final int ratingPassionfruitTaste = mPassionfruit.getProgress();
        final int ratingLycheeTaste = mLychee.getProgress();
        final int ratingRedcurrantTaste = mRedcurrant.getProgress();
        final int ratingBlackcurrantTaste = mBlackcurrant.getProgress();
        final int ratingStrawberryTaste = mStrawberry.getProgress();
        final int ratingBlackberryTaste = mBlackberry.getProgress();
        final int ratingCherryTaste = mCherry.getProgress();
        final int ratingPlumTaste = mPlum.getProgress();
        final int ratingGreenpepperTaste = mGreenpepper.getProgress();
        final int ratingTomatoTaste = mTomato.getProgress();
        final int ratingMintTaste = mMint.getProgress();
        final int ratingTobaccoTaste = mTobacco.getProgress();
        final int ratingHayTaste = mHay.getProgress();
        final int ratingKeroseneTaste = mKerosene.getProgress();
        final int ratingButterTaste = mButter.getProgress();
        final int ratingToastedbreadTaste = mToastedbread.getProgress();
        final int ratingCoffeeTaste = mCoffee.getProgress();
        final int ratingVanilaTaste = mVanila.getProgress();
        final int ratingPepperTaste = mPepper.getProgress();
        final int ratingCinnamonTaste = mCinnamon.getProgress();
        final int ratingLicoriceTaste = mLicorice.getProgress();
        final int ratingCloveTaste = mClove.getProgress();
        final int ratingCoconutTaste = mCoconut.getProgress();
        final int ratingHazelnutTaste = mHazelnut.getProgress();
        final int ratingAlmondTaste = mAlmond.getProgress();
        final int ratingOakTaste = mOak.getProgress();
        final int ratingOrangepeelTaste = mOrangepeel.getProgress();
        final int ratingDriedapricotTaste = mDriedapricot.getProgress();
        final int ratingPruneTaste = mPrune.getProgress();
        final int ratingHoneyTaste = mHoney.getProgress();
        final int ratingChocolateTaste = mChocolate.getProgress();
        final int ratingLeatherTaste = mLeather.getProgress();
        final int ratingMushroomTaste = mMushroom.getProgress();
        final int ratingTruffleTaste = mTruffle.getProgress();
        final int ratingCorkTaste = mCork.getProgress();
        final int ratingHoneysuckleTaste = mHoneysuckle.getProgress();
        final int ratingRubberbandTaste = mRubberband.getProgress();
        final int ratingEggTaste = mEgg.getProgress();
        final int ratingOnionTaste = mOnion.getProgress();
        final int ratingCornTaste = mCorn.getProgress();
        final int ratingGeraniumTaste = mGeranium.getProgress();
        final int ratingAppleblossumTaste = mAppleblossum.getProgress();
        final int ratingOrangeblossumTaste = mOrangeblossum.getProgress();
        final int ratingVioletTaste = mViolet.getProgress();
        final int ratingLavenderTaste = mLavender.getProgress();
        final int ratingRoseTaste = mRose.getProgress();
        final int ratingCutgrassTaste = mCutgrass.getProgress();
        final int ratingRosemaryTaste = mRosemary.getProgress();
        final int ratingThymeTaste = mThyme.getProgress();
        final int ratingEucalyptusTaste = mEucalyptus.getProgress();
        final int ratingFlintTaste = mFlint.getProgress();
        final int ratingBreadTaste = mBread.getProgress();
        final int ratingCreamTaste = mCream.getProgress();
        final int ratingSmokeTaste = mSmoke.getProgress();
        final int ratingNutmegTaste = mNutmeg.getProgress();
        final int ratingPineTaste = mPine.getProgress();
        final int ratingCedarTaste = mCedar.getProgress();
        final int ratingFigTaste = mFig.getProgress();
        final int ratingFloralTaste = mFloral.getProgress();
        final int ratingRaspberryTaste = mRaspberry.getProgress();
        final int ratingJamTaste = mJam.getProgress();
        final int ratingKiwifruitTaste = mKiwifruit.getProgress();
        final int ratingMangoTaste = mMango.getProgress();
        final int ratingChiliTaste = mChili.getProgress();
        final int ratingPomegranateTaste = mPomegranate.getProgress();
        final int ratingWatermelonTaste = mWatermelon.getProgress();
        final int ratingSaffronTaste = mSaffron.getProgress();
        final int ratingWalnutTaste = mWalnut.getProgress();
        final int ratingPeachTaste = mPeach.getProgress();
        final int ratingCantelopeTaste = mCantelope.getProgress();
        final int ratingBlueberryTaste = mBlueberry.getProgress();
        final int ratingCaramelTaste = mCaramel.getProgress();
        final int ratingBlueCheeseTaste = mBlueCheese.getProgress();

        final String mWineNameText = mWineName.getText().toString();
        final String mWineVintageText = mWineVintage.getText().toString();
        final String mWineVarietyText = mWineVariety.getText().toString();
        //TODO: Replace with actual wineImageUrl

        if (mWineNameText.isEmpty()) {
            Toast.makeText(CreateNewTasting.this, "Wine Name Required", Toast.LENGTH_SHORT).show();

        } else {

            Firebase wineTastingBottleRef = new Firebase(Constants.FIREBASE_URL_TASTINGS).child(tastingPushID);
            Firebase wineTastingBottleFirebaseRefPushId = wineTastingBottleRef.push();
            final String wineTastingBottleRefPushId = wineTastingBottleFirebaseRefPushId.getKey();


            uploadFile(bitmap, wineTastingBottleRefPushId, new UploadImageInterface() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot snapshot) {

                    Uri downloadUrl = snapshot.getDownloadUrl();
                    Log.d("downloadUrl-->", "" + downloadUrl);

                    Toast.makeText(CreateNewTasting.this, "downloadUrl: " + downloadUrl, Toast.LENGTH_SHORT).show();

                    //TODO: Set the URL into the tasting summary
                    String wineImageUrl = downloadUrl.toString();


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

                    WineTastingPojo wineTastingPojo = new WineTastingPojo(mWineNameText, mWineVintageText, mWineVarietyText, wineImageUrl);


                    //Firebase myTastingsLocationSummary = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(FIREBASE_MY_TASTINGS).child(tastingPushID).child(wineTastingBottleRefPushId);
                    //myTastingsLocationSummary.setValue(wineTastingPojo);

                    Firebase myTastingsLocationFlavour = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(wineTastingBottleRefPushId).child(FIREBASE_WINE_FLAVOR_DETAILS);
                    Firebase myTastingsLocationDetails = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(wineTastingBottleRefPushId).child(FIREBASE_WINE_SUMMARY_DETAILS);
                    myTastingsLocationFlavour.setValue(wineTastePojo);
                    myTastingsLocationDetails.setValue(wineTastingPojo);
                    Firebase myTastingsSummaryRef = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(tastingPushID).child(wineTastingBottleRefPushId);
                    myTastingsSummaryRef.setValue(wineTastingPojo);

                }

                @Override
                public void onFailure(@NonNull Exception exception) {

                }
            });


            mWineName.setText("");

            mGrapefuit.setProgress(0);
            mLemon.setProgress(0);
            mLime.setProgress(0);
            mOrange.setProgress(0);
            mPear.setProgress(0);
            mApple.setProgress(0);
            mGrannysmith.setProgress(0);
            mApricot.setProgress(0);
            mMelon.setProgress(0);
            mGuava.setProgress(0);
            mBanana.setProgress(0);
            mPineapple.setProgress(0);
            mPassionfruit.setProgress(0);
            mLychee.setProgress(0);
            mRedcurrant.setProgress(0);
            mBlackcurrant.setProgress(0);
            mStrawberry.setProgress(0);
            mBlackberry.setProgress(0);
            mCherry.setProgress(0);
            mPlum.setProgress(0);
            mGreenpepper.setProgress(0);
            mTomato.setProgress(0);
            mMint.setProgress(0);
            mTobacco.setProgress(0);
            mHay.setProgress(0);
            mKerosene.setProgress(0);
            mButter.setProgress(0);
            mToastedbread.setProgress(0);
            mCoffee.setProgress(0);
            mVanila.setProgress(0);
            mPepper.setProgress(0);
            mCinnamon.setProgress(0);
            mLicorice.setProgress(0);
            mClove.setProgress(0);
            mCoconut.setProgress(0);
            mHazelnut.setProgress(0);
            mAlmond.setProgress(0);
            mOak.setProgress(0);
            mOrangepeel.setProgress(0);
            mDriedapricot.setProgress(0);
            mPrune.setProgress(0);
            mHoney.setProgress(0);
            mChocolate.setProgress(0);
            mLeather.setProgress(0);
            mMushroom.setProgress(0);
            mTruffle.setProgress(0);
            mCork.setProgress(0);
            mRubberband.setProgress(0);
            mEgg.setProgress(0);
            mOnion.setProgress(0);
            mCorn.setProgress(0);
            mHoneysuckle.setProgress(0);
            mGeranium.setProgress(0);
            mAppleblossum.setProgress(0);
            mOrangeblossum.setProgress(0);
            mViolet.setProgress(0);
            mLavender.setProgress(0);
            mRose.setProgress(0);
            mCutgrass.setProgress(0);
            mRosemary.setProgress(0);
            mThyme.setProgress(0);
            mEucalyptus.setProgress(0);
            mFlint.setProgress(0);
            mBread.setProgress(0);
            mCream.setProgress(0);
            mSmoke.setProgress(0);
            mNutmeg.setProgress(0);
            mPine.setProgress(0);
            mCedar.setProgress(0);
            mFig.setProgress(0);
            mFloral.setProgress(0);
            mRaspberry.setProgress(0);
            mJam.setProgress(0);
            mKiwifruit.setProgress(0);
            mMango.setProgress(0);
            mChili.setProgress(0);
            mPomegranate.setProgress(0);
            mWatermelon.setProgress(0);
            mSaffron.setProgress(0);
            mWalnut.setProgress(0);
            mPeach.setProgress(0);
            mCantelope.setProgress(0);
            mBlueberry.setProgress(0);
            mCaramel.setProgress(0);
            mBlueCheese.setProgress(0);

            mWinePicture.setVisibility(View.GONE);

        }

        return;

    }

    ;

    public void addWineToTastingDatabaseAndFinish(Bitmap bitmap) {
        Toast.makeText(CreateNewTasting.this, "Save Finish", Toast.LENGTH_SHORT).show();

        mFirebaseAuth = FirebaseAuth.getInstance();


        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();
        String userName = user.getDisplayName().toString();
        String taster = user.getDisplayName().toString();

        final int ratingGrapefruitTaste = mGrapefuit.getProgress();
        final int ratingLemonTaste = mLemon.getProgress();
        final int ratingLimeTaste = mLime.getProgress();
        final int ratingOrangeTaste = mOrange.getProgress();
        final int ratingPearTaste = mPear.getProgress();
        final int ratingAppleTaste = mApple.getProgress();
        final int ratingGrannysmithTaste = mGrannysmith.getProgress();
        final int ratingApricotTaste = mApricot.getProgress();
        final int ratingMelonTaste = mMelon.getProgress();
        final int ratingGuavaTaste = mGuava.getProgress();
        final int ratingBananaTaste = mBanana.getProgress();
        final int ratingPineappleTaste = mPineapple.getProgress();
        final int ratingPassionfruitTaste = mPassionfruit.getProgress();
        final int ratingLycheeTaste = mLychee.getProgress();
        final int ratingRedcurrantTaste = mRedcurrant.getProgress();
        final int ratingBlackcurrantTaste = mBlackcurrant.getProgress();
        final int ratingStrawberryTaste = mStrawberry.getProgress();
        final int ratingBlackberryTaste = mBlackberry.getProgress();
        final int ratingCherryTaste = mCherry.getProgress();
        final int ratingPlumTaste = mPlum.getProgress();
        final int ratingGreenpepperTaste = mGreenpepper.getProgress();
        final int ratingTomatoTaste = mTomato.getProgress();
        final int ratingMintTaste = mMint.getProgress();
        final int ratingTobaccoTaste = mTobacco.getProgress();
        final int ratingHayTaste = mHay.getProgress();
        final int ratingKeroseneTaste = mKerosene.getProgress();
        final int ratingButterTaste = mButter.getProgress();
        final int ratingToastedbreadTaste = mToastedbread.getProgress();
        final int ratingCoffeeTaste = mCoffee.getProgress();
        final int ratingVanilaTaste = mVanila.getProgress();
        final int ratingPepperTaste = mPepper.getProgress();
        final int ratingCinnamonTaste = mCinnamon.getProgress();
        final int ratingLicoriceTaste = mLicorice.getProgress();
        final int ratingCloveTaste = mClove.getProgress();
        final int ratingCoconutTaste = mCoconut.getProgress();
        final int ratingHazelnutTaste = mHazelnut.getProgress();
        final int ratingAlmondTaste = mAlmond.getProgress();
        final int ratingOakTaste = mOak.getProgress();
        final int ratingOrangepeelTaste = mOrangepeel.getProgress();
        final int ratingDriedapricotTaste = mDriedapricot.getProgress();
        final int ratingPruneTaste = mPrune.getProgress();
        final int ratingHoneyTaste = mHoney.getProgress();
        final int ratingChocolateTaste = mChocolate.getProgress();
        final int ratingLeatherTaste = mLeather.getProgress();
        final int ratingMushroomTaste = mMushroom.getProgress();
        final int ratingTruffleTaste = mTruffle.getProgress();
        final int ratingCorkTaste = mCork.getProgress();
        final int ratingHoneysuckleTaste = mHoneysuckle.getProgress();
        final int ratingRubberbandTaste = mRubberband.getProgress();
        final int ratingEggTaste = mEgg.getProgress();
        final int ratingOnionTaste = mOnion.getProgress();
        final int ratingCornTaste = mCorn.getProgress();
        final int ratingGeraniumTaste = mGeranium.getProgress();
        final int ratingAppleblossumTaste = mAppleblossum.getProgress();
        final int ratingOrangeblossumTaste = mOrangeblossum.getProgress();
        final int ratingVioletTaste = mViolet.getProgress();
        final int ratingLavenderTaste = mLavender.getProgress();
        final int ratingRoseTaste = mRose.getProgress();
        final int ratingCutgrassTaste = mCutgrass.getProgress();
        final int ratingRosemaryTaste = mRosemary.getProgress();
        final int ratingThymeTaste = mThyme.getProgress();
        final int ratingEucalyptusTaste = mEucalyptus.getProgress();
        final int ratingFlintTaste = mFlint.getProgress();
        final int ratingBreadTaste = mBread.getProgress();
        final int ratingCreamTaste = mCream.getProgress();
        final int ratingSmokeTaste = mSmoke.getProgress();
        final int ratingNutmegTaste = mNutmeg.getProgress();
        final int ratingPineTaste = mPine.getProgress();
        final int ratingCedarTaste = mCedar.getProgress();
        final int ratingFigTaste = mFig.getProgress();
        final int ratingFloralTaste = mFloral.getProgress();
        final int ratingRaspberryTaste = mRaspberry.getProgress();
        final int ratingJamTaste = mJam.getProgress();
        final int ratingKiwifruitTaste = mKiwifruit.getProgress();
        final int ratingMangoTaste = mMango.getProgress();
        final int ratingChiliTaste = mChili.getProgress();
        final int ratingPomegranateTaste = mPomegranate.getProgress();
        final int ratingWatermelonTaste = mWatermelon.getProgress();
        final int ratingSaffronTaste = mSaffron.getProgress();
        final int ratingWalnutTaste = mWalnut.getProgress();
        final int ratingPeachTaste = mPeach.getProgress();
        final int ratingCantelopeTaste = mCantelope.getProgress();
        final int ratingBlueberryTaste = mBlueberry.getProgress();
        final int ratingCaramelTaste = mCaramel.getProgress();
        final int ratingBlueCheeseTaste = mBlueCheese.getProgress();

        final String mWineNameText = mWineName.getText().toString();
        final String mWineVintageText = mWineVintage.getText().toString();
        final String mWineVarietyText = mWineVariety.getText().toString();

        if (mWineNameText.isEmpty()) {
            Toast.makeText(CreateNewTasting.this, "Wine Name Required", Toast.LENGTH_SHORT).show();

        } else {

            Firebase wineTastingBottleRef = new Firebase(Constants.FIREBASE_URL_TASTINGS).child(tastingPushID);
            Firebase wineTastingBottleFirebaseRefPushId = wineTastingBottleRef.push();
            final String wineTastingBottleRefPushId = wineTastingBottleFirebaseRefPushId.getKey();


            uploadFile(bitmap, wineTastingBottleRefPushId, new UploadImageInterface() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot snapshot) {

                    Uri downloadUrl = snapshot.getDownloadUrl();
                    Log.d("downloadUrl-->", "" + downloadUrl);

                    Toast.makeText(CreateNewTasting.this, "downloadUrl: " + downloadUrl, Toast.LENGTH_SHORT).show();

                    String wineImageUrl = downloadUrl.toString();


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
                            ratingOnionTaste, ratingCornTaste, ratingHoneysuckleTaste, ratingGeraniumTaste, ratingAppleblossumTaste, ratingOrangeblossumTaste,
                            ratingVioletTaste, ratingLavenderTaste, ratingRoseTaste,
                            ratingCutgrassTaste, ratingRosemaryTaste, ratingThymeTaste, ratingEucalyptusTaste, ratingFlintTaste, ratingBreadTaste,
                            ratingCreamTaste, ratingSmokeTaste, ratingNutmegTaste, ratingPineTaste, ratingCedarTaste, ratingFigTaste, ratingFloralTaste,
                            ratingRaspberryTaste, ratingJamTaste, ratingKiwifruitTaste, ratingMangoTaste, ratingChiliTaste,
                            ratingPomegranateTaste, ratingWatermelonTaste, ratingSaffronTaste, ratingWalnutTaste, ratingPeachTaste, ratingCantelopeTaste,
                            ratingBlueberryTaste, ratingCaramelTaste, ratingBlueCheeseTaste);

                    WineTastingPojo wineTastingPojo = new WineTastingPojo(mWineNameText, mWineVintageText, mWineVarietyText, wineImageUrl);

                    Firebase myTastingsLocationFlavour = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(wineTastingBottleRefPushId).child(FIREBASE_WINE_FLAVOR_DETAILS);
                    Firebase myTastingsLocationDetails = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(wineTastingBottleRefPushId).child(FIREBASE_WINE_SUMMARY_DETAILS);
                    myTastingsLocationFlavour.setValue(wineTastePojo);
                    myTastingsLocationDetails.setValue(wineTastingPojo);

                    Firebase myTastingsSummaryRef = new Firebase(Constants.FIREBASE_URL_TASTING_WINE_DETAILS).child(tastingPushID).child(wineTastingBottleRefPushId);
                    myTastingsSummaryRef.setValue(wineTastingPojo);

                }

                @Override
                public void onFailure(@NonNull Exception exception) {

                }
            });


            mWineName.setText("");


            //Send the user back the the wine list.  They'll be able to see all the wines they're recently added.
            Intent MyTastings = new Intent(CreateNewTasting.this, com.example.android.cellavino.UserInterface2.CreateTasting.MyTastings.class);
            // Start the new activity
            startActivity(MyTastings);

        }
        return;
    }

    private void uploadFile(Bitmap bitmap, String wineTastingBottleRefPushId, final UploadImageInterface uploadImageInterface) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(Constants.STORAGE_URL);
        StorageReference mountainImagesRef = null;

        try {
            mountainImagesRef = storageRef.child("Wine Photos/" + URLEncoder.encode(wineTastingBottleRefPushId + ".jpg", "UTF-8"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
            byte[] data = baos.toByteArray();

            UploadTask uploadTask = mountainImagesRef.putBytes(data);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                    uploadImageInterface.onFailure(exception);
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    uploadImageInterface.onSuccess(taskSnapshot);
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
