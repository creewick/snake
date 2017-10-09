package game;

import com.sun.glass.ui.Size;
import game.fieldItems.Apple;
import game.fieldItems.fieldItem;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class Level {

    public HashSet<fieldItem> field;

    public Size size;

    public void GenerateApple(int count) {
        List<Point> freeCells = new ArrayList<Point>();
        for (int x = 0; x < size.width; x++) {
            for (int y = 0; y < size.height; y++) {
                freeCells.add(new Point(x, y));
            }
        }
        for (fieldItem item : field) {
            for (Point cell : freeCells) {
                if (cell.equals(item.position))
                    freeCells.remove(cell);
            }
        }
        Point freePoint = freeCells.get(ThreadLocalRandom.current().nextInt(0, freeCells.size()));
        Apple apple = new Apple();
        apple.position = new Point(freePoint.x, freePoint.y);
        field.add(apple);
    }
}
