package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.cellavino.PojoDirectory.UI2.WineTastingListPojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastingPojo;
import com.example.android.cellavino.R;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by Andrew on 13/08/2017.
 */

public class TastingWinesAdapter extends FirebaseListAdapter<WineTastingPojo> {


    private WineTastingPojo mWineTastingPojo;
    private String mTastingWineList;
    //final static String LOG_TAG = MyTastingsAdapter.class.getSimpleName();


//   MyTastingsAdapter(this, WineTastingListPojo.class, R.layout.tasting_details, tastingReference, mTastingId);

    public TastingWinesAdapter(Activity activity, Class<WineTastingPojo> modelClass, int modelLayout, Query ref, String tastingWineID) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
        this.mTastingWineList = tastingWineID;

    }


    public void myTastings(WineTastingPojo wineTastingPojo) {
        this.mWineTastingPojo = wineTastingPojo;
        this.notifyDataSetChanged();

    }

    //the protected method below will populate the view that is attached to the adapter (insert the view name here)
    // with  items inflated from the wine_details card

    //TODO: Update thsi to populate the correct view.

    protected void populateView(View view, final WineTastingPojo list, int position) {
        // Find the textViews and save them in textView fields, enabling display.
        // then set the wineName and Vintage on the list - ready for a customer to click on and display the details of the wine they've tasted.

        TextView textViewTastingWineName = (TextView) view.findViewById(R.id.tasting_wine_vintage);
        textViewTastingWineName.setText(list.getWineVintage());

        TextView textViewTastingOwner = (TextView) view.findViewById(R.id.tasting_wine_name);
        textViewTastingOwner.setText(list.getWineName());

        ImageView imageViewTastingWine = (ImageView) view.findViewById(R.id.tasting_wine_image);
        Picasso.with(mActivity).load(list.getWineImageUrl()).placeholder(R.drawable.sample_wine_flight).into(imageViewTastingWine);
    }
}
