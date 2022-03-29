package logic.events;

import common.EventType;
import common.User;

public class UserLoginResponseEvent extends AccountResponseEvent {
    private static final EventType eventType = EventType.USER_LOGIN_RESPONSE;

    public UserLoginResponseEvent(Object source, Object... args) {
        super(source, eventType, (User) args[0], (Boolean) args[1], (String) args[2]);
    }

    @Override
    public User getUser() {
        System.out.println("Overridden get user");
        return user;
    }

}
