package ConnectionTest;

import java.sql.Connection;


public class Test {
    public static void main(String[] args) {
//        HikariCPUtil.getConnection();
//        DruidUtil.getConnection();

        long start = System.currentTimeMillis();

        int y = 0;
        int x = 0;
        for(;x<150;x++){
//            Connection connection = DruidUtil.getConnection();
            Connection connection = HikariCPUtil.getConnection();
            if(connection!=null){
                y++;
            }
        }

        long end = System.currentTimeMillis();
//        System.out.println("HikariCP创建100个连接的用时:"+(end-start));  // 973,899,886
//        System.out.println("其中无效的连接:"+(x-y));  //  0,0,0

        System.out.println("HikariCP创建150个连接的用时:"+(end-start));  // 1155,1079,1033
        System.out.println("其中无效的连接:"+(x-y));  //  0,0,0

//        System.out.println("Druid创建100个连接的用时:"+(end-start));  // 934,914,970
//        System.out.println("其中无效的连接:"+(x-y));  //  0,0,0

//        System.out.println("Druid创建150个连接的用时:"+(end-start));  // 1136,1188,1222
//        System.out.println("其中无效的连接:"+(x-y));  //  0,0,0




    }
}
