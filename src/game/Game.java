package game;

import game.fieldItems.fieldItem;
import java.awt.*;
import java.util.Dictionary;
import java.util.List;


public class Game {

    public Level currentLevel;

    public Game(List<Player> players, List<Level> levels) {
        this.players = players;
    }

    private List<Level> levels;

    private List<Player> players;

    boolean isGameOver;

    public void nextStep(Point direction) {
        for (Player player : this.players)
            player.moveSnake(direction);

        for (Player player : players){
            for (fieldItem item : currentLevel.field) {
                if (item.position.equals(player.getHead()))
                    item.onCollision(player, isGameOver);
            }
        }
    }
}
