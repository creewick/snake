import game.*;
import game.fieldItems.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void nextStep() throws Exception {
        List<SnakePart> snake = new ArrayList<>();
        snake.add(new SnakePart(0, 0));
        snake.add(new SnakePart(0, 1));
        Player player = new Player(snake);

        Apple redApple = new Apple();
        redApple.position = new Point(1, 1);
        Wall wall = new Wall();
        wall.position = new Point(2, 1);

        Level level = new Level(3, 3);
        level.field = new HashSet<fieldItem>();
        level.field.add(redApple);
        level.field.add(wall);
        List<Level> levels = Arrays.asList(level);
        List<Player> players = Arrays.asList(player);

        Game game = new Game(players, levels);
        game.currentLevel = level;


        game.nextStep(new Point(1, 0), player);
        game.nextStep(new Point(1, 0), player);

        assertEquals(100, player.score);
        assertTrue(player.isGameOver);
    }
}
