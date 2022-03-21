package common;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public final class EventManager {

    private static EventManager INSTANCE;

    private final PropertyChangeSupport support;

    public EventManager() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl, EventType... eventType) {
        for(EventType event : eventType) {
            support.addPropertyChangeListener(event.toString(), pcl);
        }

    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void notify(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }

    public synchronized static EventManager getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new EventManager();
        }

        return INSTANCE;
    }

}
