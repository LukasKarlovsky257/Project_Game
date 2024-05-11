package org.example;

import org.example.logic.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class GameGraphics extends JFrame {
    Draw draw;
    GameLogic findLogic;
    public GameGraphics(GameLogic findLogic) throws HeadlessException {
        this.draw = new Draw();
        this.findLogic = findLogic;

        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Find Game");

        add(draw);
    }

    public void render(GameLogic findLogic) {
        this.findLogic = findLogic;
        repaint();
    }

    public class Draw extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.BLACK);
            Font font = new Font("Arial", Font.BOLD, 20);
            g.setFont(font);

            g.drawImage(findLogic.getBg().getImage(), findLogic.getBg().getCoord().x, findLogic.getBg().getCoord().y, 1080, 720, this);

            g.drawRect(findLogic.item1.getRectangle().x, findLogic.item1.getRectangle().y, findLogic.item1.getRectangle().width, findLogic.item1.getRectangle().height);
            g.drawImage(GameLogic.getPlayer().getImage(), GameLogic.getPlayer().getX(), GameLogic.getPlayer().getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });

            g.drawString("Tvůj čas: " + findLogic.getTime(), 30, 30);
            g.drawString("Tvůj level: " + findLogic.getLevel(), 900, 30);

            g.drawImage(findLogic.getItem().getImage(), findLogic.getItem().getX(), findLogic.getItem().getY(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });

            for (Enemy enemy: GameLogic.getEnemy())
                g.drawImage(enemy.getImage(), enemy.getCoord().x, enemy.getCoord().y, new ImageObserver() {
                    @Override
                    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                        return false;
                    }
                });

            for (Wall wall: findLogic.getWalls()) {
                    g.setColor(wall.getColor());
                    g.drawLine(wall.getCoordStart().x, wall.getCoordStart().y, wall.getCoordEnd().x, wall.getCoordEnd().y);
            }

            for (Bush bush: findLogic.getBushes()) {
                g.drawImage(bush.getImage(), bush.getCoord().x, bush.getCoord().y, 500, 500, this);
            }
        }
        @Override
        protected Graphics getComponentGraphics(Graphics g) {
            return super.getComponentGraphics(g);
        }
    }
}