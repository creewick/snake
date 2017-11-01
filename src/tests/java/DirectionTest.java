package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectionTest {
    @Test
    public void getLeftDirectionRight() throws Exception {
        Direction right = Direction.Right;
        assertEquals(Direction.Up, right.getLeft());
    }

    @Test
    public void getLeftDIrectionDown() throws Exception {
        Direction down = Direction.Down;
        assertEquals(Direction.Right, down.getLeft());
    }

    @Test
    public void getLeftDirectionLeft() throws Exception {
        Direction left = Direction.Left;
        assertEquals(Direction.Down, left.getLeft());
    }

    @Test
    public void getLeftDirectionUp() throws Exception {
        Direction up = Direction.Up;
        assertEquals(Direction.Left, up.getLeft());
    }

    @Test
    public void getRightDirectionUp() throws Exception {
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
    public void getRightDirectionDown() throws Exception {
        Direction down = Direction.Down;
        assertEquals(Direction.Left, down.getRight());

    }

    @Test
    public void getRightDirectionRight() throws Exception {
        Direction right = Direction.Right;
        assertEquals(Direction.Down, right.getRight());
    }

    @Test
    public void getRightDirectionLeft() throws Exception {
        Direction left = Direction.Left;
        assertEquals(Direction.Up, left.getRight());
    }



    @Test
    public void asPoint() throws Exception {
        assertTrue(Direction.Up.getPoint().equals(new Point(0, -1)));
        assertTrue(Direction.Down.getPoint().equals(new Point(0, 1)));
        assertTrue(Direction.Left.getPoint().equals(new Point(-1, 0)));
        assertTrue(Direction.Right.getPoint().equals(new Point(1, 0)));
    }

}