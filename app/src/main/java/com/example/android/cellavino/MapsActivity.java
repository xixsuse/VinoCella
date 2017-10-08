package com.example.android.cellavino;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.android.cellavino.PojoDirectory.UI2.LocationPojo;
import com.example.android.cellavino.PojoDirectory.UI2.TastingDetailsPojo;
import com.example.android.cellavino.Utils.Constants;
import com.example.android.cellavino.adapter.RecyclerAdapter;
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
import com.google.maps.android.SphericalUtil;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.android.cellavino.Utils.Constants.TASTING_GEO;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    LatLngBounds.Builder builder;
    public static HashMap<String, TastingDetailsPojo> stringTastingDetailsPojoHashMap;
    private GoogleMap mMap;
    LocationPojo locationPojo;

    HashMap<LatLng, TastingDetailsPojo> markerHashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        stringTastingDetailsPojoHashMap = new HashMap<>();

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
        mMap.setOnMarkerClickListener(this);
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
//                        ArrayList<TastingDetailsPojo> pojoArrayList = new ArrayList<>();
                        final TastingDetailsPojo detailsPojo = dataSnapshot.getValue(TastingDetailsPojo.class);
                        Marker marker = mMap.addMarker(new MarkerOptions().position(new LatLng(detailsPojo
                                .getLatitude(), detailsPojo.getLongitude())).icon(BitmapDescriptorFactory.
                                defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                        marker.setTag(detailsPojo);

                        stringTastingDetailsPojoHashMap.put(detailsPojo.getTasteUid(), detailsPojo);
                        builder.include(marker.getPosition());
                        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 200));

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

    @Override
    public boolean onMarkerClick(Marker marker) {
        markerClick(marker);
        return true;
    }

    public void markerClick(Marker marker) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.CustomDialog);
        View markerView = LayoutInflater.from(this).inflate(R.layout.recyclerview_windowtitle, null);
        markerView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        builder.setView(markerView);
        TastingDetailsPojo myMarkerTaste = (TastingDetailsPojo) marker.getTag();
        ArrayList<TastingDetailsPojo> detailsPojos = new ArrayList<>();
        for (HashMap.Entry<String, TastingDetailsPojo> entry : MapsActivity.stringTastingDetailsPojoHashMap.entrySet()) {
            double distance = SphericalUtil.computeDistanceBetween(new LatLng(entry.getValue().getLatitude(), entry.getValue().getLongitude()),
                    new LatLng(myMarkerTaste.getLatitude(), myMarkerTaste.getLongitude()));
            if (distance < 1) {
                detailsPojos.add(entry.getValue());
            }
        }

        RecyclerView recyclerView = (RecyclerView) markerView.findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, detailsPojos);
        recyclerView.setAdapter(recyclerAdapter);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setLayout(1000, 900);
    }
}
