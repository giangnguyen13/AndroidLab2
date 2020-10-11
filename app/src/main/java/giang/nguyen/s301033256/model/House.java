package giang.nguyen.s301033256.model;

import android.graphics.drawable.Drawable;

public class House {

    private double price;
    private String address;
    private Drawable img;
    private String houseType;

    public House(double price, String address, Drawable img, String houseType) {
        this.price = price;
        this.address = address;
        this.img = img;
        this.houseType = houseType;
    }

    public House() {
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

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }
}
