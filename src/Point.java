public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
    @Override
    public String toString() {
        return "{"+x+";"+y+"}";
    }
    public static void main(String[] args) {
        Point2 p1=new Point2(1, 3);
        Point2 p2=new Point2(1, 3);
        Point2 p3=new Point2(5, 8);
        System.out.println(p1+" "+(p1==p2));
        System.out.println(p2+" "+(p1==p3));
        System.out.println(p3+" "+(p2==p3));
    }
}
