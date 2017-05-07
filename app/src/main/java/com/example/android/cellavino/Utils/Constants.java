package com.example.android.cellavino.Utils;

/**
 * Created by Andrew on 21/04/2017.
 */

public class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where active lists are stored (ie "activeLists")
     */

    public static final String FIREBASE_LOCATION_WINE_DETAILS = "New Wine Details";
    public static final String FIREBASE_LOCATION_USER_DETAILS = "User Details";
    public static final String FIREBASE_LOCATION_WINERY_DETAILS = "Winery Details";
    public static final String FIREBASE_WINE_FLAVOR_PROFILE = "Flavor Profile";



    /**
     * Constants for Firebase object properties
     */
    public static final String FIREBASE_PROPERTY_TIMESTAMP_CREATED = "timestampCreated";
    public static final String FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED = "timestampLastChanged";



    /**
     * Constants for Firebase URL
     */

    public static final String FIREBASE_URL = "https://vinocella-ae4d9.firebaseio.com/";
    public static final String FIREBASE_URL_LOCATION_WINE_DETAILS = FIREBASE_URL + "/" + FIREBASE_LOCATION_WINE_DETAILS;
    public static final String FIREBASE_URL_LOCATION_WINERY_DETAILS = FIREBASE_URL + "/" + FIREBASE_LOCATION_WINERY_DETAILS;
    public static final String FIREBASE_URL_USER_DETAILS = FIREBASE_URL + "/" + FIREBASE_LOCATION_USER_DETAILS;
    public static final String FIREBASE_URL_WINE_FLAVOR_PROFILE = FIREBASE_URL + "/" + FIREBASE_WINE_FLAVOR_PROFILE;

    /**
     * Constants for bundles, extras and shared preferences keys
     */


    public static final String WINE_LIST_ID = "WINE_LIST_ID";
    public static final String KEY_LAYOUT_RESOURCE = "LAYOUT_RESOURCE";





}
