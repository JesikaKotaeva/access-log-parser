package ru.courses.main;

import ru.courses.geometry.Point;

public class SimpleNames {

    public static void main(String[] args) {
        Point myPoint = new Point(10, 20);
        System.out.println("geometry point (ru.courses.geometry): " + myPoint);

        java.awt.Point awtPoint = new java.awt.Point(30, 40);
        System.out.println("awt point (java.awt): " + awtPoint);

    }
}