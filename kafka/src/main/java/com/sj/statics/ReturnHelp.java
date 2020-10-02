package com.sj.statics;

import com.sj.model.Response;

public class ReturnHelp {
    private static volatile Response successResponse;
    private static volatile Response errorResponse;
    private static ReturnHelp returnHelp = new ReturnHelp();
    private ReturnHelp(){

    }

    public static Response success(){
        if(successResponse==null)
            synchronized (Response.class){
                if(successResponse==null){
                    successResponse = new Response();
                    successResponse.setCode(CODE.SYSTEM_OK.getValue());
                    successResponse.setData(CODE.SYSTEM_OK.getDescription());
                }
            }
        return successResponse;
    }
    public static Response error(){
        if(errorResponse==null)
            synchronized (Response.class){
                if(errorResponse==null){
                    errorResponse = new Response();
                    errorResponse.setCode(CODE.SYSTEM_ERROR.getValue());
                    errorResponse.setData(CODE.SYSTEM_ERROR.getDescription());
                }
            }
        return errorResponse;
    }
}
