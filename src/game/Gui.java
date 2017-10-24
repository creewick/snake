package game;

import game.fieldItems.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Image;

import java.io.File;


public class Gui extends JPanel implements ActionListener{

    private Game currentGame;
    public void setCurrentGame(Game game) { currentGame = game; }

    private JFrame frame;
    private final int fps = 5;
    private int counter = fps*1;

    private int cellWidth() {return frame.getWidth() / (currentGame.currentLevel.size.x + 1);}
    private int cellHeight() {return frame.getHeight() / (currentGame.currentLevel.size.y + 1);}

    private Timer mainTimer = new Timer(1000/fps, this);

    //Убрать после изучения аттрибутов
    Sound bgm = new Sound(new File("music/bgm.wav"));
    Image background = new ImageIcon("images/bg.jpg").getImage();
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

    private void animateHead(int counter, Graphics g, Image head1, Image head2, Player player){
        Image currentImage = counter % 2 == 0
                ? head2
                : head1;
        g.drawImage(currentImage,
                player.getHead().position.x * cellWidth() - (cellWidth() / 2),
                player.getHead().position.y * cellHeight() - (cellHeight() / 2),
                cellWidth() * 2, cellHeight() * 2,
                null);
    }

    private void drawBackground(Graphics g){
        g.drawImage(background, 0, 0, frame.getWidth(), frame.getHeight(), null);
    }

    private void drawLogo(Graphics g){
        g.drawImage(poppy, 100, 0, frame.getWidth() - 200, frame.getHeight() - 100, null);
    }

    private void drawObjects(Graphics g){
        for (fieldItem fieldItem : currentGame.currentLevel.field) {
            g.drawImage(fieldItem.getClass().getAnnotation(game.Image).path().getImage())
            //Убрать после изучения атрибутов
            if (fieldItem instanceof Apple)
                g.drawImage(redApple,
                        fieldItem.position.x * cellWidth() - (cellWidth() / 2),
                        fieldItem.position.y * cellHeight() - (cellHeight() / 2),
                        cellWidth() * 2, cellHeight() * 2, null);
            if (fieldItem instanceof Wall)
                g.drawImage(wall,
                        fieldItem.position.x * cellWidth(),
                        fieldItem.position.y * cellHeight(),
                        cellWidth(), cellHeight(), null);
        }
    }

    private void drawSnakes(Graphics g){
        for (int i=0; i < currentGame.players.length; i++) {
            Player player = currentGame.players[i];
            if (!player.isDead) {
                for (SnakePart snakePart : player.getSnake()) {
                    g.drawImage(snakePartImage,
                            snakePart.position.x * cellWidth(),
                            snakePart.position.y * cellHeight(),
                            cellWidth(), cellHeight(), null);
                }
                if (i == 0) {
                    animateHead(counter, g, snakeHead1, snakeHead2, player);
                } else {
                    animateHead(counter, g, snake2Head1, snake2Head2, player);
                }
            }
        }
    }

    public void paint(Graphics g){
        g.clearRect(0, 0, frame.getWidth(), frame.getHeight());
        if (counter > 0) {
            drawLogo(g);
            return;
        }
        drawBackground(g);
        drawObjects(g);
        drawSnakes(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter--;
        //рисовать один раз
        if (counter < 0){
            currentGame.directions.clear();
            for (Point point : currentGame.tempDirections){
                currentGame.directions.add(point);
            }
            currentGame.nextStep();
        }
        bgm.play(false);
        repaint();
    }
}
