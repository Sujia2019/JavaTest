package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.sj.demo.param.Address;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GsonTest {

    //    private static String address = "localhost:8080";
    private static Gson gson = new Gson();
    private static Address address = new Address("localhost:8080");

    @Test
    public void toGson() {
        String res = gson.toJson(address);
        System.out.println(res);
    }

    @Test
    public void toGsonArray() {
        Address[] arrays = new Address[]{address, address, address};
        String res = gson.toJson(arrays);
        System.out.println(res);
    }

    @Test
    public void getAddresses() {
        Address[] arrays = new Address[]{address, address, address};
        String jsons = gson.toJson(arrays);

        List<Address> addresses = gson.fromJson(jsons, new TypeToken<ArrayList<Address>>() {
        }.getType());
        System.out.println(addresses);
    }

    @Test
    public void getAddress() {
        String jsons = gson.toJson(address);
        Address address1 = gson.fromJson(jsons, new TypeToken<Address>() {
        }.getType());
        System.out.println(address1);
    }

}
