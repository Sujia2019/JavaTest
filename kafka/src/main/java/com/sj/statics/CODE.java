package com.sj.statics;

import java.util.NoSuchElementException;

public enum CODE {
    PUSH_ACTIVITY("推送", 10000);

    private String description;
    private final Integer value;

    /**
     * description 构造函数
     * param [description, value]
     **/
    CODE(String description, int value) {
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

    public Integer getValue() {
        return value;
    }
}
