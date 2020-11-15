package com.example.treequilibrium;

import java.util.ArrayList;

public class Shares {
    private int pointer = 0;
    private double fraction = 0;
    private ArrayList<Integer> prices = new ArrayList<Integer>();
    private ArrayList<Integer> landlordIDs = new ArrayList<Integer>();
    public int getPointer() {
        return pointer;
    }
    public void movePointer() {
        pointer++;
    }
    public double getFraction() {
        return fraction;
    }
    public void changeFraction(double newFraction) {
        fraction = newFraction;
    }
    public void addFraction(double delta) {
        fraction += delta;
    }
    public ArrayList<Integer> getPrices() {
        return prices;
    }
    public void addShare(int id, int price) {
        boolean flag = true;
        for(int i=0;i<prices.size();++i) {
            if(prices.get(i) >= price) {
                prices.add(i, price);
                landlordIDs.add(i, id);
                flag = false;
                break;
            }
        }
        if(flag) {
            prices.add(price);
            landlordIDs.add(id);
        }
    }
}
