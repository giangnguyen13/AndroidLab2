package giang.nguyen.s301033256;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class NguyenActivitySelectHouse extends AppCompatActivity {

    private Intent startIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_house);
        final Spinner spin = (Spinner)findViewById(R.id.giangHouseTypeDropdownSpinner);
        Button submitBtn = (Button)findViewById(R.id.giangSubmitViewHouseBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the spinner view as text view
                TextView text_sel = (TextView)spin.getSelectedView();
                String selectedType = text_sel.getText().toString();
                switch (selectedType){
                    case "Apartment":
                        startIntent = new Intent(getApplicationContext(), NguyenApartmentActivity.class);
                        startActivity(startIntent);
                        break;
                    case "Detached home":
                        startIntent = new Intent(getApplicationContext(), NguyenDetachedActivity.class);
                        startActivity(startIntent);
                        break;
                    case "Semi-detached home":
                        startIntent = new Intent(getApplicationContext(), NguyenSemiDetachedActivity.class);
                        startActivity(startIntent);
                        break;
                    case "Condominium apartment":
                        startIntent = new Intent(getApplicationContext(), NguyenCondoHouseActivity.class);
                        startActivity(startIntent);
                        break;
                    case "Town house":
                        startIntent = new Intent(getApplicationContext(), NguyenTownHouseActivity.class);
                        startActivity(startIntent);
                        break;
                }
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
}