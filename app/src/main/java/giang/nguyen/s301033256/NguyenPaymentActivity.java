package giang.nguyen.s301033256;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Lab 2 - Assignment
 * Student Name: Giang Nguyen
 * Student# 301033256
 * Professor: Haki Sharifi
 * COMP 304 - 002
 * */

public class NguyenPaymentActivity extends AppCompatActivity {
    static int progress;
    ProgressBar progressBar;
    TextView processingTv;
    int progressStatus = 0;
    //create the Handler object in the UI thread
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguyen_payment);

        Button paymentBtn = (Button)findViewById(R.id.giangPaymentBtn);

        final EditText firstName = (EditText)findViewById(R.id.giangFullNameTv);
        final EditText phone = (EditText)findViewById(R.id.giangPhoneTv);
        final EditText card = (EditText)findViewById(R.id.giangCardNumberTv);


        paymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (this.validateNameField(firstName.getText().toString()) &&
                        this.validatePhoneField(phone.getText().toString()) &&
                        this.validateCardField(card.getText().toString())){
                    progress = 0;
                    //create the progress bar object
                    progressBar = (ProgressBar) findViewById(R.id.giangProgressBar);
                    processingTv = (TextView)findViewById(R.id.giangProcessTv);
                    progressBar.setMax(100);
                    progressBar.setVisibility(View.VISIBLE);
                    processingTv.setVisibility(View.VISIBLE);
                    //the update part
                    //---do some work in background thread---
                    new Thread(new Runnable() //create a new thread
                    {
                        //implement run method
                        //this is where you do the thread's job
                        public void run()
                        {
                            //�-do some work here�-
                            while (progressStatus < 100)
                            {
                                //get the updated progess value
                                progressStatus = doSomeWork();

                                //�-Update the progress bar�-
                                //you have to do that from within UI thread
                                //by posting a message to Handler object
                                handler.post(new Runnable()
                                {
                                    //this thread updates the progress status
                                    public void run() {
                                        //set the updated progres value
                                        progressBar.setProgress(progressStatus);
                                    }
                                });
                            }

                            //---hides the progress bar--- update the UI
                            handler.post(new Runnable()
                            {
                                public void run()
                                {
                                    //---0 - VISIBLE; 4 - INVISIBLE; 8 - GONE---
                                    progressBar.setVisibility(View.GONE);
                                    processingTv.setVisibility(View.INVISIBLE);
                                    Intent startIntent = new Intent(getApplicationContext(), GiangActivity.class);
                                    startIntent.putExtra("message", "This text is fromm intent object of checkout activity");
                                    startActivity(startIntent);
                                }
                            });
                        }

                        //---do some long running work here---
                        private int doSomeWork()
                        {
                            try {
                                //---simulate doing some work---
                                Thread.sleep(20); //one second sleep
                            } catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                            return ++progress;
                        }
                    }).start();
                }else{
                    if(this.validateNameField(firstName.getText().toString()) == false){
                        firstName.setError("Required input.!");
                    }
                    if(this.validatePhoneField(phone.getText().toString()) == false){
                        phone.setError("Invalid input.!");
                    }
                    if(this.validateCardField(card.getText().toString()) == false){
                        card.setError("Invalid input.!");
                    }
                }

            }
            private boolean validateNameField(String name){
                if (name.length() == 0){
                    return false;
                }
                return true;
            }
            private boolean validatePhoneField(String name){
                if (name.length() == 10){
                    return true;
                }
                return false;
            }
            private boolean validateCardField(String name){
                if (name.length() == 16){
                    return true;
                }
                return false;
            }
        });
    }
}