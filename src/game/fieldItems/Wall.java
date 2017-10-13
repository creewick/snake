package game.fieldItems;

import game.Level;
import game.Player;

public class Wall extends fieldItem {

    public void onCollision(Player player, Level level) {
        player.isGameOver = true;
    }
}
