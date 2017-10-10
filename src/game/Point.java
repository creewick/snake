package game;

public class Point {

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x, y;

    public boolean equals(Point point) {
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public int hashCode()
    {
        String str = this.x + "," + this.y;
        return str.hashCode();
    }

    public Point sum(Point point) {
        return new Point(x + point.x, y + point.y);
    }
}
