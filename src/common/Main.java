package common;

import frontend.AccountResponseController;
import frontend.FrontEndEventDispatcher;
import logic.AccountController;
import logic.AccountResponseDispatcher;
import persistence.MockDatabase;

public class Main {

    private final EventManager eventManager;

    private final FrontEndEventDispatcher frontEndEventDispatcher;

    private final AccountResponseDispatcher logicEndEventDispatcher;

    private final MockDatabase database;

    public Main() {
        // The main method is where the EventManager is created for the first (and only) time
        eventManager = EventManager.getInstance();

        // This may be the home page or something of those sorts
        frontEndEventDispatcher = new FrontEndEventDispatcher();
        logicEndEventDispatcher = new AccountResponseDispatcher();


        /*
        FOR EVERY LISTENER, it must be instantiated and registered when the program starts.

        Additionally, an arbitrary number of EventTypes that the listener will respond to
        can be supplied here! Thanks to the Java spread operator ...
         */
        eventManager.addPropertyChangeListener(
            new AccountController(logicEndEventDispatcher),
            EventType.USER_LOGIN, EventType.USER_CREATE_ACCOUNT);
        eventManager.addPropertyChangeListener(new AccountResponseController(),
            EventType.USER_LOGIN_RESPONSE);

        this.database = new MockDatabase();

        // Tracer bullet. Should succeed
        User fakeUser = new User(
            "acarney@skidmore.edu",
            "ACarney",
            "password",
            false);

        frontEndEventDispatcher.fireLoginEvent(fakeUser);

        // Tracer bullet 2. Should fail
        User fakeUser2 = new User(
            "acarn2ey@skidmore.edu",
            "ACarney",
            "password",
            false
            );

        frontEndEventDispatcher.fireLoginEvent(fakeUser2);

    }

    public static void main(String[] args) {
        new Main();
    }
}
