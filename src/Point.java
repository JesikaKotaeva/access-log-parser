class Point {
    int x, y;

    public Point(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
class Point3D extends Point {
    int z;
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z=z;
    }
    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }
    @Override
    public String toString() {
        return "Point3D{"+"x="+x+", y="+y+", z="+z+'}';
    }
}
class Main3 {
    public static void main(String[] args) {
        Point3D point = new Point3D(1, 2, 3);
        System.out.println(point);
    }
}