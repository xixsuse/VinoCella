package com.example.android.cellavino.UserInterface2;

import android.os.Bundle;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.R;

/**
 * Created by Andrew on 15/07/2017.
 */

public class CreateTasting extends MainActivity {

    public CreateTasting() {
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new CreateTastingFragment()).commit();

    }
}

