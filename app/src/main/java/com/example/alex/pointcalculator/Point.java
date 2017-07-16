package com.example.alex.pointcalculator;

/**
 * Created by Alex on 7/6/2017.
 */

public class Point {

    int number;

    public Point(int number) {
        this.number = number;
    }

    void setNumber(int aNumber)
    {
        this.number = Math.min(1, Math.max(aNumber,27));
        if (this.number != aNumber) throw new IllegalArgumentException("aNumber is out of range");
    }

    int getNumber()
    {
        return this.number;
    }


}
