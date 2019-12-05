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
 * 聚餐的基本信息表
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PartyInfo对象", description="聚餐的基本信息表")
public class PartyInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "聚餐简述，标题")
    @TableField("party_title")
    private String partyTitle;

    @ApiModelProperty(value = "具体的内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "聚餐的大致人数")
    @TableField("people_total")
    private Integer peopleTotal;

    @ApiModelProperty(value = "聚餐的地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "聚餐的时间")
    @TableField("party_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date partyDate;

    @ApiModelProperty(value = "联系电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "聚餐的承办厨师团队名称")
    @TableField("chef_group_name")
    private String chefGroupName;

    @ApiModelProperty(value = "备案时间")
    @TableField("register_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date registerDate;

    @ApiModelProperty(value = "录入的乡镇协管员编号")
    @TableField("register_helper_id")
    private String registerHelperId;



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
    private Date attribute09;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_10")
    private Date attribute10;

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_11")
    private String attribute11;


}
