package common;

public class Password implements Payload {

    private final String passwordValue;

    public Password(String value) {
        passwordValue = value;
    }

    public String getPasswordValue() {
        return passwordValue;
    }
}
