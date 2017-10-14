package game.fieldItems;

import game.Level;
import game.Player;
import game.Point;

public class Wall extends fieldItem {

    public Wall(int x, int y){
        this.position = new Point(x ,y);
    }

    public void onCollision(Player player, Level level) {
        player.Kill();
    }
}
