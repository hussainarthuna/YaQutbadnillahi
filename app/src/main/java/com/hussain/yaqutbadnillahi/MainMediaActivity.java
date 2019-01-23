package com.hussain.yaqutbadnillahi;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMediaActivity extends AppCompatActivity {


    private TextView textView;
    private ImageView bundImage;
    private Button play,prev,next,listOfBund;
    private Resources res;
    private MediaPlayer mp;
    private String bundnumber;
    private Boolean isPause=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_media);

       // mp.reset();
        textView=(TextView)findViewById(R.id.bundNumber);
        bundImage=(ImageView) findViewById(R.id.bundImage);
        play=(Button)findViewById(R.id.play);
        prev=(Button)findViewById(R.id.prev);
        next=(Button)findViewById(R.id.next);
        listOfBund=(Button)findViewById(R.id.listOfBund);

        textView.setVisibility(View.GONE);



        bundnumber=getIntent().getStringExtra("bundname");
        isPause=getIntent().getBooleanExtra("isPause",false);


        if(isPause==false){
            play.setBackgroundResource(android.R.drawable.ic_media_pause);
        }
        else{
            play.setBackgroundResource(android.R.drawable.ic_media_play);

        }

        checkBund(bundnumber);

        String fileName="bund"+bundnumber;
        res = this.getResources();
        int resourceId = res.getIdentifier(
                fileName, "drawable", this.getPackageName() );
        // Drawable drawable = res.getDrawable( resourceId );
        //bundImage.setImageDrawable( drawable );
        bundImage.setImageResource( resourceId );

        // bundImage.setImageResource(R.drawable.bund1);
        textView.setText("Bund - "+bundnumber);

        int music = res.getIdentifier(fileName,"raw",this.getPackageName());


        mp=MediaPlayer.create(this,music);

        if(isPause==false){
            mp.start();

        }



        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
                //mp.reset();
                Intent intent = new Intent(getApplicationContext(),MainMediaActivity.class);

                int nextBund = Integer.parseInt(bundnumber)+1;

                if(nextBund<=35){
                    intent.putExtra("bundname",String.valueOf(nextBund));
                    intent.putExtra("isPause",isPause);
                }

                else {
                    intent.putExtra("isPause",isPause);
                    intent.putExtra("bundname",String.valueOf(1));

                }

                //intent.putExtra("bundname",bundItem.get(viewHolder.getAdapterPosition()));

                startActivity(intent);
                finish();

            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mp.isPlaying()){

                    mp.pause();
                    isPause = true;
                    v.setBackgroundResource(android.R.drawable.ic_media_play);
                }
                else {
                    mp.start();
                    isPause = false;
                    v.setBackgroundResource(android.R.drawable.ic_media_pause);

                }

            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();
                //mp.reset();
                Intent intent = new Intent(getApplicationContext(),MainMediaActivity.class);

                int nextBund = Integer.parseInt(bundnumber)-1;

                if(nextBund<=35){
                    intent.putExtra("bundname",String.valueOf(nextBund));
                    intent.putExtra("isPause",isPause);
                }

                else {
                    intent.putExtra("bundname",String.valueOf(1));
                    intent.putExtra("isPause",isPause);
                }

                //intent.putExtra("bundname",bundItem.get(viewHolder.getAdapterPosition()));

                startActivity(intent);
                finish();

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.release();
                //mp.reset();
                Intent intent = new Intent(getApplicationContext(),MainMediaActivity.class);

                int nextBund = Integer.parseInt(bundnumber)+1;

                if(nextBund<=35){
                    intent.putExtra("bundname",String.valueOf(nextBund));
                    intent.putExtra("isPause",isPause);
                }

                else {
                    intent.putExtra("bundname",String.valueOf(1));
                    intent.putExtra("isPause",isPause);

                }

                //intent.putExtra("bundname",bundItem.get(viewHolder.getAdapterPosition()));

                startActivity(intent);
                finish();

            }
        });

        listOfBund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                Intent intent=new Intent(getApplicationContext(),BundListActivity.class);
                startActivity(intent);


            }
        });










    }

    private void checkBund(String bundnumber) {


        if(bundnumber.equals("1")){

            prev.setVisibility(View.INVISIBLE);
        }
        if (bundnumber.equals("35")){

            next.setVisibility(View.INVISIBLE);

        }

    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//
//
//        mp.pause();
//    }


    @Override
    protected void onRestart() {
        super.onRestart();


        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }
}
