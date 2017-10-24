package game;

import game.fieldItems.Apple;
import game.fieldItems.SnakePart;
import game.fieldItems.Wall;

import javax.swing.JFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main{

    public static final int cellSize = 20;

    public static void main(String args[]){
        JFrame frame = new JFrame("Awesome Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        Gui ourGui = new Gui(frame);
        Game ourGame = testGame();
        ourGui.setCurrentGame(ourGame);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                for (int i = 0; i < ourGame.players.length; i++){
                    if (ourGame.players[i].getControls().containsKey(e.getKeyCode())){
                        Point newPoint = ourGame.players[i].getControls().get(e.getKeyCode()).asPoint();
                        Point oldPoint = ourGame.directions.get(i);
                        if (newPoint.x != -oldPoint.x && newPoint.y != -oldPoint.y) {
                            ourGame.tempDirections.remove(i);
                            ourGame.tempDirections.add(i, ourGame.players[i].getControls().get(e.getKeyCode()).asPoint());
                        }
                    }
                }
            }
        });
        frame.add(ourGui);
        frame.setVisible(true);
    }

    public static Player testPlayer1(){
        List<SnakePart> snake = new ArrayList();
        snake.add(new SnakePart(0, 0));
        snake.add(new SnakePart(1, 0));
        snake.add(new SnakePart(2, 0));

        HashMap<Integer, Direction> controls = new HashMap();
        controls.put(38, Direction.Up);
        controls.put(37, Direction.Left);
        controls.put(39, Direction.Right);
        controls.put(40, Direction.Down);

        return new Player(snake, controls);
    }

    public static Player testPlayer2(){
        List<SnakePart> snake = new ArrayList();
        snake.add(new SnakePart(10, 0));
        snake.add(new SnakePart(11, 0));
        snake.add(new SnakePart(12, 0));

        HashMap<Integer, Direction> controls = new HashMap();
        controls.put(87, Direction.Up);
        controls.put(65, Direction.Left);
        controls.put(68, Direction.Right);
        controls.put(83, Direction.Down);

        return new Player(snake, controls);
    }

    public static Level testLevel1(){
        Level level = new Level(20, 20);
        level.field = new HashSet<>();
        level.field.add(new Apple(10, 10));
        level.field.add(new Wall(15, 15));
        level.field.add(new Wall(15, 16));
        level.field.add(new Wall(15, 17));
        return level;
    }

    public static Game testGame(){
        Game game = new Game(new Player[] {testPlayer1(), testPlayer2()}, new Level[] {testLevel1()});
        game.currentLevel = testLevel1();
        return game;
    }
}
