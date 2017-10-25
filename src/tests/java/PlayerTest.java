import game.Direction;
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
    public void getSnakeTest(){
        List<SnakePart> snake = Arrays.asList(
                new SnakePart(1, 2));
        Player player = new Player(snake);
        List<SnakePart> res = player.getSnake();
        for (int x = 0; x < res.size(); x++){
            assertTrue(res.get(x).position.equals(snake.get(x).position));
        }
    }

    @Test
    public void increaseSnakeTest(){
        List<SnakePart> snake = new ArrayList<>();
        snake.add(new SnakePart(1, 2));
        Player player = new Player(snake);
        player.increaseSnake();
        for (SnakePart snakePart : player.getSnake()){
            assertTrue(snakePart.position.equals(new Point(1, 2)));
        }
    }

    @Test
    public void killTest(){
        List<SnakePart> snake = new ArrayList<>();
        snake.add(new SnakePart(0, 0));
        Player player = new Player(snake);
        player.Kill();
        assertTrue(player.isDead());
    }

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

        Level level = new Level(7, 7, new HashSet<fieldItem>());

        player.setDirection(Direction.Up);
        player.moveSnake(level);
        player.setDirection(Direction.Right);
        player.moveSnake(level);
        player.setDirection(Direction.Right);
        player.moveSnake(level);
        player.setDirection(Direction.Down);
        player.moveSnake(level);

        List<Point> correctResult = Arrays.asList(
                new Point(1, 1),
                new Point(2, 1),
                new Point(3, 1),
                new Point(3, 2));
        for (int y = 0; y < player.getSnake().size(); y++) {
            assertTrue(correctResult.get(y).equals(player.getSnake().get(y).position));
        }
    }
}