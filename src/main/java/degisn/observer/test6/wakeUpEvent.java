package degisn.observer.test6;
//时间类 fire Event
public class wakeUpEvent {
    long timestamp;
    String loc;
    Child source;

    public wakeUpEvent(long timestamp, String loc,Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }
}
