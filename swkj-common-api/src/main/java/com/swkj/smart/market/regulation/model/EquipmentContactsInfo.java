package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 特种设备业主（联系人）信息表
 * </p>
 *
 * @author 宋伟朋
 * @since 2019-10-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EquipmentContactsInfo对象", description="特种设备业主（联系人）信息表")
public class EquipmentContactsInfo extends BaseEntity {

    @ApiModelProperty(value = "联系人姓名")
    private String name;

    @ApiModelProperty(value = "性别；0：女，1：男")
    private Boolean gender;

    @ApiModelProperty(value = "职务")
    private String duty;

    @ApiModelProperty(value = "联系电话，用于接收提示短信")
    private String phone;

    @ApiModelProperty(value = "所属特种设备的统一编号")
    private String unitId;

    @ApiModelProperty(value = "特种设备内部统一编号")
    private String eId;

    @TableField(exist=false)
    private SpecialEquipmentInfo specialEquipmentInfo;

}
