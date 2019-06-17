package no.smidig.test.testrepo.controller;


import no.smidig.test.testrepo.entity.Comment;
import no.smidig.test.testrepo.service.CommentService;
import no.smidig.test.testrepo.service.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;



    @GetMapping("/all")
    public Iterable<Comment> getAllPost(){
        return commentService.findAllComment();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostByIdentifier(@PathVariable Long id){
        commentService.deleteCommentByCommentIdentifier(id);

        return new ResponseEntity<String>("Post with username '" + id + "' was deleted", HttpStatus.OK);
    }



}
