package no.smidig.test.testrepo.service;


import no.smidig.test.testrepo.entity.Event;
import no.smidig.test.testrepo.entity.User;
import no.smidig.test.testrepo.repositories.EventRepository;
import no.smidig.test.testrepo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class EventService {


    private Event event;


    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;


    public Event addEvent(String eventName, Event event){
        User user = userRepository.findByUserName(eventName);
        event.setUser(user);

        return eventRepository.save(event);
    }


    public Event saveOrUpdateEvent(Event event){
        entityManager.refresh(event);
        event.setId(event.getId());

        return eventRepository.save(event);
    }


    public Event findEventByIdentifier(String eventName){
        Event event = eventRepository.findByEventName(eventName);

        return event;
    }

    public Iterable<Event> findAllEvent(){
        return eventRepository.findAll();
    }

    public void deletePostByIdentifier(String eventName){
        Event event = eventRepository.findByEventName(eventName);

        //dette er dårlig kode. vi har allerede gjort et databasekall. bør være unødvendig å gjøre et til. fiks dette senere
        eventRepository.deleteById(event.getId());
    }
}
