package ru.courses.geometry;
public class PolyLine implements Measurable {
    Point[] points;

    public PolyLine(Point... points) {
        this.points = points;
    }

@Override
    public double getLength() {
        double sum=0, len1,len2;
        for (int i=0; i<points.length-1; i++) {
            len1=points[i].x-points[i+1].x;
            len2=points[i].y-points[i+1].y;
            sum+=Math.sqrt(len1*len1+len2*len2);
        }
        return sum;
    }
@Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;
        PolyLine other = (PolyLine) obj;
        if (this.points.length!=other.points.length) return false;
        for (int i=0; i<this.points.length; i++) {
            if (!this.points[i].equals(other.points[i])) {
                return false;
            }
        }
        return true;
    }
}