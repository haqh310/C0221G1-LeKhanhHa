package bai6_inheritance.bai_tap.lop_point_va_moveable_point;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    public MovablePoint(){

    }


    public MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }
    public float[] getSpeed(){
        return new float[]{getXSpeed(), getYSpeed()};
    }

    @Override
    public String toString() {
        return "MoveAblePoint{(x,y),speed= (" +
                +this.xSpeed
                +", "+this.ySpeed
                +")}";
    }
    public MovablePoint move(){
        super.setX(super.getX()+getXSpeed());
        super.setY(super.getY()+getYSpeed());
        return this;
    }
}
