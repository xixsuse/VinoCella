package com.example.android.cellavino.UserInterface2.JoinTasting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;

/**
 * Created by Andrew on 16/08/2017.
 */

public class JoinTastingWinesFragment extends Fragment {

    private String mWineTastingId;


    public JoinTastingWinesFragment() {
    }


    public static JoinTastingWinesFragment newInstance() {
        JoinTastingWinesFragment fragment = new JoinTastingWinesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, new JoinTastingFragment()).commit();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getActivity(), "This works", Toast.LENGTH_SHORT).show();

        /*

        Intent intent = getActivity().getIntent();
        mWineTastingId = intent.getStringExtra(Constants.TASTING_ID);
        if (mWineTastingId == null) {
            //finish();
            Toast.makeText(getActivity(), "No Tasting Details", Toast.LENGTH_SHORT).show();
            //getActivity().finish();
            //return;
        }
        if (mWineTastingId != null) {
            Toast.makeText(getActivity(), "Tastings Found", Toast.LENGTH_SHORT).show();
            return;
        }

        //TODO: Add a message that says 'no wines found' if the list items equal zero.

         */


    }


}

