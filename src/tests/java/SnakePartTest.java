import game.Level;
import game.Player;
import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class SnakePartTest {
    @Test
    public void onCollision() {

        Player player = new Player(new ArrayList<SnakePart>());
        SnakePart snake = new SnakePart(0, 0);
        snake.onCollision(player, new Level(1, 1, new HashSet<>()));
        assertEquals(player.getSnake().size(), 0);
    }
}