package giang.nguyen.s301033256;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

import giang.nguyen.s301033256.model.House;

/**
 * Lab 2 - Assignment
 * Student Name: Giang Nguyen
 * Student# 301033256
 * Professor: Haki Sharifi
 * COMP 304 - 002
 * */

public class NguyenCheckoutActivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_checkout);

        ArrayList<String> ar1=getIntent().getExtras().getStringArrayList("list");
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.giangRadioGroup);
        for(String s : ar1){
            String[] house = s.split("--");
            TextView address = new TextView(this);
            address.setText(house[1]);
            address.setTextColor(getResources().getColor(R.color.info));
            address.setTextSize(getResources().getDimension(R.dimen.address_text));
            TextView price = new TextView(this);
            price.setText("$ "+house[2]);
            price.setTextColor(getResources().getColor(R.color.success));
            price.setTextSize(getResources().getDimension(R.dimen.price_text));
            ImageView image = new ImageView(this);
            image.setImageDrawable(this.getImg(house[3]));
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText("Buy this house");
            radioGroup.addView(image);
            radioGroup.addView(price);
            radioGroup.addView(address);
            radioGroup.addView(radioButton);
        }


        Button checkoutBtn = (Button)findViewById(R.id.giangPayBtn);
        builder = new AlertDialog.Builder(this);
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radioGroup.getCheckedRadioButtonId() == -1)
                {
                    //Setting message manually and performing action on button click
                    builder.setMessage(R.string.selection_error)
                            .setCancelable(false)
                            .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    //Creating dialog box
                    AlertDialog alert = builder.create();
                    //Setting the title manually
                    alert.setTitle("Error");
                    alert.show();
                }
                else
                {
                    Intent startIntent = new Intent(getApplicationContext(), NguyenPaymentActivity.class);
                    startIntent.putExtra("message","This text is fromm intent object of checkout activity");
                    startActivity(startIntent);
                }
            }
        });
    }

    public Drawable getImg(String imgSource){
        Drawable drawableObj = getDrawable(getResources().getIdentifier(imgSource, "drawable", getPackageName()));
        return drawableObj;
    }
}