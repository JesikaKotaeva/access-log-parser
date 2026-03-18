public class Sum {
    public static void main(String[] args) {
        double sum = 0;

        for (String arg : args) {
            try {
                sum += Double.parseDouble(arg);
            } catch (NumberFormatException e) {}
        }
        System.out.println("result: "+sum);
    }
}
