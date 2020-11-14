package com.example.treequilibrium;

import java.util.ArrayList;
import java.util.Random;

public class PriceDataGenerator {
    private Random random;
    private int size;
    private double [] priceData;
    private double [] params;
    private double res;
    private double noise;

    private double generatingFunction(double x)
    {
        return Math.exp(-params[0]) * Math.cos(params[1]*x + params[2]);
    }

    public PriceDataGenerator(int size, int res, double noise, double [] params) {
        this.size = size;
        this.random = new Random();
        this.params = params;
        this.res = res;
        this.noise = noise;

        this.priceData = new double[size];

        for (int i = 0; i < size; i++)
        {
            priceData[i] = generatingFunction(i*this.res) + random.nextDouble()*noise;
        }

    }
}
