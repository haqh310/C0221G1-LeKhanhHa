package bai2_loop_java.bai_tap;

public class PrimeLess100 {
    public static void main(String[] args) {
        for(int i=2;i<100;i++){
           boolean check =  DisplayPrimes.isPrime(i);
           if(check){
               System.out.print(i+" ");
           }
     }
    }
}
