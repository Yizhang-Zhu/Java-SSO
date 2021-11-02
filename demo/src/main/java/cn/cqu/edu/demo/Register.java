package cn.cqu.edu.demo;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.cqu.edu.demo.User.UserRepository;
import cn.cqu.edu.demo.User.User;

@Controller
public class Register {
    @Autowired
    private UserRepository  userRepository;
    
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Optional<User> uOptional = userRepository.findById(username);
        if(uOptional.isPresent())return "wrongName";
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        userRepository.insert(user);
        return "login";
    }
}