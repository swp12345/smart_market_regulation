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
 * 厨师团队备案管理信息
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="ChefGroupInfo对象", description="厨师团队备案管理信息")
public class ChefGroupInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "厨师团队名称")
    @TableField("group_name")
    private String groupName;

    @ApiModelProperty(value = "团队管理者名称")
    @TableField("manager_name")
    private String managerName;

    @ApiModelProperty(value = "联系或服务电话")
    @TableField("server_phone")
    private String serverPhone;

    @ApiModelProperty(value = "备案日期")
    @TableField("register_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date registerTime;



    @ApiModelProperty(value = "管理者身份证号")
    @TableField("manager_id")
    private String managerId;

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
    private Date attribute09;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_10")
    private Date attribute10;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_11")
    private String attribute11;


}
