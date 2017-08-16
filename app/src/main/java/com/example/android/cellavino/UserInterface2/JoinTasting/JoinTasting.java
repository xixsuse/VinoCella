package com.example.android.cellavino.UserInterface2.JoinTasting;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface2.CreateTasting.MyTastingsFragment;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Andrew on 13/08/2017.
 */

public class JoinTasting extends MainActivity {

    public FirebaseAuth mFirebaseAuth;

    public JoinTasting() {
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new JoinTastingFragment()).commit();

        FloatingActionButton addWineFab = (FloatingActionButton) findViewById(R.id.addWineFab);
        addWineFab.hide();


    }


}
