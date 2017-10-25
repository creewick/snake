import game.Level;
import game.Player;
import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;
import org.junit.Test;
import game.fieldItems.Wall;

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

        HashSet<fieldItem> field = new HashSet<>();
        field.add(wall);
        Level level = new Level(3, 3, field);
        wall.onCollision(player, level);
        assertEquals(true, player.isDead());
    }

}