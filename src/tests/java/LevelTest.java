import game.Level;
import game.Point;
import game.fieldItems.Apple;
import game.fieldItems.Wall;
import game.fieldItems.fieldItem;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LevelTest{

    @Test
    public void generateApple() throws Exception {
        HashSet<fieldItem> field = new HashSet<>();
        Apple greenApple = new Apple(0, 0);
        Wall firstWall = new Wall(0, 1);
        Wall secondWall = new Wall(1, 0);

        field.add(greenApple);
        field.add(firstWall);
        field.add(secondWall);

        Level newLevel = new Level(2, 2, field);
        newLevel.generateApple();

        boolean flag = false;

        for (fieldItem item : newLevel.getField()){
            if (item.position.equals(new Point(1, 1)))
                if (item instanceof Apple)
                    flag = true;
        }
        assertTrue(flag);
    }
}