package game;

import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;
import java.awt.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;


public class Game {

    public Level currentLevel;

    public Game(List<Player> players, List<Level> levels) {

        this.players = players;
        this.levels = levels;
    }

    public List<Level> levels;

    public List<Player> players;

    public List<SnakePart> getAllSnakeItems(Player currentPlayer){
        List<SnakePart> snakeParts = new ArrayList<>();
        for (Player player : players){
            for (SnakePart snakePart : player.snake){
                snakeParts.add(snakePart);
            }
        }
        snakeParts.remove(currentPlayer.getHead());
        return snakeParts;
    }

    public void nextStep(Point direction, Player currentPlayer) {
        currentPlayer.moveSnake(direction, currentLevel);

        for (SnakePart snakePart : this.getAllSnakeItems(currentPlayer)){
            if (snakePart.position.equals(currentPlayer.getHead().position))
                snakePart.onCollision(currentPlayer, currentLevel);
        }

        for (Player player : players)
            for (fieldItem item : currentLevel.field) {
                if (item.position.equals(player.getHead().position))
                    item.onCollision(currentPlayer, currentLevel);
            }



    }
}
