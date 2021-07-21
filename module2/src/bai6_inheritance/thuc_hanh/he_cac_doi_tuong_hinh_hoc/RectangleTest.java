package bai6_inheritance.thuc_hanh.he_cac_doi_tuong_hinh_hoc;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle( "orange", true,2.5,3.8);
        System.out.println(rectangle);
    }
}
