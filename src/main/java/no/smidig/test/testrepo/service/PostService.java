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

        postEntity.setId(postEntity.getId());

        return postRepository.save(postEntity);
    }


    public PostEntity findPostByIdentifier(Long id){
        PostEntity postEntity = postRepository.findByid(id);

        return postEntity;
    }

    public Iterable<PostEntity> findAllPost(){
        return postRepository.findAll();
    }

    public void deletePostByIdentifier(Long id){
        PostEntity postEntity = postRepository.findByid(id);

        //dette er dårlig kode. vi har allerede gjort et databasekall. bør være unødvendig å gjøre et til. fiks dette senere
        postRepository.deleteById(postEntity.getId());
    }


}
