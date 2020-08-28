package com.jnu.example.db.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@ApiModel(value="HandOver对象", description="")
public class HandOver implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID",type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "交车记录编号")
    private String id;

    private String applicationId;

    @ApiModelProperty(value = "接车里程")
    private Integer takeOverMileage;

    @ApiModelProperty(value = "交车里程")
    private Integer handOverMileage;

    @ApiModelProperty(value = "接车人")
    private String takeOverPerson;

    @ApiModelProperty(value = "交车人")
    private String handOverPerson;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
