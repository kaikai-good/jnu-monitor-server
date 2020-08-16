package com.jnu.example.core.pojo;

import com.jnu.example.core.constant.enums.AdvanceQueryConditionEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: zy
 * Description: 分页查询 请求参数
 * Date: 2020/5/20
 */
@Data
public class PageRequestDTO {
    @Positive(message = "pageNum必须是正整数")
    @ApiModelProperty(value = "页码",example = "1")
    private Long pageNum = 1L;

    @Positive(message = "pageSize必须是正整数")
    @ApiModelProperty(value = "页大小",example = "10")
    private Long pageSize = 10L;

    @NotNull(message = "all不能为空")
    @ApiModelProperty(value = "查询全部",example = "true")
    private Boolean all = true;

    @ApiModelProperty("高级查询条件")
    private List<@Valid AdvanceQueryConditionRemoteDTO> conditions;

    public PageRequestDTO addCondition(String filed, AdvanceQueryConditionEnum op, String value) {
        return this.addCondition(new AdvanceQueryConditionRemoteDTO(filed, op, value));
    }

    public PageRequestDTO addCondition(AdvanceQueryConditionRemoteDTO condition) {
        initConditions();
        this.conditions.add(condition);
        return this;
    }

    public PageRequestDTO addSqlCondition(String where) {
        initConditions();
        this.conditions.add(new AdvanceQueryConditionRemoteDTO(null, AdvanceQueryConditionEnum.APPLY, where));
        return this;
    }

    public PageRequestDTO addOrderByAsc(String filed) {
        initConditions();
        this.conditions.add(new AdvanceQueryConditionRemoteDTO(filed, AdvanceQueryConditionEnum.ORDER_BY_ASC, null));
        return this;
    }

    public PageRequestDTO addOrderByDesc(String filed) {
        initConditions();
        this.conditions.add(new AdvanceQueryConditionRemoteDTO(filed, AdvanceQueryConditionEnum.ORDER_BY_DESC, null));
        return this;
    }

    private void initConditions() {
        if (this.conditions == null) {
            this.conditions = new ArrayList<>();
        }
    }
}
