package com.api.springboottodo.services;

import com.api.springboottodo.models.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private List<Event> events = new ArrayList<>();
    private Long nextEventId = 1L;

    public Event addEvent(Event event) {
        event.setId(nextEventId);
        nextEventId++;
        events.add(event);
        return event;
    }

    public Event getEventById(Long id) {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return event;
            }
        }
        return null;
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public void deleteEvent(Long id) {
        events.removeIf(event -> event.getId().equals(id));
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.getId().equals(id)) {
                updatedEvent.setId(id);
                events.set(i, updatedEvent);
                return updatedEvent;
            }
        }
        return null;
    }
}
