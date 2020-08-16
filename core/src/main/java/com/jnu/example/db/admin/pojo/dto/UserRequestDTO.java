package com.jnu.example.db.admin.pojo.dto;

import com.jnu.example.db.admin.constant.enums.GenderEnum;
import com.jnu.example.db.admin.constant.enums.GeneralStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *  @Author: zy
 *  @Date: 2020/4/14 22:45
 *  @Description: 新增或者修改用户通用字段
 */
@Data
public class UserRequestDTO {
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别")
    private GenderEnum gender;

    @ApiModelProperty(value = "部门编号")
    private String departmentId;

    @ApiModelProperty(value = "状态")
    private GeneralStatusEnum status;

    @ApiModelProperty(value = "照片")
    private String photo;

    @ApiModelProperty(value = "手机号")
    private String telephone;

    @ApiModelProperty(value = "出生日期")
    private LocalDateTime birthday;

    @ApiModelProperty(value = "地址")
    private String address;
}
