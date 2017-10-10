package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public Player(List<Point> snake, int score){
        this.snake = snake;
        this.score = score;
    }

    public List<Point> snake;

    public int score;

    public boolean isGameOver;

    public Point getHead() {
        return snake.get(snake.size() - 1);
    }

    public void moveSnake(Point direction) {
        this.snake.remove(0);
        this.snake.add(getHead().sum(direction));
    }
}
