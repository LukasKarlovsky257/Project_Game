
package org.example;

import org.example.logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static org.example.logic.Direction.*;

public class GameLogic {
    public static Player player;
    private static ArrayList<Enemy> enemies;
    private ArrayList<Bush> bushes;
    private ArrayList<Wall> walls;
    private final int ENEMY_STEPS = 5;
    private final int ITEM_STEPS = 10;
    public PNG bg = new PNG(0,0,"Background_no_object.png");
    public PNG logo = new PNG(0,0,"Perseus.png");
    public JOptionPane pane = new JOptionPane();
    public int time;
    public Item item1;
    public int level;
    public int enemy_X;
    public int enemy_Y;

    public GameLogic() {
        this.player = null;
        this.enemies = new ArrayList<>();
        this.bushes = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.level = 0;
    }

    public void initialize() {
        if (level == 0) {
            bg = new PNG(0,0,"Background_no_object.png");
            logo = new PNG(0,0,"Perseus.png");
            item1 = new Item(500, 200, "Item.png");

            bushes = new ArrayList<>();
            Bush bush1 = new Bush(-100, 200,"Object.png");
            Bush bush2 = new Bush(600, 150, "Object.png");
            Bush bush3 = new Bush(100, 300, "Object.png");
            Bush bush4 = new Bush(500, 300, "Object.png");
            Bush bush5 = new Bush(300, 300, "Object.png");
            Bush bush6 = new Bush(-100, 0,"Object.png");
            Bush bush7 = new Bush(-100,  0,"Object.png");
            Bush bush8 = new Bush(600, -50,"Object.png");
            bushes.add(bush1);
            bushes.add(bush2);
            bushes.add(bush3);
            bushes.add(bush4);
            bushes.add(bush5);
            bushes.add(bush6);
            bushes.add(bush7);
            bushes.add(bush8);
        }

        if (level == 1) {
            setTime(700);
            player = new Player(20, 20, "Player_down.png");
            bg = new PNG(0, 0, "Background_no_object.png");

            walls = new ArrayList<>();
            Wall wall1 = new Wall(0,0,1080,0, Color.BLACK);
            Wall wall2 = new Wall(0,0,0,720, Color.RED);
            Wall wall3 = new Wall(1000,720,1000,0, Color.BLUE);
            Wall wall4 = new Wall(0,720,1080,720, Color.ORANGE);
            walls.add(wall1);
            walls.add(wall2);
            walls.add(wall3);
            walls.add(wall4);

            enemies = new ArrayList<>();
            Enemy enemy1 = new Enemy(500,0, "Enemy_down.png");
            Enemy enemy2 = new Enemy(200,0, "Enemy_down.png");

            enemies.add(enemy1);
            enemies.add(enemy2);

            bushes = new ArrayList<>();
            Bush bush1 = new Bush(-100, 150,"Object.png");
            Bush bush2 = new Bush(200, -100, "Object.png");
            Bush bush3 = new Bush(500, 0, "Object.png");
            bushes.add(bush1);
            bushes.add(bush2);
            bushes.add(bush3);

            item1 = new Item(700,200,"Item.png");
        }

        if (level == 2) {
            setTime(500);
            player = new Player(20, 20, "Player_down.png");
            bg = new PNG(0, 0, "Background_no_object.png");

            walls = new ArrayList<>();
            Wall wall1 = new Wall(0,0,1080,0, Color.BLACK);
            Wall wall2 = new Wall(0,0,0,720, Color.RED);
            Wall wall3 = new Wall(1080,720,1080,0, Color.BLUE);
            Wall wall4 = new Wall(0,720,1080,720, Color.ORANGE);
            walls.add(wall1);
            walls.add(wall2);
            walls.add(wall3);
            walls.add(wall4);

            enemies = new ArrayList<>();
            Enemy enemy1 = new Enemy(250,100, "Enemy_down.png");
            Enemy enemy2 = new Enemy(100,50, "Enemy_down.png");
            Enemy enemy3 = new Enemy(300, 0, "Enemy_down.png");
            enemies.add(enemy1);
            enemies.add(enemy2);
            enemies.add(enemy3);

            bushes = new ArrayList<>();
            Bush bush1 = new Bush(-100, 250,"Object.png");
            Bush bush2 = new Bush(200, -100, "Object.png");
            Bush bush3 = new Bush(350, 0, "Object.png");
            Bush bush4 = new Bush(0, 0, "Object.png");
            Bush bush5 = new Bush(100, 200, "Object.png");
            Bush bush6 = new Bush(700, 0, "Object.png");
            Bush bush7 = new Bush(500, 200, "Object.png");
            bushes.add(bush1);
            bushes.add(bush2);
            bushes.add(bush3);
            bushes.add(bush4);
            bushes.add(bush5);
            bushes.add(bush6);
            bushes.add(bush7);

            item1 = new Item(700,400,"Item.png");
        }
        if (level == 3) {
            setTime(250);
            player = new Player(20, 20, "Player_down.png");
            bg = new PNG(0, 0, "Background_no_object.png");

            walls = new ArrayList<>();
            Wall wall1 = new Wall(0,0,1080,0, Color.BLACK);
            Wall wall2 = new Wall(0,0,0,720, Color.RED);
            Wall wall3 = new Wall(1080,720,1080,0, Color.BLUE);
            Wall wall4 = new Wall(0,720,1080,720, Color.ORANGE);
            walls.add(wall1);
            walls.add(wall2);
            walls.add(wall3);
            walls.add(wall4);

            enemies = new ArrayList<>();
            Enemy enemy1 = new Enemy(0,0, "Enemy_down.png");
            Enemy enemy2 = new Enemy(10,100, "Enemy_down.png");
            Enemy enemy3 = new Enemy(400,0, "Enemy_down.png");
            Enemy enemy4 = new Enemy(300,200, "Enemy_down.png");
            enemies.add(enemy1);
            enemies.add(enemy2);
            enemies.add(enemy3);
            enemies.add(enemy4);

            bushes = new ArrayList<>();
            Bush bush1 = new Bush(200, -100, "Object.png");
            Bush bush2 = new Bush(0, 0, "Object.png");
            Bush bush3 = new Bush(-150, -100, "Object.png");
            Bush bush4 = new Bush(-150, 200, "Object.png");
            Bush bush5 = new Bush(500, 300, "Object.png");
            Bush bush6 = new Bush(-10, 300, "Object.png");
            Bush bush7 = new Bush(250, 300, "Object.png");
            Bush bush8 = new Bush(700, 100, "Object.png");
            Bush bush9 = new Bush(500, 0, "Object.png"); //keř
            bushes.add(bush1);
            bushes.add(bush2);
            bushes.add(bush3);
            bushes.add(bush4);
            bushes.add(bush5);
            bushes.add(bush6);
            bushes.add(bush7);
            bushes.add(bush8);
            bushes.add(bush9);

            item1 = new Item(700,200,"Item.png");
        }
    }

    public void update() {
        if (!(level == 0)) {
            for (Wall wall: walls) {
                if (level == 1) {
                    if (item1.isCollided(wall.getRectangle().getBounds())) {
                        var level1 = JOptionPane.showConfirmDialog(pane,"Dokončení level " + level + ", tvůj čas byl: " + time + "." + "\nPřeješ si pokračovat?", "Level 1", JOptionPane.YES_NO_OPTION);
                        if (level1 == pane.YES_OPTION) {
                            level = 2;
                            initialize();
                        }
                        else {
                            System.exit(0);
                        }
                    } else {
                        enemies.get(0).move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                        enemies.get(1).move(ENEMY_STEPS, DOWN, "Enemy_down.png");
                        enemyControl(DOWN);
                        enemyControl(RIGHT);
                    }

                } else if (level == 2) {
                    if (item1.isCollided(wall.getRectangle().getBounds())) {
                        var level2 = JOptionPane.showConfirmDialog(pane,"Dokončení level " + level + ", tvůj čas byl: " + time + "." + "\nPřeješ si pokračovat?", "Level 3", JOptionPane.YES_NO_OPTION);
                        if (level2 == pane.YES_OPTION) {
                            level = 3;
                            initialize();
                        }
                        else {
                            System.exit(0);
                        }
                    } else {
                        enemies.get(0).move(ENEMY_STEPS, UP, "Enemy_up.png");
                        enemies.get(1).move(ENEMY_STEPS, DOWN, "Enemy_down.png");
                        enemies.get(2).move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                        enemyControl(DOWN);
                        enemyControl(UP);
                        enemyControl(RIGHT);
                    }
                } else if (level == 3) {
                    if (item1.isCollided(wall.getRectangle().getBounds())) {
                        var level3 = JOptionPane.showConfirmDialog(pane,"Dokončení level " + level + ", tvůj čas byl: " + time + "." + "\nPřeješ si pokračovat?", "Reset hry", JOptionPane.YES_NO_OPTION);
                        if (level3 == pane.YES_OPTION) {
                            level = 1;
                            initialize();
                        }
                        else {
                            System.exit(0);
                        }
                    } else {
                        enemies.get(0).move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                        enemies.get(1).move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                        enemies.get(2).move(ENEMY_STEPS, LEFT, "Enemy_left.png");
                        enemies.get(3).move(ENEMY_STEPS, LEFT, "Enemy_left.png");
                        enemyControl(RIGHT);
                        enemyControl(LEFT);
                    }
                }
            }
        }
        else {
            var level0 = JOptionPane.showConfirmDialog(pane,"Vítej v této hře s názvem Perseus! :D Chceš jít rovnou na první level?", "Vítej", JOptionPane.YES_NO_OPTION);
            if (level0 == pane.YES_OPTION) {
                level = 1;
                initialize();
            }
            else {
                pane.showMessageDialog(null, "Tak nic. Ahoj :)");
                System.exit(0);
            }
        }
        if (!(level == 0)){
            if (!(time == 0)) {
                time--;
            } else if (time == 0){
                JOptionPane.showMessageDialog(null, "Čas zvítežil nad tebou. Ale nevzdávej se. :D");
                initialize();
            }
            collision();
        }
    }

    public void collision() {
        if (level == 1) {
            if (player.isCollided(item1.getRectangle_Item())) {
                System.out.println("Kolize");
                item1.move(ITEM_STEPS, UP, "Item.png");
            }
        }
        if (level == 2) {
            if (player.isCollided(item1.getRectangle_Item())) {
                System.out.println("Kolize");
                item1.move(ITEM_STEPS, UP, "Item.png");
            }
        }
        if (level == 3) {
            if (player.isCollided(item1.getRectangle_Item())) {
                System.out.println("Kolize");
                item1.move(ITEM_STEPS, UP, "Item.png");
            }
        }
        for (Enemy enemy : enemies) {
            for (Bush bush: bushes) {
                if (enemy.getRectangle_Enemy().intersects(bush.getRectangle_Bush())) {
                    System.out.println("Nepřítel = keř");
                    if (enemy.getCoord().x == enemy_X++) {
                        enemyControl(RIGHT);
                    }
                    if (enemy.getCoord().x == enemy_X--) {
                        enemyControl(LEFT);
                    }
                    if (enemy.getCoord().y == enemy_Y++) {
                        enemyControl(UP);
                    }
                    if (enemy.getCoord().y == enemy_Y--) {
                        enemyControl(DOWN);
                    }
                }
            }
            if (enemy.getRectangle_Enemy().intersects(walls.get(0).getRectangle())) {
                System.out.println("Debug - Detekce se zdi");
            }
            if (enemy.getRectangle_Enemy().intersects(walls.get(1).getRectangle())) {
                System.out.println("Debug - Detekce se zdi");
            }
            if (enemy.getRectangle_Enemy().intersects(walls.get(2).getRectangle())) {
                System.out.println("Debug - Detekce se zdi");
            }
            if (enemy.getRectangle_Enemy().intersects(walls.get(3).getRectangle())) {
                System.out.println("Debug - Detekce se zdi");
            }
        }
    }

    public boolean enemyControl(Direction direction) {
        for (Enemy enemy: enemies) {
            for (Wall wall: walls) {
                for (Bush bush: bushes){
                    switch (direction) {
                        case RIGHT -> {
                            Random rand = new Random();
                            int rand_number = rand.nextInt(1, 4 + 1);
                            boolean once = true;
                            if (enemy.getRectangle_Enemy().intersects(wall.getRectangle())) {
                                if (rand_number == 1) {
                                    enemy.move(ENEMY_STEPS, UP, "Enemy_up.png");
                                }
                                if (rand_number == 2) {
                                    enemy.move(ENEMY_STEPS, LEFT, "Enemy_left.png");
                                }
                                if (rand_number == 3) {
                                    enemy.move(ENEMY_STEPS, DOWN, "Enemy_down.png");
                                }
                                else {
                                    enemy.move(0, RIGHT, "Enemy_right.png");
                                }
                            } else if (enemy.getRectangle_Enemy().intersects(bush.getRectangle_Bush())) {
                                if (rand_number == 1) {
                                    enemy.move(ENEMY_STEPS, UP, "Enemy_up.png");
                                }
                                if (rand_number == 2) {
                                    enemy.move(ENEMY_STEPS, LEFT, "Enemy_left.png");
                                }
                                if (rand_number == 3) {
                                    enemy.move(ENEMY_STEPS, DOWN, "Enemy_down.png");
                                }
                                else {
                                    enemy.move(0, RIGHT, "Enemy_right.png");
                                }
                            }
                        }
                        case LEFT -> {
                            if (enemy.getRectangle_Enemy().intersects(wall.getRectangle())) {
                                Random rand = new Random();
                                int rand_number = rand.nextInt(1, 4 + 1);
                                System.out.println(rand_number);
                                if (rand_number == 1) {
                                    enemy.move(ENEMY_STEPS, UP, "Enemy_up.png");
                                }
                                if (rand_number == 4) {
                                    enemy.move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                                }
                                if (rand_number == 3) {
                                    enemy.move(ENEMY_STEPS, DOWN, "Enemy_down.png");
                                }
                                else {
                                    enemy.move(0, LEFT, "Enemy_left.png");
                                }
                            } else if (enemy.getRectangle_Enemy().intersects(bush.getRectangle_Bush())) {
                                Random rand = new Random();
                                int rand_number = rand.nextInt(1, 4 + 1);
                                System.out.println(rand_number);
                                if (rand_number == 1) {
                                    enemy.move(ENEMY_STEPS, UP, "Enemy_up.png");
                                }
                                if (rand_number == 4) {
                                    enemy.move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                                }
                                if (rand_number == 3) {
                                    enemy.move(ENEMY_STEPS, DOWN, "Enemy_down.png");
                                }
                                else {
                                    enemy.move(0, LEFT, "Enemy_left.png");
                                }
                            }
                        }
                        case UP -> {
                            if (enemy.getRectangle_Enemy().intersects(wall.getRectangle())) {
                                Random rand = new Random();
                                int rand_number = rand.nextInt(1, 4 + 1);
                                System.out.println(rand_number);
                                if (rand_number == 4) {
                                    enemy.move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                                }
                                if (rand_number == 2) {
                                    enemy.move(ENEMY_STEPS, LEFT, "Enemy_left.png");
                                }
                                if (rand_number == 3) {
                                    enemy.move(ENEMY_STEPS, DOWN, "Enemy_down.png");
                                }
                                else {
                                    enemy.move(0, UP, "Enemy_up.png");
                                }
                            } else if (enemy.getRectangle_Enemy().intersects(bush.getRectangle_Bush())) {
                                Random rand = new Random();
                                int rand_number = rand.nextInt(1, 4 + 1);
                                System.out.println(rand_number);
                                if (rand_number == 4) {
                                    enemy.move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                                }
                                if (rand_number == 2) {
                                    enemy.move(ENEMY_STEPS, LEFT, "Enemy_left.png");
                                }
                                if (rand_number == 3) {
                                    enemy.move(ENEMY_STEPS, DOWN, "Enemy_down.png");
                                }
                                else {
                                    enemy.move(0, UP, "Enemy_up.png");
                                }
                            }
                        }
                        case DOWN -> {
                            if (enemy.getRectangle_Enemy().intersects(wall.getRectangle())) {
                                Random rand = new Random();
                                int rand_number = rand.nextInt(1, 4 + 1);
                                System.out.println(rand_number);
                                if (rand_number == 4) {
                                    enemy.move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                                }
                                if (rand_number == 2) {
                                    enemy.move(ENEMY_STEPS, LEFT, "Enemy_left.png");
                                }
                                if (rand_number == 1) {
                                    enemy.move(ENEMY_STEPS, UP, "Enemy_up.png");
                                } else {
                                    enemy.move(0, DOWN, "Enemy_down.png");
                                }
                            } else if (enemy.getRectangle_Enemy().intersects(bush.getRectangle_Bush())) {
                                Random rand = new Random();
                                int rand_number = rand.nextInt(1, 4 + 1);
                                System.out.println(rand_number);
                                if (rand_number == 4) {
                                    enemy.move(ENEMY_STEPS, RIGHT, "Enemy_right.png");
                                }
                                if (rand_number == 2) {
                                    enemy.move(ENEMY_STEPS, LEFT, "Enemy_left.png");
                                }
                                if (rand_number == 1) {
                                    enemy.move(ENEMY_STEPS, UP, "Enemy_up.png");
                                } else {
                                    enemy.move(0, DOWN, "Enemy_down.png");
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static ArrayList<Enemy> getEnemy() {
        return enemies;
    }

    public static Player getPlayer() {
        return player;
    }

    public ArrayList<Bush> getBushes() {
        return bushes;
    }


    public PNG getBg() {
        return bg;
    }

    public PNG getLogo() {
        return logo;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Item getItem() {
        return item1;
    }

    public static void setPlayer(Player player) {
        GameLogic.player = player;
    }

}
