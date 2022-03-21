package logic.events;

import common.EventType;
import common.User;

public class UserLoginResponseEvent extends AccountResponseEvent {
    private static final EventType eventType = EventType.USER_LOGIN_RESPONSE;

    public UserLoginResponseEvent(Object source, User user, boolean rejected, String responseMessage) {
        super(source, eventType, user, rejected, responseMessage);
    }

    @Override
    public User getUser() {
        System.out.println("Overridden get user");
        return user;
    }

}
