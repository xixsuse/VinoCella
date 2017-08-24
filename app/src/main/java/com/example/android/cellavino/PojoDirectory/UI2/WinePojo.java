package com.example.android.cellavino.PojoDirectory.UI2;

import com.example.android.cellavino.Utils.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.ServerValue;

import java.util.HashMap;

/**
 * Created by Andrew on 5/05/2017.
 */

public class WinePojo {
    String wineName;
    String wineWinery;
    String wineVintage;
    String wineVariety;
    String wineTastingDate;
    String wineDescription;
    String taster;
    String userName;
    String uid;
    private Float mCreateNewWineRating;
    private HashMap<String, Object> timestampLastChanged;
    private HashMap<String, Object> timestampCreated;


    public WinePojo() {

    }

    public WinePojo(String wineName, String wineWinery, String wineVintage, String wineVariety, String taster, String userName,
                    String uid, String wineTastingDate, String wineDescription, Float mCreateNewWineRating, HashMap<String, Object> timestampCreated) {
        this.wineName = wineName;
        this.wineWinery = wineWinery;
        this.wineVintage = wineVintage;
        this.wineVariety = wineVariety;
        this.wineTastingDate = wineTastingDate;
        this.wineDescription = wineDescription;
        this.taster = taster;
        this.userName = userName;
        this.uid = uid;
        this.mCreateNewWineRating = mCreateNewWineRating;
        this.timestampCreated = timestampCreated;

        HashMap<String, Object> timestampLastChangedObj = new HashMap<String, Object>();
        timestampLastChangedObj.put(Constants.FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED, ServerValue.TIMESTAMP);
        this.timestampLastChanged = timestampLastChangedObj;


    }

    public String getWineName() {
        return wineName;
    }

    public String getWineWinery() {
        return wineWinery;
    }

    public String getWineVintage() {
        return wineVintage;
    }

    public String getWineVariety() {
        return wineVariety;
    }

    public String getWineTastingDate() {
        return wineTastingDate;
    }

    public String getWineDescription() {
        return wineDescription;
    }

    public String getTaster() {
        return taster;
    }

    public String getUserName() {
        return userName;
    }

    public String getUid() {
        return uid;
    }

    public Float getmCreateNewWineRating() {
        return mCreateNewWineRating;
    }

    public HashMap<String, Object> getTimestampLastChanged() {
        return timestampLastChanged;
    }

    public HashMap<String, Object> getTimestampCreated() {
        return timestampCreated;
    }

    @JsonIgnore
    public long getTimestampLastChangedLong() {
        return (long) timestampLastChanged.get(Constants.FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED);
    }

    @JsonIgnore
    public long getTimestampCreatedLong() {
        return (long) timestampCreated.get(Constants.FIREBASE_PROPERTY_TIMESTAMP_CREATED);
    }


}
