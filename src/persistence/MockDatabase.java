package persistence;

import common.User;

import java.util.ArrayList;

public class MockDatabase {
    private static MockDatabase INSTANCE;
    private ArrayList<User> database;

    public MockDatabase() {
        database = new ArrayList<>();
        seedDatabase();
    }

    public void seedDatabase() {
        User alex = new User(
            "acarney@skidmore.edu",
            "ACarney",
            "passwordHASHED",
            true);
        database.add(alex);
    }

    public ArrayList<User> getDatabase() {
        return database;
    }

    public synchronized static MockDatabase getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new MockDatabase();
        }
        return INSTANCE;
    }
}
