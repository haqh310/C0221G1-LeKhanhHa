package bai6_inheritance.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.getColor());
        System.out.println(triangle.getArea());
        triangle = new Triangle(3,4,5);
        triangle.setColor("Red");
        System.out.println(triangle.getColor());
        System.out.println(triangle);
        System.out.println(triangle.getArea());

    }
}
