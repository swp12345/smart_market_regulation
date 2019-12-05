package com.swkj.smart.market.regulation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 被监管单位信息表
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UnitInfo对象", description="被监管单位信息表")
public class UnitInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "统一社会信用代码")
    @TableField("unit_no")
    private String unitNo;

    @ApiModelProperty(value = "被监管单位名称")
    @TableField("unit_name")
    private String unitName;

    @ApiModelProperty(value = "被监管单位地址")
    @TableField("unit_address")
    private String unitAddress;

    @ApiModelProperty(value = "注册资本")
    @TableField("register_capital")
    private String registerCapital;

    @ApiModelProperty(value = "注册日期")
    @TableField("register_date")
    private LocalDate registerDate;

    @ApiModelProperty(value = "经营范围")
    @TableField("business_scope")
    private String businessScope;
    

    @ApiModelProperty(value = "图片保存路径")
    @TableField("unit_image")
    private String unitImage;

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
