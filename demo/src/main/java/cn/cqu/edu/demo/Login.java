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
public class Login {
    @Autowired
    private UserRepository userRespository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Optional<User> user_Optional = userRespository.findById(username);
        if(!user_Optional.isPresent())return "register";
        User user = user_Optional.get();
        if(!user.getPassword().equals(password))return "wrongPassword";
        else{
            SSO.giveToken(request, session);
            return "success";
        }
    }

    @RequestMapping(value = "/clogin", method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request,HttpSession session) {
        return SSO.checkToken(request, session);
    }
}