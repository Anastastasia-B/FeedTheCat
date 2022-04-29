package com.study.feedthecat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResultsActivity extends AppCompatActivity {
    private TableLayout tableLayout;
    final String FILENAME = "results";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        tableLayout = findViewById(R.id.tableLayout);
        readFile();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void readFile() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    openFileInput(FILENAME)));
            String str = "";
            int i = 1;
            while ((str = br.readLine()) != null) {
                TableRow tableRow = new TableRow(this);
                tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                String[] strings = str.split("\\|");
                for (int j = 0; j < strings.length; j++) {
                    TextView textView = new TextView(this);
                    textView.setGravity(Gravity.CENTER);
                    textView.setText(strings[j]);
                    tableRow.addView(textView, j);
                }
                tableLayout.addView(tableRow, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
