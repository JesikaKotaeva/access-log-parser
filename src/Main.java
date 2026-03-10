public class Main {
    public static void printLengths(Measurable[] measurables) {
        for (Measurable m : measurables) {
            System.out.println("Длина: " + m.getLength());
        }
    }

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);

        PolyLine polyLine = new PolyLine(p1, p2, p3);
        ClosedPolyLine closedPolyLine = new ClosedPolyLine(p1, p2, p3);

        Measurable[] measurables = {polyLine, closedPolyLine};
        printLengths(measurables);
    }
}