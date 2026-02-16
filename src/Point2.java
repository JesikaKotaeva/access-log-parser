class Point2 {
    private int x;
    private int y;
    public Point2(int x, int y) {
        this.x=x;
        this.y=y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y =y;
    }
    @Override
    public String toString() {
        return "("+x+";"+y+")";
    }
}

class Line {
    private Point2 start;
    private Point2 end;
    public Line(Point2 start, Point2 end) {
        this.start = start;
        this.end = end;
    }
    public Line(int x1, int y1, int x2, int y2) {
        this.start =new Point2(x1, y1);
        this.end = new Point2(x2, y2);
    }

    @Override
    public String toString() {
        return "Линия от"+start+"до"+end;
    }
    public double getLength() {
        double dx = end.getX()-start.getX();
        double dy =end.getY()-start.getY();
        return Math.sqrt(dx*dx+dy*dy);
    }
    public Point2 getStart() {
        return start;
    }
    public Point2 getEnd() {
        return end;
    }
}

class Final {
    public static void main(String[] args) {
        Point2 point1 = new Point2(1, 3);
        Point2 point2 = new Point2(5, 8);
        Point2 point3 = new Point2(10, 11);
        Point2 point4 = new Point2(15, 19);

        System.out.println("Точка 1 (из первого задания): " + point1);
        System.out.println("Точка 2 (из первого задания): " + point2);

        Line line1 = new Line(point1, point2);
        Line line2 = new Line(point3, point4);
        Line line3 = new Line(point2, point3);

        System.out.println("\nЛиния 3 до изменения: " + line3);

        line3.getStart().setX(6);
        line3.getStart().setY(9);
        line3.getEnd().setX(11);
        line3.getEnd().setY(12);

        System.out.println("Точка 2 после изменения через Линию 3: " + point2);
        System.out.println("Точка 3 после изменения через Линию 3: " + point3);
        System.out.println("Линия 3 после изменения: " + line3);
        System.out.println("Линия 1 тоже изменилась (использует Точку 2): " + line1);

        double totalLength = line1.getLength() + line2.getLength() + line3.getLength();
        System.out.println("\nСуммарная длина всех линий: " + totalLength);
    }
}