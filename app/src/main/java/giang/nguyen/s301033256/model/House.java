package giang.nguyen.s301033256.model;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Lab 2 - Assignment
 * Student Name: Giang Nguyen
 * Student# 301033256
 * Professor: Haki Sharifi
 * COMP 304 - 002
 * */

public class House implements Parcelable {

    private double price;
    private String address;
    private String houseType;

    private String imgSource;

    public House(double price, String address, String imgSource, String houseType) {
        this.price = price;
        this.address = address;
        this.imgSource = imgSource;
        this.houseType = houseType;
    }

    public House() {
    }

    protected House(Parcel in) {
        price = in.readDouble();
        address = in.readString();
        houseType = in.readString();
    }

    public static final Creator<House> CREATOR = new Creator<House>() {
        @Override
        public House createFromParcel(Parcel in) {
            return new House(in);
        }

        @Override
        public House[] newArray(int size) {
            return new House[size];
        }
    };

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(price);
        dest.writeString(address);
        dest.writeString(houseType);
        dest.writeString(imgSource);
    }
}
