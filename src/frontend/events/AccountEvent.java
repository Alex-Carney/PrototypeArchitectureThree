package frontend.events;

import common.EventType;
import common.User;

import java.beans.PropertyChangeEvent;



public abstract class AccountEvent extends PropertyChangeEvent {


    private final User user;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       the bean that fired the event
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public AccountEvent(Object source, EventType eventType, User user) {
        super(source, eventType.toString(), null, null);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    public abstract EventType getEventType();

}

