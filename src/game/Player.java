package game;

import game.fieldItems.SnakePart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private List<SnakePart> snake;
    public List<SnakePart> getSnake() { return snake; }
    public void increaseSnake() { snake.add(getHead()); }

    private HashMap<Integer, Direction> controls;
    public HashMap<Integer, Direction> getControls() {return controls; }

    public int score;

    public boolean isDead;

    public void Kill(){
        this.snake = new ArrayList<>();
        isDead = true;
    }

    public Player(List<SnakePart> snake, HashMap<Integer, Direction> controls){
        this.snake = snake;
        this.controls = controls;
        this.score = 0;
    }

    public Player(List<SnakePart> snake){
        this.snake = snake;
        this.score = 0;
        this.controls = new HashMap<>();
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
