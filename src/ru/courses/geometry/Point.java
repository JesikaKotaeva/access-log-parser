package ru.courses.geometry;
public class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }
@Override
    public String toString() {
        return "Point[x=" + x + ",y=" + y + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public Point clone() {
        return new Point(this.x, this.y);
    }
}