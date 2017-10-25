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
        HashSet<fieldItem> field = new HashSet<>();
        field.add(greenApple);
        Level level = new Level(3, 3, field);
        greenApple.onCollision(player, level);
        assertEquals(100, player.getScore());
        assertEquals(snake.size(), 5);
        assertEquals(level.getField().size(), 1);
    }
}