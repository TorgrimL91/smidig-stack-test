package no.smidig.test.testrepo.repositories;

import no.smidig.test.testrepo.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {


    Location findByCity(String city);

    Iterable<Location> findAll();

}
