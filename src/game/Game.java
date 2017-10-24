package game;

import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Game {

    public Level currentLevel;
    public Level[] levels;
    public Player[] players;

    public Game(Player[] players, Level[] levels) {
        this.players = players;
        this.levels = levels;
    }

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
        for (int x = 0; x < players.length; x++)
            if (!players[x].isDead) {
                players[x].moveSnake(players[x].getDirection(), currentLevel);
                players[x].unlockKey();
        }

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
