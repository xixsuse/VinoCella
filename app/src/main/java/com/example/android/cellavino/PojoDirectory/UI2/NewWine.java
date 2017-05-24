package com.example.android.cellavino.PojoDirectory.UI2;

import com.example.android.cellavino.Utils.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.ServerValue;

import java.util.HashMap;

/**
 * Created by Andrew on 26/04/2017.
 */

public class NewWine {
    private String createWineName;
    private String createWineYear;
    private HashMap<String, Object> timestampLastChanged;
    private HashMap<String, Object> timestampCreated;

    public NewWine() {

    }

    public NewWine(String createWineName, String createWineYear, HashMap<String, Object> timestampCreated) {
        this.createWineName = createWineName;
        this.createWineYear = createWineYear;
        this.timestampCreated = timestampCreated;
        HashMap<String, Object> timestampNowObject = new HashMap<String, Object>();

        timestampNowObject.put(Constants.FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED, ServerValue.TIMESTAMP);
        this.timestampLastChanged = timestampNowObject;
    }

    public String getCreateWineName() {
        return createWineName;
    }

    public String getCreateWineYear() {
        return createWineYear;
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
    public long getTimeStampCreatedLong() {
        return (long) timestampCreated.get(Constants.FIREBASE_PROPERTY_TIMESTAMP_CREATED);
    }

}


