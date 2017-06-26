package com.example.android.cellavino.PojoDirectory.UI2;

import android.net.Uri;

import java.util.HashMap;

/**
 * Created by Andrew on 17/06/2017.
 */

public class UserDetailsPojo {

    private String name;
    private String email;
    //private Uri userProfilePic;
    private HashMap<String, Object> timestampJoined;

    //public constructor

    public UserDetailsPojo() {
    }

    //this POJO will create a new user
    //Takes user name, email and timestampJoined as params
    //@param name
    //@param email
    //@param userProfilePic
    //@param timestampJoined

    public UserDetailsPojo(String name, String email, HashMap<String, Object> timestampJoined) {
        this.name = name;
        this.email = email;
        //this.userProfilePic = userProfilePic;
        this.timestampJoined = timestampJoined;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    //public Uri getUserProfilePic() {
    //    return userProfilePic;
    //}

    public HashMap<String, Object> getTimestampJoined() {
        return timestampJoined;
    }
}


