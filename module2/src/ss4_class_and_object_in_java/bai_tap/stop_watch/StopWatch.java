package ss4_class_and_object_in_java.bai_tap.stop_watch;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
    }

    public StopWatch(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long start() {
        this.startTime = System.currentTimeMillis();
        return this.startTime;
    }

    public long stop() {
        this.endTime = System.currentTimeMillis();
        return this.endTime;
    }

    //    Tính khoảng thời gian đã trôi qua
    public long getElapsedTime() {
        long result = this.getEndTime() - this.getStartTime();
        return result;
    }

}
