package bai4_oop_java.bai_tap.xay_dung_lop_fan;

public class Fan {
    public final int SLOW = 1;
    public final int MEDIUM = 2;
    public final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    Fan() {

    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean getOn() {
        return this.on;
    }

    public void setOn(boolean isOn) {
        this.on = isOn;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        String result = "Speed: " + this.speed + ", Radius: " + this.radius + ", Color: " + this.color;
        if (on) {
            result += ", Fan is on";
        } else {
            result += ", Fan is off";
        }
        return result;
    }
}
