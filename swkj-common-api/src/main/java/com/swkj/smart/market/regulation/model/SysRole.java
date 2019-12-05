package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.swkj.smart.market.regulation.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysRole对象", description="角色")
public class SysRole extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "角色名称")
    @TableField("role_name")
    @Excel(name = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "备注")
    @TableField("remark")
    @Excel(name = "备注")
    private String remark;
    

}
