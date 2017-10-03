package com.example.android.cellavino.Utils;

import com.firebase.geofire.GeoFire;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Andrew on 21/04/2017.
 */

public class Constants {

    //Project URL
    public static final String FIREBASE_URL = "https://vinocella-ae4d9.firebaseio.com/";

    //Constants related to locations in Firebase, such as the name of the node

    public static final String FIREBASE_LOCATION_WINE_DETAILS = "wineDetails";
    public static final String FIREBASE_LOCATION_ARCHIVED_WINE_DETAILS = "archivedWineDetails";
    public static final String FIREBASE_LOCATION_THIS_WINE_DETAILS = "Specific_Wine_Details";
    public static final String FIREBASE_LOCATION_WINERY_DETAILS = "Winery_Details";
    public static final String FIREBASE_WINE_SUMMARY_DETAILS = "summaryDetails";
    public static final String FIREBASE_WINE_FLAVOR_DETAILS = "flavorDetails";
    public static final String FIREBASE_LOCATION_USERS = "CellaVino_Users";
    public static final String FIREBASE_MY_TASTINGS = "myTastings";
    public static final String FIREBASE_EVERYONE_TASTING = "everyoneTasting";
    public static final String FIREBASE_MY_TASTING_SUMMARY = "tastingSummary";
    public static final String FIREBASE_TASTING_NAME = "tastingName";
    public static final String FIREBASE_TASTINGS = "tastings";
    public static final String FIREBASE_MY_WINES = "myWines";
    public static final String FIREBASE_TASTING_WINE_DETAILS = "tastingWineDetails";
    public static final String FIREBASE_WINES = "wines";
    public static final String FIREBASE_OWNER = "owner";
    public static final String FIREBASE_IMAGE_URL = "imageUrl";
    public static final String FIREBASE_MY_ARCHIVED_WINES = "myArchivedWines";
    public static final int GPS_PERMISSION = 201;
    public static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 202;
    public static final int LOCATION_PICKER_REQUEST = 203;


    public static final GeoFire TASTING_GEO = new GeoFire(FirebaseDatabase.getInstance().getReference("Tasting_geo"));
    /**
     * Constants for Firebase object properties
     */
    public static final String FIREBASE_PROPERTY_WINE_NAME = "wineName";
    public static final String FIREBASE_PROPERTY_WINE_VINTAGE = "wineVintage";
    public static final String FIREBASE_PROPERTY_WINE_DESCRIPTION = "wineDescription";
    public static final String FIREBASE_PROPERTY_WINE_VARIETY = "wineVariety";
    public static final String FIREBASE_PROPERTY_WINE_WINERY = "wineWinery";
    public static final String FIREBASE_PROPERTY_WINE_RATING = "mCreateNewWineRating";
    public static final String FIREBASE_PROPERTY_WINE_TASTING_DATE = "wineTastingDate";
    public static final String FIREBASE_PROPERTY_TIMESTAMP_CREATED = "timestampCreated";
    public static final String FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED = "timestampLastChanged";


    //USer wine constants...this simple change should make users only able to see their wines.
    public static final String FIREBASE_LOCATION_USERS_WINE_URL = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;


    /**
     * Constants for Firebase URL
     */

    public static final String FIREBASE_URL_LOCATION_THIS_WINE_DETAILS = FIREBASE_URL + "/" + FIREBASE_LOCATION_THIS_WINE_DETAILS;
    public static final String FIREBASE_URL_LOCATION_WINE_DETAILS = FIREBASE_URL + "/" + FIREBASE_LOCATION_WINE_DETAILS;
    public static final String FIREBASE_URL_LOCATION_USERS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USERS;
    public static final String FIREBASE_URL_LOCATION_WINERY_DETAILS = FIREBASE_URL + "/" + FIREBASE_LOCATION_WINERY_DETAILS;
    public static final String FIREBASE_URL_LOCATION_ARCHIVED_WINE_DETAILS = FIREBASE_URL + "/" + FIREBASE_LOCATION_ARCHIVED_WINE_DETAILS;
    public static final String FIREBASE_URL_TASTING_WINE_DETAILS = FIREBASE_URL + "/" + FIREBASE_TASTING_WINE_DETAILS;
    public static final String FIREBASE_URL_TASTINGS = FIREBASE_URL + "/" + FIREBASE_TASTINGS;
    public static final String FIREBASE_URL_EVERYONE_TASTING = FIREBASE_URL + "/" + FIREBASE_EVERYONE_TASTING;
    public static final String STORAGE_URL = "gs://vinocella-ae4d9.appspot.com";
    /**
     * Constants for bundles, extras and shared preferences keys
     */
    public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";


    public static final String WINE_LIST_ID = "WINE_LIST_ID";
    public static final String TASTING_LIST_ID = "TASTING_LIST_ID";
    public static final String TASTING_ID = "TASTING_ID";
    public static final String FIREBASE_MY_TASTING_NAME = "MY_TASTING_NAME";
    public static final String KEY_LAYOUT_RESOURCE = "LAYOUT_RESOURCE";
    public static final String PUBLIC = "public";
    public static final String TASTINGPOINTS = "tastingPoints";
    public static final String WINE_NAME = "wineName";
    public static final String WINE_VINTAGE = "wineVintage";
    public static final String WINE_VARIETY = "wineVariety";



    //Flavor Profiles
    public static final String GRAPEFRUIT_TASTE = "mGrapefruit";

    public static final int TAKE_PICTURE = 1;
}
