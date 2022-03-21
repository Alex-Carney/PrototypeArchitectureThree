package frontend.events;

import common.EventType;
import common.User;

public class UserDeleteAccountEvent extends AccountEvent {

    private final User user;
    private static final EventType eventType = EventType.USER_DELETE_ACCOUNT;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source         the bean that fired the event
     * @param associatedUser The logged in user attempting to delete their account
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserDeleteAccountEvent(Object source, User associatedUser) {
        super(source, eventType, associatedUser);
        this.user = associatedUser;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }
}
