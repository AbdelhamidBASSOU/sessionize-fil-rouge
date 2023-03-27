package Sessionize.service.impl;

import Sessionize.entity.Event;
import Sessionize.repository.EventReposiroty;
import Sessionize.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventReposiroty eventRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException("Event not found !"));
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event updateEvent(Long eventId, Event updatedEvent) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalStateException("Event not found !"));
        updatedEvent.setName(event.getName());
        updatedEvent.setCategory(event.getCategory());
        updatedEvent.setStartdate(event.getStartdate());
        updatedEvent.setEnddate(event.getEnddate());
        updatedEvent.setStartTime(event.getStartTime());
        updatedEvent.setLocation(event.getLocation());
        updatedEvent.setAttendeeList(event.getAttendeeList());
        return eventRepository.save(event);
    }

    public void deleteEventById(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
