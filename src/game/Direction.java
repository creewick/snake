package game;

public enum Direction{
    Up(new Point(0, -1)),
    Right(new Point(1, 0)),
    Down(new Point(0, 1)),
    Left(new Point(-1, 0));

    private Point point;
    public Point getPoint() {return this.point; }

    Direction(Point point){
        this.point = point;
    }

    public Direction getLeft(){
        return Direction.values()[(this.ordinal() + Direction.values().length - 1) % Direction.values().length];
    }

    public Direction getRight() {
        return Direction.values()[(this.ordinal() + Direction.values().length + 1) % Direction.values().length];
    }
}
