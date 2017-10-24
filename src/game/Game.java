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

    public Game(Player[] players, Level[] levels) {

        this.players = players;
        this.levels = levels;
        this.directions = new ArrayList<>();
        this.tempDirections = new ArrayList<>();
        for (int i = 0; i < players.length; i++){
            directions.add(new Point(0, 1));
            tempDirections.add(new Point(0, 1));
        }
    }

    public Level[] levels;

    public Player[] players;

    public List<SnakePart> getSnakePartsToCollisionWith(Player currentPlayer){
        List<SnakePart> snakeParts = new ArrayList<>();
        for (Player player : players){
            for (SnakePart snakePart : player.getSnake()){
                snakeParts.add(snakePart);
            }
        }
        if (!currentPlayer.isDead)
            snakeParts.remove(currentPlayer.getHead());
        return snakeParts;
    }

    public void nextStep() {
        for (int x = 0; x < directions.size(); x++)
            if (!players[x].isDead)
                players[x].moveSnake(directions.get(x), currentLevel);

        for (Player player : players){
            for (SnakePart snakePart : this.getSnakePartsToCollisionWith(player)) {
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
