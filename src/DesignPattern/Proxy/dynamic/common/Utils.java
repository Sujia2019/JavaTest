package DesignPattern.Proxy.dynamic.common;

public class Utils {
    private static final String ADDRESS="address->";
    private static final String IMP = ",imp->";

    public static String setValue(String address,String imp){
        return ADDRESS+address+IMP+imp;
    }
    public static String setAddressKey(String address){
        return ADDRESS+address;
    }

    public static String getImp(String name){
        return name.split(IMP)[1];
    }

    public static String getAddress(String name){
        return name.split(IMP)[0];
    }
}
