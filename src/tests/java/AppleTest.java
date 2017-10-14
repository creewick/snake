import game.Game;
import game.Level;
import game.Player;
import game.Point;
import game.fieldItems.Apple;
import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class AppleTest {

    @Test
    public void onCollision() {
        List<SnakePart> snake = new ArrayList<>();
        snake.add(new SnakePart(0, 0));
        snake.add(new SnakePart(0, 1));
        snake.add(new SnakePart(0, 2));
        snake.add(new SnakePart(1, 2));
        Player player = new Player(snake);

        Apple greenApple = new Apple(1, 2);
        Level level = new Level(3, 3);
        level.field = new HashSet<fieldItem>();
        level.field.add(greenApple);
        greenApple.onCollision(player, level);
        assertEquals(100, player.score);
        assertEquals(snake.size(), 5);
        assertEquals(level.field.size(), 0);
    }
}