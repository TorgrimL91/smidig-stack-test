package no.smidig.test.testrepo.service;


import no.smidig.test.testrepo.entity.Location;
import no.smidig.test.testrepo.repositories.EventRepository;
import no.smidig.test.testrepo.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {


    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private LocationRepository locationRepository;



    public Location saveOrUpdateLocation(Location location){

        location.setId(location.getId());
        return locationRepository.save(location);
    }


    public Location findLocationByIdentifier(String city){

        Location location = locationRepository.findByCity(city);
        return location;
    }

    public Iterable<Location> findAllLocation(){

        return locationRepository.findAll();
    }

    public void deleteLocationByIdentifier(String city){
        Location location = locationRepository.findByCity(city);

        //dette er dårlig kode. vi har allerede gjort et databasekall. bør være unødvendig å gjøre et til. fiks dette senere
        locationRepository.deleteById(location.getId());
    }

}
