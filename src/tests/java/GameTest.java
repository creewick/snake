import game.*;
import game.fieldItems.*;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void nextStep() throws Exception {
        List<Point> snake = new ArrayList<>();
        snake.add(new Point(0, 0));
        snake.add(new Point(0, 1));
        Player player = new Player(snake, 0);
        Level level = new Level();
        level.size = new Point(3, 3);
        List<Level> levels = Arrays.asList(level);
        List<Player> players = Arrays.asList(player);

        Game game = new Game(players, levels);
        game.currentLevel = level;
        Apple redApple = new Apple();
        redApple.position = new Point(1, 1);
        Wall wall = new Wall();
        wall.position = new Point(2, 1);
        level.field = new HashSet<fieldItem>();
        level.field.add(redApple);
        level.field.add(wall);

        game.nextStep(new Point(1, 0), player);
        game.nextStep(new Point(1, 0), player);

        assertEquals(player.score, 100);
        assertEquals(player.isGameOver, true);
    }

}