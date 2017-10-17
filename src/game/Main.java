package game;

import game.gui.Gui;
import game.fieldItems.Apple;
import game.fieldItems.SnakePart;
import game.fieldItems.Wall;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;

public class Main{

    static private List<Map<Integer, Point>> controls = new ArrayList();

    static private void createControls(){
        Map<Integer, Point> map1 = new HashMap();
        map1.put(38, new Point(0, -1));
        map1.put(37, new Point(-1, 0));
        map1.put(39, new Point(1, 0));
        map1.put(40, new Point(0, 1));
        controls.add(map1);
        Map<Integer, Point> map2 = new HashMap();
        map2.put(87, new Point(0,-1));
        map2.put(65, new Point(-1, 0));
        map2.put(83, new Point(0, 1));
        map2.put(68, new Point(1, 0));
        controls.add(map2);
    };

    public static final int cellSize = 20;

    public static void main(String args[]){

        Game firstGame = Main.firstGame();
        createControls();
        JFrame frame = new JFrame("Awesome Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        Gui newGui = new Gui(frame);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                for (int i = 0; i < newGui.currentGame.players.size(); i++){
                    if (controls.get(i).containsKey(e.getKeyCode())){
                        Point newPoint = controls.get(i).get(e.getKeyCode());
                        Point oldPoint = newGui.currentGame.directions.get(i);
                        if (newPoint.x != -oldPoint.x && newPoint.y != -oldPoint.y) {
                            newGui.currentGame.tempDirections.remove(i);
                            newGui.currentGame.tempDirections.add(i, controls.get(i).get(e.getKeyCode()));
                        }
                    }
                }
            }
        });
        newGui.currentGame = firstGame();
        frame.add(newGui);
        frame.setVisible(true);
    }

    public static Game firstGame(){
        List<SnakePart> snake = new ArrayList();
        snake.add(new SnakePart(0, 0));
        snake.add(new SnakePart(1, 0));
        snake.add(new SnakePart(2, 0));

        Player player = new Player(snake);
        List<SnakePart> snake2 = new ArrayList();
        snake2.add(new SnakePart(10, 0));
        snake2.add(new SnakePart(11, 0));
        snake2.add(new SnakePart(12, 0));
        Player player2 = new Player(snake2);

        List<Player> singlePlayer = new ArrayList<>();
        singlePlayer.add(player);
        singlePlayer.add(player2);

        Level oneLevel = new Level(20, 20);
        oneLevel.field = new HashSet<>();
        oneLevel.field.add(new Apple(10, 10));
        oneLevel.field.add(new Wall(15, 15));
        oneLevel.field.add(new Wall(15, 16));
        oneLevel.field.add(new Wall(15, 17));
        List<Level> levels = new ArrayList<>();
        levels.add(oneLevel);

        Game newGame = new Game(singlePlayer, levels);
        newGame.currentLevel = oneLevel;
        return newGame;
    }
}
