import game.Level;
import game.Player;
import game.Point;
import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void getHead(){
        List<SnakePart> snake = Arrays.asList(
                new SnakePart(1, 2),
                new SnakePart(3, 3),
                new SnakePart(4, 5));
        Player player = new Player(snake);
        assertEquals(player.getHead().position.equals(new Point(4, 5)), true);
    }

    @Test
    public void moveSnake() {
        List<SnakePart> snake = new ArrayList<>();
        snake.add(new SnakePart(0, 0));
        snake.add(new SnakePart(0, 1));
        snake.add(new SnakePart(0, 2));
        snake.add(new SnakePart(1, 2));
        Player player = new Player(snake);

        Level level = new Level(7, 7);
        level.field = new HashSet<fieldItem>();
        level.field.add(new SnakePart(0, 0));
        level.field.add(new SnakePart(0, 1));
        level.field.add(new SnakePart(0, 2));
        level.field.add(new SnakePart(1, 2));

        player.moveSnake(new Point(0, -1), level);
        player.moveSnake(new Point(1, 0), level);
        player.moveSnake(new Point(1, 0), level);
        player.moveSnake(new Point(0, 1), level);

        List<Point> correctResult = Arrays.asList(
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 1),
                new Point(3, 2));
        for (int y = 0; y < player.snake.size(); y++) {
            assertTrue(correctResult.get(y).equals(player.snake.get(y).position));
        }
    }
}