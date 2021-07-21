package bai4_oop_java.bai_tap.xay_dung_lop_stopwatch;

public class Exercise2 {
    public static void main(String[] args) {
        StopWatch time = new StopWatch();
        time.start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println(i);
        }
        time.stop();
        System.out.println(time.getStartTime());
        System.out.println(time.getEndTime());
        System.out.println(time.getElapsedTime());
    }
}
