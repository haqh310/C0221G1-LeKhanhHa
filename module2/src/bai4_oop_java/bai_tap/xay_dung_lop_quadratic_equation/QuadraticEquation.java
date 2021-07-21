package bai4_oop_java.bai_tap.xay_dung_lop_quadratic_equation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(){

    }
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA(){
        return this.a;
    }
    public double getB(){
        return this.b;
    }
    public double getC(){
        return this.c;
    }
    public double getDiscriminant(){
        return Math.pow(b,2)- 4*a*c;
    }
    public double getRoot1(){
        double delta = this.getDiscriminant();
        double result=0f;
        if(delta >=0){
            result = (-b + Math.sqrt(delta))/(2*a);
        }
        else {
            result =0;
        }
        return  result;
    }
    public double getRoot2(){
        double delta = this.getDiscriminant();
        double result=0f;
        if(delta >=0){
            result = (-b - Math.sqrt(delta))/(2*a);
        }
        else {
            result =0;
        }
        return  result;
    }
}
