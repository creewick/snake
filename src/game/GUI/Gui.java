package game.gui;

import game.*;
import game.fieldItems.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JPanel implements ActionListener{

    public Game currentGame;


    public final int fps = 10;
    public int counter = fps*1;

    Timer mainTimer = new Timer(1000/fps, this);
    Image grass = new ImageIcon("images/grass.png").getImage();
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

    private int cellWidth() {return frame.getWidth() / (currentGame.currentLevel.size.x+1);}
    private int cellHeight() {return frame.getHeight() / (currentGame.currentLevel.size.y+1);}

    public void paint(Graphics g){
        if (counter > 0) {
            ((Graphics2D) g).drawImage(poppy, 0, 0, frame.getWidth(), frame.getHeight(), null);
        } else {
            for (int x = 0; x < currentGame.currentLevel.size.x; x++){
                for (int y = 0; y < currentGame.currentLevel.size.y; y++){
                    ((Graphics2D) g).drawImage(grass, x * cellWidth(), y * cellHeight(), cellWidth(), cellHeight(), null);
                }
            }
            Image currentImage = redApple;
            for (fieldItem fieldItem : currentGame.currentLevel.field) {
                if (fieldItem instanceof Apple)
                    currentImage = redApple;
                if (fieldItem instanceof Wall)
                    currentImage = wall;
                ((Graphics2D) g).drawImage(currentImage, fieldItem.position.x * cellWidth(),
                        fieldItem.position.y * cellHeight(), cellWidth(), cellHeight(), null);
            }

            currentImage = snakePart;
            for (Player player : currentGame.players) {
                if (!player.isDead) {
                    for (SnakePart snakePart : player.snake) {
                        ((Graphics2D) g).drawImage(currentImage, snakePart.position.x * cellWidth(),
                                snakePart.position.y * cellHeight(), cellWidth(), cellHeight(), null);
                    }
                    ((Graphics2D) g).drawImage(snakeHead,
                            player.getHead().position.x * cellWidth(),
                            player.getHead().position.y * cellHeight(),
                            cellWidth(), cellHeight(),
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
