package org.example.logic;

public class Enemy extends Entity {
    private int stun;

    public Enemy(int x, int y, String url, int stun) {
        super(x, y, url);
        this.stun = stun;
    }

    public int getStun() {
        return stun;
    }

    public void setStun(int stun) {
        this.stun = stun;
    }
}
