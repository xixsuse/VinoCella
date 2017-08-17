package com.example.android.cellavino.UserInterface2.JoinTasting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface2.CreateTasting.CreateNewTasting;
import com.example.android.cellavino.Utils.Constants;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Andrew on 17/08/2017.
 */

public class TastingWineInput extends AppCompatActivity {

    public FirebaseAuth mFirebaseAuth;

    public SeekBar mGrapefuitInput;

    private Toast mToastMessage;

    private String mTastingWineInput;
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

        //Initialise the views.
        mGrapefuitInput = (SeekBar) findViewById(R.id.seekBar_grapefruit);

        mGrapefuitInput.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
                mToastMessage = Toast.makeText(TastingWineInput.this, "Grapefruit: " + grapefruitValue, Toast.LENGTH_SHORT);
                mToastMessage.show();
            }
        });


        /*
        //TODO: Get a DataSnapshot and then use the WineTastPojo to grab the flavors and work them through the code;
                mGrapefuit.setProgress(wineTastePojo.getmGrapefruitTaste());

                mGrapefuit = wineTastePojo.getmGrapefruitTaste();

         */


    }

}
