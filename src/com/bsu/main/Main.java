package com.bsu.main;

import com.sun.media.sound.InvalidFormatException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter k: ");
            int k = scanner.nextInt();
            if(k <= 0) {
                throw new InvalidFormatException("k should be a natural number");
            }

            System.out.println("Enter x (-1, 1): ");
            double x = scanner.nextDouble();
            if (x <= -1 || x >= 1) {
                throw new InvalidFormatException("X should be in (-1, 1)");
            }

            double eps = Math.pow(10, -k);

            double actualValue = calculateActualValue(x);
            double calculatedValue = calculateTailorSeries(eps, x);

            System.out.println("Actual value: " + formattedNumericValue(actualValue));
            System.out.println("Calculated value: " + formattedNumericValue(calculatedValue));

        } catch (Exception ex) {

            System.out.println("Error while reading value: " + ex);
        }
    }

    public static double calculateActualValue (double x) {

        return Math.log((1 + x) / (1 - x));
    }

    public static double calculateTailorSeries (double eps, double x) {

        double ans = 0;

        int powCount = 1;
        double temp = 0;

        do {
            temp = Math.pow(x, powCount) / powCount;
            ans += temp;
            powCount += 2;

        } while (Math.abs(temp) > Math.abs(eps));

        ans *= 2;
        return ans;
    }

    private static String formattedNumericValue (double value) {

        return String.format("%.3f", value);
    }

}
