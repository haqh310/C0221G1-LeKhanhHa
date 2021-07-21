package bai6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

public class Square extends Rectangle {
    public Square() {
    }
    public Square(double side){
        super(side,side);
    }
    public Square(String color,boolean filled ,double side){
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
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
