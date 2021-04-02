package BaseTest;

import com.google.gson.Gson;

import java.util.List;
import java.util.TreeSet;

public class JsonTest {
    public static void main(String[] args) {
        String address = "[\"192.168.80.50:9999\",\"192.168.80.30:7777\"]";
        Gson gson = new Gson();
        TreeSet set = gson.fromJson(address, TreeSet.class);
        System.out.println(set.size());

        User user = new User();
        user.setAddress("xxx");
        user.setAge(10);
        user.setName("sujia");
        String json = gson.toJson(user);
        System.out.println(json);
    }
}
