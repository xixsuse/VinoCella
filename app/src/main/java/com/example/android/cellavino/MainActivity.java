package com.example.android.cellavino;

import android.*;
import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.LocationPojo;
import com.example.android.cellavino.PojoDirectory.UI2.UserDetailsPojo;
import com.example.android.cellavino.UserInterface.WineAdapter;
import com.example.android.cellavino.UserInterface2.CreateTasting.MyTastings;
import com.example.android.cellavino.UserInterface2.EditProfile.EditProfile;
import com.example.android.cellavino.UserInterface2.JoinTasting.JoinTasting;
import com.example.android.cellavino.UserInterface2.WineDetails.CreateNewWine;
import com.example.android.cellavino.UserInterface2.WineDetails.MyWinesList;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQueryEventListener;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.example.android.cellavino.Utils.Constants.GPS_PERMISSION;
import static com.example.android.cellavino.Utils.Constants.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION;
import static com.example.android.cellavino.Utils.Constants.TASTING_GEO;

public class MainActivity extends AppCompatActivity implements android.location.LocationListener {

    private static final String TAG = "MainActivity";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String ANONYMOUS = "anonymous";
    public static final int RC_SIGN_IN = 1;
    public String mUsername;

    Button nearbyTasting;


    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mWineDatabaseReference;
    private DatabaseReference mUserDatabaseReference;
    private DatabaseReference mMyWinesReference;
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
    private Uri userProfilePic;
    private TextView mUsernameTextView;
    LocationManager locationManager;
    String provider;
    Location mCurrentLocation;
    ArrayList<String> tastingArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.my_wines_list);
        //setContentView(R.layout.activity_container);
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyWinesListFragment()).commit();


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        provider = locationManager.getBestProvider(new Criteria(), false);
        nearbyTasting = (Button) findViewById(R.id.search_nearby_tastings);
        getLocation();


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
        mMyWinesReference = mFirebaseDatabase.getReference().child("Users").child("myWines");


        //initialising the views
        //ListView mWineListView = (ListView) findViewById(R.id.wineListView);


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


        //initialise view_my_wines button click listener
        Button viewMyWinesButton = (Button) findViewById(R.id.view_my_wines);
        viewMyWinesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyWinesList.class);
                startActivity(intent);

            }
        });

        //initialise edit_profile button click listener
        Button editProfileButton = (Button) findViewById(R.id.edit_profile);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditProfile.class);
                startActivity(intent);

            }
        });


        //initialise edit_profile button click listener
        Button createTastingButton = (Button) findViewById(R.id.create_tasting);
        createTastingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyTastings.class);
                startActivity(intent);

            }
        });

        //initialise edit_profile button click listener
        Button joinTastingButton = (Button) findViewById(R.id.join_tasting);
        joinTastingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JoinTasting.class);
                startActivity(intent);

            }
        });

        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        if (user != null) {
            String userName = user.getDisplayName();
            TextView mUsernameTextView = (TextView) findViewById(R.id.user_name);
            mUsernameTextView.setText(userName);
        } else {
            TextView mUsernameTextView = (TextView) findViewById(R.id.user_name);
            mUsernameTextView.setVisibility(View.GONE);
        }


        nearbyTasting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    mCurrentLocation = locationManager.getLastKnownLocation(provider);
                } catch (Exception e) {
                }

                if (mCurrentLocation != null) {
                    getNearTasting(mCurrentLocation);
                } else {
                    getLocation();
                    Toast.makeText(MainActivity.this, "Get a move to get your location", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if ( ContextCompat.checkSelfPermission( this, Manifest.permission.CAMERA ) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    Constants.TAKE_PICTURE);
        }
    }

    public void getNearTasting(final Location location) {
        final ProgressDialog progressDialog = ProgressDialog.show(MainActivity.this, "Loading..", null, true, false);
        tastingArrayList = new ArrayList<>();
        TASTING_GEO.queryAtLocation(new GeoLocation(location.getLatitude(), location.getLongitude()), 10).addGeoQueryEventListener(new GeoQueryEventListener() {
            @Override
            public void onKeyEntered(String key, GeoLocation location) {
                tastingArrayList.add(key);
            }

            @Override
            public void onKeyExited(String key) {

            }

            @Override
            public void onKeyMoved(String key, GeoLocation location) {

            }

            @Override
            public void onGeoQueryReady() {
                progressDialog.dismiss();

                if (tastingArrayList.size() >= 1) {
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    LocationPojo pojo = new LocationPojo(location.getLatitude(), location.getLongitude());
                    intent.putExtra("Nearest", pojo);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Sorry Not found Tasting Near you ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onGeoQueryError(DatabaseError error) {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                String uid = user.getUid();
                String userName = user.getDisplayName();
                String userEmail = user.getEmail();
                Uri userProfilePic = user.getPhotoUrl();
                createUserInFirebaseHelper(uid, userName, userEmail);
                Toast.makeText(MainActivity.this, "Hello " + userName + "!", Toast.LENGTH_SHORT).show();

            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this, "Sign in cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else if (requestCode == GPS_PERMISSION) {

            String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            if (provider != null) {
                getLocation();
            } else {
                Toast.makeText(this, "You must enable Gps to get your location", Toast.LENGTH_SHORT).show();
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
        //mWineAdapter.clear();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_navigation_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //if (mActionBarDrawerToggle.onOptionsItemSelected(item)) {
        //    return true;
        //}

        switch (item.getItemId()) {
            case R.id.sign_out_menu:
                //sign out
                AuthUI.getInstance().signOut(this);
                return true;

            /*
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
            */
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void onSignedInInialise(String username) {
        mUsername = username;
        //attachDatabaseReadListener();

        //this code adds a new user name each time it logs in.
        //mUserDatabaseReference.push().setValue(username);

    }

    private void onSignedOutCleanup() {
        mUsername = ANONYMOUS;
        //mWineAdapter.clear();
        detachDatabaseReadListener();
    }

    /*
    private void attachDatabaseReadListener() {
        if (mChildEventListener == null) {
            mChildEventListener = new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    WineDetails wineDetails = dataSnapshot.getValue(WineDetails.class);
                    //mWineAdapter.add(wineDetails);
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
*/
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


    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }


    @Override
    public void onProviderDisabled(String provider) {

    }


    public boolean checkGPS() {
        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean isenabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
        return isenabled;
    }

    public void showGpsAlert() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // set title
        alertDialogBuilder.setTitle("Alert");
        // set dialog message
        alertDialogBuilder.setMessage("Enable GPS")
                .setCancelable(false)
                .setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(intent, GPS_PERMISSION);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationManager.removeUpdates(this);
    }

    public void getLocation() {

        if (checkGPS()) {

            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(locationManager.getBestProvider(new Criteria(), false), 1000, 1, this);

            } else {
                requestPermissions(
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
            }
        } else {
            showGpsAlert();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == Constants.TAKE_PICTURE)
        {
            Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT);
        } else
        {
            Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT);
        }
    }
}
