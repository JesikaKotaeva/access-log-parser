package ru.courses.main;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class PowerCalculator {

    public static double powerFromString(String x, String y) {
        int base = parseInt(x);
        int exponent = parseInt(y);
        return pow(base, exponent);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Использование: java PowerCalculator <X> <Y>");
            return;
        }

        double result = powerFromString(args[0], args[1]);

        System.out.println(args[0] + " ^ " + args[1] + " = " + result);
    }
}