package DesignPattern.Proxy.dynamic;

import lombok.Data;

@Data
public class Request {
   private String requestId;
   //请求接口名
   private String className;
   //请求方法名
   private String methodName;
   //请求参数类型
   private Class<?> [] paramTypes;
   //请求参数
   private Object [] params;

   public String getRequestId() {
      return requestId;
   }

   public void setRequestId(String requestId) {
      this.requestId = requestId;
   }

   public String getClassName() {
      return className;
   }

   public void setClassName(String className) {
      this.className = className;
   }

   public String getMethodName() {
      return methodName;
   }

   public void setMethodName(String methodName) {
      this.methodName = methodName;
   }

   public Class<?>[] getParamTypes() {
      return paramTypes;
   }

   public void setParamTypes(Class<?>[] paramTypes) {
      this.paramTypes = paramTypes;
   }

   public Object[] getParams() {
      return params;
   }

   public void setParams(Object[] params) {
      this.params = params;
   }
}
