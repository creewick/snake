package game;

import game.GUI.Field;
import game.fieldItems.Apple;
import game.fieldItems.SnakePart;
import game.fieldItems.Wall;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main{

    public static void main(String args[]){

        Game firstGame = Main.firstGame();

        JFrame frame = new JFrame("Awesome Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        Field newField = new Field();
        newField.currentGame = firstGame();
        frame.add(newField);
        frame.setVisible(true);

    }

    public static Game firstGame(){
        List<SnakePart> snake = new ArrayList();
        snake.add(new SnakePart(0, 0));
        snake.add(new SnakePart(1, 0));
        snake.add(new SnakePart(2, 0));

        Player player = new Player(snake);
        List<Player> singlePlayer = new ArrayList<>();
        singlePlayer.add(player);

        Level oneLevel = new Level(50, 35);
        oneLevel.field = new HashSet<>();
        oneLevel.field.add(new Apple(10, 10));
        oneLevel.field.add(new Wall(20, 20));
        oneLevel.field.add(new Wall(21, 20));
        List<Level> levels = new ArrayList<>();
        levels.add(oneLevel);

        Game newGame = new Game(singlePlayer, levels);
        newGame.currentLevel = oneLevel;
        return newGame;
    }
}
