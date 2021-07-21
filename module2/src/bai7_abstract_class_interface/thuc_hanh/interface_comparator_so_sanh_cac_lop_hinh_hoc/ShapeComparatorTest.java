package bai7_abstract_class_interface.thuc_hanh.interface_comparator_so_sanh_cac_lop_hinh_hoc;

import bai6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeComparatorTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Shape("Red",true);
        shapes[1] = new Shape("Black",true);
        shapes[2] = new Shape("Yellow", false);
        shapes[3] = new Shape("pink", false);
        shapes[4] = new Shape("Green", false);

        System.out.println("Pre-sorted:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        Comparator shapeComparator = new ShapeComparator();
        Arrays.sort(shapes, shapeComparator);

        System.out.println("After-sorted:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
