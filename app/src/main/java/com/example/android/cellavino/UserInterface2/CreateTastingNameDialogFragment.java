package com.example.android.cellavino.UserInterface2;

import android.app.Dialog;
import android.os.Bundle;

import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;

/**
 * Created by Andrew on 15/07/2017.
 */

public class CreateTastingNameDialogFragment extends CreateTastingFragment {

    private static final String LOG_TAG = CreateTasting.class.getSimpleName();
    String mTastingName;


    /**
     * Public static constructor that creates fragment and passes a bundle with data into it when adapter is created
     * <p>
     * <p>
     * public static CreateTastingNameDialogFragment newInstance(ShoppingList shoppingList, String listId) {
     * CreateTastingNameDialogFragment editListNameDialogFragment = new CreateTastingNameDialogFragment();
     * Bundle bundle = CreateTastingNameDialogFragment.newInstanceHelper(shoppingList, R.layout.dialog_edit_list, listId);
     * bundle.putString(Constants.FIREBASE_MY_TASTINGS, shoppingList.getListName());
     * editListNameDialogFragment.setArguments(bundle);
     * return editListNameDialogFragment;
     * }
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTastingName = getArguments().getString(Constants.FIREBASE_MY_TASTING_NAME);


    }


    /**
     @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
     // {@link EditListDialogFragment#createDialogHelper(int)} is a
     // superclass method that creates the dialog


     Dialog dialog = super.createDialogHelper(R.string.tasting_name);

     helpSetDefaultValueEditText(mListName);
     return dialog;
     }
     ***/

}
