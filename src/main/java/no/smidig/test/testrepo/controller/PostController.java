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


    @GetMapping("/{postcontent}")
    public ResponseEntity<?> getPostByPostContent(@PathVariable String postcontent){
        PostEntity postEntity = postService.findPostByIdentifier(postcontent);

        return new ResponseEntity<PostEntity>(postEntity, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<PostEntity> getAllPost(){
        return postService.findAllPost();
    }

    @DeleteMapping("/{postcontent}")
    public ResponseEntity<?> deletePostByIdentifier(@PathVariable String postcontent){
        postService.deletePostByIdentifier(postcontent);

        return new ResponseEntity<String>("Post with postcontent '" + postcontent + "' was deleted", HttpStatus.OK);
    }


}
