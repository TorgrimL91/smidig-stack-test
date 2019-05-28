package no.smidig.test.testrepo.controller;



import no.smidig.test.testrepo.entity.PostEntity;
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

    @PostMapping("")
    public ResponseEntity<?> createNewPost(@Valid @RequestBody PostEntity postEntity, BindingResult result){
        PostEntity postEntity1 = postService.saveOrUpdatePost(postEntity);

        return new ResponseEntity<PostEntity>(postEntity, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPostByPostId(@PathVariable Long id){
        PostEntity postEntity = postService.findPostByIdentifier(id);

        return new ResponseEntity<PostEntity>(postEntity, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<PostEntity> getAllPost(){
        return postService.findAllPost();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostByIdentifier(@PathVariable Long id){
        postService.deletePostByIdentifier(id);

        return new ResponseEntity<String>("Post with postId '" + id + "' was deleted", HttpStatus.OK);
    }


}
