import game.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void equals() {
        Point firstPoint = new Point(1, 2);
        Point secondPoint = new Point(1, 2);
        assertEquals(false, firstPoint == secondPoint);
        assertEquals(true, firstPoint.equals(secondPoint));
    }

    @Test
    public void sum() {
        Point firstPoint = new Point(1, 2);
        Point secondPoint = new Point(-7, 4);
        Point thirdPoint = firstPoint.sum(secondPoint);
        assertEquals(thirdPoint.x, -6);
        assertEquals(thirdPoint.y, 6);
    }

}