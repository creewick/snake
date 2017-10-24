package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {
    @Test
    public void getLeft() throws Exception {
        Direction right = Direction.Right;
        assertEquals(Direction.Up, right.getLeft());
        Direction down = Direction.Down;
        assertEquals(Direction.Right, down.getLeft());
        Direction left = Direction.Left;
        assertEquals(Direction.Down, left.getLeft());
        Direction up = Direction.Up;
        assertEquals(Direction.Left, up.getLeft());
    }

    @Test
    public void getRight() throws Exception {
        Direction up = Direction.Up;
        assertEquals(Direction.Right, up.getRight());
        Direction down = Direction.Down;
        assertEquals(Direction.Left, down.getRight());

        Direction right = Direction.Right;
        assertEquals(Direction.Down, right.getRight());
        Direction left = Direction.Left;
        assertEquals(Direction.Up, left.getRight());

    }

    @Test
    public void asPoint() throws Exception {
        assertTrue(Direction.Up.asPoint().equals(new Point(0, -1)));
        assertTrue(Direction.Down.asPoint().equals(new Point(0, 1)));
        assertTrue(Direction.Left.asPoint().equals(new Point(-1, 0)));
        assertTrue(Direction.Right.asPoint().equals(new Point(1, 0)));
    }

}