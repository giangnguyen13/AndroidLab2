package giang.nguyen.s301033256;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import giang.nguyen.s301033256.model.House;

/**
 * Lab 2 - Assignment
 * Student Name: Giang Nguyen
 * Student# 301033256
 * Professor: Haki Sharifi
 * COMP 304 - 002
 * */

public class NguyenCondoHouseActivity extends AppCompatActivity {

    private ArrayList<House> selectedHouses = new ArrayList<House>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giang_condo_house);

        LinearLayout linearLayout = findViewById(R.id.giangCondoLinearLayout);
        for (final House house : this.getCondoHouses())
        {
            TextView address = new TextView(this);
            address.setText(house.getAddress());
            address.setTextColor(getResources().getColor(R.color.info));
            address.setTextSize(getResources().getDimension(R.dimen.address_text));
            TextView price = new TextView(this);
            price.setText("$ "+house.getPrice());
            price.setTextColor(getResources().getColor(R.color.success));
            price.setTextSize(getResources().getDimension(R.dimen.price_text));
            ImageView image = new ImageView(this);
            image.setMaxHeight(50);
            //image.setMaxWidth(50);
            image.setImageDrawable(this.getImg(house.getImgSource()));
            final CheckBox virtualVisit = new CheckBox(this);
            final CheckBox physicalVisit = new CheckBox(this);
            virtualVisit.setText("Visit Virtually");
            virtualVisit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean checkedVirtual = virtualVisit.isChecked();
                    boolean checkedPhysical = physicalVisit.isChecked();
                    // Check which checkbox was clicked
                    if (checkedVirtual == false && checkedPhysical == false){
                        selectedHouses = this.removeHouse(selectedHouses,house);
                    }
                    else{
                        selectedHouses = this.addHouse(selectedHouses,house);
                    }
                }

                public ArrayList<House> addHouse(ArrayList<House> list, House house){
                    if (!list.contains(house)){
                        list.add(house);
                    }
                    return list;
                }

                public ArrayList<House> removeHouse(ArrayList<House> list, House house){
                    if (list.contains(house)){
                        list.remove(house);
                    }
                    return list;
                }
            });

            physicalVisit.setText("Visit Physically");
            physicalVisit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean checkedVirtual = virtualVisit.isChecked();
                    boolean checkedPhysical = physicalVisit.isChecked();
                    // Check which checkbox was clicked
                    if (checkedVirtual == false && checkedPhysical == false){
                        selectedHouses = this.removeHouse(selectedHouses,house);
                    }
                    else{
                        selectedHouses = this.addHouse(selectedHouses,house);
                    }
                }

                public ArrayList<House> addHouse(ArrayList<House> list, House house){
                    if (!list.contains(house)){
                        list.add(house);
                    }
                    return list;
                }

                public ArrayList<House> removeHouse(ArrayList<House> list, House house){
                    if (list.contains(house)){
                        list.remove(house);
                    }
                    return list;
                }
            });

            linearLayout.addView(image);
            linearLayout.addView(price);
            linearLayout.addView(address);
            linearLayout.addView(virtualVisit);
            linearLayout.addView(physicalVisit);
        }

        Button paymentBtn = new Button(this);
        paymentBtn.setText(R.string.submit);
        linearLayout.addView(paymentBtn);
        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NguyenCondoHouseActivity.this, NguyenCheckoutActivity.class);

                ArrayList<String> ar=new ArrayList<String>();
                for (House house : selectedHouses){
                    String houseString = house.getHouseType() + "--" + house.getAddress() + "--" +
                            house.getPrice() + "--" + house.getImgSource();
                    ar.add(houseString);
                }
                intent.putStringArrayListExtra("list", ar);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent startIntent;
        switch (item.getItemId()){
            case R.id.apartment:
                Toast.makeText(this,"Select Apartment House type", Toast.LENGTH_SHORT).show();
                startIntent = new Intent(getApplicationContext(), NguyenApartmentActivity.class);
                startActivity(startIntent);
                return true;
            case R.id.semi_detached:
                Toast.makeText(this,"Select Semi-Detached House type", Toast.LENGTH_SHORT).show();
                startIntent = new Intent(getApplicationContext(), NguyenSemiDetachedActivity.class);
                startActivity(startIntent);
                return true;
            case R.id.town_house:
                Toast.makeText(this,"Select Town House House type", Toast.LENGTH_SHORT).show();
                startIntent = new Intent(getApplicationContext(), NguyenTownHouseActivity.class);
                startActivity(startIntent);
                return true;
            case R.id.condo:
                Toast.makeText(this,"Select Condo House type", Toast.LENGTH_SHORT).show();
                startIntent = new Intent(getApplicationContext(), NguyenCondoHouseActivity.class);
                startActivity(startIntent);
                return true;
            case R.id.detached_home:
                Toast.makeText(this,"Select Detached Home House type", Toast.LENGTH_SHORT).show();
                startIntent = new Intent(getApplicationContext(), NguyenDetachedActivity.class);
                startActivity(startIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public ArrayList<House> getCondoHouses(){
        ArrayList<House> list = new ArrayList<House>();

        House house1 = new House(550000, "48 Spring Forest Sq", "house1","Condominium apartment");
        list.add(house1);
        House house2 = new House(600000, "60 Glenstroke Drive", "house2","Condominium apartment");
        list.add(house2);
        House house3 = new House(300000, "2 Queen Street", "house3","Condominium apartment");
        list.add(house3);
        House house4 = new House(700000, "123 Dundas East Street", "house4","Condominium apartment");
        list.add(house4);
        House house5 = new House(750000, "77 College East Street", "house5","Condominium apartment");
        list.add(house5);
        House house6 = new House(800000, "4500 Sheppard Ave East", "house6","Condominium apartment");
        list.add(house6);
        return list;
    }

    public Drawable getImg(String imgSource){
        Drawable drawableObj = getDrawable(getResources().getIdentifier(imgSource, "drawable", getPackageName()));
        return drawableObj;
    }
}