package org.example.logic;

import java.awt.*;

public class Wall {
    private Coords coordStart;
    private Coords coordEnd;
    private Color color;
    private boolean active;

    public Wall(int x1, int y1, int x2, int y2, Color color) {
        this.color = color;
        this.coordStart = new Coords(x1, y1);
        this.coordEnd = new Coords(x2, y2);
        this.active = true;
    }

    public Coords getCoordStart() {
        return coordStart;
    }

    public Coords getCoordEnd() {
        return coordEnd;
    }

    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }

    public Rectangle getRectangle() {
        return new Rectangle(coordStart.x, coordStart.y, coordEnd.x - coordStart.x+1, coordEnd.y - coordStart.y+1);
    }

    public Color getColor() {
        return color;
    }
}
