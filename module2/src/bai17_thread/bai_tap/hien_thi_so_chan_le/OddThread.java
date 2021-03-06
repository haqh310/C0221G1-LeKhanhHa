package bai17_thread.bai_tap.hien_thi_so_chan_le;

public class OddThread extends Thread {
    private int num;

    public OddThread(int num) {
        this.num = num;
    }

    public void run() {
        try {
            for (int i = 1; i <= num; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
