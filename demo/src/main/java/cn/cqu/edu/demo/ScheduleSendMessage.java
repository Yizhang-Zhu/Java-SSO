package cn.cqu.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.cqu.edu.demo.Token.*;
import java.util.*;

@Component
public class ScheduleSendMessage {
    @Autowired
    private TokenRepository tokenRepository;

    @Scheduled(cron = "*/30 * * * * ?")
    public void deleteToken() {
        List<Token> token_list = tokenRepository.findAll();
        System.out.println("token清理");
        // 判断当前时间是否大于数据库时间
        for (int i = 0; i < token_list.size(); i++) {
            if (token_list.get(i).getUpdateTime().getTime() < System.currentTimeMillis()) {
                tokenRepository.deleteById(token_list.get(i).getId());
            }
        }
    }

}
