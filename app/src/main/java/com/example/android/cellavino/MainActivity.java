package com.example.android.cellavino;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.Accounts.Login;
import com.example.android.cellavino.PojoDirectory.UI1.WineDetails;
import com.example.android.cellavino.PojoDirectory.UI2.UserDetailsPojo;
import com.example.android.cellavino.UserInterface.AddWine;
import com.example.android.cellavino.UserInterface.WineAdapter;
import com.example.android.cellavino.UserInterface2.CreateNewWine;
import com.example.android.cellavino.UserInterface2.MyWinesList;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String ANONYMOUS = "anonymous";
    public static final int RC_SIGN_IN = 1;
    private String mUsername;


    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mWineDatabaseReference;
    private DatabaseReference mUserDatabaseReference;
    private ChildEventListener mChildEventListener;

    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private FirebaseStorage mFirebaseStorage;
    private WineAdapter mWineAdapter;
    private ListView mWineListView;
    private RecyclerView mWineRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ProgressBar mProgressBar;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout mNavigationDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ListView mWineInformation;
    private TextView mWineName;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    private ListView mDrawerList;
    private String[] mMenuOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise Firebase
        Firebase.setAndroidContext(this);

        mUsername = ANONYMOUS;

        //mTitle = mDrawerTitle = getTitle();


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseStorage = FirebaseStorage.getInstance();
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

        //WineDatabase in Firebase initialisation
        mWineDatabaseReference = mFirebaseDatabase.getReference().child("Wine Details");
        mUserDatabaseReference = mFirebaseDatabase.getReference().child("Users");

        //initialising the views
        ListView mWineListView = (ListView) findViewById(R.id.wineListView);


        //Navigation Drawer setup
        mDrawerList = (ListView) findViewById(R.id.navigation_drawer_menu);
        mNavigationDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mNavigationDrawerLayout, R.string.Open, R.string.Close);

        mNavigationDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialise the ListView
        List<WineDetails> wineDetails = new ArrayList<>();
        mWineAdapter = new WineAdapter(this, R.layout.wine_list_item, (ArrayList<WineDetails>) wineDetails);
        mWineListView.setAdapter(mWineAdapter);


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //user is signed in
                    onSignedInInialise(user.getDisplayName());
                } else {
                    //user is signed out
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                                    .build(),
                            RC_SIGN_IN);
                }

            }
        };

        //add code that will bring up the Add_Wine screen when a user clicks on the floating action button for addwine.
        FloatingActionButton addWineFab = (FloatingActionButton) findViewById(R.id.addWineFab);
        addWineFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateNewWine.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(MainActivity.this, "You are now signed in!", Toast.LENGTH_SHORT).show();
                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                String uid = user.getUid();
                String userName = user.getDisplayName();
                String userEmail = user.getEmail();
                createUserInFirebaseHelper(uid, userName, userEmail);
                Toast.makeText(MainActivity.this, "Hello " + userName + "!", Toast.LENGTH_SHORT).show();

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Sign in cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    private void createUserInFirebaseHelper(String uid, String userName, String userEmail) {

        final String mUserName = userName;
        final String mUserEmail = userEmail;
        final Firebase userDetailLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid);

        //See if there is already a user (for example, if they already logged in with an associated google account

        userDetailLocation.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                // If there is no user, make one
                if (dataSnapshot.getValue() == null) {
                    //Set raw version of date to the ServerValue.TIMESTAMP value and save into dateCreatedMap
                    HashMap<String, Object> timestampJoined = new HashMap<>();
                    timestampJoined.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);
                    UserDetailsPojo newUser = new UserDetailsPojo(mUserName, mUserEmail, timestampJoined);
                    userDetailLocation.setValue(newUser);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.d(LOG_TAG, getString(R.string.log_error_occurred) + firebaseError.getMessage());

            }
        });
    }

    //When the app comes back from background state etc
    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }


    //When the app goes to background state
    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
        detachDatabaseReadListener();
        mWineAdapter.clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                //sign out
                AuthUI.getInstance().signOut(this);
                return true;
            case R.id.menu_add_wine:
                //add wine
                Intent intent = new Intent(MainActivity.this, AddWine.class);
                startActivity(intent);
                return true;

            case R.id.view_my_wines:
                //view the working wine list Andrews Wines
                Intent intent2 = new Intent(MainActivity.this, MyWinesList.class);
                startActivity(intent2);
                return true;

            case R.id.test_option:
                //view the test screens for Andrews Wines
                Intent intent3 = new Intent(MainActivity.this, Login.class);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void onSignedInInialise(String username) {
        mUsername = username;
        attachDatabaseReadListener();

        //this code adds a new user name each time it logs in.
        //mUserDatabaseReference.push().setValue(username);

    }

    private void onSignedOutCleanup() {
        mUsername = ANONYMOUS;
        mWineAdapter.clear();
        detachDatabaseReadListener();
    }

    private void attachDatabaseReadListener() {
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    WineDetails wineDetails = dataSnapshot.getValue(WineDetails.class);
                    mWineAdapter.add(wineDetails);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            };
            mWineDatabaseReference.addChildEventListener(mChildEventListener);
        }
    }

    private void detachDatabaseReadListener() {
        if (mChildEventListener != null) {
            mWineDatabaseReference.removeEventListener(mChildEventListener);
            mChildEventListener = null;
        }
    }

    private void initializeScreen(View rootView) {
        mWineInformation = (ListView) rootView.findViewById(R.id.wine_list_item_details);
        mWineName = (TextView) rootView.findViewById(R.id.wine_name);
    }

}
