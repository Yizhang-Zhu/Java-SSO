package cn.cqu.edu.demo;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.cqu.edu.demo.Token.*;
import cn.cqu.edu.demo.User.*;


@Controller
public class Login {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Optional<User> user_Optional = userRepository.findById(username);
        if(!user_Optional.isPresent())return "register";
        User user = user_Optional.get();
        if(!user.getPassword().equals(password))return "wrongPassword";
        else{
            Token token = new Token();
            token.setId(session.getId());
            token.setName("token_"+session.getId());
            session.setAttribute("token", token);
            tokenRepository.insert(token);
            return "success";
        }
    }

    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
    public String checkLogin(HttpServletRequest request,HttpSession session) {
        String id = session.getId();
        Optional<Token> token_Optional = tokenRepository.findById(id);
        if(token_Optional==null)return "login";
        else{
            Token token = token_Optional.get();
            if(id==token.getId())return "success";
            else return "login";
        }
    }
}