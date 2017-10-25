import game.*;
import game.fieldItems.*;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void nextStep() throws Exception {
        List<SnakePart> snake = new ArrayList<>();
        snake.add(new SnakePart(0, 0));
        snake.add(new SnakePart(0, 1));
        Player player = new Player(snake);

        Apple redApple = new Apple(1, 1);
        Wall wall = new Wall(2, 1);


        HashSet<fieldItem> field = new HashSet<>();
        field.add(redApple);
        field.add(wall);
        Level level = new Level(3, 3, field);

        Game game = new Game(new Player[] { player }, new Level[] { level });
        game.setCurrentLevel(level);

        game.getPlayers()[0].setDirection(Direction.Right);
        game.nextStep();
        game.getPlayers()[0].setDirection(Direction.Right);
        game.nextStep();

        assertEquals(100, player.getScore());
        assertTrue(player.isDead());
    }

    @Test
    public void getSnakePartsToCollisionWithTest(){
        List<SnakePart> snake1 = new ArrayList<>();
        snake1.add(new SnakePart(0, 0));
        snake1.add(new SnakePart(0, 1));
        Player player1 = new Player(snake1);

        List<SnakePart> snake2 = new ArrayList<>();
        snake2.add(new SnakePart(7, 0));
        snake2.add(new SnakePart(7, 1));
        snake2.add(new SnakePart(7, 2));
        Player player2 = new Player(snake2);

        Game game = new Game(new Player[] {player1, player2}, new Level[] {new Level(10, 10, new HashSet<>())});

        List<SnakePart> snake_parts = game.getSnakePartsToCollisionWith(game.getPlayers()[0]);
        List<SnakePart> result = new ArrayList<>();
        result.add(new SnakePart(0, 0));
        result.add(new SnakePart(7, 0));
        result.add(new SnakePart(7, 1));
        result.add(new SnakePart(7, 2));
        for (int x = 0; x < result.size(); x++){
            assertTrue(result.get(x).position.equals(snake_parts.get(x).position));
        }
    }
}
