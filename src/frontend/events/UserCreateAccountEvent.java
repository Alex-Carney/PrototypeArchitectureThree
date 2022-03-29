package frontend.events;

import common.EventType;
import common.User;

public class UserCreateAccountEvent extends AccountEvent {

    private static final EventType eventType = EventType.USER_CREATE_ACCOUNT;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source         the bean that fired the event
     * @param associatedUser The email, username, and password supplied with the new account request
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserCreateAccountEvent(Object source, Object... args) {
        super(source, eventType, (User) args[0]);
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
