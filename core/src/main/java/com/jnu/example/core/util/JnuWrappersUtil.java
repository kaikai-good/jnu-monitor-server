package com.jnu.example.core.util;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jnu.example.core.constant.enums.AdvanceQueryConditionEnum;
import com.jnu.example.core.pojo.AdvanceQueryConditionRemoteDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zy
 * Description: 高阶查询工具类
 * Date: 2020/5/20
 */
public final class JnuWrappersUtil {
    /*
     * 禁止实例化
     */
    private JnuWrappersUtil() {
        throw new AssertionError();
    }

    /**
     * @author: zy
     * @description: 构建高阶查询条件构造器
     * @date: 2020/5/20 14:08
     * @param queryConditions: 高阶查询条件
     * @param entityClass: 实体类class
     * @return QueryWrapper:
     */
    public static <T> QueryWrapper<T> query(List<AdvanceQueryConditionRemoteDTO> queryConditions, Class<?> entityClass){
        //构建条件构造器
        QueryWrapper<T> wrappers = Wrappers.<T>query();
        if(queryConditions == null){
            queryConditions = new ArrayList<>();
        }

        //构建查询条件
        build(queryConditions, wrappers,entityClass);

        return wrappers;
    }


    /**
     * @author: zy
     * @description: 构建高阶查询条件构造器 支持lambda表达式
     * @date: 2020/5/20 14:08
     * @param queryConditions: 高阶查询条件
     * @param entityClass: 实体类class
     * @return LambdaQueryWrapper:
     */
    public static <T> LambdaQueryWrapper<T> lambdaQuery(List<AdvanceQueryConditionRemoteDTO> queryConditions, Class<?> entityClass){
        return JnuWrappersUtil.<T>query(queryConditions,entityClass).lambda();
    }

    /**
     * @author: zy
     * @description: 构建高阶更新条件构造器
     * @date: 2020/5/20 14:08
     * @param queryConditions: 高阶查询条件
     * @param entityClass: 实体类class
     * @return UpdateWrapper:
     */
    public static <T> UpdateWrapper<T> update(List<AdvanceQueryConditionRemoteDTO> queryConditions, Class<?> entityClass){
        //构建条件构造器
        UpdateWrapper<T> wrappers = Wrappers.<T>update();
        if(queryConditions == null){
            queryConditions = new ArrayList<>();
        }
        //构建查询条件
        build(queryConditions, wrappers,entityClass);

        return wrappers;
    }

    /**
     * @author: zy
     * @description: 构建高阶更新条件构造器  支持lambda表达式
     * @date: 2020/5/20 14:08
     * @param queryConditions: 高阶查询条件
     * @param entityClass: 实体类class
     * @return UpdateWrapper:
     */
    public static <T> LambdaUpdateWrapper<T> lambdaUpdate(List<AdvanceQueryConditionRemoteDTO> queryConditions, Class<?> entityClass){
        return JnuWrappersUtil.<T>update(queryConditions,entityClass).lambda();
    }

    /**
     * @author: zy
     * @description: 构建查询条件
     * @date: 2020/5/20 14:42
     * @param queryConditions: 查询条件
     * @param wrappers:
     * @param entityClass: 实体类class
     * @return void:
     */
    private static <T,C extends AbstractWrapper<T, String, C>> void build(List<AdvanceQueryConditionRemoteDTO> queryConditions,
                                                                          AbstractWrapper<T,String,C> wrappers, Class<?> entityClass) {
        //判断是否存在order by条件、如果不存在、自动追加
        boolean existOrderBy = false;

        //拼接高级查询条件
        for(AdvanceQueryConditionRemoteDTO queryCondition:queryConditions){
            //拼接sql
            if (queryCondition.getCondition() == AdvanceQueryConditionEnum.APPLY && StrUtil.isNotBlank(queryCondition.getValue())) {
                //防止sql注入 替换特殊字符
                wrappers.nested(i->i.apply(queryCondition.getValue().replace("--","")));
                continue;
            }
            //获取泛型的class 如果指定字段不存在
            if(StrUtil.isBlank(queryCondition.getField()) || ReflectUtil.getField(entityClass,queryCondition.getField()) == null){
                continue;
            }
            switch (queryCondition.getCondition()){
                case EQ:
                    wrappers.eq(queryCondition.getField(),queryCondition.getValue());
                    break;
                case NE:
                    wrappers.ne(queryCondition.getField(),queryCondition.getValue());
                    break;
                case IN:
                    wrappers.in(StringUtils.isNotBlank(queryCondition.getValue()), queryCondition.getField(), queryCondition.getValue().split(","));
                    break;
                case NOT_IN:
                    wrappers.notIn(StringUtils.isNotBlank(queryCondition.getValue()), queryCondition.getField(), queryCondition.getValue().split(","));
                    break;
                case GT:
                    wrappers.gt(queryCondition.getField(),queryCondition.getValue());
                    break;
                case GE:
                    wrappers.ge(queryCondition.getField(),queryCondition.getValue());
                    break;
                case LE:
                    wrappers.le(queryCondition.getField(),queryCondition.getValue());
                    break;
                case LIKE:
                    wrappers.like(queryCondition.getField(),queryCondition.getValue());
                    break;
                case NOT_LIKE:
                    wrappers.notLike(queryCondition.getField(),queryCondition.getValue());
                    break;
                case LIKE_LEFT:
                    wrappers.likeLeft(queryCondition.getField(),queryCondition.getValue());
                    break;
                case LIKE_RIGHT:
                    wrappers.likeRight(queryCondition.getField(),queryCondition.getValue());
                    break;
                case IS_NULL:
                    wrappers.isNull(queryCondition.getField());
                    break;
                case IS_NOT_NULL:
                    wrappers.isNotNull(queryCondition.getField());
                    break;
                case ORDER_BY_ASC:
                    wrappers.orderByAsc(queryCondition.getField());
                    existOrderBy = true;
                    break;
                case ORDER_BY_DESC:
                    wrappers.orderByDesc(queryCondition.getField());
                    existOrderBy = true;
                    break;
                default:
                    break;
            }
        }


        //默认根据数据表id  order by排序
        if(wrappers instanceof QueryWrapper && !existOrderBy) {
            if (ReflectUtil.getField(entityClass, "createTime") != null) {
                wrappers.orderByDesc("createTime");
            }else if(ReflectUtil.getField(entityClass, "id") != null) {
                wrappers.orderByDesc("id");
            }
        }
    }
}
