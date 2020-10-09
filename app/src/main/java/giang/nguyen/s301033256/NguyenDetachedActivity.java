package giang.nguyen.s301033256;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class NguyenDetachedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_detached);
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
}