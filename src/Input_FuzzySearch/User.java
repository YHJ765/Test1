package Input_FuzzySearch;

import java.sql.Date;
//
public class User {
    // 对象中声明的属性名尽量和数据库中的字段相同
    private String Department;
    private String Name;
    private String Address;
    private String Phone;
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    public User(int id, String name, String password, String email, Date birthday) {
        super();
        this.Department = Department;
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String Department) {
        this.Department = Department;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) { this.Name = Name; }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }
    @Override
    public String toString() {
        return "User [Department=" + Department + ", Name=" + Name + ", Address=" + Address + ", Phone=" + Phone + "]";
    }
}