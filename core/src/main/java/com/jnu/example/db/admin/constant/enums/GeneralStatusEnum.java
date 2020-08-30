package com.jnu.example.db.admin.constant.enums;

import com.jnu.example.core.constant.enums.IBaseEnum;


/**
 *  @Author: zy
 *  @Date: 2020/8/16 13:18
 *  @Description: 通用状态
 */
public enum GeneralStatusEnum implements IBaseEnum {
    //使能
    ENABLE(0,"激活"),

    //禁用
    DISABLE(1,"禁用");

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
    GeneralStatusEnum(Integer value, String desc){
        this.value = value;
        this.desc = desc;
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
