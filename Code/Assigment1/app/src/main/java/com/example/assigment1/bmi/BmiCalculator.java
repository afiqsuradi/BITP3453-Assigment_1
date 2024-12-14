package com.example.assigment1.bmi;

import java.text.DecimalFormat;

public class BmiCalculator {
    private float height, weight;

    public BmiCalculator() {
        weight = 0;
        height = 0;

    }

    public BmiCalculator(float height, float weight) {
        this.height = height;
        this.weight = weight;
    }

    public double calculateBmi(){
        return weight / Math.pow(convertCmToM(height), 2);
    }

    private double convertCmToM(float centimeter){
        return centimeter / 100;
    }

    public static String formatBmi(double bmi){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return  decimalFormat.format(bmi);
    }
}
