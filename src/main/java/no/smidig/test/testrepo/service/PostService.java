package no.smidig.test.testrepo.service;



import no.smidig.test.testrepo.entity.PostEntity;
import no.smidig.test.testrepo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public PostEntity saveOrUpdatePost(PostEntity postEntity){

        postEntity.setPostContent(postEntity.getPostContent().toUpperCase());

        return postRepository.save(postEntity);
    }


    public PostEntity findPostByIdentifier(String postContent){
        PostEntity postEntity = postRepository.findByPostContent(postContent);

        return postEntity;
    }

    public Iterable<PostEntity> findAllPost(){
        return postRepository.findAll();
    }

    public void deletePostByIdentifier(String postContent){
        PostEntity postEntity = postRepository.findByPostContent(postContent);

        //dette er dårlig kode. vi har allerede gjort et databasekall. bør være unødvendig å gjøre et til. fiks dette senere
        postRepository.deleteById(postEntity.getId());
    }


}
