package models;

public class Price implements Get<Price> {
    private int value;

    @Override
    public int identifier() {
        return value;
    }
}
