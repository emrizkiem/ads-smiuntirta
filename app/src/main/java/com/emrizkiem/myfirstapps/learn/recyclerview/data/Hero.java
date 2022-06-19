package com.emrizkiem.myfirstapps.learn.recyclerview.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {
    private String name;
    private String description;
    private Integer photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeInt(this.photo);
    }

    public Hero() {}

    private Hero(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.photo = in.readInt();
    }

    public static final Parcelable.Creator<Hero> CREATOR = new Parcelable.Creator<Hero>() {

        @Override
        public Hero createFromParcel(Parcel parcel) {
            return new Hero(parcel);
        }

        @Override
        public Hero[] newArray(int i) {
            return new Hero[i];
        }
    };
}


