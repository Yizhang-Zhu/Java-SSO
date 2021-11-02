package cn.cqu.edu.demo.Token;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Token {
    @Id
    private String id;
    private String name;
    private Date createTime = new Date();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}