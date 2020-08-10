package com.jnu.example.db.admin.entity;

import java.io.Serializable;
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

    private String id;

    private String name;

    @ApiModelProperty(value = "类型：0接口，1菜单")
    private Integer type;

    @ApiModelProperty(value = "接口url")
    private String code;


}
