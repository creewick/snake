package game;

import game.gui.Gui;
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
import java.util.Map;

public class Main{

    public static final int cellSize = 20;

    public static void main(String args[]){

        Game firstGame = Main.firstGame();
        JFrame frame = new JFrame("Awesome Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        Gui newGui = new Gui(frame);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                for (int i = 0; i < newGui.getCurrentGame().players.size(); i++){
                    if (newGui.getCurrentGame().players.get(i).getControls().containsKey(e.getKeyCode())){
                        Point newPoint = newGui.getCurrentGame().players.get(i).getControls().get(e.getKeyCode()).asPoint();
                        Point oldPoint = newGui.getCurrentGame().directions.get(i);
                        if (newPoint.x != -oldPoint.x && newPoint.y != -oldPoint.y) {
                            newGui.getCurrentGame().tempDirections.remove(i);
                            newGui.getCurrentGame().tempDirections.add(i, newGui.getCurrentGame().players.get(i).getControls().get(e.getKeyCode()).asPoint());
                        }
                    }
                }
            }
        });
        newGui.setCurrentGame(firstGame());
        frame.add(newGui);
        frame.setVisible(true);
    }

    public static Game firstGame(){
        List<SnakePart> snake = new ArrayList();
        snake.add(new SnakePart(0, 0));
        snake.add(new SnakePart(1, 0));
        snake.add(new SnakePart(2, 0));

        HashMap<Integer, Direction> map1 = new HashMap();
        map1.put(38, Direction.Up);
        map1.put(37, Direction.Left);
        map1.put(39, Direction.Right);
        map1.put(40, Direction.Down);

        Player player = new Player(snake, map1);

        List<SnakePart> snake2 = new ArrayList();
        snake2.add(new SnakePart(10, 0));
        snake2.add(new SnakePart(11, 0));
        snake2.add(new SnakePart(12, 0));

        HashMap<Integer, Direction> map2 = new HashMap();
        map2.put(87, Direction.Up);
        map2.put(65, Direction.Left);
        map2.put(68, Direction.Right);
        map2.put(83, Direction.Down);

        Player player2 = new Player(snake2, map2);

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
