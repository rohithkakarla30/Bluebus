package bean;

public class ScheduleBean {
    
    private String scheduleId;
    private String source;
    private String destination;
    private String startTime;
    private String arrivalTime;
    
    public String getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    @Override
    public String toString() {
        return "ScheduleBean [arrivalTime=" + arrivalTime + ", destination=" + destination + ", scheduleId="
                + scheduleId + ", source=" + source + ", startTime=" + startTime + "]";
    }
    public void setEndTime(String parameter) {
    }    
}
