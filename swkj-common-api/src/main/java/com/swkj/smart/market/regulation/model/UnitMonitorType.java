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
 * 重点餐饮单位分类名称表
 * </p>
 *
 * @author hy
 * @since 2019-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UnitMonitorType对象", description="重点餐饮单位分类名称表")
public class UnitMonitorType extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "行业类别代码")
    @TableField("type_id")
    private String typeId;

    @ApiModelProperty(value = "行业类别名称")
    @TableField("type_name")
    private String typeName;
    


}
