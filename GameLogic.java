package org.example;

import org.example.logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static org.example.logic.Direction.*;

public class GameLogic {
    public static Player player;
    private static ArrayList<Enemy> enemies;
    private ArrayList<Bush> bushes;
    private BG bg;
    private ArrayList<Wall> walls;
    private final int ENEMY_STEPS = 15;
    public JOptionPane pane = new JOptionPane();
    public int stun = 20;
    public int time = 1000;
    public GameGraphics graphic;
    public Item item1;

    public GameLogic(int ballSteps) {
        this.player = null;
        this.enemies = new ArrayList<>();
        this.bushes = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.stun = stun;
    }

    public void initialize() {

        player = new Player(20, 20, "Player.png");
        bg = new BG(0, 0, "Background_no_object.png");

        Enemy enemy1 = new Enemy(0,0, "Enemy.png",100);
        Enemy enemy2 = new Enemy(10,10, "Enemy.png",100);
        enemies.add(enemy1);
        enemies.add(enemy2);

        Bush bush1 = new Bush(-100, 150,"Object.png");
        Bush bush2 = new Bush(200, -100, "Object.png");
        Bush bush3 = new Bush(500, 0, "Object.png");
        bushes.add(bush1);
        bushes.add(bush2);
        bushes.add(bush3);

        item1 = new Item(700,200,"Item.png");

        Wall wall1 = new Wall(0,0,1080,0, Color.BLACK);
        Wall wall2 = new Wall(0,0,0,720, Color.RED);
        Wall wall3 = new Wall(1080,720,1080,0, Color.BLUE);
        Wall wall4 = new Wall(0,720,1080,720, Color.ORANGE);
        walls.add(wall1);
        walls.add(wall2);
        walls.add(wall3);
        walls.add(wall4);
    }

    public void update() {
        for (Wall wall: walls) {
            for (Enemy enemy: enemies) {
                if (!(time == 0)) {
                    time--;
                } else {
                    JOptionPane.showMessageDialog(null, "Game Over");
                    System.exit(0);
                }
            }
            if (item1.isCollided(wall.getRectangle())) {
                JOptionPane.showMessageDialog(null, "Completed Level 1");
                System.exit(0);
            }
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
        if (player.isCollided(bushes.getLast().getRectangle())) {
            System.out.println("Kolize");
            item1.move(ENEMY_STEPS, UP);
        }
    }

    private void moveEnemy(Direction direction, Enemy enemy){
        if (!predictEnemyCollision(ENEMY_STEPS, direction)) {
            enemy.move(ENEMY_STEPS, direction);
        } else if (predictEnemyCollision(ENEMY_STEPS, direction)) {
            switch (direction) {
                case UP -> {
                    enemy.move(ENEMY_STEPS, Direction.LEFT);
                    break;
                }
                case DOWN -> {
                    enemy.move(ENEMY_STEPS, Direction.RIGHT);
                    break;
                }
                case LEFT -> {
                    enemy.move(ENEMY_STEPS, Direction.UP);
                    break;
                }
                case RIGHT -> {
                    enemy.move(ENEMY_STEPS, Direction.DOWN);
                    break;
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

    public ArrayList<Enemy> getEnemies() {
        return enemies;
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

    public Item getItem() {
        return item1;
    }

}