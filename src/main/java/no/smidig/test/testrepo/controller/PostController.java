package no.smidig.test.testrepo.controller;



import no.smidig.test.testrepo.entity.Comment;
import no.smidig.test.testrepo.entity.PostEntity;
import no.smidig.test.testrepo.service.CommentService;
import no.smidig.test.testrepo.service.MapValidationErrorService;
import no.smidig.test.testrepo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/post")
@CrossOrigin
public class PostController {




    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;


    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewPost(@Valid @RequestBody PostEntity postEntity, BindingResult result){
        PostEntity postEntity1 = postService.saveOrUpdatePost(postEntity);

        return new ResponseEntity<PostEntity>(postEntity, HttpStatus.CREATED);
    }


    @PostMapping("/comment/{username}")
    public ResponseEntity<?> addComment(@Valid @RequestBody Comment comment, BindingResult result,
                                        @PathVariable String username){
        ResponseEntity<?> erroMap = mapValidationErrorService.MapValidationService(result);
        if(erroMap != null) return erroMap;

        Comment comment1 = commentService.addComment(username, comment);
        return new ResponseEntity<Comment>(comment1, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getPostByPostId(@PathVariable String username){
        PostEntity postEntity = postService.findPostByIdentifier(username);

        return new ResponseEntity<PostEntity>(postEntity, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<PostEntity> getAllPost(){
        return postService.findAllPost();
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deletePostByIdentifier(@PathVariable String username){
        postService.deletePostByIdentifier(username);

        return new ResponseEntity<String>("Post with username '" + username + "' was deleted", HttpStatus.OK);
    }


}
