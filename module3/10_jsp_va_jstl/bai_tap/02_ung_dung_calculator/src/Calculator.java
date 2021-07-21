public class Calculator {
    public static double calculate(float a , float b , String op) throws Exception{
        double result=0;
        switch (op){
            case "+":
                result=a+b;
                break;
            case "-":
                result=a-b;
                break;
            case "*":
                result=a/b;
                break;
            default:
                if(b==0){
                    throw new Exception("Khong the bang khong");
                }
                result=a/b;
        }
        return result;
    }
}
