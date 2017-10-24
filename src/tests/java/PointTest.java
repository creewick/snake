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

    @Test
    public void hashCodeTest(){
        Point firstPoint = new Point(1, 1);
        Point secondPoint = new Point(1, 2);
        Point thirdPoint = new Point(1, 2);
        assertEquals(false, firstPoint.hashCode() == secondPoint.hashCode());
        assertEquals(thirdPoint.hashCode(), secondPoint.hashCode());
    }

    @Test
    public void loopingInTheField(){
        Point point = new Point(10, 10);
        point.loopingInTheField(10, 10);
        assertTrue(point.equals(new Point(0, 0)));
    }

}