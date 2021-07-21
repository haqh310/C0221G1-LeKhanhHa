package bai7_abstract_class_interface.bai_tap.interface_colorable_cho_cac_lop_hinh_hoc;


import bai7_abstract_class_interface.bai_tap.interface_resizeable_cho_cac_lop_hinh_hoc.Rectangle;

public class Square extends Rectangle implements Colorable {

    public Square() {
    }
    public Square(double side){
        super(side,side);
    }
    public Square(String color, boolean filled , double side){
        super(color,filled,side,side);
    }
    public double getSide(){
        return getWidth();
    }
    public void setSide(double side){
        super.setWidth(side);
        super.setLength(side);
    }
    @Override
    public void setWidth(double with){
        super.setWidth(with);
    }

    @Override
    public void setLength(double length) {
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                +Math.round( getSide()*100)/100
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
}

