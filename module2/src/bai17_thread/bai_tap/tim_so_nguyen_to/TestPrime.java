package bai17_thread.bai_tap.tim_so_nguyen_to;

public class TestPrime {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new LazyPrimeFactorization());
        Thread thread2 = new Thread(new OptimizedPrimeFactorization());


        thread1.start();
        thread2.start();
    }
}
