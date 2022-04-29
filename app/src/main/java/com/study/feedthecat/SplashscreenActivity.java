package com.study.feedthecat;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashscreenActivity extends AppCompatActivity {

    AnimationDrawable catAnimation;
    private ImageView catImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        catImageView = (ImageView) findViewById(R.id.big_cat_image_view);
        catImageView.setBackgroundResource(R.drawable.cat_animation);
        catAnimation = (AnimationDrawable) catImageView.getBackground();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Intent intent = new Intent(SplashscreenActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }, 6000);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        catAnimation.start();
    }
}
