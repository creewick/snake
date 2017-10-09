package game.fieldItems;

import game.Player;

public class Wall extends fieldItem {

    public void onCollision(Player player, boolean isGameOver) {
        isGameOver = true;
    }
}
