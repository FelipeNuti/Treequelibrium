package com.example.treequilibrium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button buttonDonate;
    TextView progressText;

    private void syncProgress() {
        progressText.setText(progressBar.getProgress() + "%");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        buttonDonate = findViewById(R.id.buttonDonate);
        progressText = findViewById(R.id.centerText);
        buttonDonate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                int progress = progressBar.getProgress();
                progressBar.setProgress((progress+10)%progressBar.getMax());
                syncProgress();
            }
        });
    }
}