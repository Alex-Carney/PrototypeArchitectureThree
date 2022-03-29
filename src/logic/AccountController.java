package logic;

import common.EventFactory;
import common.EventType;
import frontend.events.UserChangePasswordEvent;
import frontend.events.UserCreateAccountEvent;
import frontend.events.UserDeleteAccountEvent;
import frontend.events.UserLoginEvent;
import frontend.events.AccountEvent;
import common.User;
import logic.events.UserLoginResponseEvent;
import persistence.MockDatabase;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class AccountController implements PropertyChangeListener {

    /*
    A controller can use external dependencies to handle its tasks, such as
    a validation service, etc.

    However, since we are likely not using Spring to handle dependency injection
    + inversion of control for us, this might become cumbersome. We may
    need to come up with a creative alternative to @Autowired
     */
    //private final UserValidationService userValidationService;
    //private final PasswordService passwordService;
    private final EventFactory eventFactory;

    public AccountController(
        /*UserValidationService userValidationService,
        PasswordService passwordService*/
    ) {
        //this.validationService = validationService;
        //this.passwordService = passwordService
        this.eventFactory = EventFactory.getInstance();
    }

    /**
     * services like this should probably be in their own class, and passed into
     * the constructors of other classes, utilizing object composition
     *
     * For the sake of example I'll just have them as methods in this class. I
     * advise against actually doing this
      */
    public void hashPassword(User user) {
        user.setPassword(user.getPassword() + "HASHED");
    }


    public boolean validateUser(User userToValidate) {
        ArrayList<User> users = MockDatabase.getInstance().getDatabase();
        User alex = users.get(0);

        /*
         * Real validation should include custom errors for user not found versus
         * user found but wrong password. Then, a separate event could be fired
         * depending on the outcome (UserNotFoundResponseEvent) vs (UserIncorrectPasswordResponseEvent)
         */
        return alex.equals(userToValidate)
            && userToValidate.getPassword().equals(alex.getPassword());

    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /*
        Step 1: Perform actions that are shared among events that this controller
        manages

        For example, every single Account management action requires validation
        that the user exists (including CreateAccountEvent, can't make an account
        if it already exists!)

        So instead of writing 4 separate listeners for each Account event,
        we can write a single Controller and have it subscribe to a list of
        account-related events, handling each one accordingly after
        executing shared logic.
         */

        /*
         Requires downcasting from PropertyChangeEvent, this is where using an
         AccountEvent abstract class is helpful -- We can share functionality
         between all account events to do similar tasks like these ones. (hashing
         and validating)
         */
        User associatedUser = ((AccountEvent) evt).getUser();
        hashPassword(associatedUser);

        boolean userIsValid = validateUser(associatedUser);


        /*
        Step 2: Handle each type of account event accordingly. There is likely
        a better way to implement this, rather than stacks of instanceof
        statements. I'm open to recommendations. Here's a good place to start
        https://stackoverflow.com/questions/2790144/avoiding-instanceof-in-java

        The conclusion I came to from looking through various sources is that
        a chain of 'instanceof' statements is likely fine, especially for our
        project. However, I'm totally open to alternative solutions (We should
        agree on a single standard, however)
         */
        if (evt instanceof UserLoginEvent) {
            System.out.println("UserLoginEvent detected in controller, handling accordingly");
            UserLoginResponseEvent ulre = (UserLoginResponseEvent) this.eventFactory.createEvent(EventType.USER_LOGIN_RESPONSE, this,
                associatedUser,
                userIsValid,
                userIsValid ? "Logged in" : "Invalid credentials"
                );
            this.eventFactory.fireEvent(ulre);
        } else if (evt instanceof UserCreateAccountEvent) {
            System.out.println("UserCreateAccountEvent detected, handling accordingly");
        } else if (evt instanceof UserDeleteAccountEvent) {
            System.out.println("UserDeleteAccountEvent detected, handling accordingly");
        } else if (evt instanceof UserChangePasswordEvent) {
            System.out.println("UserChangePasswordEvent detected, handling accordingly");
        }


    }
}
