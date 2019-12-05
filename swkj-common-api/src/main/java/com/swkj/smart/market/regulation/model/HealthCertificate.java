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
 * 
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="HealthCertificate对象", description="")
public class HealthCertificate extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "健康证编号")
    @TableField("health_id")
    private String healthId;

    @ApiModelProperty(value = "持有人身份证编号")
    @TableField("people_id")
    private String peopleId;

    @ApiModelProperty(value = "持有人姓名")
    @TableField("people_name")
    private String peopleName;

    @ApiModelProperty(value = "性别：0：女，1：男")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty(value = "联系电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "签发日期")
    @TableField("register_date")
    private LocalDate registerDate;

    @ApiModelProperty(value = "是否可用：0：不可用,1:可用")
    @TableField("is_available")
    private Integer isAvailable;

    @ApiModelProperty(value = "住址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "有效日期")
    @TableField("effective_date")
    private LocalDate effectiveDate;

    @ApiModelProperty(value = "照片")
    @TableField("photo")
    private String photo;

    @ApiModelProperty(value = "行业类型")
    @TableField("type")
    private String type;





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
