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

}
