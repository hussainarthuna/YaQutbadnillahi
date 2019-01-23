package com.hussain.yaqutbadnillahi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        final Thread thread=new Thread(){

            @Override
            public void run() {


                try {
                    sleep(1500);
                }
                catch (Exception e){

                    e.printStackTrace();
                }

                finally {

                    Intent intent = new Intent(getApplicationContext(),MainMediaActivity.class);
                    intent.putExtra("bundname",String.valueOf(1));
                    //intent.putExtra("bundname",bundItem.get(viewHolder.getAdapterPosition()));

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }

            }
        };
        thread.start();




    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
