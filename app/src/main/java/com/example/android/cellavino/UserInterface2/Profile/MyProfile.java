package com.example.android.cellavino.UserInterface2.Profile;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.PojoDirectory.UI2.PublicUserDetailsPojo;
import com.example.android.cellavino.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_URL_LOCATION_USERS;
import static com.example.android.cellavino.Utils.Constants.PUBLIC;

/**
 * Created by Andrew on 15/07/2017.
 */

public class MyProfile extends MainActivity {

    public String uid;
    public ValueEventListener mTotalPointsListener;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);
        CardView editPersonalDetailsCard = (CardView) findViewById(R.id.edit_personal_details_card);
        Button updatePersonalDetails = (Button) findViewById(R.id.update_personal_details_button);
        editPersonalDetailsCard.setVisibility(View.GONE);
        updatePersonalDetails.setVisibility(View.GONE);
        setTitle(getString(R.string.myProfile));

        mFirebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String userName = user.getDisplayName();
        TextView userNameText = (TextView) findViewById(R.id.user_name);
        userNameText.setText(userName);
        String uid = user.getUid();


        Firebase mTotalUserPoints = new Firebase(FIREBASE_URL_LOCATION_USERS).child(uid).child(PUBLIC);

        mTotalPointsListener = mTotalUserPoints.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PublicUserDetailsPojo publicUserDetailsPojo = dataSnapshot.getValue(PublicUserDetailsPojo.class);
                if (publicUserDetailsPojo == null) {
                    //TODO: Error Toast
                }
                if (publicUserDetailsPojo != null) {
                    int mTotalUserPoints = publicUserDetailsPojo.getTastingPoints();
                    int mPreviousTastingPoints = publicUserDetailsPojo.getMostRecentTastingPoints();
                    int mTotalWinesTasted = publicUserDetailsPojo.getTotalWinesTasted();
                    TextView totalUserPoints = (TextView) findViewById(R.id.total_user_points);
                    totalUserPoints.setText(Integer.toString(mTotalUserPoints));
                    TextView previousTastingScore = (TextView) findViewById(R.id.user_previous_tasting_score);
                    previousTastingScore.setText(Integer.toString(mPreviousTastingPoints));
                    //TextView previousTastingScore = (TextView) findViewById(R.id.user_tasting_level);
                    //previousTastingSc
                    TextView totalWinesTasted = (TextView) findViewById(R.id.user_total_wines_tasted);
                    totalWinesTasted.setText(Integer.toString(mTotalWinesTasted));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.edit_profile:
                editProfile();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void editProfile() {
        Toast.makeText(MyProfile.this, "This can't be done just yet as Andrew " +
                "hasn't written the code", Toast.LENGTH_SHORT).show();
    }
}
