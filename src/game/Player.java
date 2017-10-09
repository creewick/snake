package game;

import java.awt.*;
import java.util.List;

public class Player {

    public List<Point> snake;

    public Point velocity;

    public int score;

    public Point getHead() {
        return snake.get(snake.size() - 1);
    }

    public void moveSnake(Point direction) {
        snake.remove(0);
        snake.add(getHead().sum(direction));
    }
}