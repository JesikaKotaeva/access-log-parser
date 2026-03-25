public class Sum {
    public static void main(String[] args) {
        double sum=0.0;
        for (String arg : args) {
            if (arg.matches("-?\\d+(\\.\\d+)?")) {
                sum+=Double.parseDouble(arg);
            }
        }
        if (sum==(long) sum) {
            System.out.println("результат: "+(long) sum);
        } else {
            System.out.println("результат: "+sum);
        }
    }
}
