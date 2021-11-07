package cn.cqu.edu.sa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@Controller
@RequestMapping("/toPage")
public class PageController {
    @RequestMapping("/{page}")
    public String toPage(@PathVariable String page) {
        return page;
    }

}
