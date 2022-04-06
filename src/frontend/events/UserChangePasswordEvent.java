package frontend.events;

import common.EventType;
import common.Password;
import common.User;

/**
 * A concrete implementation of an Event, representing the data transfer object
 * DTO associated with a user attempting to change their password.
 * @author Alex Carney
 */
public class UserChangePasswordEvent extends AccountEvent {

    /**
     * Proposed new password for user.
     */
    private final Password newPassword;

    /**
     * EventType enum for this class
     */
    private static final EventType eventType =
        EventType.USER_CHANGE_PASSWORD;

    /**
     * Constructs a new {@code PropertyChangeEvent}.
     *
     * @param source       The bean that fired the event
     * @param user         The un-authorized user associated with the event
     * @param newPassword  The proposed new password for the user
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public UserChangePasswordEvent(Object source, Object... args) {
        super(source, eventType, (User) args[0]);
        this.newPassword = (Password) args[1];
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }

    /**
     * Get the proposed new password of a user, unique to this concrete
     * implementation
     * @return new password object
     */
    public Password getNewPassword() {
        return newPassword;
    }
}
