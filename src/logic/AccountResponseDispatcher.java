package logic;

import common.EventDispatcher;
import common.EventManager;
import common.EventType;
import common.User;
import logic.events.UserLoginResponseEvent;

import java.beans.PropertyChangeEvent;

/**
 * The method for responding to events is still up in the air. It would be
 * simple to fire events directly from the controller that caught the
 * incoming events, however that could potentially break SRP.
 *
 *
 */
public class AccountResponseDispatcher implements EventDispatcher {


    private final EventManager eventManager;

    public AccountResponseDispatcher() {
        eventManager = EventManager.getInstance();

    }

    public void accountEventResponseFactory(EventType eventType, User user, boolean success, String responseMessage) {
        PropertyChangeEvent eventToFire;
        switch(eventType) {
            case USER_LOGIN_RESPONSE:
                eventToFire = new UserLoginResponseEvent(eventType, user, success, responseMessage);
                break;

            default:
                throw new IllegalStateException(
                    "Unexpected value: " + eventType);
        }
        fireEvent(eventToFire);
    }


    @Override
    public void fireEvent(PropertyChangeEvent event) {
        eventManager.notify(event);
    }
}
