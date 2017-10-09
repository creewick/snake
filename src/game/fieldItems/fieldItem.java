package game.fieldItems;

import game.Player;
import game.Point;

public abstract class fieldItem {

    public abstract void onCollision(Player player, boolean isGameOver);

    public Point position;
}
