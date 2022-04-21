package degisn.observer.test7;

//时间类 fire Event
public class wakeUpEvent extends Event<Child> {
    long timestamp;
    String loc;
    Child source;

    public wakeUpEvent(long timestamp, String loc, Child source) {
        this.timestamp = timestamp;
        this.loc = loc;
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}
