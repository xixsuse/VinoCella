package com.example.android.cellavino.PojoDirectory.UI1;

import java.util.HashMap;

/**
 * Created by Andrew on 25/03/2017.
 */

public class WineDetails {

    private String wineName;
    private String wineryName;
    private String wineYear;
    private String grapeType;
    private String tastingDate;
    private String wineDescription;
    private Float mMyWineRating;
    private String winePhotoUrl;

    public WineDetails() {
    }

    public WineDetails(String wineName, String wineryName, String wineYear, String grapeType, String tastingDate, String wineDescription, Float mMyWineRating, String winePhotoUrl) {

        this.wineName = wineName;
        this.wineryName = wineryName;
        this.wineYear = wineYear;
        this.grapeType = grapeType;
        this.tastingDate = tastingDate;
        this.wineDescription = wineDescription;
        this.mMyWineRating = mMyWineRating;
        this.winePhotoUrl = winePhotoUrl;

    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public String getWineryName() {
        return wineryName;
    }

    public void setWineryName() {
        this.wineryName = wineryName;
    }

    public String getWineYear() {
        return wineYear;
    }

    public void setWineYear() {
        this.wineYear = wineYear;
    }

    public String getGrapeType() {
        return grapeType;
    }

    public void setGrapeType() {
        this.grapeType = grapeType;
    }

    public String getTastingDate() {
        return tastingDate;
    }

    public void setTastingDate() {
        this.tastingDate = tastingDate;
    }

    public String getWineDescription() {
        return wineDescription;
    }

    public void setWineDescription() {
        this.wineDescription = wineDescription;
    }

    public Float getmMyWineRating() {
        return mMyWineRating;
    }

    public void setMyWineRating() {
        this.mMyWineRating = mMyWineRating;
    }

    public String getWinePhotoUrl() {
        return winePhotoUrl;
    }

    public void setWinePhotoUrl() {
        this.winePhotoUrl = winePhotoUrl;
    }

}
