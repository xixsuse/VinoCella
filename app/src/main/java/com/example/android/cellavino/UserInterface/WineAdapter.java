package com.example.android.cellavino.UserInterface;

/**
 * Created by Andrew on 30/03/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.cellavino.PojoDirectory.UI1.WineDetails;
import com.example.android.cellavino.R;


import java.util.List;


// this is adapts the wine details so they can be populated as a list of all the wines that a user has in their database.

public class WineAdapter extends ArrayAdapter<WineDetails> {

    //constructing a new WineAdapter, where wineDetails is the list of all the wines that are in the database.
    public WineAdapter(Context context, int resource, List<WineDetails> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent) {
        //this will first check if there is a list item there, and then populate below it.  if there is nothing a new view will be created.
        if (listItemView == null) {
            listItemView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.wine_list_item, parent, false);
        }

        TextView wineNameTextView = (TextView) listItemView.findViewById(R.id.wine_name);
        TextView wineryNameTextView = (TextView) listItemView.findViewById(R.id.winery_name);
        TextView wineVintageTextView = (TextView) listItemView.findViewById(R.id.vintage);
        TextView wineGrapeVarietyTextView = (TextView) listItemView.findViewById(R.id.grape_variety);
        TextView wineDescriptionTextView = (TextView) listItemView.findViewById(R.id.wine_details);
        ImageView winePhotoView = (ImageView) listItemView.findViewById(R.id.wine_photo);

        WineDetails winedetails = getItem(position);

        boolean isPhoto = winedetails.getWinePhotoUrl() != null;
        if (isPhoto) {
            wineNameTextView.setVisibility(View.VISIBLE);
            wineNameTextView.setText(winedetails.getWineName());
            wineryNameTextView.setVisibility(View.VISIBLE);
            wineryNameTextView.setText(winedetails.getWineryName());
            wineVintageTextView.setVisibility(View.VISIBLE);
            wineVintageTextView.setText(winedetails.getWineYear());
            wineGrapeVarietyTextView.setVisibility(View.VISIBLE);
            wineGrapeVarietyTextView.setText(winedetails.getGrapeType());
            wineDescriptionTextView.setVisibility(View.VISIBLE);
            wineDescriptionTextView.setText(winedetails.getWineDescription());
            winePhotoView.setVisibility(View.VISIBLE);
            Glide.with(winePhotoView.getContext())
                    .load(winedetails.getWinePhotoUrl())
                    .centerCrop()
                    .into(winePhotoView);
        } else {
            wineNameTextView.setVisibility(View.VISIBLE);
            wineNameTextView.setText(winedetails.getWineName());
            wineryNameTextView.setVisibility(View.VISIBLE);
            wineryNameTextView.setText(winedetails.getWineryName());
            wineVintageTextView.setVisibility(View.VISIBLE);
            wineVintageTextView.setText(winedetails.getWineYear());
            wineGrapeVarietyTextView.setVisibility(View.VISIBLE);
            wineGrapeVarietyTextView.setText(winedetails.getGrapeType());
            wineDescriptionTextView.setVisibility(View.VISIBLE);
            wineDescriptionTextView.setText(winedetails.getWineDescription());
            winePhotoView.setVisibility(View.GONE);
        }
        return listItemView;

    }

}
