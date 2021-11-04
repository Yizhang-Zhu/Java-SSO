package cn.cqu.edu.demo.Token;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @Autowired 
    private TokenRepository tokenRepository;
    @RequestMapping(value = "/token/add")
    public Token add(Token token)
    {
        return tokenRepository.insert(token);
    }
    @RequestMapping(value = "/token/findById")
    public Optional<Token> findById(String id)
    {
        return tokenRepository.findById(id);
    }
    @RequestMapping(value = "/token/delete")
    public boolean delete(String id)
    {
        tokenRepository.deleteById(id);
        if(tokenRepository.existsById(id)) return false;
        else return true;
    }
}