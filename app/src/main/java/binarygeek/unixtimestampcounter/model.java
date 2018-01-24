package binarygeek.unixtimestampcounter;

/**
 * Created by uy on 1/22/2018.
 */

public class model {
 public    String name;
 public    long  unixTime;

    public long getUnixTime() {
        return unixTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnixTime(long unixTime) {
        this.unixTime = unixTime;
    }
}
