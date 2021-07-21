package bai17_thread.bai_tap.tao_thread_don_gian;

public class NumberGenerator implements Runnable {
    private int number;
    public NumberGenerator(int number){
        this.number = number;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(i+number);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
