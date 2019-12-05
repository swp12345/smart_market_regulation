package com.swkj.smart.market.regulation.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author huyang
 */
@Data
public  class BaseEntity {
    @TableId(value = "ID", type = IdType.AUTO)
    @ApiModelProperty(value = "ID")
    private Long id;
    
    @ApiModelProperty(value = "创建者ID")
    @TableField("create_by")
    private Long createBy;
    
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;
    
    @ApiModelProperty(value = "更新人")
    @TableField("last_update_by")
    private Long lastUpdateBy;
    
    @ApiModelProperty(value = "更新时间")
    @TableField("last_update_time")
    private Date lastUpdateTime;
}
