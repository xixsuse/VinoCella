package com.example.android.cellavino.UserInterface;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.bumptech.glide.Glide;
import com.example.android.cellavino.PojoDirectory.WineDetails;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

/**
 * Created by Andrew on 25/03/2017.
 */


public class AddWine extends AppCompatActivity {

    public static final String ANONYMOUS = "anonymous";

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mWineDatabaseReference;
    private FirebaseStorage mFirebaseStorage;
    private StorageReference mWinePhotosStorageReference;
    private ChildEventListener mChildEventListener;

    public static final int RC_PHOTO_PICKER = 2;
    private static final int CAMERA_REQUEST_CODE = 3;


    private String mUsername;
    private Button mAddNewWine;

    private FloatingActionButton mAddWinePhotoFab;
    private Uri mWinePhotoUrl;
    private ImageView mWinePhoto;
    private EditText mWineName;
    private EditText mWineryName;
    private EditText mVintage;
    private EditText mGrapeVariety;
    private EditText mTastingDate;
    private EditText mWineDescription;
    private TextView myWineRatingNumber;
    private RatingBar mMyWineRating;
    private ImageSwitcher mTasteSwitch;
    private Button mNext;
    private Button mPrevious;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_wine);


        mUsername = ANONYMOUS;

        mFirebaseStorage = FirebaseStorage.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mWineDatabaseReference = mFirebaseDatabase.getReference().child("Wine Details");
        mWinePhotosStorageReference = mFirebaseStorage.getReference().child("Wine Photos");


        //intialise references to views
        mWinePhoto = (ImageView) findViewById(R.id.add_wine_photo);
        mAddWinePhotoFab = (FloatingActionButton) findViewById(R.id.addWinePhotoFab);
        mWineName = (EditText) findViewById(R.id.wineName);
        mWineryName = (EditText) findViewById(R.id.wineryName);
        mVintage = (EditText) findViewById(R.id.vintage);
        mGrapeVariety = (EditText) findViewById(R.id.grapeVariety);
        mTastingDate = (EditText) findViewById(R.id.tastingDate);
        mWineDescription = (EditText) findViewById(R.id.wine_description);
        mAddNewWine = (Button) findViewById(R.id.add_new_wine);
        mMyWineRating = (RatingBar) findViewById(R.id.my_wine_rating);
        myWineRatingNumber = (TextView) findViewById(R.id.my_wine_rating_number);
        mTasteSwitch = (ImageSwitcher) findViewById(R.id.switcher_taste_one);
        mPrevious = (Button) findViewById(R.id.previous_flavour);
        mNext = (Button) findViewById(R.id.next_flavour);
        mProgress = new ProgressDialog(this);


        mMyWineRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar myWineRating, float wineRating, boolean fromUser) {
                myWineRatingNumber.setText("My Rating: " + wineRating);
            }
        });

        mTasteSwitch.setFactory(new ViewSwitcher.ViewFactory(){
            @Override
            public View makeView(){
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });





        mNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mTasteSwitch.setImageResource(R.drawable.aa_grapefruit);

            }
        });

        mPrevious.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mTasteSwitch.setImageResource(R.drawable.ab_lemon);
            }
        });

        mAddNewWine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewWineToDatabase();
            }

            public void addNewWineToDatabase() {
                WineDetails wineDetails = new WineDetails(mWineName.getText().toString(), mWineryName.getText().toString(), mVintage.getText().toString(), mGrapeVariety.getText().toString(), mTastingDate.getText().toString(), mWineDescription.getText().toString(), mMyWineRating.getRating(), mWinePhotoUrl.toString());
                mWineDatabaseReference.push().setValue(wineDetails);

                // Clear input box
                mWineName.setText("");
                mWineryName.setText("");
                mVintage.setText("");
                mGrapeVariety.setText("");
                mTastingDate.setText("");
                mWineDescription.setText("");

                //if (!wineDetails.equals(""))
                //{
                //    Firebase wineDetails2 = new Firebase(Constants.FIREBASE_LOCATION_WINE_DETAILS);
                //    Firebase newDetailsRef = wineDetails2.push();
                //    /* Save wineDetails2.push() to maintain same random Id */
                //    final String listId = newDetailsRef.getKey();
                //}
                // Create a new intent to go back to the home screen
                Intent MainActivity = new Intent(AddWine.this, MainActivity.class);
                // Start the new activity
                startActivity(MainActivity);


            }

        });


        // ImagePickerButton shows an image picker to upload a image for a message
        mAddWinePhotoFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);
                //startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });

    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK){

            Uri selectedImageUri = data.getData();

            StorageReference photoRef = mWinePhotosStorageReference.child(selectedImageUri.getLastPathSegment());

            //upload file to firebase
            photoRef.putFile(selectedImageUri)
                    .addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //when the image is uploaded

                            Uri downloadUrl = taskSnapshot.getDownloadUrl();
                            mWinePhotoUrl = downloadUrl;

                            Glide.with(AddWine.this).load(downloadUrl).centerCrop().into(mWinePhoto);

                            //WineDetails wineDetails = new WineDetails(null, null, null, null, null, null, null, downloadUrl.toString());
                            //mWineDatabaseReference.push().setValue(wineDetails);

                            Toast.makeText(AddWine.this, "Photo uploaded", Toast.LENGTH_SHORT).show();
                        }
                    });


            //ImageView addWineView = (ImageView) addWineView.findViewById(R.id.add_wine_photo);
            //winePhotoView.setVisibility(View.VISIBLE);
            //mWinePhoto.setVisibility(View.VISIBLE);
            //Glide.with(mWinePhoto.getContext())
            //        .load(mWinePhoto.getWinePhotoUrl())
            //        .centerCrop()
            //        .into(mWinePhoto);
        }
    }


}