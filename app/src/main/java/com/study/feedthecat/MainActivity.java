package com.study.feedthecat;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    AnimationDrawable catAnimation;
    private TextView satietyValue;
    private int clicks = 0;
    private String personName = "guest";
    private ImageView catImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        satietyValue = findViewById(R.id.satiety_value);
        satietyValue.setText(String.valueOf(clicks));

        catImageView = (ImageView) findViewById(R.id.cat_image_view);
        catImageView.setBackgroundResource(R.drawable.cat_animation);
        catAnimation = (AnimationDrawable) catImageView.getBackground();
    }

    public void feed_button_click(View view) {
        clicks++;
        satietyValue.setText(String.valueOf(clicks));
        if (clicks % 15 == 0) {
            catAnimation.start();
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            catAnimation.stop();
                        }
                    }, 3250);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_about_developer:
                Intent intent = new Intent(this,AboutDeveloperActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}