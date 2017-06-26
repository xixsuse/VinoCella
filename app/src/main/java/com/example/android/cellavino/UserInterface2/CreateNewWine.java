package com.example.android.cellavino.UserInterface2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.cellavino.PojoDirectory.UI2.WinePojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.UserInterface.AddWine;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.firebase.client.ServerValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_LOCATION_USERS;

/**
 * Created by Andrew on 25/04/2017.
 */

public class CreateNewWine extends AppCompatActivity {

    public TextView mCreateWineName;
    public TextView mCreateWineWinery;
    public TextView mCreateWineVintage;
    public TextView mCreateWineVariety;
    public TextView mCreateWineTastingDate;
    public TextView mCreateWineDescription;
    public Button mCreateNewWine;
    public FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_wine);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mCreateWineVintage = (TextView) findViewById(R.id.create_wine_year);
        mCreateWineName = (TextView) findViewById(R.id.create_wine_name);
        mCreateWineWinery = (TextView) findViewById(R.id.create_wine_winery);
        mCreateWineVariety = (TextView) findViewById(R.id.create_wine_variety);
        mCreateWineTastingDate = (TextView) findViewById(R.id.create_wine_tasting_date);
        mCreateWineDescription = (TextView) findViewById(R.id.create_wine_description);
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
        String newWineToAddWinery = mCreateWineWinery.getText().toString();
        String newWineToAddVintage = mCreateWineVintage.getText().toString();
        String newWineToAddVariety = mCreateWineVariety.getText().toString();
        String newWineToAddTastingDate = mCreateWineTastingDate.getText().toString();
        String newWineToAddDescription = mCreateWineDescription.getText().toString();

        FirebaseUser user = mFirebaseAuth.getCurrentUser();
        String uid = user.getUid().toString();
        String userName = user.getDisplayName().toString();
        String taster = user.getDisplayName().toString();
        //String taster = "Andrew Marshall".toString();

        if (!mCreateWineName.equals("")) {
            //Write the wine details to the main wine database.
            Firebase wineNameRef = new Firebase(Constants.FIREBASE_URL_LOCATION_WINE_DETAILS);
            Firebase wineNameFirebaseRef = wineNameRef.push();
            final String winePushID = wineNameFirebaseRef.getKey();
            HashMap<String, Object> timestampCreated = new HashMap<>();
            timestampCreated.put(Constants.FIREBASE_PROPERTY_TIMESTAMP_CREATED, ServerValue.TIMESTAMP);

            //Building the wine POJO so that it can be added to Firebase.
            WinePojo winePojo = new WinePojo(newWineToAdd, newWineToAddWinery, newWineToAddVintage, newWineToAddVariety, taster, userName, uid, newWineToAddTastingDate, newWineToAddDescription, timestampCreated);

            // Go to the "WineListName" child node of the root node.  This will create the node for you if it doesn't already exist.
            // Then using the setValue menu it will set value the node to WineName.
            //Firebase wineNamePushID;
            wineNameFirebaseRef.setValue(winePojo);


            // then this part of the code will write the details that are needed to be put into the card under the uid.
            //myWineSummary

            Firebase myWinesRefLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(Constants.FIREBASE_MY_WINES).child(winePushID);
            myWinesRefLocation.setValue(winePojo);


            //This then resets the text to lank.
            mCreateWineName.setText("");
            mCreateWineWinery.setText("");
            mCreateWineVintage.setText("");
            mCreateWineVariety.setText("");
            mCreateWineTastingDate.setText("");
            mCreateWineDescription.setText("");

            //Send the user back the the wine list.  They'll be able to see all the wines they're recently added.
            Intent MyWinesList = new Intent(CreateNewWine.this, MyWinesList.class);
            // Start the new activity
            startActivity(MyWinesList);
        }

    }
}
