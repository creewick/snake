package game.fieldItems;

import game.Player;

public class SnakePart extends fieldItem {

    public void onCollision(Player player) {
        player.isGameOver = true;
    }
}