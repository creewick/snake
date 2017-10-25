package game.fieldItems;

import game.Image;
import game.Level;
import game.Player;
import game.Point;

@Image(path="images/red_apple.png")
public class Apple extends fieldItem {

    public Apple(int x, int y){
        this.position = new Point(x, y);
    }

    public void onCollision(Player player, Level level) {
        player.addScore(100);
        player.increaseSnake();
        level.generateApple();
        level.getField().remove(this);
    }
}
