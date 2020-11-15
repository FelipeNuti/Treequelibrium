package com.example.treequilibrium;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PriceDataGenerator {
    private Random random;
    private int size;
    private List<Entry> priceData;
    private double [] params;
    private double res;
    private double noise;

    private double generatingFunction(double x)
    {
        return (params[0]/(x+params[1]) + 3.8);
        //return Math.exp(-params[0]) * Math.cos(params[1]*x + params[2]) + params[3];
    }

    public PriceDataGenerator(int size, double res, double noise, double [] params) {
        this.size = size;
        this.random = new Random();
        this.params = params;
        this.res = res;
        this.noise = noise;

        this.priceData = new ArrayList<>();

        for (int i = 0; i < size; i++)
        {
            //int hour = (i*(24*3600)/size) / 3600;
            //int minute = ((i*(24*3600)/size) % 3600) /60;
            Entry entry = new Entry(i/24, (float) (generatingFunction(i*this.res) + random.nextDouble()*noise));
            priceData.add(entry);
        }

    }

    public List<Entry> getPriceData(){
        return this.priceData;
    }
}
