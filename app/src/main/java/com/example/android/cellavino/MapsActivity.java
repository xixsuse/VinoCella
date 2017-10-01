package com.example.android.cellavino;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.LocationPojo;
import com.example.android.cellavino.PojoDirectory.UI2.TastingDetailsPojo;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseError;

import static com.example.android.cellavino.Utils.Constants.TASTING_GEO;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    LatLngBounds.Builder builder;
    private GoogleMap mMap;
    LocationPojo locationPojo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationPojo = getIntent().getParcelableExtra("Nearest");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        builder = new LatLngBounds.Builder();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(locationPojo.getLatitude(), locationPojo.getLongitude()), 15));
        getNearest(locationPojo);
    }

    // TODO: update the 10 to a adjustable value radius.
    public void getNearest(LocationPojo mCurrentLoc) {
        TASTING_GEO.queryAtLocation(new GeoLocation(mCurrentLoc.getLatitude()
                , mCurrentLoc.getLongitude()), 150).addGeoQueryEventListener(new GeoQueryEventListener() {
            @Override
            public void onKeyEntered(String key, GeoLocation location) {
                Firebase tastingRef = new Firebase(Constants.FIREBASE_URL_EVERYONE_TASTING);
                tastingRef.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        TastingDetailsPojo detailsPojo = dataSnapshot.getValue(TastingDetailsPojo.class);
                        Marker marker = mMap.addMarker(new MarkerOptions().position(new LatLng(detailsPojo
                                .getLatitude(), detailsPojo.getLongitude())).icon(BitmapDescriptorFactory.
                                defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        marker.setTag(detailsPojo);
                        marker.setTitle(detailsPojo.getName());

                        builder.include(marker.getPosition());
                        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 200));


                        //TODO: add a click listener to take people to the correct tasting and fix the tastingName to show the correct location.


                        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                            @Override
                            public boolean onMarkerClick(Marker marker1) {

                                //final String tastingName = detailsPojo.getName();

                                Toast.makeText(MapsActivity.this, "Wine Tasting Name: ", Toast.LENGTH_SHORT).show();

                                return false;
                            }
                        });

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
            }


            @Override
            public void onKeyExited(String key) {

            }

            @Override
            public void onKeyMoved(String key, GeoLocation location) {

            }

            @Override
            public void onGeoQueryReady() {

            }

            @Override
            public void onGeoQueryError(DatabaseError error) {

            }
        });


    }
}
