package com.jnu.example.db.admin.constant;

import com.jnu.example.core.constant.enums.IBaseEnum;

public enum ResourceType implements IBaseEnum {
    //接口
    INTERFACE(0,"接口"),

    //菜单
    MENU(1,"菜单");

    /**
     * 值
     */
    private int value;

    /**
     * 描述
     */
    private String desc;

    /**
     * @author: zy
     * @description: 构造函数
     * @date: 2020/3/1 20:26
     * @param value:
     * @param desc:
     * @return :
     */
    ResourceType(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * @author: zy
     * @description:  int转枚举类型
     * @date: 2020/2/19 14:32
     * @param value: 值
     * @return UserType:
     */
    public static ResourceType valueOf(int value) {
        switch (value) {
            case 0:
                return INTERFACE;
            case 1:
                return MENU;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * @author: zy
     * @description: 获取值
     * @date: 2020/3/2 10:15
     * @param :
     * @return int:
     */
    @Override
    public int getValue() {
        return this.value;
    }

    /**
     * @author: zy
     * @description: 获取描述信息
     * @date: 2020/3/2 10:15
     * @param :
     * @return int:
     */
    @Override
    public String getDesc() {
        return this.desc;
    }
}
