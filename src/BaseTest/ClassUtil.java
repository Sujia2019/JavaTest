package BaseTest;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassUtil {
    public static void main(String[] args) throws ClassNotFoundException {

        Method[] methods = Demo.class.getMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            String route = Demo.class.getName();
            Class<?>[] paramTypes = method.getParameterTypes();
            StringBuilder params = new StringBuilder();
            for (Class<?> type : paramTypes) {
                params.append(type.getSimpleName()).append("|");
            }
            Service service = new Service();
            service.setMethodName(methodName);
            service.setParams(params.toString());
            service.setRoute(route);
            System.out.println("===Demo中的方法：" + service);
        }

        String xxx = "String|String";

        String[] sub = xxx.split("\\|");
        System.out.println(sub.length);
        List<Class<?>> classes = new ArrayList<>();
        for (String x : sub) {
            classes.add(Class.forName("java.lang." + x));
        }

        for (Class<?> claz : classes) {
            System.out.println(claz.getName());
        }
    }
}

@Data
class Service {
    String methodName;
    String route;
    String params;
}
