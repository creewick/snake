package game;

import com.sun.glass.ui.Size;
import game.fieldItems.fieldItem;
import java.awt.*;
import java.util.List;

public class Game {

    public Level currentLevel;

    private List<Level> levels;

    private Player player;

    boolean isGameOver;

    public void nextStep(Point direction) {
        player.moveSnake(direction);
        for (fieldItem item : currentLevel.field) {
            if (item.position.equals(player.getHead()))
                item.onCollision(player, isGameOver);
        }
    }
}
