package com.example.android.cellavino.PojoDirectory;

import com.example.android.cellavino.Utils.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.ServerValue;

import java.util.HashMap;

/**
 * Created by Andrew on 5/05/2017.
 */

public class WinePojo {
    String wineName;
    String wineVintage;
    String taster;
    private HashMap<String, Object> timestampLastChanged;
    private HashMap<String, Object> timestampCreated;


    public WinePojo() {

    }

    public WinePojo(String wineName, String wineVintage, String taster, HashMap<String, Object> timestampCreated) {
        this.wineName = wineName;
        this.wineVintage = wineVintage;
        this.taster = taster;
        this.timestampCreated = timestampCreated;

        HashMap<String, Object> timestampLastChangedObj = new HashMap<String, Object>();
        timestampLastChangedObj.put(Constants.FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED, ServerValue.TIMESTAMP);
        this.timestampLastChanged = timestampLastChangedObj;


    }

    public String getWineName() {
        return wineName;
    }

    public String getWineVintage() {
        return wineVintage;
    }

    public String getTaster() {
        return taster;
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
