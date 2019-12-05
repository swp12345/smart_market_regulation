package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.swkj.smart.market.regulation.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 系统访问记录
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysLogininfor对象", description="系统访问记录")
public class SysLogininfor extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "访问ID")
    @TableId(value = "info_id", type = IdType.AUTO)
    private Long infoId;

    @ApiModelProperty(value = "登录账号")
    @TableField("login_name")
    @Excel(name = "登录账号")
    private String loginName;

    @ApiModelProperty(value = "登录IP地址")
    @TableField("ipaddr")
    @Excel(name = "登录IP地址")
    private String ipaddr;

    @ApiModelProperty(value = "登录地点")
    @TableField("login_location")
    @Excel(name = "登录地点")
    private String loginLocation;

    @ApiModelProperty(value = "登录状态（0成功 1失败）")
    @TableField("status")
    @Excel(name = "登录状态",readConverterExp = "0=成功,1=失败")
    private String status;

    @ApiModelProperty(value = "提示消息")
    @TableField("msg")
    @Excel(name = "提示消息")
    private String msg;

    @ApiModelProperty(value = "访问时间")
    @TableField("login_time")
    @Excel(name = "访问时间")
    private Date loginTime;


}
