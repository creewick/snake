package game;

import javax.swing.*;
import java.awt.Image;
import java.util.HashMap;
import java.io.File;

public class Resources {
    public static HashMap<String, Image> getImages() {
        HashMap<String, Image> result = new HashMap<>();
        result.put("background", new ImageIcon("images/bg.jpg").getImage());
        result.put("snakeHead1", new ImageIcon("images/bober1.png").getImage());
        result.put("snakeHead2", new ImageIcon("images/bober2.png").getImage());
        result.put("snake2Head1", new ImageIcon("images/sham1.png").getImage());
        result.put("snake2Head2", new ImageIcon("images/sham2.png").getImage());
        result.put("poppy", new ImageIcon("images/poppy.jpg").getImage());
        return result;
    }

    public static Sound getSound() {
        return new Sound(new File("music/bgm.wav"));
    }
}
