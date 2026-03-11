package ru.courses.math;

public class Fraction extends Number {
    int num, denom;

    public Fraction(int num, int denom) {
        this.num = num;
        this.denom = denom;
    }

    @Override
    public int intValue() { return (int) ((double) num / denom); }

    @Override
    public long longValue() { return (long) ((double) num / denom); }

    @Override
    public float floatValue() { return (float) num / denom; }

    @Override
    public double doubleValue() { return (double) num / denom; }

    public String toString() { return num + "/" + denom; }

    public Fraction add(Fraction other) {
        int newNumerator = this.num * other.denom + other.num * this.denom;
        int newDenominator = this.denom * other.denom;
        return new Fraction(newNumerator, newDenominator);
    }
}