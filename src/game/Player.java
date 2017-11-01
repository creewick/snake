package game;

import game.fieldItems.SnakePart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private List<SnakePart> snake;
    public List<SnakePart> getSnake() { return snake; }
    public void increaseSnake() {
        SnakePart head = getHead();
        snake.add(head);
    }

    private HashMap<Integer, Direction> controls;
    public HashMap<Integer, Direction> getControls() {return controls; }

    private Direction direction;
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction dir) { direction = dir; }

    private int score;
    public int getScore(){
        return score;
    }
    public void addScore(int n){
        this.score += n;
    }

    private boolean isDead;
    public boolean isDead(){
        return isDead;
    }

    public void Kill(){
        this.snake = new ArrayList<>();
        isDead = true;
    }

    public Player(List<SnakePart> snake, HashMap<Integer, Direction> controls, Direction direction){
        this.snake = snake;
        this.controls = controls;
        this.direction = direction;
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

    public void moveSnake(Level level) {
        Point position = getHead().position.sum(direction.getPoint());
        position.loopingInTheField(level.getSize().x, level.getSize().y);
        SnakePart head = new SnakePart(position.x, position.y);
        this.snake.add(head);
        this.snake.remove(0);
    }
}
