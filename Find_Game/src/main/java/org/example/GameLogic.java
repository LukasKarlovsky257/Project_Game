package org.example;

import org.example.logic.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static org.example.logic.Direction.*;

public class GameLogic {
    private static Player player;
    private static ArrayList<Enemy> enemies;
    private ArrayList<Bush> bushes;
    private BG bg;
    private ArrayList<Wall> walls;
    private final int ENEMY_STEPS = 5;


    public GameLogic(int ballSteps) {
        this.player = null;
        this.enemies = new ArrayList<>();
        this.bushes = new ArrayList<>();
        this.walls = new ArrayList<>();
    }

    public void initialize() {

        player = new Player(20, 20, "Player.png");
        bg = new BG(0, 0, "Background_no_object.png");

        Enemy enemy1 = new Enemy(350,350, "Object.png",100);
        Enemy enemy2 = new Enemy(150,250, "Object.png",100);
        enemies.add(enemy1);
        enemies.add(enemy2);

        Bush bush1 = new Bush(-100, 150,  "Object.png");
        Bush bush2 = new Bush(200, -100, "Object.png");
        Bush bush3 = new Bush(500, 0, "Object.png");
        Bush bush4 = new Bush(-500, -150,  "Object.png");
        bushes.add(bush1);
        bushes.add(bush2);
        bushes.add(bush3);
        bushes.add(bush4);


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
        for (Enemy enemy: enemies) {
            for (Bush bush: bushes) {
                for (Wall wall: walls) {
                    if (enemy.getRectangle().intersects(bush.getRectangle())) {
                        int max=4,min=1;
                        int number = (int) (Math.random() * ((max-min)+1));
                        if (number == 1) {
                            enemy.move(ENEMY_STEPS, DOWN);
                            System.out.println("Detekce 1");
                            break;
                        } else if (number == 2) {
                            enemy.move(ENEMY_STEPS, LEFT);
                            System.out.println("Detekce 2");
                            break;
                        } else if (number == 3) {
                            enemy.move(ENEMY_STEPS, RIGHT);
                            System.out.println("Detekce 3");
                            break;
                        } else if (number == 4) {
                            enemy.move(ENEMY_STEPS, UP);
                            System.out.println("Detekce 4");
                            break;
                        }
                    } else if (wall.getRectangle().intersects(enemy.getRectangle())) {
                        int max=4,min=1;
                        int number = (int) (Math.random() * ((max-min)+1));
                        if (number == 1) {
                            enemy.move(ENEMY_STEPS, DOWN);
                            System.out.println("Detekce 1");
                            break;
                        } else if (number == 2) {
                            enemy.move(ENEMY_STEPS, LEFT);
                            System.out.println("Detekce 2");
                            break;
                        } else if (number == 3) {
                            enemy.move(ENEMY_STEPS, RIGHT);
                            System.out.println("Detekce 3");
                            break;
                        } else if (number == 4) {
                            enemy.move(ENEMY_STEPS, UP);
                            System.out.println("Detekce 4");
                            break;
                        }
                    }
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

    public int getENEMY_STEPS() {
        return ENEMY_STEPS;
    }

    public BG getBg() {
        return bg;
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }
}