package com.example.android.cellavino.UserInterface2.WineDetails;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.R;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;

/**
 * Created by Andrew on 7/05/2017.
 * The WineInformationAdapter is used to link Firebase and the WinePojo together.
 */

public class WineInformationAdapter extends FirebaseListAdapter<WinePojo> {

    private WinePojo mWinePojo;
    private String mWineId;
    final static String LOG_TAG = WineInformationAdapter.class.getSimpleName();

    /**
     * Public constructor that initializes private instance variables when adapter is created
     */

    public WineInformationAdapter(Activity activity, Class<WinePojo> modelClass, int modelLayout, Query ref, String wineId) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
        this.mWineId = wineId;
    }

    public void setWineInformation(WinePojo winePojo) {
        this.mWinePojo = winePojo;
        this.notifyDataSetChanged();

    }

    //the protected method below will populate the view that is attached to the adapter (insert the view name here)
    // with  items inflated from the wine_details card


    protected void populateView(View view, final WinePojo list, int position) {
        // Find the textViews and save them in textView fields, enabling display.
        // then set the wineName and Vintage on the list - ready for a customer to click on and display the details of the wine they've tasted.

        TextView textViewWineName = (TextView) view.findViewById(R.id.detail_wine_name);
        textViewWineName.setText(list.getWineName());

        TextView textViewWineVintage = (TextView) view.findViewById(R.id.detail_wine_vintage);
        textViewWineVintage.setText(list.getWineVintage());

        TextView textViewWineVariety = (TextView) view.findViewById(R.id.detail_wine_variety);
        textViewWineVariety.setText(list.getWineVariety());
    }

}
