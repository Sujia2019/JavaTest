package com.sj.demo.util;

import java.io.IOException;
import java.net.ServerSocket;

public class NetUtil {
    public static boolean isPortUsed(int port){
        boolean used ;
        try{
            ServerSocket server = new ServerSocket(port);
            used = false;
        } catch (IOException e) {
            used = true;
            e.printStackTrace();
        }
        return used;
    }
}
