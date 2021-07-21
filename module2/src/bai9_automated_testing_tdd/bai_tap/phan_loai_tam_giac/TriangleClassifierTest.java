package bai9_automated_testing_tdd.bai_tap.phan_loai_tam_giac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void triangle1() {
        int a = 2;
        int b = 2;
        int c = 2;
        String expected = "A Equilateral Triangle";
        String result = TriangleClassifier.triangle(a,b,c);
        assertEquals(expected,result);
    }
    @Test
    void triangle2() {
        int a = 2;
        int b = 2;
        int c = 3;
        String expected = "A Isosceles Triangle";
        String result = TriangleClassifier.triangle(a,b,c);
        assertEquals(expected,result);
    }
    @Test
    void triangle3() {
        int a = 3;
        int b = 4;
        int c = 5;
        String expected = "A Triangle";
        String result = TriangleClassifier.triangle(a,b,c);
        assertEquals(expected,result);
    }
    @Test
    void triangle4() {
        int a = 8;
        int b = 2;
        int c = 3;
        String expected = "No is A Triangle";
        String result = TriangleClassifier.triangle(a,b,c);
        assertEquals(expected,result);
    }
    @Test
    void triangle5() {
        int a = -1;
        int b = 2;
        int c = 1;
        String expected = "No is A Triangle";
        String result = TriangleClassifier.triangle(a,b,c);
        assertEquals(expected,result);
    }
    @Test
    void triangle6() {
        int a = 0;
        int b = 1;
        int c = 1;
        String expected = "No is A Triangle";
        String result = TriangleClassifier.triangle(a,b,c);
        assertEquals(expected,result);
    }
}