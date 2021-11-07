package cn.cqu.edu.demo;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private String back;

    @RequestMapping(value = "/back")
    public void getBack(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        back = request.getParameter("back");
        request.getRequestDispatcher("/login").forward(request, response);
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println(id);
        Optional<Token> token_Optional = tokenRepository.findById(id);

        if (!token_Optional.isPresent()) {
            request.getRequestDispatcher("/toPage/login").forward(request, response);
        } else {
            response.sendRedirect(back + "?msg=true");
            return null;
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Optional<User> user_Optional = userRepository.findById(username);
        if (!user_Optional.isPresent())
            return "register";
        User user = user_Optional.get();
        if (!user.getPassword().equals(password))
            return "wrongPassword";
        else {
            Token token = new Token();
            token.setId(session.getId());
            token.setName("token_" + session.getId());

            // 添加Cookie
            response.setContentType("text/html;charset=utf-8");
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60 * 30);
            response.addCookie(cookie);

            session.setAttribute("token", token);
            tokenRepository.insert(token);

            response.sendRedirect(back + "?msg=true");
            return null;
        }
    }

    // @RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
    // public void checkLogin(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // response.setContentType("text/html;charset=utf-8");

    // // HttpSession session1 = request.getSession();
    // // if (session.getId() == session1.getId()) {
    // // response.sendRedirect(back + "?msg=true");
    // // return;
    // // }
    // HttpSession session = request.getSession();
    // System.out.println(2);
    // String id = session.getId();
    // System.out.println(id);
    // Optional<Token> token_Optional = tokenRepository.findById(id);
    // System.out.println(token_Optional);
    // if (!token_Optional.isPresent()) {
    // request.getRequestDispatcher("/toPage/login").forward(request, response);
    // return;
    // } else {
    // response.sendRedirect(back + "?msg=true");
    // return;
    // }
    // }
    
}