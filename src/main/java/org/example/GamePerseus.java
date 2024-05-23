package org.example;

import org.example.logic.Direction;
import org.example.logic.Enemy;
import org.example.logic.Entity;
import org.example.logic.Player;

import javax.swing.*;
import java.awt.event.*;

import static org.example.GameLogic.*;

public class GamePerseus {
    GameLogic logic;
    private final int PLAYER_STEPS = 20;

    public GamePerseus() {
        logic = new GameLogic();
        GameGraphics graphic = new GameGraphics(logic);
        logic.initialize();
        graphic.render(logic);
        logic.update();


            graphic.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {
                    if (!(logic.level == 0)) {
                        for (Enemy enemy: logic.getEnemies()) {
                            if (!(enemy.getRectangle_Enemy().intersects(player.getRectangle_Player())))
                                switch (e.getKeyCode()) {
                                    case KeyEvent.VK_LEFT:
                                        controlledMove(player, Direction.LEFT, "Player_left.png");
                                        break;
                                    case KeyEvent.VK_RIGHT:
                                        controlledMove(player, Direction.RIGHT, "Player_right.png");
                                        break;
                                    case KeyEvent.VK_UP:
                                        controlledMove(player, Direction.UP, "Player_up.png");
                                        break;
                                    case KeyEvent.VK_DOWN:
                                        controlledMove(player, Direction.DOWN, "Player_down.png");
                                        break;
                                    case KeyEvent.VK_W:
                                        controlledMove(player, Direction.UP, "Player_up.png");
                                        break;
                                    case KeyEvent.VK_S:
                                        controlledMove(player, Direction.DOWN, "Player_down.png");
                                        break;
                                    case KeyEvent.VK_A:
                                        controlledMove(player, Direction.LEFT, "Player_left.png");
                                        break;
                                    case KeyEvent.VK_D:
                                        controlledMove(player, Direction.RIGHT, "Player_right.png");
                                        break;
                                    case KeyEvent.VK_SPACE:
                                }

                            else {
                                System.out.println("Kolize s hráčem");
                                keyPressed(null);
                            }
                        }
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                graphic.render(logic);
                logic.update();
            }
        });

        timer.start();
    }

    public void controlledMove(Entity entity, Direction direction1, String url) {
        logic.getPlayer().move(PLAYER_STEPS, direction1, url);
    }

    public GameLogic getLogic() {
        return logic;
    }
}