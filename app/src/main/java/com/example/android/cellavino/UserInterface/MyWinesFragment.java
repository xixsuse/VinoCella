package com.example.android.cellavino.UserInterface;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.util.Util;
import com.example.android.cellavino.PojoDirectory.WinePojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.example.android.cellavino.Utils.Utils;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.realtime.util.StringListReader;

import static com.example.android.cellavino.R.id.wineName;

import java.util.Date;


/**
 * Created by Andrew on 25/04/2017.
 */


public class MyWinesFragment extends AppCompatActivity implements MyWineAdapter.ListItemClickListener {

    private static final int NUM_LIST_ITEMS = 100;
    private MyWineAdapter mMyWineAdapter;
    private RecyclerView mMyWineList;
    private Toast mToast;
    private TextView mTestText;
    private TextView mTestVintage;
    private TextView mTestUser;
    private TextView mTestTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wines_list);

        mMyWineList = (RecyclerView) findViewById(R.id.my_wine_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mMyWineList.setLayoutManager(layoutManager);

        mTestText = (TextView) findViewById(R.id.testText);
        mTestVintage = (TextView) findViewById(R.id.testVintage);
        mTestUser = (TextView) findViewById(R.id.testUser);
        mTestTime = (TextView) findViewById(R.id.testTime);

        mMyWineList.setHasFixedSize(true);

        mMyWineAdapter = new MyWineAdapter(NUM_LIST_ITEMS, this);
        mMyWineList.setAdapter(mMyWineAdapter);


        Firebase refWineName = new Firebase(Constants.FIREBASE_URL).child("wineName");
        refWineName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                WinePojo winePojoDetail = dataSnapshot.getValue(WinePojo.class);
                // If there was data, take the TextViews and set the appropriate values.
                if (winePojoDetail != null) {
                    mTestText.setText(winePojoDetail.getWineName());
                    mTestVintage.setText(winePojoDetail.getWineVintage());
                    mTestUser.setText(winePojoDetail.getTaster());
                    if (winePojoDetail.getTimestampLastChanged() != null) {
                        mTestTime.setText(Utils.SIMPLE_DATE_FORMAT.format(new Date(winePojoDetail.getTimestampLastChangedLong())));
                    } else {
                        mTestTime.setText("");

                    }

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

        if (mToast != null) {
            mToast.cancel();
        }
        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);


        mToast.show();
    }
}
