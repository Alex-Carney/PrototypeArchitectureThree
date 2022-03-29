package common;

public class User implements Payload {
    private String email;

    private String userName;

    private String password;

    private boolean isAuthorized;

    public User(String email, String userName, String password,
        boolean isAuthorized) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.isAuthorized = isAuthorized;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User otherUser = (User) o;
        return otherUser.getEmail().equals(this.email) && otherUser.getUserName().equals(this.userName);
    }
}
