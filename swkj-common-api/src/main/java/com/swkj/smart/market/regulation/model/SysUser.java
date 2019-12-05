package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.swkj.smart.market.regulation.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysUser对象", description="系统用户")
public class SysUser extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "工号")
    @TableField("user_no")
    @Excel(name = "工号")
    private String userNo;

    @ApiModelProperty(value = "姓名")
    @TableField("username")
    @Excel(name = "姓名")
    private String username;

    @ApiModelProperty(value = "年龄")
    @TableField("user_age")
    @Excel(name = "年龄")
    private Integer userAge;

    @ApiModelProperty(value = "性别：0:女 1：男")
    @TableField("gender")
    @Excel(name = "性别",readConverterExp="0=女,1=男")
    private Integer gender;

    @ApiModelProperty(value = "部门id")
    @TableField("dept_id")
    @Excel(name = "部门ID")
    private Long deptId;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    @Excel(name = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    @TableField("mobile")
    @Excel(name = "手机号")
    private String mobile;

    @ApiModelProperty(value = "用户头像路径")
    @TableField("avatar")
    @Excel(name = "用户头像路径")
    private String avatar;

    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    @TableField("status")
    @Excel(name = "状态",readConverterExp="0=禁用,1=正常")
    private Integer status;
    
    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_01")
    private String attribute01;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_02")
    private String attribute02;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_03")
    private String attribute03;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_04")
    private String attribute04;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_05")
    private String attribute05;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_06")
    private Integer attribute06;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_07")
    private Integer attribute07;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_08")
    private Integer attribute08;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_09")
    private LocalDateTime attribute09;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_10")
    private LocalDateTime attribute10;
    
    
}
