package bai17_thread.bai_tap.hien_thi_so_chan_le;

public class EvenThread extends Thread {
    private int num;

    public EvenThread(int num) {
        this.num = num;
    }

    public void run() {
        try {
            for (int i = 1; i <= num; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
