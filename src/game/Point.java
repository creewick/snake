package game;

public class Point {

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x, y;

    public boolean equals(Point point) {
        return x == point.x && y == point.y;
    }

    public Point sum(Point point) {
        return new Point(x + point.x, y + point.y);
    }
}
