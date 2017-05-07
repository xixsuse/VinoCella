package com.example.android.cellavino.UserInterface;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.cellavino.PojoDirectory.WinePojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;

/**
 * Created by Andrew on 6/05/2017.
 */

public class MyWines extends Fragment {
    private ListView mListView;
    private WinePojo mActiveListAdapter;


    /* Required empty public constructor */
    public MyWines() {

    }

    public static MyWines newInstance() {
        MyWines fragment = new MyWines();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    //@Override
    //public View onCreateView(LayoutInflater inflater, ViewGroup container,
    //                         Bundle savedInstanceState) {
    /**
     * Initalize UI elements
     */
    //    View rootView = inflater.inflate(R.layout.my_wines_list, container, false);
    //    initializeScreen(rootView);

    //    Firebase myWinesDetails = new Firebase(Constants.FIREBASE_URL);

    //    mActiveListAdapter = new ActiveListAdapter(getActivity(), WinePojo.class,
    //            R.layout.single_active_list, activeListsRef);

    /**
     * Set the adapter to the mListView
     */
    //    mListView.setAdapter(mActiveListAdapter);


    /**
     * Set interactive bits, such as click events and adapters
     */
    //  mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    //      @Override
    //      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    //          ShoppingList selectedList = mActiveListAdapter.getItem(position);
    //         if (selectedList != null){
    //              Intent intent = new Intent(getActivity(), ActiveListDetailsActivity.class);
    //              String listId = mActiveListAdapter.getRef(position).getKey();
    //              intent.putExtra(Constants.KEY_LIST_ID, listId);
    //              startActivity(intent);
    //          }
    //      }
    //  });

    //  return rootView;
    //}
    //@Override
    //public void onDestroy() {
    //    super.onDestroy();
    //    mActiveListAdapter.cleanup();

    //}

    /**
     * Link listView elements from XML
     */
    //private void initializeScreen(View rootView) {
    //    mListView = (ListView) rootView.findViewById(R.id.list_view_active_lists);
    //}
}