package game.fieldItems;

import game.*;

public class SnakePart extends fieldItem {

    public SnakePart(int x, int y){
        this.position = new Point(x, y);
    }

    public void onCollision(Player player, Level level) {
        player.isGameOver = true;
    }
}