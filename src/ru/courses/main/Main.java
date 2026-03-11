package ru.courses.main;

import ru.courses.geometry.*;
import ru.courses.math.*;

public class Main {

    public static void main(String[] args) {
        testGeometry();
        testFractions();
        testFractionTask6();
    }

    public static void testGeometry() {
        //geometry
        System.out.println("---> Тест geometry:");
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);

        PolyLine polyLine = new PolyLine(p1, p2, p3);
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(p1, p2, p3);

        System.out.println("Длина PolyLine: " + polyLine.getLength());
        System.out.println("Длина ClosedPolyLine: " + closedPolyLine.getLength());
    }

    public static void testFractions() {
        System.out.println("\n ---> Тест дробей:");
        //(дроби)
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(3, 4);
        System.out.println("f1 + f2 = " + f1.add(f2));
    }

    public static void testFractionTask6() {
        System.out.println("\n---> Тест FractionTask6:");
        double result1 = sumAll(2, new FractionTask6(3, 5), 2.3);
        System.out.println("2 + 3/5 + 2.3 = " + result1);

        double result2 = sumAll(3.6, new FractionTask6(49, 12), 3, new FractionTask6(3, 2));
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);

        double result3 = sumAll(new FractionTask6(1, 3), 1);
        System.out.println("1/3 + 1 = " + result3);
    }

    public static double sumAll(Number... numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }
}