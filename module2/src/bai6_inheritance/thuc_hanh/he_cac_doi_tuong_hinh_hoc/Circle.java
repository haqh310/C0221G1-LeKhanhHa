package bai6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

public class Circle extends Shape {
    private double radius = 1.0;
    public Circle(){

    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(String color,boolean filled,double radius){
        super(color,filled);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
    public double getPerimeter(){
        return 2*Math.PI*this.radius;
    }
    @Override
    public String toString(){
        return "A Circle with radius= "
                +this.radius
                +", which is a subclass of "
                +super.toString();
    }
}
