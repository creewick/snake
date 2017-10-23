package game;

public enum Direction{
    Up, Right, Down, Left;

    public Direction getLeft(){
        return Direction.values()[(this.ordinal() + Direction.values().length - 1) % Direction.values().length];
    }

    public Direction getRight() {
        return Direction.values()[(this.ordinal() + Direction.values().length + 1) % Direction.values().length];
    }

    public Point asPoint(){
        if (this == Direction.Up)
            return new Point(0, -1);
        if (this == Direction.Right)
            return new Point(1, 0);
        if (this == Direction.Down)
            return new Point(0, 1);
        if (this == Direction.Left)
            return new Point(-1, 0);
        return new Point(0,0);
    }
}
