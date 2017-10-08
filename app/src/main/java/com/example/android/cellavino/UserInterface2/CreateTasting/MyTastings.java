package com.example.android.cellavino.UserInterface2.CreateTasting;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.cellavino.Interfaces.UploadImageInterface;
import com.example.android.cellavino.MainActivity;
import com.example.android.cellavino.PojoDirectory.UI2.TastingDetailsPojo;
import com.example.android.cellavino.R;
import com.example.android.cellavino.Utils.Constants;
import com.example.android.cellavino.Utils.Utils;
import com.firebase.client.Firebase;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static com.example.android.cellavino.Utils.Constants.FIREBASE_MY_TASTINGS;
import static com.example.android.cellavino.Utils.Constants.FIREBASE_TASTING_NAME;
import static com.example.android.cellavino.Utils.Constants.FIREBASE_URL_EVERYONE_TASTING;
import static com.example.android.cellavino.Utils.Constants.LOCATION_PICKER_REQUEST;
import static com.example.android.cellavino.Utils.Constants.TASTING_GEO;


/**
 * Created by Andrew on 15/07/2017.
 */


public class MyTastings extends MainActivity {

    private Button mCreateTastingButton;
    private String mTastingName;
    public ImageView mTastingPicture;
    private Button addLocation;
    private ImageView mImageButton;
    public FirebaseAuth mFirebaseAuth;
    EditText mTastingNameInput;
    EditText mTastingSummaryInput;
    Button mCreateTasting;
    Place place = null;

    private Bitmap imageData;

    public MyTastings() {
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MyTastingsFragment()).commit();

        mFirebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = mFirebaseAuth.getCurrentUser();
        final String uid = user.getUid().toString();
        final String userName = user.getDisplayName().toString();

        //initialise the Floating Action Button in this fragment.
        FloatingActionButton addWineFab = (FloatingActionButton) findViewById(R.id.addWineFab);
        addWineFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.create_new_wine_tasting_summary);
                mTastingPicture = (ImageView) findViewById(R.id.tasting_photo);
                mTastingNameInput = (EditText) findViewById(R.id.create_tasting_name);
                mTastingSummaryInput = (EditText) findViewById(R.id.create_tasting_summary);
                mCreateTasting = (Button) findViewById(R.id.create_tasting);
                mImageButton = (ImageView) findViewById(R.id.image_button);

                mTastingPicture.setVisibility(View.GONE);

                addLocation = (Button) findViewById(R.id.add_location);
                addLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                        try {
                            startActivityForResult(builder.build(MyTastings.this), LOCATION_PICKER_REQUEST);
                        } catch (GooglePlayServicesRepairableException e) {
                            e.printStackTrace();
                        } catch (GooglePlayServicesNotAvailableException e) {
                            e.printStackTrace();
                        }

                    }
                });

                mImageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                        File photo = new File(Environment.getExternalStorageDirectory(), "capture.jpg");
//                        intent.putExtra(MediaStore.EXTRA_OUTPUT, FileProvider.getUriForFile(MyTastings.this,"com.example.android.fileprovider",photo));
//                        imageUri = FileProvider.getUriForFile(MyTastings.this,"com.example.android.fileprovider",photo);
                        startActivityForResult(intent, Constants.TAKE_PICTURE);
                    }
                });

                mCreateTasting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (mTastingNameInput.getText().toString().isEmpty() && mTastingSummaryInput.getText().toString().isEmpty())
                        {
                            showAlert("You've left something blank... ", "Error");
                        } else if (imageData == null)
                        {
                            showAlert("Please Select an Image", "Error");
                        } else{
                            String mTastingName = mTastingNameInput.getText().toString();
                            createTastingInFirebase(mTastingName, uid, userName, imageData);
                        }
                    }

                });


            }
        });
                /*
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MyTastings.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_create_tasting, null);
                final EditText mTastingNameInput = (EditText) mView.findViewById(R.id.dialog_create_tasting_name_input);
                alertDialogBuilder.setPositiveButton("Create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!mTastingNameInput.getText().toString().isEmpty()) {
                            String mTastingName = mTastingNameInput.getText().toString();
                            addWineTastingPicture(mTastingName, uid, userName);

                        } if (mTastingNameInput.getText().toString().isEmpty()) {
                            Toast.makeText(MyTastings.this, "You've got to name a tasting first!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                alertDialogBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alertDialogBuilder.setView(mView);
                AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();
            }

        });
        */


    }

    public void showAlert(String message, String title)
    {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(MyTastings.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(MyTastings.this);
        }
        builder.setTitle("Title")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })

                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOCATION_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                place = PlacePicker.getPlace(data, this);
                mTastingSummaryInput.setText(place.getAddress().toString());
            }
        }
        if (requestCode == Constants.TAKE_PICTURE) {
            if (resultCode == RESULT_OK) {
                imageData = (Bitmap) data.getExtras().get("data");
                mTastingPicture.setImageBitmap(imageData);
                mTastingPicture.setVisibility(View.VISIBLE);
                mImageButton.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(MyTastings.this, "Opps We've had an issue", Toast.LENGTH_SHORT).show();
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

    //TODO: replace with with a create winetasting screen "create_new_wine_tasting_summary"
    //This will allow the user to add a picture of the set of wines they are about to taste
    private void addWineTastingPicture(String mTastingName, String uid, String userName) {

        final String mMTastingName = mTastingName.toString();
        final String mUid = uid.toString();
        final String mUserName = userName.toString();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MyTastings.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_add_wine_tasting_photo, null);
        alertDialogBuilder.setPositiveButton("Add Picture", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                createTastingInFirebase(mMTastingName, mUid, mUserName);
            }
        });

        alertDialogBuilder.setNegativeButton("Skip", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                createTastingInFirebase(mMTastingName, mUid, mUserName);
            }
        });

        alertDialogBuilder.setView(mView);
        AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();

    }


    private void createTastingInFirebase(final String mTastingName, final String uid, final String userName, Bitmap bitmap) {

        Firebase tastingRef = new Firebase(Constants.FIREBASE_URL_TASTINGS);
        Firebase tastingFirebaseRef = tastingRef.push();
        final String tastingPushID = tastingFirebaseRef.getKey();

        uploadFile(bitmap, tastingPushID, new UploadImageInterface() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot snapshot) {

                Uri downloadUrl = snapshot.getDownloadUrl();
                Log.d("downloadUrl-->", "" + downloadUrl);
                Firebase myTastingsLocation = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS).child(uid).child(FIREBASE_MY_TASTINGS)
                        .child(tastingPushID).child(FIREBASE_TASTING_NAME);
                myTastingsLocation.setValue(mTastingName);
                Firebase myTastingsLocationOwner = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS)
                        .child(uid).child(FIREBASE_MY_TASTINGS).child(tastingPushID).child(Constants.FIREBASE_OWNER);
                myTastingsLocationOwner.setValue(userName);

                //Sets the url of the photo into firebase
                Firebase myTastingsImageUrl = new Firebase(Constants.FIREBASE_URL_LOCATION_USERS)
                        .child(uid).child(FIREBASE_MY_TASTINGS).child(tastingPushID).child(Constants.FIREBASE_IMAGE_URL);
                myTastingsImageUrl.setValue(downloadUrl.toString());

                // this is for everyone tasting so we can easily query them instead of going to every user
                Firebase everyoneTasting = new Firebase(FIREBASE_URL_EVERYONE_TASTING);
                TastingDetailsPojo tastingDetailsPojo =
                        new TastingDetailsPojo(mTastingName, userName, place.getLatLng().latitude, place.getLatLng().longitude, uid);
                everyoneTasting.child(tastingPushID).setValue(tastingDetailsPojo);


                // saving the tasting Location;
                TASTING_GEO.setLocation(tastingPushID, new GeoLocation(place.getLatLng().latitude, place.getLatLng().longitude));






                //TODO: Save details of when the tasting was created and who by etc.
                //HashMap<String, Object> myTastingName = new HashMap<>();
                //myTastingName.put(mTastingName, ServerValue.TIMESTAMP);

                //TODO: This is where I should add the second AlertDialogBuilder, a positive response will direct people
                //TODO: cont.. to upload an image, a negative response will simply dismiss the dialog.

                Intent CreateTasting = new Intent(MyTastings.this, CreateNewTasting.class);
                CreateTasting.putExtra("thisTastingName", mTastingName);
                CreateTasting.putExtra("thisTastingPushID", tastingPushID);

                startActivity(CreateTasting);

            }

            @Override
            public void onFailure(@NonNull Exception exception) {

            }
        });

    }

    //This is the code that uploads the image into Firebase Storage.
    private void uploadFile(Bitmap bitmap, String tastingPushId, final UploadImageInterface uploadImageInterface) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl(Constants.STORAGE_URL);
        StorageReference mountainImagesRef = null;
        try {
            mountainImagesRef = storageRef.child("Wine Photos/" + URLEncoder.encode(tastingPushId + ".jpg", "UTF-8"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos);
            byte[] data = baos.toByteArray();
            UploadTask uploadTask = mountainImagesRef.putBytes(data);
            uploadTask.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle unsuccessful uploads
                    uploadImageInterface.onFailure(exception);
                }
            }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                    uploadImageInterface.onSuccess(taskSnapshot);
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

}

