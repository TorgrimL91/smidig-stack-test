package no.smidig.test.testrepo.controller;

import no.smidig.test.testrepo.entity.Event;
import no.smidig.test.testrepo.entity.PostEntity;
import no.smidig.test.testrepo.entity.User;
import no.smidig.test.testrepo.service.EventService;
import no.smidig.test.testrepo.service.MapValidationErrorService;
import no.smidig.test.testrepo.service.PostService;
import no.smidig.test.testrepo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    @Autowired
    private EventService eventService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewUser(@Valid @RequestBody User user, BindingResult result){
        User user1 = userService.saveOrUpdateUser(user);

        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUserName(@PathVariable String username){
        User user = userService.findUserByIdentifier(username);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


    @PostMapping("/post/{username}")
    public ResponseEntity<?> addPost(@Valid @RequestBody PostEntity postEntity, BindingResult result,
                                     @PathVariable String username){
        ResponseEntity<?> erroMap = mapValidationErrorService.MapValidationService(result);
        if (erroMap != null) return  erroMap;

        PostEntity postEntity1 = postService.addPost(username, postEntity);

        return new ResponseEntity<PostEntity>(postEntity1,HttpStatus.CREATED);
    }


    @PostMapping("/event/{username}")
    public ResponseEntity<?> addEvent(@Valid @RequestBody Event event, BindingResult result,@PathVariable String username){
        ResponseEntity<?> erroMap = mapValidationErrorService.MapValidationService(result);
        if (erroMap != null) return  erroMap;
        Event event1 = eventService.addEvent(username, event);
        return new ResponseEntity<Event>(event1,HttpStatus.CREATED);
    }



    @GetMapping("/all")
    public Iterable<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUserByIdentifier(@PathVariable String username){
        userService.deleteUserByIdentifier(username);

        return new ResponseEntity<String>("User with username '" + username + "' was deleted", HttpStatus.OK);
    }


}
