package giang.nguyen.s301033256;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Lab 2 - Assignment
 * Student Name: Giang Nguyen
 * Student# 301033256
 * Professor: Haki Sharifi
 * COMP 304 - 002
 * */
public class GiangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enterBtn = (Button)findViewById(R.id.giangEnterButton);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), NguyenActivitySelectHouse.class);
                //startIntent.putExtra("welcomeText","HELLO WORLD! This is Android");
                startActivity(startIntent);
            }
        });
    }
}