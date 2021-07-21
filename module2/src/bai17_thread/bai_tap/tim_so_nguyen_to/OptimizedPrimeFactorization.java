package bai17_thread.bai_tap.tim_so_nguyen_to;

public class OptimizedPrimeFactorization implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 100; i < 1000; i++) {
                if (isPrime(i)) {
                    System.out.println("Optimized Prime: "+i);
                }
            }
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
