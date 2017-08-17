package com.example.android.cellavino.UserInterface2.WineDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.R;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;


/**
 * Created by Andrew on 7/05/2017.
 * This is creating the WineList which contains a container where we initialise the MyWineListFragment which will then display all the wines.
 */

public class MyWinesList extends MainActivity {

    private ValueEventListener mUserRefListener;
    private Firebase mUserRef;
    private FirebaseAuth mFirebaseAuth;
    private static final String LOG_TAG = MyWinesList.class.getSimpleName();

    public MyWinesList() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyWinesListFragment()).commit();

        //initialise the Floating Action Button in this fragment.
        FloatingActionButton addWineFab = (FloatingActionButton) findViewById(R.id.addWineFab);
        addWineFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyWinesList.this, CreateNewWine.class);
                startActivity(intent);
            }
        });

    }
}
