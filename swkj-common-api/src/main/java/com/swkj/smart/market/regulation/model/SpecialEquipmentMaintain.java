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
 * 
 * </p>
 *
 * @author 宋伟朋
 * @since 2019-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SpecialEquipmentMaintain对象", description="")
public class SpecialEquipmentMaintain extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "特种设备统一备案编号")
    private String eId;

    @ApiModelProperty(value = "维修单位代码")
    private String unitId;

    @ApiModelProperty(value = "维修时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date maintainDate;

    @ApiModelProperty(value = "维修过期时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date maintenanceloseDate;

    @ApiModelProperty(value = "维修内容")
    private String maintainContent;

    @ApiModelProperty(value = "维修结果")
    private String maintainResult;

    @ApiModelProperty(value = "维保类型")
    private String maintenanceType;

    @ApiModelProperty(value = "检测报告")
    private String detectionImage;

    @ApiModelProperty(value = "维修人")
    private String maintenancePerson;
    @ApiModelProperty(value = "维修人联系电话")
    private String  maintenancePhone;

    @ApiModelProperty(value = "所属辖区")
    private String  memberArea;

}
