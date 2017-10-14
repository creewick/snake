package game.GUI;

import game.*;
import game.Point;
import game.fieldItems.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Field extends JPanel implements ActionListener{

    public Game currentGame;

    Timer mainTimer = new Timer(100, this);
    Image grass = new ImageIcon("images/grass.jpg").getImage();
    Image snakePart = new ImageIcon("images/snake_part.png").getImage();
    Image snakeHead = new ImageIcon("images/snake_head.png").getImage();
    Image redApple = new ImageIcon("images/red_apple.png").getImage();
    Image wall = new ImageIcon("images/wall.png").getImage();

    public Field(){
        mainTimer.start();
    }

    public void paint(Graphics g){
        ((Graphics2D) g).drawImage(grass, 0, 0, null);
        Image currentImage = redApple;
        for (fieldItem fieldItem : currentGame.currentLevel.field){
            if (fieldItem instanceof Apple)
                currentImage = redApple;
            if (fieldItem instanceof Wall)
                currentImage = wall;
            ((Graphics2D) g).drawImage(currentImage, fieldItem.position.x * 20, fieldItem.position.y * 20, null);
        }

        currentImage = snakePart;
        for (Player player : currentGame.players)
            for (SnakePart snakePart : player.snake)
                ((Graphics2D) g).drawImage(currentImage, snakePart.position.x * 20, snakePart.position.y * 20, null);
        ((Graphics2D) g).drawImage(snakeHead,
                currentGame.players.get(0).getHead().position.x * 20,
                currentGame.players.get(0).getHead().position.y * 20,
                null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentGame.nextStep(new Point(0, 1), currentGame.players.get(0));
        repaint();
    }
}
