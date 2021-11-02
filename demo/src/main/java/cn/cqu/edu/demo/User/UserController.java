package cn.cqu.edu.demo.User;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private static UserRepository userRepository;
    @RequestMapping(value="/user/add")
    static public User add(User user)
    {
        return userRepository.insert(user);
    }
    @RequestMapping(value="/user/findAll")
    static public List<User> findAll()
    {
        return userRepository.findAll();
    }
    @RequestMapping(value="/user/findById")
    static public Optional<User> findById(String userId)
    {
        return userRepository.findById(userId);
    }
    @RequestMapping(value="/user/update")
    static public User update(User user)
    {
        if(userRepository.existsById(user.getName()))
            return userRepository.save(user);
        else
            return null;
    }
    @RequestMapping(value="/user/delete")
    static public boolean delete(String userId)
    {
        userRepository.deleteById(userId);
        if(userRepository.existsById(userId))
            return false;
        else return true;
    }
}