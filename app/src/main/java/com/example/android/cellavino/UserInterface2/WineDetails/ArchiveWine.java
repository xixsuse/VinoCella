package com.example.android.cellavino.UserInterface2.WineDetails;

import android.os.Bundle;

import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_MY_ARCHIVED_WINES;
import static com.example.android.cellavino.Utils.Constants.FIREBASE_MY_WINES;

/**
 * Created by Andrew on 12/07/2017.
 */

public class ArchiveWine extends MainActivity {

    private Firebase mArchiveMyWines;
    private Firebase mMyArchivedWines;
    private Firebase mArchiveMasterWines;
    private Firebase mArchivedMasterWines;
    private String mWinePushID;
    private String mUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        mWinePushID = bundle.getString("thisWinePushID");
        mUid = bundle.getString("thisUserID");


        mArchiveMasterWines = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID);
        mArchivedMasterWines = new Firebase(Constants.FIREBASE_URL_LOCATION_ARCHIVED_WINE_DETAILS).child(mWinePushID);
        archiveMasterWine(mArchiveMasterWines, mArchivedMasterWines);

        mArchiveMyWines = new Firebase(Constants.FIREBASE_LOCATION_USERS_WINE_URL).child(mUid).child(FIREBASE_MY_WINES).child(mWinePushID);
        mMyArchivedWines = new Firebase(Constants.FIREBASE_LOCATION_USERS_WINE_URL).child(mUid).child(FIREBASE_MY_ARCHIVED_WINES).child(mWinePushID);
        archiveUserWine(mArchiveMyWines, mMyArchivedWines);


    }

    // mWineInformationRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS).child(mWinePushID).child(Constants.FIREBASE_WINE_SUMMARY_DETAILS);
    //Firebase(Constants.FIREBASE_LOCATION_USERS + "/" + uid + "/" + Constants.FIREBASE_MY_WINES + "/" + mWinePushID);

    public void archiveMasterWine(final Firebase mArchiveMasterWines, final Firebase mArchivedMasterWines) {
        mArchiveMasterWines.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mArchivedMasterWines.setValue(dataSnapshot.getValue(), new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        if (firebaseError != null) {
                            System.out.println("Delete Failed");
                        } else {
                            System.out.println("Deleted");
                            mArchiveMasterWines.setValue(null);

                        }

                    }
                });
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("Delete Failed");
            }
        });

    }

    public void archiveUserWine(final Firebase mArchiveMyWines, final Firebase mMyArchivedWines) {

        mArchiveMyWines.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mMyArchivedWines.setValue(dataSnapshot.getValue(), new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        if (firebaseError != null) {
                            System.out.println("Delete Failed");
                        } else {
                            System.out.println("Deleted");
                            mArchiveMyWines.setValue(null);

                        }
                    }
                });
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("Delete Failed");
            }
        });

    }
}
