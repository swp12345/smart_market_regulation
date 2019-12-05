package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "SysDept对象", description = "部门表")
public class SysDept extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "父部门id")
    @TableField("parent_id")
    private Long parentId;
    
    @ApiModelProperty(value = "部门编号")
    @TableField("dept_no")
    private String deptNo;
    
    @ApiModelProperty(value = "部门名称")
    @TableField("dept_name")
    private String deptName;
    
    @ApiModelProperty(value = "显示顺序")
    @TableField("order_num")
    private Integer orderNum;
    
    @ApiModelProperty(value = "负责人")
    @TableField("leader")
    private String leader;
    
    @ApiModelProperty(value = "联系电话")
    @TableField("phone")
    private String phone;
    
    @ApiModelProperty(value = "部门状态（0正常 1停用）")
    @TableField("status")
    private String status;
    
    //非数据库字段
    private Integer level;
    //非数据库字段
    private List<SysDept> children;
    //非数据库字段
    private String parentName;
    
}
