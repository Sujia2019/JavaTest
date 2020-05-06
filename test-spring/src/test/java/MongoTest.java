import com.sujia.mongo.GroupMsg;
import com.sujia.mongo.GroupService;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MongoTest {

    private static GroupService service = new GroupService();

    @Test
    public void createGroup(){
        GroupMsg groupMsg = new GroupMsg();
        groupMsg.setGroupId("777");
        groupMsg.setGroupName("test7");
        List<String> managers = new ArrayList<>();
        managers.add("6");
        groupMsg.setManagers(managers);
        List<String> members = new ArrayList<>();
        members.add("1");
        members.add("3");
        members.add("4");
        members.add("5");
        members.add("6");
        members.add("7");
        groupMsg.setMembersId(members);
        groupMsg.setStatus((short) 2);
        service.createGroup(groupMsg);
        Assert.assertEquals(service.searchGroup("777"),groupMsg);
    }

    /*
    多个成员添加
     */
    @Test
    public void insertMembers(){
        String[] members = new String[]{"12","13"};
        service.insertMembers("444",members);
    }


    /*
    单个成员添加
     */
    @Test
    public void insertMember(){
        String member = "666";
        String groupId = "444";
        service.insertMember(groupId,member);
    }

    /*
    添加管理员
     */
    @Test
    public void insertManager(){
        String manager = "5";
        String groupId = "444";
        service.insertManager(groupId,manager);
    }

    /*
    删除管理员
     */
    @Test
    public void delManager(){
        String manager = "5";
        String groupId = "444";
        service.delManager(groupId,manager);
    }

    /*
    查询一个组
     */
    @Test
    public void searchGroup(){
        String groupId = "444";
        GroupMsg groupMsg = service.searchGroup(groupId);
        System.out.println(groupMsg);
    }

}
