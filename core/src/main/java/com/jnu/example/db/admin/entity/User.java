package com.jnu.example.db.admin.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jnu.example.db.admin.constant.enums.GenderEnum;
import com.jnu.example.db.admin.constant.enums.GeneralStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zy
 * @since 2020-08-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID",type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "人员编号")
    private String id;

    @ApiModelProperty(value = "登录名称")
    private String loginName;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

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
