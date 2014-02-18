package models;

public class Quantity implements Get<Quantity> {
    private int value;

    @Override
    public int identifier() {
        return value;
    }
}
