//package frontend;
//
//import common.EventFactory;
//import common.EventManager;
//import common.EventType;
//import common.User;
//
//import java.beans.PropertyChangeEvent;
//
//public class AccountEventFactory extends EventFactory {
//
//    private final EventManager eventManager;
//
//    public AccountEventFactory(EventManager eventManager) {
//        this.eventManager = eventManager;
//    }
//
//
//    @Override
//    public PropertyChangeEvent createEvent(EventType eventTypeToCreate, user) {
//        switch(eventTypeToCreate) {
//            case USER_LOGIN:
//
//
//
//        }
//    }
//
//    @Override
//    public void fireEvent(PropertyChangeEvent evt) {
//        this.eventManager.notify(evt);
//
//    }
//
//}
