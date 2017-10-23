package game.fieldItems;

import game.Level;
import game.Player;
import game.Point;

public class Apple extends fieldItem {

    public Apple(int x, int y){
        this.position = new Point(x, y);
    }

    public void onCollision(Player player, Level level) {
        player.score += 100;
        player.increaseSnake();
        level.generateApple();
        level.field.remove(this);
    }
}
