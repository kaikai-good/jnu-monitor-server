package com.jnu.example.db.admin.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.jnu.example.db.admin.constant.ResourceType;
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
@ApiModel(value="Privilege对象", description="")
public class Privilege implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID",type = IdType.ASSIGN_ID)
    private String id;

    private String name;

    @ApiModelProperty(value = "类型：0接口，1菜单")
    private ResourceType type;

    @ApiModelProperty(value = "接口url")
    private String code;


}
