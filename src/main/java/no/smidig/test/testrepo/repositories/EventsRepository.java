package no.smidig.test.testrepo.repositories;

import no.smidig.test.testrepo.entity.EventsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository<EventsEntity, Long> {

    EventsEntity findByid(Long id);

    Iterable<EventsEntity> findAll();
}