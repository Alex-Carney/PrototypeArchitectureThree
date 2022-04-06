package frontend.events;

import common.EventType;
import common.User;

import java.beans.PropertyChangeEvent;



public abstract class AccountEvent extends PropertyChangeEvent {
    /**
     * User executing operation.
     */
    private final User user;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source        the bean that fired the event
     * @param eventType     the EventType enum entry that corresponds to this
     *                      event
     * @param user          User executing operation
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    protected AccountEvent(Object source, EventType eventType, User user) {
        super(source, eventType.toString(), null, null);
        this.user = user;
    }

    /**
     * Shared by all concrete account events
     * @return User executing an account management operation
     */
    public User getUser() {
        return user;
    }

    /**
     * Abstract method to be overridden by concrete subclasses.
     * @return The EventType enum associated with the event.
     */
    public abstract EventType getEventType();
}

