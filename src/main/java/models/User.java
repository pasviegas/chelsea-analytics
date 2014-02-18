package models;

public class User implements Get<User> {

    private int id;

    @Override
    public int identifier() {
        return id;
    }
}
