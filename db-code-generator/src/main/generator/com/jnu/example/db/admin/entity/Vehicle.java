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
@ApiModel(value="Vehicle对象", description="")
public class Vehicle implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    @ApiModelProperty(value = "车牌号")
    private String licenseNumber;

    @ApiModelProperty(value = "车型")
    private String type;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "所属部门")
    private String departmentId;

    @ApiModelProperty(value = "行驶里程")
    private Integer mileage;

    @ApiModelProperty(value = "状态：0正常，1维修中，2维修完成")
    private String status;

    @ApiModelProperty(value = "驾驶人编号")
    private String userId;

    @ApiModelProperty(value = "照片")
    private String photo;

    @ApiModelProperty(value = "发动机编号")
    private Integer engineId;


}
