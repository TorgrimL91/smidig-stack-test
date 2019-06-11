package no.smidig.test.testrepo.controller;

import no.smidig.test.testrepo.entity.Location;
import no.smidig.test.testrepo.service.LocationService;
import no.smidig.test.testrepo.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/location")
@CrossOrigin
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewLocation(@Valid @RequestBody Location location, BindingResult result){
        Location location1 = locationService.saveOrUpdateLocation(location);

        return new ResponseEntity<Location>(location, HttpStatus.CREATED);
    }

    @GetMapping("/{city}")
    public ResponseEntity<?> getLocationById(@PathVariable String city){
        Location location = locationService.findLocationByIdentifier(city);

        return new ResponseEntity<Location>(location, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Location> getAllLocation(){
        return locationService.findAllLocation();
    }

    @DeleteMapping("/{city}")
    public ResponseEntity<?> deleteLocationByIdentifier(@PathVariable String city){
        locationService.deleteLocationByIdentifier(city);

        return new ResponseEntity<String>("Location '" + city + "' was deleted", HttpStatus.OK);
    }




}
