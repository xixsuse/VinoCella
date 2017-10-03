package com.example.android.cellavino.Interfaces;

import android.support.annotation.NonNull;

import com.google.firebase.storage.UploadTask;

/**
 * Created by jhade on 10/3/2017.
 */

public interface UploadImageInterface {
    void onSuccess(UploadTask.TaskSnapshot snapshot);
    void onFailure(@NonNull Exception exception);
}
