package com.example.android.cellavino.UserInterface;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
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
import android.net.Uri;

import com.bumptech.glide.Glide;
import com.example.android.cellavino.PojoDirectory.UI1.WineDetails;
import com.example.android.cellavino.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.bitmap;

/**
 * Created by Andrew on 25/03/2017.
 */


public class AddWine extends AppCompatActivity {

    public static final String ANONYMOUS = "anonymous";
    public static final int RC_PHOTO_PICKER = 1;
    public static final int CAMERA_REQUEST_CODE = 1;
    public static final int ACTION_IMAGE_CAPTURE = 1;

    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseStorage mFirebaseStorage;
    private DatabaseReference mWineDatabaseReference;
    private StorageReference mWinePhotosStorageReference;
    private ChildEventListener mChildEventListener;


    private String mCurrentPhotoPath;
    private String mUsername;
    private Button mAddNewWine;

    private FloatingActionButton mAddWinePhotoFab;
    private Uri mWinePhotoUrl;
    private Uri photoURI;
    //private String mWinePhotoUrl;
    private ImageView mWinePhotoImageView;
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
        mWinePhotoImageView = (ImageView) findViewById(R.id.add_wine_photo);
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

        mMyWineRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar myWineRating, float wineRating, boolean fromUser) {
                myWineRatingNumber.setText("My Rating: " + wineRating);
            }
        });

        mTasteSwitch.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });


        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTasteSwitch.setImageResource(R.drawable.aa_grapefruit);

            }
        });

        mPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                Intent MainActivity = new Intent(AddWine.this, com.example.android.cellavino.MainActivity.class);
                // Start the new activity
                startActivity(MainActivity);
            }
        });

        // ImagePickerButton shows an image picker to upload a image for a from the camera.
        mAddWinePhotoFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhotoIntent();


                //this was the code that got the photopicker to work.

                //Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                ////Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //intent.setType("image/jpeg");
                //intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                //startActivityForResult(Intent.createChooser(intent, "Complete action using"), RC_PHOTO_PICKER);
            }
        });

    }

    private void takePhotoIntent() {
        Intent takeAPhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takeAPhotoIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File...
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);

                takeAPhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takeAPhotoIntent, CAMERA_REQUEST_CODE);
            }
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {

            mProgress = new ProgressDialog(this);
            mProgress.setMessage("Uploding image...");
            mProgress.show();

            Uri selectedImageUri = data.getData();

            //Firebase storage folder where you want to put the images
            StorageReference photoRef = mWinePhotosStorageReference.child(selectedImageUri.getLastPathSegment());

            //upload file to firebase
            photoRef.putFile(photoURI).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //when the image is uploaded
                    //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                    //mWinePhotoUrl = downloadUrl;
                    //Glide.with(AddWine.this).load(downloadUrl).centerCrop().into(mWinePhoto);

                    mProgress.dismiss();
                    Toast.makeText(AddWine.this, "Photo uploaded", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(AddWine.this, "Upload Failed!", Toast.LENGTH_SHORT).show();

                }
            })
            ;

        }

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }
}