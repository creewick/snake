import game.Player;
import game.Point;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void getHead() {
        List<Point> snake = Arrays.asList(
                new Point(1, 2),
                new Point(3, 3),
                new Point(4, 5));
        Player player = new Player(snake, 0);
        assertEquals(player.getHead().equals(new Point(4, 5)), true);
    }

    @Test
    public void moveSnake() {
        List<Point> snake = new ArrayList<>();
        snake.add(new Point(0, 0));
        snake.add(new Point(0, 1));
        snake.add(new Point(0, 2));
        snake.add(new Point(1, 2));
        Player player = new Player(snake, 0);

        player.moveSnake(new Point(0, -1));
        player.moveSnake(new Point(1, 0));
        player.moveSnake(new Point(1, 0));
        player.moveSnake(new Point(0, 1));

        List<Point> correctResult = Arrays.asList(
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 1),
                new Point(3, 2));
        for (int y = 0; y < player.snake.size(); y++) {
            assertTrue(correctResult.get(y).equals(player.snake.get(y)));
        }
    }
}