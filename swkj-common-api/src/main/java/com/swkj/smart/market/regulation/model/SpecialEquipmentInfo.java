package com.swkj.smart.market.regulation.model;

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
 * 特种设备备案信息表
 * </p>
 *
 * @author 杨路遥
 * @since 2019-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SpecialEquipmentInfo对象", description="特种设备备案信息表")
public class SpecialEquipmentInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "特种设备内部统一编号",hidden = true)
    private String eId;

    @ApiModelProperty(value = "特种设备的名称")
    private String eName;

    @ApiModelProperty(value = "安装地址")
    private String address;

    @ApiModelProperty(value = "生产日期,出厂日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date productDate;

    @ApiModelProperty(value = "特种设备业主名称")
    private String ownerName;

    @ApiModelProperty(value = "业主移动电话，可推送提示短信")
    private String ownerPhone;

    @ApiModelProperty(value = "备案日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date registerDate;

    @ApiModelProperty(value = "出厂日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date releaseDate;

    @ApiModelProperty(value = "设备状态：0：已损坏 1：维修中 2：正常")
    private Integer status;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "合格证")
    private String qualificationImag;


    @ApiModelProperty(value = "是否有效；0：无效，1：有效")
    private Integer  isEnabled;

    @ApiModelProperty(value = "设备型号")
    private String  EquipmentId;

}
