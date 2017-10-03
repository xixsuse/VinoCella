package com.example.android.cellavino.PojoDirectory.UI2;

/**
 * Created by Andrew on 4/08/2017.
 */

public class WineTastingListPojo {

    String tastingName;
    String owner;
    String imageUrl;


    public WineTastingListPojo() {

    }

    public WineTastingListPojo(String tastingName, String owner, String imageUrl) {
        this.tastingName = tastingName;
        this.owner = owner;
        this.imageUrl = imageUrl;
    }

    public String getTastingName() {
        return tastingName;
    }

    public String getOwner() {
        return owner;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

