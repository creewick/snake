import game.Game;
import game.Level;
import game.Player;
import game.Point;
import game.fieldItems.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class AppleTest {

    @Test
    public void onCollision() {
        List<Point> snake = new ArrayList<>();
        snake.add(new Point(0, 0));
        snake.add(new Point(0, 1));
        snake.add(new Point(0, 2));
        snake.add(new Point(1, 2));
        Player player = new Player(snake, 0);

        Apple greenApple = new Apple();
        greenApple.onCollision(player);
        assertEquals(100, player.score);
        assertEquals(snake.size(), 5);

    }
}