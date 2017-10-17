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


    public final int fps = 5;
    public int counter = fps*1;

    Timer mainTimer = new Timer(1000/fps, this);
    Image backGround = new ImageIcon("images/bg.jpg").getImage();
    Image snakePartImage = new ImageIcon("images/snake_part.png").getImage();
    Image snakeHead1 = new ImageIcon("images/bober1.png").getImage();
    Image snakeHead2 = new ImageIcon("images/bober2.png").getImage();
    Image snake2Head1 = new ImageIcon("images/sham1.png").getImage();
    Image snake2Head2 = new ImageIcon("images/sham2.png").getImage();
    Image redApple = new ImageIcon("images/red_apple.png").getImage();
    Image wall = new ImageIcon("images/wall.jpg").getImage();
    Image poppy = new ImageIcon("images/poppy.jpg").getImage();

    public Gui(JFrame frame){
        this.frame = frame;
        mainTimer.start();
    }

    private JFrame frame;

    private int cellWidth() {return frame.getWidth() / (currentGame.currentLevel.size.x + 1);}
    private int cellHeight() {return frame.getHeight() / (currentGame.currentLevel.size.y + 1);}

    public void paint(Graphics g){
        g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
        if (counter > 0) {
            g.drawImage(poppy, 100, 0, frame.getWidth() - 200, frame.getHeight()- 100, null);
        } else {
            g.drawImage(backGround, 0, 0, frame.getWidth(), frame.getHeight(), null);
            for (fieldItem fieldItem : currentGame.currentLevel.field) {
                if (fieldItem instanceof Apple)
                    g.drawImage(redApple, fieldItem.position.x * cellWidth() - (cellWidth() / 2),
                            fieldItem.position.y * cellHeight() - (cellHeight() / 2), cellWidth() * 2, cellHeight() * 2, null);
                if (fieldItem instanceof Wall)
                    g.drawImage(wall, fieldItem.position.x * cellWidth(),
                            fieldItem.position.y * cellHeight(), cellWidth(), cellHeight(), null);
            }

            for (int i=0; i < currentGame.players.size(); i++) {
                Player player = currentGame.players.get(i);
                if (!player.isDead) {
                    for (SnakePart snakePart : player.snake) {
                        g.drawImage(snakePartImage, snakePart.position.x * cellWidth(),
                                snakePart.position.y * cellHeight(), cellWidth(), cellHeight(), null);
                    }
                    if (counter % 2 == 0) {
                        if (i == 0) {
                            g.drawImage(snakeHead1,
                                    player.getHead().position.x * cellWidth() - (cellWidth() / 2),
                                    player.getHead().position.y * cellHeight() - (cellHeight() / 2),
                                    cellWidth() * 2, cellHeight() * 2,
                                    null);
                        } else {
                            g.drawImage(snake2Head1,
                                    player.getHead().position.x * cellWidth() - (cellWidth() / 2),
                                    player.getHead().position.y * cellHeight() - (cellHeight() / 2),
                                    cellWidth() * 2, cellHeight() * 2,
                                    null);
                        }
                    } else {
                        if (i==0) {
                            g.drawImage(snakeHead2,
                                    player.getHead().position.x * cellWidth() - (cellWidth() / 2),
                                    player.getHead().position.y * cellHeight() - (cellHeight() / 2),
                                    cellWidth() * 2, cellHeight() * 2,
                                    null);
                        } else {
                            g.drawImage(snake2Head2,
                                    player.getHead().position.x * cellWidth() - (cellWidth() / 2),
                                    player.getHead().position.y * cellHeight() - (cellHeight() / 2),
                                    cellWidth() * 2, cellHeight() * 2,
                                    null);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter--;
        if (counter < 0){
            currentGame.nextStep();
        }
        repaint();
    }
}
