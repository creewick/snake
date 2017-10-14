package game.GUI;

import game.*;
import game.Point;
import game.fieldItems.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

public class Gui extends JPanel implements ActionListener{

    public Game currentGame;


    public final int fps = 10;
    public int counter = fps*1;

    Timer mainTimer = new Timer(1000/fps, this);
    Image grass = new ImageIcon("images/grass.jpg").getImage();
    Image snakePart = new ImageIcon("images/snake_part.png").getImage();
    Image snakeHead = new ImageIcon("images/snake_head.png").getImage();
    Image redApple = new ImageIcon("images/red_apple.png").getImage();
    Image wall = new ImageIcon("images/wall.png").getImage();
    Image poppy = new ImageIcon("images/poppy.jpg").getImage();

    public Gui(JFrame frame){
        this.frame = frame;
        mainTimer.start();
    }

    private JFrame frame;

    private int cellWidth() {return frame.getWidth() / currentGame.currentLevel.size.x;}
    private int cellHeight() {return frame.getHeight() / currentGame.currentLevel.size.y;}

    public void paint(Graphics g){
        ((Graphics2D) g).drawImage(grass, 0, 0, null);
        if (counter > 0) {
            ((Graphics2D) g).drawImage(poppy, 0, -50, 1000, 1000, null);
        } else {
            Image currentImage = redApple.getScaledInstance(cellWidth(), cellHeight(), Image.SCALE_DEFAULT);
            for (fieldItem fieldItem : currentGame.currentLevel.field) {
                if (fieldItem instanceof Apple)
                    currentImage = redApple.getScaledInstance(cellWidth(), cellHeight(), Image.SCALE_DEFAULT);
                if (fieldItem instanceof Wall)
                    currentImage = wall.getScaledInstance(cellWidth(), cellHeight(), Image.SCALE_DEFAULT);
                ((Graphics2D) g).drawImage(currentImage, fieldItem.position.x * cellWidth(),
                        fieldItem.position.y * cellHeight(), null);
            }

            currentImage = snakePart.getScaledInstance(cellWidth(), cellHeight(), Image.SCALE_DEFAULT);
            for (Player player : currentGame.players) {
                if (!player.isDead) {
                    for (SnakePart snakePart : player.snake) {
                        ((Graphics2D) g).drawImage(currentImage, snakePart.position.x * cellWidth(),
                                snakePart.position.y * cellHeight(), null);
                    }
                    ((Graphics2D) g).drawImage(snakeHead.getScaledInstance(cellWidth(), cellHeight(), Image.SCALE_DEFAULT),
                            player.getHead().position.x * cellWidth(),
                            player.getHead().position.y * cellHeight(),
                            null);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (counter > 0) {
            counter--;
        } else {
            currentGame.nextStep();
        }
        repaint();
    }
}
