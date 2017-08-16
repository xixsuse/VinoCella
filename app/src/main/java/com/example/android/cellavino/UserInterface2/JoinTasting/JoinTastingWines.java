package com.example.android.cellavino.UserInterface2.JoinTasting;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Andrew on 16/08/2017.
 */

public class JoinTastingWines extends MainActivity {

    public FirebaseAuth mFirebaseAuth;

    public JoinTastingWines() {
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new JoinTastingWinesFragment()).commit();

        FloatingActionButton addWineFab = (FloatingActionButton) findViewById(R.id.addWineFab);
        addWineFab.hide();


    }


}
