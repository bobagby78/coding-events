package org.launchcode.codingevents.models;

public class Event {

    private String eventName;
    private String eventDescription;

    public Event(String eventName, String eventDescription) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getName() {
        return eventName;
    }

    public void setName(String name) {
        this.eventName = name;
    }

    @Override
    public String toString() {
        return eventName;
    }
}
