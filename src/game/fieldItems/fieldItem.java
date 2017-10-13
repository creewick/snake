package game.fieldItems;

import game.Level;
import game.Player;
import game.Point;

public abstract class fieldItem {

    public abstract void onCollision(Player player, Level level);

    public Point position;
}
