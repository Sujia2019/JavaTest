package com.sj.statics;

import java.util.NoSuchElementException;

public enum CODE {
    PUSH_ACTIVITY("推送活动", StaticConfigs.TOPIC_PUSH_ACTIVITY),
    PUSH_GM("系统消息", StaticConfigs.TOPIC_PUSH_GM),


    SYSTEM_OK("成功",StaticConfigs.SUCCESS),
    SYSTEM_ERROR("错误",StaticConfigs.ERROR)
    ;


    private String description;
    private String value;

    /**
     * description 构造函数
     * param [description, value]
     **/
    CODE(String description, String value) {
        this.description = description;
        this.value = value;
    }


    public static CODE getCodeValue(Integer value) {
        if (value == null) {
            return null;
        }
        return CODE.getCodeValue(value);
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }
}
