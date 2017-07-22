package com.example.android.cellavino.UserInterface2.AromaPager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface2.AromaPager.FruitFragment;

/**
 * Created by Andrew on 18/07/2017.
 */

public class WoodyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_wine);
        getSupportFragmentManager().beginTransaction().replace(R.id.flavour_container, new FruitFragment()).commit();


    }

}