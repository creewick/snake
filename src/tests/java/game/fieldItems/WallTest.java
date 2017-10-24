package game.fieldItems;

import game.Level;
import game.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class WallTest {
    @Test
    public void onCollision() throws Exception {
        Wall wall = new Wall(0, 0);
        List<SnakePart> snake = new ArrayList<>();
        snake.add(new SnakePart(0, 0));
        Player player = new Player(snake);
        Level level = new Level(3, 3);
        level.field = new HashSet<fieldItem>();
        level.field.add(wall);
        wall.onCollision(player, level);
        assertEquals(true, player.isDead);
    }

}