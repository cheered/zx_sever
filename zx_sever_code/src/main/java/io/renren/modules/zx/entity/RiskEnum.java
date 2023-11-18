package io.renren.modules.zx.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum RiskEnum {
    LOW(1, "低风险"),
    MIDANDLOW(2, "中低风险"),
    MID(3, "中风险"),
    MIDANDHIGH(4, "中高风险"),
    HIGH(5, "高风险");

    @EnumValue
    private Integer key;

    @JsonValue
    private String display;


    RiskEnum(Integer key, String display) {
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
