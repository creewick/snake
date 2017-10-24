package game.fieldItems;

import game.Image;
import game.Level;
import game.Player;
import game.Point;

@Image(path="images/snake_part.png")
public class SnakePart extends fieldItem {

    public SnakePart(int x, int y){
        this.position = new Point(x, y);
    }

    public void onCollision(Player player, Level level) {
        player.Kill();
    }
}