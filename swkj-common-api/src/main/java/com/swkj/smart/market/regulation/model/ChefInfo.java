package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

/**
 * <p>
 * 备案厨师信息表
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ChefInfo对象", description="备案厨师信息表")
public class ChefInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "厨师的身份证编码")
    @TableField("chef_id")
    private String chefId;

    @ApiModelProperty(value = "姓名")
    @TableField("chef_name")
    private String chefName;

    @ApiModelProperty(value = "性别；0：女，1：男")
    @TableField("gender")
    private String gender;

    @ApiModelProperty(value = "联系电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "备案日期")
    @TableField("register_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date registerDate;

    @ApiModelProperty(value = "厨师团队自增编号")
    @TableField("chef_group_id")
    private Integer chefGroupId;



    @ApiModelProperty(value = "是否可用")
    @TableField("status")
    private Integer status;



    @ApiModelProperty(value = "健康证编号")
    @TableField("health_code")
    private String healthCode;

    @ApiModelProperty(value = "预留字段")
    @TableField("position")
    private String position;

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
    private Date attribute09;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_10")
    private Date attribute10;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_11")
    private String attribute11;


}
