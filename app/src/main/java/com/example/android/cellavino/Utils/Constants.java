package com.example.android.cellavino.Utils;

/**
 * Created by Andrew on 21/04/2017.
 */

public class Constants {

    //Project URL
    public static final String FIREBASE_URL = "https://vinocella-ae4d9.firebaseio.com/";

    //Constants related to locations in Firebase, such as the name of the node

    public static final String FIREBASE_LOCATION_WINE_DETAILS = "New_Wine_Details";
    public static final String FIREBASE_LOCATION_THIS_WINE_DETAILS = "Specific_Wine_Details";
    public static final String FIREBASE_LOCATION_WINERY_DETAILS = "Winery_Details";
    public static final String FIREBASE_WINE_SUMMARY_DETAILS = "summaryDetails";
    public static final String FIREBASE_WINE_FLAVOR_DETAILS = "flavorDetails";
    public static final String FIREBASE_LOCATION_USERS = "CellaVino_Users";
    public static final String FIREBASE_MY_WINES = "myWines";



    /**
     * Constants for Firebase object properties
     */
    public static final String FIREBASE_PROPERTY_WINE_NAME = "wineName";
    public static final String FIREBASE_PROPERTY_WINE_VINTAGE = "wineVintage";
    public static final String FIREBASE_PROPERTY_WINE_DESCRIPTION = "wineDescription";
    public static final String FIREBASE_PROPERTY_WINE_VARIETY = "wineVariety";
    public static final String FIREBASE_PROPERTY_WINE_WINERY = "wineWinery";
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

    /**
     * Constants for bundles, extras and shared preferences keys
     */
    public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";



    public static final String WINE_LIST_ID = "WINE_LIST_ID";
    public static final String KEY_LAYOUT_RESOURCE = "LAYOUT_RESOURCE";


    //Flavor Profiles
    public static final String GRAPEFRUIT_TASTE = "mGrapefruit";




}
