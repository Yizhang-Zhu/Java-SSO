package cn.cqu.edu.demo;

import java.util.HashMap;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import cn.cqu.edu.demo.Token.*;

@Controller
public class SSO {

    // private HashMap<String,String> map=new HashMap<String,String>();
    
    static public void giveToken(HttpServletRequest request, HttpSession session){
        Token token = new Token();
        token.setId(session.getId());
        token.setName("token_"+session.getId());
        session.setAttribute("token", token);
        TokenController.add(token);
    }

    static public String checkToken(HttpServletRequest request, HttpSession session){
        String id = session.getId();
        Optional<Token> token_Optional = TokenController.findById(id);
        if(token_Optional==null)return "login";
        else{
            Token token = token_Optional.get();
            if(id==token.getId())return "success";
            else return "login";
        }
    }
}