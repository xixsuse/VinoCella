package com.example.android.cellavino.PojoDirectory.UI2;

/**
 * Created by Andrew on 16/05/2017.
 */

public class SpecificWineDetailsPojo {
    private String viewWineName;
    private String viewWineVintage;
    private String viewWineVariety;


    public SpecificWineDetailsPojo() {
    }

    public SpecificWineDetailsPojo(String viewWineName, String viewWineVintage, String viewWineVariety) {
        this.viewWineName = viewWineName;
        this.viewWineVintage = viewWineVintage;
        this.viewWineVariety = viewWineVariety;
    }

    public String getViewWineName() {
        return viewWineName;
    }

    public String getViewWineVintage() {
        return viewWineVintage;
    }

    public String getViewVariety() {
        return viewWineVariety;
    }


}
