package game.fieldItems;

import game.Image;
import game.Level;
import game.Player;
import game.Point;

@Image(path="images/wall.jpg")
public class Wall extends fieldItem {

    public Wall(int x, int y){
        this.position = new Point(x ,y);
    }

    public void onCollision(Player player, Level level) {
        player.Kill();
    }
}
