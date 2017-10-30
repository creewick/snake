package game;

import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Game {

    private Level currentLevel;
    public Level getCurrentLevel() {
        return currentLevel;
    }
    public void setCurrentLevel(Level level){
        currentLevel = level;
    }

    private Level[] levels;
    private Player[] players;

    public Player[] getPlayers() {
        return players;
    }

    public Game(Player[] players, Level[] levels) {
        this.players = players;
        this.levels = levels;
    }

    public List<SnakePart> getEvilHeads(Player currentPlayer){
        List<SnakePart> evilHeads = new ArrayList<>();
        for (Player player : players){
            if (!player.isDead())
                evilHeads.add(player.getHead());
        }
        if (!currentPlayer.isDead()){
            evilHeads.remove(currentPlayer.getHead());
        }
        return evilHeads;
    }

    public List<SnakePart> getSnakePartsToCollisionWith(Player currentPlayer){
        List<SnakePart> snakeParts = new ArrayList<>();
        for (Player player : players){
            if (!player.isDead())
                for (SnakePart snakePart : player.getSnake()){
                    snakeParts.add(snakePart);
                }
        }
        if (!currentPlayer.isDead())
            snakeParts.remove(currentPlayer.getHead());
        return snakeParts;
    }

    public void nextStep() {
        for (int x = 0; x < players.length; x++)
            if (!players[x].isDead()) {
                players[x].moveSnake(currentLevel);
        }

        HashMap<Player, SnakePart> CollisionHeads = new HashMap<>();

        for (Player player : players){
            if (!player.isDead()){
                for (SnakePart evilHead : getEvilHeads(player)){
                    if (evilHead.position.equals(player.getHead()))
                        CollisionHeads.put(player, evilHead);
                }
            }
        }

        for (Player player : CollisionHeads.keySet()){
            CollisionHeads.get(player).onCollision(player, currentLevel);
        }

        for (Player player : players){
            for (SnakePart snakePart : this.getSnakePartsToCollisionWith(player)) {
                if (!player.isDead() && snakePart.position.equals(player.getHead().position))
                    snakePart.onCollision(player, currentLevel);
            }
        }

        HashSet<fieldItem> oldField = new HashSet<>();
        for (fieldItem item : currentLevel.getField())
            oldField.add(item);

        for (Player player : players) {
            for (fieldItem item : oldField) {
                if (!player.isDead() && item.position.equals(player.getHead().position))
                    item.onCollision(player, currentLevel);
            }
        }
    }
}
