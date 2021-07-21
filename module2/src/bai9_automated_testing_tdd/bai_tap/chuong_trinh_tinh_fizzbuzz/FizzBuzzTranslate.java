package bai9_automated_testing_tdd.bai_tap.chuong_trinh_tinh_fizzbuzz;

public class FizzBuzzTranslate {
    public static String translateNumber(int number){
        if(number <0 || number >100){
            return "Can not translate";
        }
        if(number % 3 == 0 && number % 5 ==0 ){
            return "FizzBuzz";
        }
        else if(number % 3 == 0){
            return "Fizz";
        }
        else if(number % 5 == 0){
            return "Buzz";
        }
        return stringNumber(number);
    }
    public static String stringNumber(int number){
        String[] stringNum ={"zero","one","two","three","four","five","six","seven","eight","nine"};
        if(number > 9){
            return stringNum[number/10]+" "+stringNum[number%10];
        }
       return stringNum[number%10];
    }
}
