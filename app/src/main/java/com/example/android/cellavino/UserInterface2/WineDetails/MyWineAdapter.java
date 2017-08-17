package com.example.android.cellavino.UserInterface2.WineDetails;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.cellavino.PojoDirectory.UI2.SpecificWineDetailsPojo;
import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.R;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;

/**
 * Created by Andrew on 29/04/2017.
 */

public class MyWineAdapter extends FirebaseListAdapter<SpecificWineDetailsPojo> {

    private WinePojo mWinePojo;
    private String mWinePushID;

    public MyWineAdapter(Activity activity, Class<SpecificWineDetailsPojo> modelClass, int modelLayout, Query ref, String winePushId) {
        super(activity, modelClass, modelLayout, ref);
        this.mActivity = activity;
        this.mWinePushID = winePushId;
    }

    public void setWineInformation(WinePojo winePojo) {
        this.mWinePojo = winePojo;
        this.notifyDataSetChanged();
    }

}
