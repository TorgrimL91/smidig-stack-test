package no.smidig.test.testrepo.repositories;

import no.smidig.test.testrepo.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    Event findByEventName(String eventName);

    Iterable<Event> findAll();
}
