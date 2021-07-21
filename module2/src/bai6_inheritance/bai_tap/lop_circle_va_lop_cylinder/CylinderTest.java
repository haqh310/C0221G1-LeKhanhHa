package bai6_inheritance.bai_tap.lop_circle_va_lop_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(10.0);
        System.out.println(cylinder);
        cylinder = new Cylinder(5.0,"blue",10.0);
        System.out.println(cylinder);
    }
}
