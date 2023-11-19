package io.renren.modules.zx.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomerEnum {
    PERSONAL(1, "个人"),
    COPERATION(2, "公司");

    @EnumValue
    private Integer key;

    @JsonValue
    private String display;


    CustomerEnum(Integer key, String display) {
        this.key = key;
        this.display = display;
    }

    public Integer getKey() {
        return key;
    }

    public String getDisplay() {
        return display;
    }
}
