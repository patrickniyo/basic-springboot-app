package com.api.springboottodo.controllers;

import com.api.springboottodo.models.Event;
import com.api.springboottodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/events")
    public Event addEvent(@RequestBody Event event) {
        return todoService.addEvent(event);
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable Long id) {
        return todoService.getEventById(id);
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return todoService.getAllEvents();
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable Long id) {
        todoService.deleteEvent(id);
    }

    @PutMapping("/events/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        return todoService.updateEvent(id, updatedEvent);
    }
}
