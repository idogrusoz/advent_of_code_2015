package org.solutions.day06;

public class DimmableLight extends LightBulb {

    @Override
    public void turnOn() {
        this.state++;
    }

    @Override
    public void turnOff() {
        if (this.state == 0) {
            return;
        }
        this.state--;
    }

    @Override
    public void toggle() {
        this.state += 2;
    }
}
