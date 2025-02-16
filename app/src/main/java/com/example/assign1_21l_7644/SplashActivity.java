package com.example.assign1_21l_7644;

import android.os.Bundle;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    public ImageView imageview;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        imageview = findViewById(R.id.splash_logo);
        animation = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.animat);
        imageview.setAnimation(animation);

        Thread thread = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                } catch(Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent i = new Intent(SplashActivity.this , MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        };
        thread.start();
    }
}