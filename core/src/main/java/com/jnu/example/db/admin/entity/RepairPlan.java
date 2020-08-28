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
@ApiModel(value="RepairPlan对象", description="")
public class RepairPlan implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID",type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "维修计划名称")
    private String name;

    @ApiModelProperty(value = "计划责任人")
    private String operator;

    @ApiModelProperty(value = "维修申请编号")
    private String applicationId;

    @ApiModelProperty(value = "计划完工时间")
    private LocalDateTime planCompleteTime;

    @ApiModelProperty(value = "计划是否已提交")
    private Integer isSubmitted;

    @ApiModelProperty(value = "审核状态：0未审核，1通过，2驳回")
    private Integer checkStatus;

    @ApiModelProperty(value = "处理状态：0未开工，1开工，2完工")
    private String processStatus;

    @ApiModelProperty(value = "计划小时")
    private Integer repairTime;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creatTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

}
