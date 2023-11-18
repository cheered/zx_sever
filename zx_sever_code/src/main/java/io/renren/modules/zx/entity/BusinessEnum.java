package io.renren.modules.zx.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BusinessEnum {
    FINANCIAL(1, "理财"),
    FUND(2, "基金"),
    ASSERT_MANAGE(3, "资管"),
    ENTRUST(4, "信托");

    @EnumValue
    private Integer key;

    @JsonValue
    private String display;


    BusinessEnum(Integer key, String display) {
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
