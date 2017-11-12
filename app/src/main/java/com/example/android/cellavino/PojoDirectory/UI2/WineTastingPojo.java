package com.example.android.cellavino.PojoDirectory.UI2;

import com.example.android.cellavino.Utils.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.firebase.client.ServerValue;

import java.util.HashMap;

/**
 * Created by Andrew on 31/07/2017.
 */

public class WineTastingPojo {

    String wineName;
    String wineVintage;
    String wineVariety;
    String wineDescription;
    String wineImageUrl;


    public WineTastingPojo() {
    }

    public WineTastingPojo(String wineName, String wineVintage, String wineVariety, String wineDescription, String wineImageUrl) {
        this.wineName = wineName;
        this.wineVintage = wineVintage;
        this.wineVariety = wineVariety;
        this.wineDescription = wineDescription;
        this.wineImageUrl = wineImageUrl;

    }

    public String getWineName() {
        return wineName;
    }

    public String getWineVintage() {
        return wineVintage;
    }

    public String getWineVariety() {
        return wineVariety;
    }

    public String getWineImageUrl() {
        return wineImageUrl;
    }

    public String getWineDescription() {
        return wineDescription;
    }

}

