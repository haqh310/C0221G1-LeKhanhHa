package bai7_abstract_class_interface.thuc_hanh.interface_comparator_so_sanh_cac_lop_hinh_hoc;

import bai6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc.Shape;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return s1.getColor().compareToIgnoreCase(s2.getColor());
    }

}
