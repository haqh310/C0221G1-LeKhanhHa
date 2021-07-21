package bai17_thread.bai_tap.hien_thi_so_chan_le;

public class TestThread {
    public static void main(String[] args) {
        int num =10;
        Thread thread1 = new Thread(new OddThread(num));
        Thread thread2 = new Thread(new EvenThread(num));
        thread1.start();
        try {
            thread1.join();
        }
        catch (Exception e){
            System.out.println(e);
        }
        thread2.start();
    }
}
