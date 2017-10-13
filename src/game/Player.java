package game;

import game.fieldItems.SnakePart;
import game.fieldItems.fieldItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public Player(List<SnakePart> snake){
        this.snake = snake;
    }

    public List<SnakePart> snake;

    public int score;

    public boolean isGameOver;

    public SnakePart getHead() {
        return snake.get(snake.size() - 1);
    }

    public void moveSnake(Point direction, Level level) {
        Point position = getHead().position.sum(direction);
        position.loopingInTheField(level.size.x, level.size.y);
        SnakePart head = new SnakePart(position.x, position.y);
        this.snake.add(head);
        level.field.add(head);
        level.field.remove(snake.get(0));
        this.snake.remove(0);
    }
}
