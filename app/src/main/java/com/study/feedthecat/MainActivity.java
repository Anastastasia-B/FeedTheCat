package com.study.feedthecat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView satietyValue;
    private int clicks = 0;
    private ImageView catImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        satietyValue = findViewById(R.id.satiety_value);
        satietyValue.setText(String.valueOf(clicks));
        catImageView =findViewById(R.id.cat_image_view);
    }

    public void feed_button_click(View view) {
        clicks++;
        satietyValue.setText(String.valueOf(clicks));
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