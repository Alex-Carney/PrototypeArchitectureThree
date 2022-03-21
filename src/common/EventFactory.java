package common;
import java.beans.PropertyChangeEvent;


public abstract class EventFactory {
    /**
     *
     */

    public abstract PropertyChangeEvent createEvent(EventType eventTypeToCreate);
    public abstract void fireEvent(PropertyChangeEvent evt);


}
