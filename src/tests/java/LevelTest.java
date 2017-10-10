import game.Level;
import game.Point;
import game.fieldItems.Apple;
import game.fieldItems.Wall;
import game.fieldItems.fieldItem;
import org.junit.Test;

import java.util.HashSet;

import static junit.framework.TestCase.assertEquals;

public class LevelTest{

    @Test
    public void generateApple() throws Exception {
        Level newLevel = new Level();
        newLevel.size = new Point(2, 2);
        newLevel.field = new HashSet<fieldItem>();

        Apple greenApple = new Apple();
        greenApple.position = new Point(0, 0);

        Wall firstWall = new Wall();
        firstWall.position = new Point(0, 1);

        Wall secondWall = new Wall();
        firstWall.position = new Point(1, 0);

        newLevel.field.add(greenApple);
        newLevel.field.add(firstWall);
        newLevel.field.add(secondWall);

        newLevel.GenerateApple(1);

        for (fieldItem item : newLevel.field){
            if (item.position.equals(new Point(1, 1)))
                assertEquals(item.getClass() == greenApple.getClass(), true);

        }
    }
}