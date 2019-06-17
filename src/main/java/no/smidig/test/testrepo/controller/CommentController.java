package no.smidig.test.testrepo.controller;


import no.smidig.test.testrepo.entity.Comment;
import no.smidig.test.testrepo.service.CommentService;
import no.smidig.test.testrepo.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewComment(@Valid @RequestBody Comment comment, BindingResult result) {
        Comment comment1 = commentService.saveOrUpdateComment(comment);

        return new ResponseEntity<Comment>(comment, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Comment> getAllPost(){
        return commentService.findAllComment();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostByIdentifier(@PathVariable String username){
        commentService.deleteCommentByCommentIdentifier(username);

        return new ResponseEntity<String>("Post with username '" + username + "' was deleted", HttpStatus.OK);
    }



}
