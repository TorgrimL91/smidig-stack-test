package no.smidig.test.testrepo.service;


import no.smidig.test.testrepo.entity.User;
import no.smidig.test.testrepo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveOrUpdateUser(User user){

        user.setUserName(user.getUserName().toUpperCase());

        return userRepository.save(user);
    }

    //deleteUserById(bruke den ferdige metoden fra crudrepository

    public User findUserByIdentifier(String username){
        User user = userRepository.findByUserName(username);

        return user;
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    /*


    public Iterable<Project> findAllProjects(){
        return  projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Cannot delete project with ID '" + projectId + "'. This project does not exist");
        }

        projectRepository.delete(project);
    }


     */

}
