package no.smidig.test.testrepo.controller;

import no.smidig.test.testrepo.entity.User;
import no.smidig.test.testrepo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

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
