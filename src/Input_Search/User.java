package Input_Search;

import java.sql.Date;

public class User {
    // 对象中声明的属性名尽量和数据库中的字段相同
    private int id;
    private String name;
    private String password;
    private String email;
    private Date birthday;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(int id, String name, String password, String email, Date birthday) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", birthday="
                + birthday + "]";
    }
}