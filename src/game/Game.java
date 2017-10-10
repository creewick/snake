package game;

import game.fieldItems.fieldItem;
import java.awt.*;
import java.util.Dictionary;
import java.util.List;


public class Game {

    public Level currentLevel;

    public Game(List<Player> players, List<Level> levels) {

        this.players = players;
        this.levels = levels;
    }

    private List<Level> levels;

    public List<Player> players;

    public void nextStep(Point direction, Player currentPlayer) {
        currentPlayer.moveSnake(direction);

        for (Player player : players)
            for (fieldItem item : currentLevel.field) {
                if (item.position.equals(player.getHead()))
                    item.onCollision(currentPlayer);
            }
    }
}
