package bai6_inheritance.bai_tap.lop_circle_va_lop_cylinder;

public class Cylinder extends Circle {
    private double height = 1.0;
    public Cylinder(){

    }
    public Cylinder(double height){
        this.height = height;
    }
    public Cylinder(double radius,String color,double height){
        super(radius,color);
        this.height = height;
    }
    public double getVolume(){
        return getArea()*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius="+super.getRadius()+
                ", color="+super.getColor()+
                ", height=" + height +
                ", volume="+getVolume()+
                '}';
    }
}
