package com.study.feedthecat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable catAnimation;
    private TextView satietyValue;
    private int clicks = 0;
    private String personName = "guest";
    final String FILENAME = "achievements";
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
        writeResults();
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
            case R.id.save_score_item:
                writeResults();
                break;
            case R.id.view_results_item:
                Intent results = new Intent(this, ResultsActivity.class);
                startActivity(results);
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

    void writeToFile(String filename,String text) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    openFileOutput(filename, MODE_APPEND)));
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeResults(){
        Date date = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);
        writeToFile("results",personName + " | " + formattedDate + " | " + clicks + "\n");
    }
}