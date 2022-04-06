package common;


public enum EventType {
    /**
     * Fired when a user attempts to login from the LoginPage
     */
    USER_LOGIN(User.class),

    /**
     * Fired when a logged in user attempts to change their password from the
     * AccountPage
     */
    USER_CHANGE_PASSWORD(User.class, Password.class),

    /**
     * Fired when a user attempts to create an account from the
     * AccountPage
     */
    USER_CREATE_ACCOUNT(User.class),

    /**
     * Fired when a logged in user attempts to delete their account from the
     * AccountPage
     */
    USER_DELETE_ACCOUNT(User.class),


    // Response events
    USER_LOGIN_RESPONSE(User.class, Boolean.class, String.class);

    /**
     * Stores the varargs for required data types for instantiation
     */
    private Object[] args;

    EventType(Object... args) {
        this.args = args;
    }

    /**
     * @return A list of class objects that represent required types for
     * event instantiation
     */
    public Object[] getArgumentList() {
        return args;
    }


}
