package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastingListPojo;
import com.example.android.cellavino.PojoDirectory.UI2.WineTastingPojo;
import com.example.android.cellavino.R;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by Andrew on 1/08/2017.
 */

public class MyTastingsAdapter extends FirebaseListAdapter<WineTastingListPojo> {


    private WineTastingPojo mWineTastingPojo;
    private String mTastingId;
    //final static String LOG_TAG = MyTastingsAdapter.class.getSimpleName();


//   MyTastingsAdapter(this, WineTastingListPojo.class, R.layout.tasting_details, tastingReference, mTastingId);

    public MyTastingsAdapter(Activity activity, Class<WineTastingListPojo> modelClass, int modelLayout, Query ref, String tastingID) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
        this.mTastingId = tastingID;

    }


    public void myTastings(WineTastingPojo wineTastingPojo) {
        this.mWineTastingPojo = wineTastingPojo;
        this.notifyDataSetChanged();

    }

    //the protected method below will populate the view that is attached to the adapter (insert the view name here)
    // with  items inflated from the wine_details card

    protected void populateView(View view, final WineTastingListPojo list, int position) {
        // Find the textViews and save them in textView fields, enabling display.
        // then set the wineName and Vintage on the list - ready for a customer to click on and display the details of the wine they've tasted.

        TextView textViewTastingName = (TextView) view.findViewById(R.id.tasting_tasting_name);
        textViewTastingName.setText(list.getTastingName());

        TextView textViewTastingOwner = (TextView) view.findViewById(R.id.tasting_owner);
        textViewTastingOwner.setText(list.getOwner());

        ImageView imageView = (ImageView) view.findViewById(R.id.tasting_photo);
        Picasso.with(mActivity).load(list.getImageUrl()).placeholder(R.drawable.sample_wine_flight).into(imageView);
    }
}


