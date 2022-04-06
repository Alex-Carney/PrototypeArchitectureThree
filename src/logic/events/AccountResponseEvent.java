package logic.events;

import common.EventType;
import common.User;

import java.beans.PropertyChangeEvent;

public abstract class AccountResponseEvent extends PropertyChangeEvent {
    protected final User user;
    protected final boolean rejected;
    protected final String responseMessage;

    public AccountResponseEvent(Object source, EventType eventType, User user, boolean rejectionStatus, String responseMessage) {
        super(source, eventType.toString(), null, null);
        this.user = user;
        this.rejected = rejectionStatus;
        this.responseMessage = responseMessage;
    }

    public User getUser() {
        return user;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
    public boolean isRejected() {
        return rejected;
    }
}
