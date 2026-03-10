package ru.courses.geometry;

public class ClosedPolyLine extends PolyLine {
    public ClosedPolyLine(Point... points) {
        super(points);
    }

@Override
    public double getLength() {
        double length = super.getLength();
        if (points.length > 1) {
            Point first = points[0];
            Point last = points[points.length - 1];
            double dx = last.x - first.x;
            double dy = last.y - first.y;
            length += Math.sqrt(dx * dx + dy * dy);
        }
        return length;
    }
}