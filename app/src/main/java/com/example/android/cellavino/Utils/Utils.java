package com.example.android.cellavino.Utils;

import android.content.Context;

import java.text.SimpleDateFormat;

/**
 * Created by Andrew on 24/04/2017.
 */

public class Utils {

    //Format the timestamp with SimpleDateFormat

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Context mContext = null;


    //Public constructor that takes mContext for later use
    public Utils(Context con) {
        mContext = con;
    }
}
