package models;

public class TimeSpan implements Get<TimeSpan>{
    private int value;

    @Override
    public int identifier() {
        return value;
    }
}

