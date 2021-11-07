package cn.cqu.edu.demo.Token;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Token {
    @Id
    private String id;
    private String name;
    private Date createTime = new Date();
    private Date UpdateTime = new Date(System.currentTimeMillis() + 100);

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

    public void setUpdateTime(Date updateTime) {
        this.UpdateTime = updateTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }
}