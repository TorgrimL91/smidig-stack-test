package no.smidig.test.testrepo.service;


import no.smidig.test.testrepo.entity.User;
import no.smidig.test.testrepo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveOrUpdateUser(User user){

        user.setUserName(user.getUserName().toUpperCase());

        return userRepository.save(user);
    }
    

    public User findUserByIdentifier(String username){
        User user = userRepository.findByUserName(username);

        return user;
    }

    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void deleteUserByIdentifier(String username){
        User user = userRepository.findByUserName(username);

        //dette er dårlig kode. vi har allerede gjort et databasekall. bør være unødvendig å gjøre et til. fiks dette senere
        userRepository.deleteById(user.getId());
    }


}
