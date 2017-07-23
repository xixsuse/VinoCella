package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.R;

/**
 * Created by Andrew on 15/07/2017.
 */


public class CreateTasting extends MainActivity {

    private Button mCreateTastingButton;

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
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(CreateTasting.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_create_tasting, null);
                final EditText mTastingNameInput = (EditText) mView.findViewById(R.id.dialog_create_tasting_name_input);
                Button mCreateTastingButton = (Button) findViewById(R.id.create_tasting_name_button);

                /*
                mCreateTastingButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!mTastingNameInput.getText().toString().isEmpty()) {
                            Toast.makeText(CreateTasting.this, "Field Complete", Toast.LENGTH_SHORT).show();
                        } if (mTastingNameInput.getText().toString().isEmpty()) {
                            Toast.makeText(CreateTasting.this, "Field Empty", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                */

                alertDialogBuilder.setView(mView);
                AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();

            }

        });
    }


}

