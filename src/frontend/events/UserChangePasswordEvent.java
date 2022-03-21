package frontend.events;

import common.EventType;
import common.User;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to change their password.
 * @author Alex Carney
 */
public class UserChangePasswordEvent extends AccountEvent {


    private final User user;
    private final String newPassword;
    private static final EventType eventType = EventType.USER_CHANGE_PASSWORD;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       the bean that fired the event
     * @param user The un-authorized user associated with the event
     * @param newPassword The proposed new password for the user
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserChangePasswordEvent(Object source, User user, String newPassword) {
        super(source, eventType, user);
        this.user = user;
        this.newPassword = newPassword;

    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
