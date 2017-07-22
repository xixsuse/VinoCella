package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

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


        //initialise the Floating Action Button in this fragment.
        FloatingActionButton addWineFab = (FloatingActionButton) findViewById(R.id.addWineFab);
        addWineFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateTasting.this, NewTasting.class);
                startActivity(intent);
            }
        });
    }


}

