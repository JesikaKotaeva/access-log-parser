class FractionTask6 extends Number {
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
class MainTask6 {
    public static double sumAll(Number... numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        double result1 = sumAll(2, new FractionTask6(3, 5), 2.3);
        System.out.println("2 + 3/5 + 2.3 = " + result1);

        double result2 = sumAll(3.6, new FractionTask6(49, 12), 3, new FractionTask6(3, 2));
        System.out.println("3.6 + 49/12 + 3 + 3/2 = " + result2);

        double result3 = sumAll(new FractionTask6(1, 3), 1);
        System.out.println("1/3 + 1 = " + result3);
    }
}