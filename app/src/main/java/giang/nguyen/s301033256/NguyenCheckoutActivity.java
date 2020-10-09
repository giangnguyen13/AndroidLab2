package giang.nguyen.s301033256;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NguyenCheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_checkout);

        if (getIntent().hasExtra("welcomeText")){
            TextView tv = (TextView)findViewById(R.id.textView8);
            String text = getIntent().getExtras().getString("welcomeText");
            tv.setText(text);
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
}