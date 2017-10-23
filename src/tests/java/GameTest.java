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

        Level level = new Level(3, 3);
        level.field = new HashSet<>();
        level.field.add(redApple);
        level.field.add(wall);
        List<Level> levels = Arrays.asList(level);
        List<Player> players = Arrays.asList(player);

        Game game = new Game(players, levels);
        game.currentLevel = game.levels.get(0);

        game.nextStep();
        game.nextStep();

        //assertEquals(100, player.score);
        //assertEquals(player.snake.size(), 0);
    }
}
