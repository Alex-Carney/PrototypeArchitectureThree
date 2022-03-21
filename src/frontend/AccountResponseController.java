package frontend;

import logic.events.UserLoginResponseEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AccountResponseController implements PropertyChangeListener {

    public AccountResponseController() {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt instanceof UserLoginResponseEvent) {
            UserLoginResponseEvent ulre = (UserLoginResponseEvent) evt;
            System.out.println("Detected user login response. The status is " + ulre.isRejected());
            System.out.println(ulre.getResponseMessage());
        }
    }
}
