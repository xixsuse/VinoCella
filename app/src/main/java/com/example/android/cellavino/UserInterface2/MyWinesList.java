package com.example.android.cellavino.UserInterface2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.UserDetailsPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.DataSnapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * Created by Andrew on 7/05/2017.
 * This is creating the WineList which contains a container where we initialise the MyWineListFragment which will then display all the wines.
 */

public class MyWinesList extends AppCompatActivity {

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


        //FirebaseUser user = mFirebaseAuth.getCurrentUser();
        //String uid = user.getUid();
        //mUserRef = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid);


        /*

        mUserRefListener = mUserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                UserDetailsPojo name = snapshot.getValue(UserDetailsPojo.class);
                // Set the activity title to current user name if user is not null
                if (name != null) {
                    // Assumes that the first word in the user's name is the user's first name.
                    String firstName = name.getName().split("\\s+")[0];
                    String title = firstName + "'s Wines";
                    setTitle(title);
                } else {
                    Toast.makeText(MyWinesList.this, "Hmm...that didn't work", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(LOG_TAG, getString(R.string.log_error_the_read_failed) + firebaseError.getMessage());

            }
        });

        */
    }


}
