package game;

import game.fieldItems.Apple;
import game.fieldItems.SnakePart;
import game.fieldItems.Wall;
import game.fieldItems.fieldItem;

import javax.swing.JFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main{

    public static final int cellSize = 20;

    private static HashMap<Player, Boolean> locks;
    public static HashMap<Player, Boolean> getLocks(){
        return locks;
    }

    public static void main(String args[]){
        JFrame frame = new JFrame("Awesome Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        Gui ourGui = new Gui(frame);
        Game ourGame = testGame();
        locks = getLocks(ourGame);
        ourGui.setCurrentGame(ourGame);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                for (Player player : ourGame.getPlayers()) {
                    if (!locks.get(player) && player.getControls().containsKey(e.getKeyCode())) {
                        Direction newDirection = player.getControls().get(e.getKeyCode());
                        Direction oldDirection = player.getDirection();
                        if (newDirection == oldDirection.getLeft() || newDirection == oldDirection.getRight()) {
                            player.setDirection(newDirection);
                            locks.put(player, true);
                        }
                    }
                }
            }
        });
//                for (int i = 0; i < ourGame.getPlayers().length; i++){
//                    if (!ourGame.getPlayers()[i].isKeyLocked() && ourGame.getPlayers()[i].getControls().containsKey(e.getKeyCode())){
//                        Direction newDirection = ourGame.getPlayers()[i].getControls().get(e.getKeyCode());
//                        Direction oldDirection = ourGame.getPlayers()[i].getDirection();
//                        if (newDirection == oldDirection.getLeft() || newDirection == oldDirection.getRight()) {
//                            ourGame.getPlayers()[i].setDirection(newDirection);
//                            ourGame.getPlayers()[i].lockKey();
//                        }
//                    }
//                }
//            }
        frame.add(ourGui);
        frame.setVisible(true);
    }

    public static HashMap<Player, Boolean> getLocks(Game game){
        HashMap<Player, Boolean> result = new HashMap<>();
        for (Player player: game.getPlayers()){
            result.put(player, false);
        }
        return result;
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

        return new Player(snake, controls, Direction.Down);
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

        return new Player(snake, controls, Direction.Down);
    }

    public static Level testLevel1(){
        HashSet<fieldItem> field = new HashSet<>();
        field.add(new Apple(10, 10));
        field.add(new Wall(15, 15));
        field.add(new Wall(15, 16));
        field.add(new Wall(15, 17));
        Level level = new Level(20, 20, field);
        return level;
    }

    public static Game testGame(){
        Game game = new Game(new Player[] {testPlayer1(), testPlayer2()}, new Level[] {testLevel1()});
        game.setCurrentLevel(testLevel1());
        return game;
    }
}
