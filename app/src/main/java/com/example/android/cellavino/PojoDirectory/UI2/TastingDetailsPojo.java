package com.example.android.cellavino.PojoDirectory.UI2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Fady on 2017-09-10.
 */

public class TastingDetailsPojo implements Parcelable {

    public TastingDetailsPojo() {
    }

    public TastingDetailsPojo(String name, String owner, double latitude, double longitude, String ownerUid) {
        this.name = name;
        this.owner = owner;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ownerUid = ownerUid;
    }

    private String name;
    private String owner;
    private double latitude;
    private double longitude;
    private String ownerUid;


    protected TastingDetailsPojo(Parcel in) {
        name = in.readString();
        owner = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        ownerUid = in.readString();
    }

    public static final Creator<TastingDetailsPojo> CREATOR = new Creator<TastingDetailsPojo>() {
        @Override
        public TastingDetailsPojo createFromParcel(Parcel in) {
            return new TastingDetailsPojo(in);
        }

        @Override
        public TastingDetailsPojo[] newArray(int size) {
            return new TastingDetailsPojo[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getOwnerUid() {
        return ownerUid;
    }


    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     * @see #CONTENTS_FILE_DESCRIPTOR
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(owner);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeString(ownerUid);
    }
}
