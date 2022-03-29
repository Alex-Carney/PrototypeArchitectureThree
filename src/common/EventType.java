package common;


public enum EventType {
    USER_LOGIN(User.class),
    USER_CHANGE_PASSWORD(User.class),
    USER_CREATE_ACCOUNT(User.class),
    USER_DELETE_ACCOUNT(User.class),


    // Response events
    USER_LOGIN_RESPONSE(User.class, Boolean.class, String.class);


    private Object[] args;

    EventType(Object... args) {
        this.args = args;
    }

    public Object[] getArgumentList() {
        return args;
    }


}
