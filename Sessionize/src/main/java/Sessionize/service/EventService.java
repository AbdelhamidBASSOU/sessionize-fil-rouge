package Sessionize.service;

import Sessionize.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    Event addEvent(Event event);
    Event getEventById(Long eventId);
    Event updateEvent(Long eventId, Event updatedEvent);
    List<Event> getAllEvents();
    void deleteEventById(Long eventId);
}
