package org.example.logic;

import java.awt.*;

public class Bush extends Entity{
    private int x1;
    private int y1;
    private String url;
    private boolean active;
    private Coords coordStart;
    private Coords coordEnd;

    public Bush(int x1, int y1, String url) {
        super(x1, y1, url);
        this.coordStart = new Coords(x1, y1);
        this.coordEnd = new Coords(x1, y1);
    }
    public void activate() {
        this.active = true;
    }

    public Coords getCoordStart() {
        return coordStart;
    }

    public Coords getCoordEnd() {
        return coordEnd;
    }

    public boolean isActive() {
        return active;
    }

    public String getUrl() {
        return url;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }


    public Rectangle getRectangle() {
        return new Rectangle(coordStart.x, coordStart.y, coordEnd.x - coordStart.x+1, coordEnd.y - coordStart.y+1);
    }
}
