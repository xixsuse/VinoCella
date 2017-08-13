package com.example.android.cellavino.PojoDirectory.UI2;

/**
 * Created by Andrew on 4/08/2017.
 */

public class WineTastingListPojo {

    String tastingName;
    String owner;


    public WineTastingListPojo() {

    }

    public WineTastingListPojo(String tastingName, String owner) {
        this.tastingName = tastingName;
        this.owner = owner;

    }

    public String getTastingName() {
        return tastingName;
    }

    public String getOwner() {
        return owner;
    }
}

