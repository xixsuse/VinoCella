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


    public WineTastingPojo() {
    }

    public WineTastingPojo(String wineName, String wineVintage, String wineVariety) {
        this.wineName = wineName;
        this.wineVintage = wineVintage;
        this.wineVariety = wineVariety;

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

}

