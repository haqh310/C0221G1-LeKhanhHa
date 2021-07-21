package bai9_automated_testing_tdd.bai_tap.phan_loai_tam_giac;

public class TriangleClassifier {
    public static String triangle(int a, int b, int c){
        boolean check = (a+b > c) && (a+c>b) && (b+c>a);
        if(check){
            boolean check1= a==b || a==c || b==c;
            if(a==b && a==c){
                return "A Equilateral Triangle";
            }
            else if(check1){
                return "A Isosceles Triangle";
            }
            else {
                return "A Triangle";
            }
        }
        else {
            return "No is A Triangle";
        }
    }
}
