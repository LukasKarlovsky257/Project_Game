package org.example;

import org.example.logic.Direction;

import javax.swing.*;
import java.awt.event.*;

public class Game {
    GameLogic logic;
    private final int PLAYER_STEPS = 20;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Game();
            }
        });
    }
    public Game() {
        logic = new GameLogic(PLAYER_STEPS);
        GameGraphics graphic = new GameGraphics(logic);
        logic.initialize();
        graphic.render(logic);
        boolean isGameOver = false;

        graphic.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        controlledMove(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        controlledMove(Direction.RIGHT);
                        break;
                    case KeyEvent.VK_UP:
                        controlledMove(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        controlledMove(Direction.DOWN);
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logic.update();
                graphic.render(logic);
            }
        });

        timer.start();
    }
    private void controlledMove(Direction direction1) {
        logic.getPlayer().move(PLAYER_STEPS, direction1);
    }

    public GameLogic getLogic() {
        return logic;
    }
}