package BaseTest.reflaction;

/**
 * @author ：sujia
 * @date ：Created in 2020/12/23 11:05 上午
 * @description：
 * @modified By：
 * @version:
 */
public class ClassModel {
    private String name;
    private String age;
    private String phone;
    public String message;

    public ClassModel() {

    }

    public ClassModel(String name, String phone) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
