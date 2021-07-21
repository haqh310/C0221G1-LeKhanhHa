package bai4_oop_java.bai_tap.xay_dung_lop_fan;

public class Exercise3 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(fan1.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());
        Fan fan2 = new Fan();
        fan2.setSpeed(fan1.MEDIUM);
        System.out.println(fan2);
    }
}

