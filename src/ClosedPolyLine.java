class PolyLine {
    Point[] points;

    public PolyLine(Point... points) {
        this.points = points;
    }
    public double length() {
        double sum = 0, len1, len2;
        for (int i = 0; i < points.length - 1; i++) {
            len1 = points[i].x - points[i+1].x;
            len2 = points[i].y - points[i+1].y;
            sum += Math.sqrt(len1 * len1 + len2 * len2);
        }
        return sum;
    }
}
class ClosedPolyLine extends PolyLine {

    public ClosedPolyLine(Point... points) {
        super(points);
    }
    @Override
    public double length() {
        double length = super.length();

        if (points.length > 1) {
            Point first = points[0];
            Point last = points[points.length-1];

            double deltaX = last.x - first.x;
            double deltaY = last.y - first.y;
            length += Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        }

        return length;
    }
}
class Main4 {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(3, 4);

        ClosedPolyLine closed = new ClosedPolyLine(p1, p2, p3);
        System.out.println("Длина замкнутой ломаной: " + closed.length());
    }
}