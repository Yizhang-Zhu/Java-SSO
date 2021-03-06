package cn.cqu.edu.demo.User;
import java.util.Date;
import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String name;
    private String password;
    private Date createTime = new Date();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}