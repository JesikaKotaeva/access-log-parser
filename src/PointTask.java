class PointTask {
    private int x;
    private int y;

    public PointTask(int x, int y) {
        this.x=x;
        this.y=y;
    }

@Override
    public String toString() {
        return "("+x+";"+y+")";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x= x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y= y;
    }
}

class PointLine {
    private PointTask start;
    private PointTask end;

    public PointLine(PointTask start, PointTask end) {
        this.start=start;
        this.end=end;
    }

@Override
    public String toString() {
        return "Линия от "+start+"до"+end;
    }

    public double getLength() {
        double dx=end.getX()-start.getX();
        double dy=end.getY()-start.getY();
        return Math.sqrt(dx*dx+dy*dy);
    }
}

class PolyLine {
    private PointTask[] points;

    public PolyLine() {
        this.points = new PointTask[0];
    }

    public PolyLine(PointTask... points) {
        this.points = points;
    }

@Override
    public String toString() {
        if (points.length == 0) {
            return "Линия []";
        }

        StringBuilder sb = new StringBuilder("Линия [");
        for (int i=0; i<points.length; i++) {
            sb.append(points[i]);
            if (i< points.length -1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public PointLine[] getLines() {
        if (points.length < 2) {
            return new PointLine[0];
        }

        PointLine[] lines = new PointLine[points.length - 1];
        for (int i=0; i< lines.length; i++) {
            lines[i] = new PointLine(points[i], points[i + 1]);
        }
        return lines;
    }

    public double getLength() {
        double totalLength = 0;
        for (PointLine line : getLines()) {
            totalLength += line.getLength();
        }
        return totalLength;
    }
}

class Main2 {
    public static void main(String[] args) {
        PointTask p1 = new PointTask(1, 5);
        PointTask p2 = new PointTask(2, 8);
        PointTask p3 = new PointTask(5, 3);
        PointTask p4 = new PointTask(8, 9);

        PolyLine polyLine = new PolyLine(p1, p2, p3, p4);

        System.out.println("1. Текстовое представление ломаной: " + polyLine);

        double polyLength = polyLine.getLength();
        System.out.println("2. Длина ломаной: " + polyLength);

        PointLine[] lines = polyLine.getLines();
        System.out.println("3. Массив линий:");
        for (PointLine line : lines) {
            System.out.println("   " + line);
        }

        double linesTotalLength = 0;
        for (PointLine line : lines) {
            linesTotalLength += line.getLength();
        }
        System.out.println("4. Суммарная длина линий: " + linesTotalLength);

        boolean lengthsMatch = (polyLength == linesTotalLength);
        System.out.println("5. Длины совпадают: " + lengthsMatch);

        p2.setX(12);
        p2.setY(8);

        System.out.println("\nПосле изменения точки (2,8) на (12,8):");
        System.out.println("   Текстовое представление ломаной: " + polyLine);
        System.out.println("   Массив линий:");
        for (PointLine line : polyLine.getLines()) {
            System.out.println("      " + line);
        }

        double newPolyLength = polyLine.getLength();
        double newLinesTotalLength = 0;
        for (PointLine line : polyLine.getLines()) {
            newLinesTotalLength += line.getLength();
        }
        System.out.println("   Новая длина ломаной: " + newPolyLength);
        System.out.println("   Новая суммарная длина линий: " + newLinesTotalLength);
        System.out.println("   Новые длины совпадают: " + (newPolyLength == newLinesTotalLength));
    }
}