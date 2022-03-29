package common;

import frontend.events.UserChangePasswordEvent;
import frontend.events.UserCreateAccountEvent;
import frontend.events.UserDeleteAccountEvent;
import frontend.events.UserLoginEvent;
import logic.events.UserLoginResponseEvent;

import java.beans.PropertyChangeEvent;
import java.util.Arrays;

/**
 * This class creates an event of type PropertyChangeEvent
 * from the metadata given in EventType enum.
 *
 * @author Sten Leinasaar
 *         Last Edit: March 23, 2022
 * @author Alex Carney
 *         Last Edit: March 29, 2022
 */
public class EventFactory implements EventDispatcher {

    /**
     * Singleton instance of a EventFactory.
     * Instance can be accessed through EventFactory.getInstance()
     */
    private static final EventFactory INSTANCE;


    private final EventManager eventManager;


    static {
        INSTANCE = new EventFactory();
    }

    /**
     * EventFactory private constructor.
     */
    private EventFactory() {
        this.eventManager = EventManager.getInstance();
    }

    /**
     * Synchronized getInstance of a EventFactory method.
     *
     * @return Singleton instance of the factory.
     */
    public static synchronized EventFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Creates an event of type PropertyChangeEvent based on the
     * EventType enum value being passed.
     *
     * @param event
     *            Type of an event as specified from the ENUM.
     * @param source
     *            Source that fired the update.
     * @param args
     *            Vararg of Object type.
     * @return An event of type that was specified.
     */
    public PropertyChangeEvent createEvent(EventType event, Object source,
        Object... args) {

        Object[] eventArgumentList = event.getArgumentList();



        for (int i = 0; i < eventArgumentList.length; i++) {
//            Class<?> clazz = args[i].getClass();
            Class<?> clazz = args[i].getClass();
            if (clazz != eventArgumentList[i]) {
                throw new IllegalArgumentException(
                    "Argument data types do not match enum"
                );
            }
            if (!Arrays.asList(clazz.getInterfaces()).contains(Payload.class)) {
                System.out.println("Warning: Using non payload, argument type " + clazz);
            }

        }


        switch (event) {
            case USER_CREATE_ACCOUNT:
                return new UserCreateAccountEvent(source, args);
            case USER_DELETE_ACCOUNT:
                return new UserDeleteAccountEvent(source, args);
            case USER_LOGIN:
                return new UserLoginEvent(source, args);
            case USER_LOGIN_RESPONSE:
                return new UserLoginResponseEvent(source, args);
            case USER_CHANGE_PASSWORD:
                return new UserChangePasswordEvent(source, args);
            default:
                System.out.println("Warning: Default case statement reached");
                break;
        }

        return null;

    }

    @Override
    public void fireEvent(PropertyChangeEvent event) {
        eventManager.notify(event);
    }
}
