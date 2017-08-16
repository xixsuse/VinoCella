package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.os.Bundle;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.R;

/**
 * Created by Andrew on 10/08/2017.
 */

public class TastingWines extends MainActivity {

    public TastingWines() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new TastingWinesFragment()).commit();


    }
}
