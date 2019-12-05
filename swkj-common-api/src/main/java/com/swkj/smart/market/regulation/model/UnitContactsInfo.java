package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 被监管单位联系人信息表
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UnitContactsInfo对象", description="被监管单位联系人信息表")
public class UnitContactsInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "被监管单位联系人姓名")
    @TableField("contact_name")
    private String contactName;

    @ApiModelProperty(value = "被监管单位联系人身份证号码")
    @TableField("card_id")
    private String cardId;

    @ApiModelProperty(value = "性别：0 女； 1 男")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty(value = "联系人职务")
    @TableField("duty")
    private String duty;

    @ApiModelProperty(value = "联系人移动电话号码")
    @TableField("m_phone")
    private String mPhone;
    

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
