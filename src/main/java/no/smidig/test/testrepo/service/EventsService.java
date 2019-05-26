package no.smidig.test.testrepo.service;


import no.smidig.test.testrepo.entity.EventsEntity;
import no.smidig.test.testrepo.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsService {


    @Autowired
    private EventsRepository eventsRepository;


    public EventsEntity saveOrUpdateEvent(EventsEntity eventsEntity){

        eventsEntity.setEventsName(eventsEntity.getEventsName().toUpperCase());

        return eventsRepository.save(eventsEntity);
    }


    public EventsEntity findEventByIdentifier(String eventName){
        EventsEntity eventsEntity = eventsRepository.findByEventsName(eventName);

        return eventsEntity;
    }

    public Iterable<EventsEntity> findAllEvents(){
        return eventsRepository.findAll();
    }

    public void deleteEventByIdentifier(String eventName){
        EventsEntity eventsEntity = eventsRepository.findByEventsName(eventName);

        //dette er dårlig kode. vi har allerede gjort et databasekall. bør være unødvendig å gjøre et til. fiks dette senere
        eventsRepository.deleteById(eventsEntity.getId());
    }

}
