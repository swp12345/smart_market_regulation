package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 证照信息表
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CertificateInfo对象", description="证照信息表")
public class CertificateInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "证照编号")
    @TableField("certificate_no")
    private String certificateNo;

    @ApiModelProperty(value = "证照生效日期")
    @TableField("effective_date")
    private LocalDate effectiveDate;

    @ApiModelProperty(value = "证照失效日期")
    @TableField("lose_date")
    private LocalDate loseDate;

    @ApiModelProperty(value = "发证机构")
    @TableField("certifying_unit")
    private String certifyingUnit;

    @ApiModelProperty(value = "持证人姓名")
    @TableField("owner")
    private String owner;

    @ApiModelProperty(value = "证件类型")
    @TableField("certificate_type_id")
    private Integer certificateTypeId;

    @ApiModelProperty(value = "被监管单位的自增型编号")
    @TableField("unit_info_id")
    private Integer unitInfoId;



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

    @ApiModelProperty(value = "预留字段")
    @TableField("attribute_11")
    private String attribute11;


}
