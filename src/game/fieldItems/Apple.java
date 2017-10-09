package game.fieldItems;

import game.Player;

import java.awt.*;

public class Apple extends fieldItem {

    public void onCollision(Player player, boolean isGameOver) {
        player.score += 100;
        player.snake.add(player.getHead());
    }
}
