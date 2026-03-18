package ru.courses.geometry;

public class Line {
    Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

  @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line other = (Line) obj;
        return start.equals(other.start) && end.equals(other.end);
    }

    @Override
    public Line clone() {
        return new Line(this.start.clone(), this.end.clone());
    }

    @Override
    public String toString() {
        return "Line[start=" + start + ", end=" + end + "]";
    }
}
