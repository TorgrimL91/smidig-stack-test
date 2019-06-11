package no.smidig.test.testrepo.service;



import no.smidig.test.testrepo.entity.PostEntity;
import no.smidig.test.testrepo.entity.User;
import no.smidig.test.testrepo.repositories.PostRepository;
import no.smidig.test.testrepo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;



    public PostEntity addPost(String username, PostEntity postEntity){
        User user = userRepository.findByUserName(username);
        postEntity.setUser(user);

        return postRepository.save(postEntity);

    }


    public PostEntity saveOrUpdatePost(PostEntity postEntity){

        postEntity.setId(postEntity.getId());

        return postRepository.save(postEntity);
    }


    public PostEntity findPostByIdentifier(String username){
        PostEntity postEntity = postRepository.findByid(username);

        return postEntity;
    }

    public Iterable<PostEntity> findAllPost(){
        return postRepository.findAll();
    }

    public void deletePostByIdentifier(String username){
        PostEntity postEntity = postRepository.findByid(username);

        //dette er dårlig kode. vi har allerede gjort et databasekall. bør være unødvendig å gjøre et til. fiks dette senere
        postRepository.deleteById(postEntity.getId());
    }


}
