package com.example.android.cellavino.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.cellavino.PojoDirectory.UI2.TastingDetailsPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface2.JoinTasting.JoinTastingWines;
import com.example.android.cellavino.Utils.Constants;
import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;

/**
 * Created by Fady on 2017-10-06.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    Context context;
    ArrayList<TastingDetailsPojo> markerArrayList;

    public RecyclerAdapter(Context context, ArrayList<TastingDetailsPojo> markers) {
        this.context = context;
        this.markerArrayList = markers;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.title_layout, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.tasteTitle.setText(Html.fromHtml("<b>Name:  </b>" +markerArrayList.get(position).getName()));
        holder.tasteOwner.setText(Html.fromHtml("<b>Owner:  </b>" +markerArrayList.get(position).getOwner()));
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JoinTastingWines.class);
                String tasting_listId = markerArrayList.get(position).getTasteUid();
                intent.putExtra(Constants.TASTING_LIST_ID, tasting_listId);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return markerArrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tasteTitle;
        TextView tasteOwner;
        LinearLayout layout;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tasteTitle = (TextView) itemView.findViewById(R.id.markerTitle);
            tasteOwner = (TextView) itemView.findViewById(R.id.markerOwner);
            layout = (LinearLayout) itemView.findViewById(R.id.cardLayout);
        }
    }
}
