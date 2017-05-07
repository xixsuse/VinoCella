package com.example.android.cellavino.UserInterface;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.cellavino.PojoDirectory.WinePojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.ServerValue;

import org.w3c.dom.Text;

import java.util.HashMap;

/**
 * Created by Andrew on 25/04/2017.
 */

public class CreateNewWine extends AppCompatActivity {

    public TextView mCreateWineName;
    public TextView mCreateWineVintage;
    public Button mCreateNewWine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_wine);
        mCreateWineVintage = (TextView) findViewById(R.id.create_wine_year);
        mCreateWineName = (TextView) findViewById(R.id.create_wine_name);
        mCreateNewWine = (Button) findViewById(R.id.create_new_wine_button);

        //set the click listener on the button that  pushes wine into the database
        mCreateNewWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWineToDatabase();
            }
        });
    }


    //This part here adds a wine to the wineName details part of the Firebase database.
    //First by taking the Firebase URL from CONSTANTS, then by taking the details the user has entered and passing them into a String.
    //These details are passed into a POJO, along with the time created TIMESTAMP.

    public void addWineToDatabase() {
        //get the reference to the Firebase URL, then get the string that user has entered and push that into the Database.
        // Get the dtails that the user has entered and pass them into a string.
        String newWineToAdd = mCreateWineName.getText().toString();
        String newWineToAddVintage = mCreateWineVintage.getText().toString();
        String taster = "Andrew Marshall".toString();

        if (!mCreateWineName.equals("")) {
            Firebase wineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS);

            Firebase wineNameFirebaseRef = wineNameRef.push();
            final String winePushID = wineNameFirebaseRef.getKey();


            HashMap<String, Object> timestampCreated = new HashMap<>();
            timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP_CREATED, ServerValue.TIMESTAMP);

            //Building the wine POJO so that it can be added to Firebase.
            WinePojo winePojo = new WinePojo(newWineToAdd, newWineToAddVintage, taster, timestampCreated);

            // Go to the "WineListName" child node of the root node.  This will create the node for you if it doesn't already exist.
            // Then using the setValue menu it will set value the node to WineName.
            //Firebase wineNamePushID;
            wineNameFirebaseRef.setValue(winePojo);

            //This then resets the text to Blank, and returns the user to the ABC activity.
            mCreateWineName.setText("");
            mCreateWineVintage.setText("");

            //TODO send the customer back to the desired activyt.
        }

    }
}
