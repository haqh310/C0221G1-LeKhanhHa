package bai7_abstract_class_interface.bai_tap.interface_resizeable_cho_cac_lop_hinh_hoc;

import bai6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Rectangle extends Shape implements Resizeable{
    private double width = 1.0;
    private double length = 1.0;
    public Rectangle(){

    }
    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    public Rectangle(String color,boolean filled,double width, double length){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public String toString(){
        return "A Rectangle with width= "
                +Math.round(this.width*100)/100
                +" and length= "
                +Math.round(this.length*100)/100
                +", which is a subclass of "
                +super.toString();
    }

    @Override
    public void resize(double percent) {
        this.length *= (1+percent);
        this.width *= (1+percent);
    }
}
