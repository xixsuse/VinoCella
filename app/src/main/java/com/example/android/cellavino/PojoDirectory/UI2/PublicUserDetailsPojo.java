package com.example.android.cellavino.PojoDirectory.UI2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.firebase.database.Exclude;

/**
 * Created by Andrew on 7/10/2017.
 */

public class PublicUserDetailsPojo {

    private int tastingPoints;
    private int mostRecentTastingPoints;
    private int totalWinesTasted;
    private int wineTastingLevel;

    public PublicUserDetailsPojo() {
    }


    public PublicUserDetailsPojo(int tastingPoints, int mostRecentTastingPoints, int totalWinesTasted
            /*
            , , int wineTastingLevel
            */) {

        this.tastingPoints = tastingPoints;
        this.mostRecentTastingPoints = mostRecentTastingPoints;
        this.totalWinesTasted = totalWinesTasted;
        //this.wineTastingLevel = wineTastingLevel;

    }

    public int getTastingPoints() {
        return tastingPoints;
    }

    @Exclude
    public int getMostRecentTastingPoints(){
        return mostRecentTastingPoints;
    }

    public int getTotalWinesTasted(){
        return totalWinesTasted;
    }

    public int getWineTastingLevel(){
        return wineTastingLevel;
    }


}
