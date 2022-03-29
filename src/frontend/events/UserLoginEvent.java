package frontend.events;

import common.EventType;
import common.User;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to login.
 * @author Alex Carney
 */
public class UserLoginEvent extends AccountEvent {


    private static final EventType eventType = EventType.USER_LOGIN;


    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       the bean that fired the event
     * @param user The un-authorized user associated with the event
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserLoginEvent(Object source, Object... args) {
        super(source, eventType, (User) args[0]);
    }


    @Override
    public EventType getEventType() {
        return eventType;
    }

}
