class Fraction extends Number {
    int num, denum;

    public Fraction(int num, int denum) {
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

class Main2 {
    public static void main(String[] args) {
        // Создаем дробь 3/4
        Fraction f1 = new Fraction(3, 4);
        System.out.println("Дробь: " + f1);
        System.out.println("doubleValue(): " + f1.doubleValue());
        System.out.println("floatValue(): " + f1.floatValue());
        System.out.println("intValue(): " + f1.intValue());
        System.out.println("longValue(): " + f1.longValue());

        System.out.println();

        Fraction f2 = new Fraction(7, 2);
        System.out.println("Дробь: " + f2);
        System.out.println("doubleValue(): " + f2.doubleValue());
        System.out.println("intValue(): " + f2.intValue());

        System.out.println();

        Fraction f3 = new Fraction(5, 3);
        System.out.println("Дробь: " + f3);
        System.out.println("doubleValue(): " + f3.doubleValue());
        System.out.println("floatValue(): " + f3.floatValue());
    }
}