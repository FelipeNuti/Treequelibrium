package com.example.treequilibrium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.android.material.button.MaterialButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button buttonDonate;
    TextView progressText;
    LineChart lineChart;

    private void syncProgress() {
        progressText.setText(progressBar.getProgress() + "%");
    }

    private List<Entry> getData()
    {
        double[] params = {10, 5, 0, 2.8};
        PriceDataGenerator pdg = new PriceDataGenerator(2000, 0.1, 0, params);
        return pdg.getPriceData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        buttonDonate = findViewById(R.id.buttonDonate);
        progressText = findViewById(R.id.centerText);
        lineChart = findViewById(R.id.lineChart);

        List<Entry> data = getData();
        LineDataSet lineDataSet = new LineDataSet(data, "Tons of carbon per €100");
        LineData lineData = new LineData(lineDataSet);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setLineWidth(3);
        lineDataSet.setColor(Color.parseColor(getResources().getString(R.color.standardGreen)));
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getXAxis().setDrawLabels(true);
        lineChart.getDescription().setEnabled(false);
        lineChart.setData(lineData);
        lineChart.invalidate();

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