package org.solutions.day06;

public class LightBulb {

    private int state;

    public LightBulb() {
        state = 0;
    }

    public int getState() {
        return state;
    }

    public void turnOn() {
        this.state = 1;
    }

    public void turnOff() {
        this.state = 0;
    }

    public void toggle() {
        this.state = this.state == 0 ? 1 : 0;
    }
}
