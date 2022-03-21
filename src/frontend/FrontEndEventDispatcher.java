package frontend;

import common.EventDispatcher;
import common.EventManager;
import frontend.events.UserCreateAccountEvent;
import frontend.events.UserLoginEvent;
import common.User;

import java.beans.PropertyChangeEvent;

/**
 * This class is a prototype of any
 */
public class FrontEndEventDispatcher implements EventDispatcher {

    private final EventManager eventManager;


    public FrontEndEventDispatcher() {
        eventManager = EventManager.getInstance();
    }

    /**
     * The method that actually fires the event can come from anywhere -
     * for front end we would fire the events from the callback from a user
     * clicking "submit" on the login screen.
      */
    public void fireLoginEvent(User user) {
        UserLoginEvent ule = new UserLoginEvent(this, user);
        fireEvent(ule);

//        UserCreateAccountEvent ucae = new UserCreateAccountEvent(this, user);
//        fireEvent(ucae);
    }

    public void fireEvent(PropertyChangeEvent event) {
        eventManager.notify(event);
    }

}
