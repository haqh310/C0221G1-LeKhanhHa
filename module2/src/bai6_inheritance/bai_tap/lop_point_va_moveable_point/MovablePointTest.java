package bai6_inheritance.bai_tap.lop_point_va_moveable_point;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);
        movablePoint = new MovablePoint(10.0f,20.0f);
        movablePoint.move();
        movablePoint.move();
        System.out.println(movablePoint.getX());
        System.out.println(movablePoint.getY());
    }
}
