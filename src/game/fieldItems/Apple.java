package game.fieldItems;

import game.Level;
import game.Player;
import game.Point;

import java.awt.*;
import java.util.HashSet;

public class Apple extends fieldItem {

    public Apple(int x, int y){
        this.position = new Point(x, y);
    }

    public void onCollision(Player player, Level level) {
        player.score += 100;
        player.snake.add(player.getHead());
        level.generateApple(1);
        level.field.remove(this);
    }
}
