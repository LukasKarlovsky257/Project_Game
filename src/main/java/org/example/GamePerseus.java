package org.example;

import org.example.logic.Direction;
import org.example.logic.Enemy;
import org.example.logic.Entity;
import org.example.logic.Player;

import javax.swing.*;
import java.awt.event.*;

import static org.example.GameLogic.getEnemies;
import static org.example.GameLogic.player;

public class GamePerseus {
    GameLogic logic;
    private final int PLAYER_STEPS = 20;

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GamePerseus();
            }
        });
    }

    public GamePerseus() {
        logic = new GameLogic();
        GameGraphics graphic = new GameGraphics(logic);
        logic.initialize();
        graphic.render(logic);
        logic.update();


        for (Enemy enemy: getEnemies()) {
            graphic.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (!(player.isCollided(enemy.getRectangle_Enemy())))
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_LEFT:
                                logic.setPlayer(new Player(logic.getPlayer().getX(), logic.getPlayer().getY(), "Player_left.png"));
                                controlledMove(player, Direction.LEFT);
                                break;
                            case KeyEvent.VK_RIGHT:
                                logic.setPlayer(new Player(logic.getPlayer().getX(), logic.getPlayer().getY(), "Player_right.png"));
                                controlledMove(player, Direction.RIGHT);
                                break;
                            case KeyEvent.VK_UP:
                                logic.setPlayer(new Player(logic.getPlayer().getX(), logic.getPlayer().getY(), "Player_up.png"));
                                controlledMove(player, Direction.UP);
                                break;
                            case KeyEvent.VK_DOWN:
                                logic.setPlayer(new Player(logic.getPlayer().getX(), logic.getPlayer().getY(), "Player_down.png"));
                                controlledMove(player, Direction.DOWN);
                                break;
                        }
                    else if (player.getRectangle_Player().intersects(enemy.getRectangle_Enemy())) {
                        keyPressed(null);
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });
        }

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphic.render(logic);
                logic.update();
            }
        });

        timer.start();
    }

    public void controlledMove(Entity entity, Direction direction1) {
        logic.getPlayer().move(PLAYER_STEPS, direction1);
    }

    public GameLogic getLogic() {
        return logic;
    }


}