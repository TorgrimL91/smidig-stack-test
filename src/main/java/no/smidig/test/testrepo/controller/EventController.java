package no.smidig.test.testrepo.controller;

import no.smidig.test.testrepo.entity.Event;
import no.smidig.test.testrepo.service.EventService;
import no.smidig.test.testrepo.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/event")
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewPost(@Valid @RequestBody Event event, BindingResult result){
        Event event1 = eventService.saveOrUpdateEvent(event);

        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPostByEventId(@PathVariable String eventName){
        Event event = eventService.findEventByIdentifier(eventName);

        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Event> getAllEvent(){
        return eventService.findAllEvent();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvententifier(@PathVariable String eventName){
        eventService.deletePostByIdentifier(eventName);

        return new ResponseEntity<String>("Event '" + eventName + "' was deleted", HttpStatus.OK);
    }


}
