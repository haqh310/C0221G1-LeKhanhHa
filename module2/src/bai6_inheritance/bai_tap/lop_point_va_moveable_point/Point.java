package bai6_inheritance.bai_tap.lop_point_va_moveable_point;

public class Point {
    private float x=0.0f;
    private float y=0.0f;
    public Point(){

    }
    public Point(float x,float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public float[] getXY(){
        float[] arrXY={getX(),getY()};
        return arrXY;
    }
    public void setXY(float x,float y){
        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
