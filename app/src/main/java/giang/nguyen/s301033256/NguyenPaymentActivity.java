package giang.nguyen.s301033256;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NguyenPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_payment);

        if (getIntent().hasExtra("message")){
            TextView tv = (TextView)findViewById(R.id.textView9);
            String text = getIntent().getExtras().getString("message");
            tv.setText(text);
        }
    }
}