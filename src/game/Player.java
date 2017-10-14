package game;

import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<SnakePart> snake;

    public int score;

    public boolean isGameOver;

    public Player(List<SnakePart> snake){

        this.snake = snake;
        this.score = 0;
        this.isGameOver = false;
    }

    public SnakePart getHead() {
        return snake.get(snake.size() - 1);
    }

    public void moveSnake(Point direction, Level level) {
        Point position = getHead().position.sum(direction);
        position.loopingInTheField(level.size.x, level.size.y);
        SnakePart head = new SnakePart(position.x, position.y);
        this.snake.add(head);
        this.snake.remove(0);
    }
}
