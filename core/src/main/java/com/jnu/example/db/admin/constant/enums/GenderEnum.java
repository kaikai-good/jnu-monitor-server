package com.jnu.example.db.admin.constant.enums;

import com.jnu.example.core.constant.enums.IBaseEnum;


/**
 *  @Author: zy
 *  @Date: 2020/8/16 13:05
 *  @Description: 性别
 */
public enum GenderEnum implements IBaseEnum {
    //男
    BOY(0,"男"),

    //女
    GIRL(1,"女");

    /*
     * 值
     */
    private Integer value;

    /*
     * 描述信息
     */
    private String desc;


    /**
     * @Author: zy
     * @Description:
     * @Date: 2020/8/16 13:09
     * @param value: 值
     * @param desc: 描述
     * @Return :
     */
    GenderEnum(Integer value, String desc){
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
