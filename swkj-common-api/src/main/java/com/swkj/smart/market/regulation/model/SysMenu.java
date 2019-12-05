package com.swkj.smart.market.regulation.model;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysMenu对象", description="菜单管理")
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "父菜单ID，一级菜单为0")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty(value = "菜单名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "菜单URL")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)")
    @TableField("perms")
    private String perms;

    @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "菜单图标")
    @TableField("icon")
    private String icon;

    @ApiModelProperty(value = "排序")
    @TableField("order_num")
    private Integer orderNum;

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
    
    // 非数据库字段
    private String parentName;
    // 非数据库字段
    private Integer level;
    // 非数据库字段
    private List<SysMenu> children;
}
