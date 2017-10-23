package game;

import game.fieldItems.*;


import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Level {

    public HashSet<fieldItem> field;

    public Point size;

    public Level(int x, int y){
        this.size = new Point(x, y);
    }

    public void generateApple() {
        List<Point> freeCells = new ArrayList<>();
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                boolean flag = false;
                for (fieldItem item : field) {
                    if (item.position.x == x && item.position.y == y) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    freeCells.add(new Point(x, y));
                }
            }
        }

        if (freeCells.size() == 0){
            return;
        }

        Point freePoint = freeCells.get(ThreadLocalRandom.current().nextInt(0, freeCells.size()));
        Apple apple = new Apple(freePoint.x, freePoint.y);
        field.add(apple);
    }
}
