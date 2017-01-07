package com.kingtvarshin.apogee2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wang.avi.AVLoadingIndicatorView;

/**
 * Created by lenovo on 15-09-2016.
 */
public class Splashscreen extends Activity {

    AVLoadingIndicatorView avi;
    Integer img = R.drawable.apogeetitle;
    ImageView title;

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        avi = (AVLoadingIndicatorView)findViewById(R.id.avi);
        title = (ImageView)findViewById(R.id.title);
        startAnim();
        Picasso.with(this).load(img).into(title);


        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splashscreen.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    void startAnim(){
        avi.show();
        // or avi.smoothToShow();
    }

    void stopAnim(){
        avi.hide();
        // or avi.smoothToHide();
    }


}