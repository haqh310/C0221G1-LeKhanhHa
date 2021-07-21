package bai7_abstract_class_interface.bai_tap.interface_resizeable_cho_cac_lop_hinh_hoc;

import bai6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

public class Interface_Resizeable_Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(5);
        shapes[2] = new Rectangle(5,5);
        System.out.println("Shapes Before: ");
        for (Shape shape:shapes ) {
            System.out.println(shape);
        }
        System.out.println("Shapes After: ");
        for (Shape shape:shapes ) {
            Resizeable resizeable = (Resizeable) shape;
            double resize = Math.random();
            resizeable.resize(resize);
            System.out.println(shape);
        }
    }
}
