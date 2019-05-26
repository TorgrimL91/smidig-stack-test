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


    @GetMapping("/{eventname}")
    public ResponseEntity<?> getEventByEventName(@PathVariable String eventname){
        EventsEntity eventsEntity = eventsService.findEventByIdentifier(eventname);

        return new ResponseEntity<EventsEntity>(eventsEntity, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<EventsEntity> getAllEvents(){
        return eventsService.findAllEvents();
    }

    @DeleteMapping("/{eventsname}")
    public ResponseEntity<?> deleteEventByIdentifier(@PathVariable String eventsname){
        eventsService.deleteEventByIdentifier(eventsname);

        return new ResponseEntity<String>("Event with eventname '" + eventsname + "' was deleted", HttpStatus.OK);
    }









}







