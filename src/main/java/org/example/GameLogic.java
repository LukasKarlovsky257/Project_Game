
package org.example;

import org.example.logic.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.example.logic.Direction.*;

public class GameLogic {
    public static Player player;
    private static ArrayList<Enemy> enemies;
    private ArrayList<Bush> bushes;
    private BG bg;
    private ArrayList<Wall> walls;
    private final int ENEMY_STEPS = 2;
    private final int ITEM_STEPS = 15;
    public JOptionPane pane = new JOptionPane();
    public int time;
    public Item item1;
    public int level;
    public JButton button;

    public GameLogic() {
        this.player = null;
        this.enemies = new ArrayList<>();
        this.bushes = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.level = 1;
        this.button = new JButton();
    }

    public void initialize() {
        if (level == 0) {
            bg = new BG(0,0,"Background_no_object.png");
        }

        if (level == 1) {
            setTime(500);
            player = new Player(20, 20, "Player.png");
            bg = new BG(0, 0, "Background_no_object.png");

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
            Enemy enemy1 = new Enemy(0,0, "Enemy.png");
            Enemy enemy2 = new Enemy(100,50, "Enemy.png");
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
            setTime(250);
            player = new Player(20, 20, "Player.png");
            bg = new BG(0, 0, "Background_no_object.png");

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
            Enemy enemy1 = new Enemy(250,50, "Enemy.png");
            Enemy enemy2 = new Enemy(10,10, "Enemy.png");
            enemies.add(enemy1);
            enemies.add(enemy2);

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
            setTime(100);
            player = new Player(20, 20, "Player.png");
            bg = new BG(0, 0, "Background_no_object.png");

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
            Enemy enemy1 = new Enemy(0,0, "Enemy.png");
            Enemy enemy2 = new Enemy(10,10, "Enemy.png");
            enemies.add(enemy1);
            enemies.add(enemy2);

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
        for (Wall wall : walls) {
            if (level == 0) {
                pane.showMessageDialog(null, "Welcome to game! When you pressed okay. We can started! :D");
                level = 1;
                initialize();
            }
            if (level == 1) {
                if (item1.isCollided(wall.getRectangle().getBounds())) {
                    pane.showMessageDialog(null, "Completed level " + level + ", your time is: " + time);
                    level = 2;
                    initialize();
                }
            } else if (level == 2) {
                if (item1.isCollided(wall.getRectangle().getBounds())) {
                    pane.showMessageDialog(null, "Completed level " + level + ", your time is: " + time);
                    level = 3;
                    initialize();
                }
            } else if (level == 3) {
                if (item1.isCollided(wall.getRectangle().getBounds())) {
                    pane.showMessageDialog(null, "Completed level " + level + ", your time is: " + time);
                    level = 1;
                    initialize();
                    System.exit(0);
                }
            }
        }

        if (!(time == 0)) {
            time--;
        } else if (time == 0){
            JOptionPane.showMessageDialog(null, "Game Over");
            System.exit(0);
        }
        collision();
    }

    public boolean predictEnemyCollision(int enemySteps, Direction direction) {
        Rectangle enemyMoveRectangle = new Rectangle();
        for (Enemy enemy : enemies) {
            switch (direction) {
                case RIGHT -> {
                    enemyMoveRectangle = new Rectangle(enemy.getCoord().x + enemySteps, enemy.getCoord().y, enemy.getWidth(), enemy.getHeight());
                }
                case LEFT -> {
                    enemyMoveRectangle = new Rectangle(enemy.getCoord().x - enemySteps, enemy.getCoord().y, enemy.getWidth(), enemy.getHeight());
                }
                case UP -> {
                    enemyMoveRectangle = new Rectangle(enemy.getCoord().x, enemy.getCoord().y - enemySteps, enemy.getWidth(), enemy.getHeight());
                }
                case DOWN -> {
                    enemyMoveRectangle = new Rectangle(enemy.getCoord().x, enemy.getCoord().y + enemySteps, enemy.getWidth(), enemy.getHeight());
                }
            }
            for (Wall wall: walls) {
                if (enemyMoveRectangle.intersects(wall.getRectangle())) {
                    switch (direction) {
                        case RIGHT -> {
                            enemy.move(ENEMY_STEPS, Direction.LEFT);
                        }
                        case LEFT -> {
                            enemy.move(ENEMY_STEPS, RIGHT);
                        }
                        case DOWN -> {
                            enemy.move(ENEMY_STEPS, Direction.UP);
                        }
                        case UP -> {
                            enemy.move(ENEMY_STEPS, Direction.DOWN);
                        }
                    }
                }
            }
        }
        return false;
    }


    public void collision() {
        if (level == 1) {
            if (player.isCollided(item1.getRectangle_Item())) {
                System.out.println("Kolize");
                item1.move(ITEM_STEPS, UP);
            } else {
                System.out.println("Nic");
            }
        }
        if (level == 2) {
            if (player.isCollided(item1.getRectangle_Item())) {
                System.out.println("Kolize");
                item1.move(ITEM_STEPS, UP);
            } else {
                System.out.println("Nic");
            }
        }
        if (level == 3) {
            if (player.isCollided(item1.getRectangle_Item())) {
                System.out.println("Kolize");
                item1.move(ITEM_STEPS, UP);
            } else {
                System.out.println("Nic");
            }
        }
        for (Enemy enemy : enemies) {
            for (Bush bush : bushes) {
                if (!(enemy.isCollided(player.getRectangle_Player()))) {
                    System.out.println("Nepřítel != hráč");
                    enemy.move(ENEMY_STEPS, RIGHT);
                }
                if (enemy.isCollided(player.getRectangle_Player())) {
                    System.out.println("Nepřítel = hráč");
                    enemy.move(ENEMY_STEPS, LEFT);
                }
                if (enemy.isCollided(bush.getRectangle_Bush())) {
                    System.out.println("Nepřítel = keř");
                    enemy.move(0, DOWN);

                }
                if (enemy.isCollided(walls.get(0).getRectangle().getBounds())) {
                    System.out.println("Nepřítel = zed");
                    enemy.move(ENEMY_STEPS, LEFT);
                }
                if (enemy.isCollided(walls.get(1).getRectangle())) {
                    System.out.println("Nepřítel = zed");
                    enemy.move(ENEMY_STEPS, LEFT);
                }
                if (enemy.isCollided(walls.get(2).getRectangle())) {
                    System.out.println("Nepřítel = zed");
                    enemy.move(ENEMY_STEPS, RIGHT);
                } if (enemy.isCollided(walls.get(3).getRectangle())) {
                    System.out.println("Nepřítel = zed");
                    enemy.move(ENEMY_STEPS, UP);
                }
            }
        }
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


    public BG getBg() {
        return bg;
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
}
