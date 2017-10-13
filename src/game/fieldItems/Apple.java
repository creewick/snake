package game.fieldItems;

import game.Level;
import game.Player;

import java.awt.*;
import java.util.HashSet;

public class Apple extends fieldItem {

    public void onCollision(Player player, Level level) {
        player.score += 100;
        player.snake.add(player.getHead());
        level.field.remove(this);
    }
}
