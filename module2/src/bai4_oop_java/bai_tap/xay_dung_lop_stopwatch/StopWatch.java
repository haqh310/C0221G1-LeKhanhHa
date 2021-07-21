package bai4_oop_java.bai_tap.xay_dung_lop_stopwatch;

import java.util.Date;

public class StopWatch {
    private Date startTime;
    private Date endTime;
    public  StopWatch(){
        this.startTime = new Date();
    }
    public Date getStartTime(){
        return startTime;
    }
    public Date getEndTime(){
        return  endTime;
    }
    public void start(){
        this.startTime = new Date();
    }
    public void stop(){
        this.endTime = new Date();
    }
    public long getElapsedTime(){
        return  endTime.getTime() - startTime.getTime();
    }
}
