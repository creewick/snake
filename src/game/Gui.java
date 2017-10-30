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
import java.util.HashMap;


public class Gui extends JPanel implements ActionListener{

    private Game currentGame;
    public void setCurrentGame(Game game) { currentGame = game; }

    private JFrame frame;
    private final int fps = 5;
    private int counter = fps*1;

    private int cellWidth() {return frame.getWidth() / (currentGame.getCurrentLevel().getSize().x + 1);}
    private int cellHeight() {return frame.getHeight() / (currentGame.getCurrentLevel().getSize().y + 1);}

    private HashMap<String, Image> images;
    private Sound bgm;

    private Timer mainTimer = new Timer(1000/fps, this);

    public Gui(JFrame frame){
        this.frame = frame;
        this.images = Resources.getImages();
        this.bgm = Resources.getSound();
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
        g.drawImage(images.get("background"), 0, 0, frame.getWidth(), frame.getHeight(), null);
    }

    private void drawLogo(Graphics g){
        g.drawImage(images.get("poppy"), 100, 0, frame.getWidth() - 200, frame.getHeight() - 100, null);
    }

    private void drawObjects(Graphics g){
        for (fieldItem fieldItem : currentGame.getCurrentLevel().getField()) {
            g.drawImage(new ImageIcon(fieldItem.getClass().getAnnotation(game.Image.class).path()).getImage(),
                    fieldItem.position.x * cellWidth(),
                    fieldItem.position.y * cellHeight(),
                    cellWidth(), cellHeight(), null);
        }
    }

    private void drawSnakes(Graphics g){
        for (int i=0; i < currentGame.getPlayers().length; i++) {
            Player player = currentGame.getPlayers()[i];
            if (!player.isDead()) {
                for (SnakePart snakePart : player.getSnake()) {
                    g.drawImage(new ImageIcon(snakePart.getClass().getAnnotation(game.Image.class).path()).getImage(),
                            snakePart.position.x * cellWidth(),
                            snakePart.position.y * cellHeight(),
                            cellWidth(), cellHeight(), null);
                }
                if (i == 0) {
                    animateHead(counter, g, images.get("snakeHead1"), images.get("snakeHead2"), player);
                } else {
                    animateHead(counter, g, images.get("snake2Head1"), images.get("snake2Head2"), player);
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
        for (Player player: Main.getLocks().keySet()){
//            Main.getLocks().get(player) = false;
        }
        if (counter < 0){
            currentGame.nextStep();
        }
        bgm.play(false);
        repaint();
    }
}
