package com.example.treequilibrium;

public class Customer {
    double CO2 = 0;
    double buywithMoney(int money, Shares curShares) {
        double cnt = 0;
        int p = curShares.getPointer();
        while(p < curShares.getPrices().size()) {
            double remain = 1 - curShares.getFraction();
            if(money < (double)curShares.getPrices().get(p) * remain) {
                cnt += (double)money / curShares.getPrices().get(p);
                curShares.addFraction((double)money / curShares.getPrices().get(p));
                break;
            }
            else {
                cnt += remain;
                p++;
                curShares.movePointer();
                curShares.changeFraction(0);
            }
        }
        CO2 += cnt;
        return cnt;
    }
}
