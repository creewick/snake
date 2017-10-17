package game;

import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Game {

    public Level currentLevel;

    public List<Point> directions;

    public List<Point> tempDirections;

    public Game(List<Player> players, List<Level> levels) {

        this.players = players;
        this.levels = levels;
        this.directions = new ArrayList<>();
        this.tempDirections = new ArrayList<>();
        for (int i = 0; i < players.size(); i++){
            directions.add(new Point(0, 1));
            tempDirections.add(new Point(0, 1));
        }
    }

    public List<Level> levels;

    public List<Player> players;

    public List<SnakePart> snakePartToBoom(Player currentPlayer){
        List<SnakePart> snakeParts = new ArrayList<>();
        for (Player player : players){
            for (SnakePart snakePart : player.snake){
                snakeParts.add(snakePart);
            }
        }
        if (!currentPlayer.isDead)
            snakeParts.remove(currentPlayer.getHead());
        return snakeParts;
    }

    public void nextStep() {
        for (int x = 0; x < directions.size(); x++)
            if (!players.get(x).isDead)
                players.get(x).moveSnake(directions.get(x), currentLevel);

        for (Player player : players){
            for (SnakePart snakePart : this.snakePartToBoom(player)) {
                if (!player.isDead && snakePart.position.equals(player.getHead().position))
                    snakePart.onCollision(player, currentLevel);
            }
        }

        HashSet<fieldItem> oldField = new HashSet<>();
        for (fieldItem item : currentLevel.field)
            oldField.add(item);

        for (Player player : players) {
            for (fieldItem item : oldField) {
                if (!player.isDead && item.position.equals(player.getHead().position))
                    item.onCollision(player, currentLevel);
            }
        }
    }
}
