package bai17_thread.bai_tap.tao_thread_don_gian;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new NumberGenerator(0));
        Thread thread2 = new Thread(new NumberGenerator(10));
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();

    }
}
