package ru.courses.math;
public class FractionTask6 extends Number {
    int num, denum;

    public FractionTask6(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }
@Override
    public int intValue() {
        return (int) ((double) num / denum);
    }

@Override
    public long longValue() {
        return (long) ((double) num / denum);
    }
@Override
    public float floatValue() {
        return (float) num / denum;
    }
@Override
    public double doubleValue() {
        return (double) num / denum;
    }

    public String toString() {
        return num + "/" + denum;
    }
}