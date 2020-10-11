package giang.nguyen.s301033256;

import androidx.appcompat.app.AppCompatActivity;

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

public class NguyenCheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_checkout);

        ArrayList<String> ar1=getIntent().getExtras().getStringArrayList("list");
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.giangRadioGroup);
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
        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), NguyenPaymentActivity.class);
                startIntent.putExtra("message","This text is fromm intent object of checkout activity");
                startActivity(startIntent);
            }
        });
    }

    public Drawable getImg(String imgSource){
        Drawable drawableObj = getDrawable(getResources().getIdentifier(imgSource, "drawable", getPackageName()));
        return drawableObj;
    }
}