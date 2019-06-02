package no.smidig.test.testrepo.controller;


import no.smidig.test.testrepo.entity.EventsEntity;
import no.smidig.test.testrepo.entity.User;
import no.smidig.test.testrepo.service.EventsService;
import no.smidig.test.testrepo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/event")
@CrossOrigin
public class EventsController {


    @Autowired
    private EventsService eventsService;

    @PostMapping("")
    public ResponseEntity<?> createNewEvent(@Valid @RequestBody EventsEntity eventsEntity, BindingResult result){
        EventsEntity eventsEntity1 = eventsService.saveOrUpdateEvent(eventsEntity);

        return new ResponseEntity<EventsEntity>(eventsEntity, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getEventByEventName(@PathVariable Long id){
        EventsEntity eventsEntity = eventsService.findEventByIdentifier(id);

        return new ResponseEntity<EventsEntity>(eventsEntity, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<EventsEntity> getAllEvents(){
        return eventsService.findAllEvents();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEventByIdentifier(@PathVariable Long id){
        eventsService.deleteEventByIdentifier(id);

        return new ResponseEntity<String>("Event with eventname '" + id + "' was deleted", HttpStatus.OK);
    }











}







