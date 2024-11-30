package ru.mirea.recyclerviewapp_hw;

public class HistoricalEvent {
    private final String eventName;
    private final String description;
    private int imageResId;

    public HistoricalEvent(String eventName, String description, int imageResId) {
        this.eventName = eventName;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    @Override
    public String toString() {
        return this.eventName + ": " + this.description;
    }
}
