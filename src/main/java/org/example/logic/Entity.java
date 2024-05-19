package org.example.logic;

import javax.swing.*;
import java.awt.*;
public class Entity {
    protected Coords coord;
    protected int width;
    protected int height;
    protected Image image;

    public Entity(int x, int y, String url) {
        this.coord = new Coords(x,y);

        ImageIcon ii = new ImageIcon(getClass().getResource("/" + url));
        this.image = ii.getImage();

        this.width = ii.getIconWidth();
        this.height = ii.getIconHeight();

    }

    public void move(int steps, Direction direction) {
        switch (direction) {
            case LEFT -> {
                this.coord.x -= steps;
            }
            case RIGHT -> {
                this.coord.x += steps;
            }
            case UP -> {
                this.coord.y -= steps;
            }
            case DOWN -> {
                this.coord.y += steps;
            }
        }
    }
    public Rectangle getRectangle_Item(){
        return new Rectangle(coord.x, coord.y, width, height);
    }
    public Rectangle getRectangle_Bush(){
        return new Rectangle(coord.x+200,coord.y+220, width/5, height/6);
    }
    public Rectangle getRectangle_Enemy(){
        return new Rectangle(coord.x+220,coord.y+243,(width/5)-15, (height/6)- 4);
    }
    public Rectangle getRectangle_Player(){
        return new Rectangle(coord.x+220,coord.y+240,(width/5)-45, (height/6)-30);
    }

    public Coords getCoord() {
        return coord;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    public boolean isCollided (Rectangle otherObject) {
        return getRectangle_Player().intersects(otherObject);
    }
}