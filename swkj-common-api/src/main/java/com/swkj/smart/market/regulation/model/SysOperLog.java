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

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysOperLog对象", description="操作日志记录")
public class SysOperLog extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "日志主键")
    @TableId(value = "oper_id", type = IdType.AUTO)
    private Long operId;

    @ApiModelProperty(value = "模块标题")
    @TableField("title")
    @Excel(name = "模块标题")
    private String title;

    @ApiModelProperty(value = "业务类型（0其它 1新增 2修改 3删除）")
    @TableField("business_type")
    @Excel(name = "业务类型",readConverterExp = "0=其它,1=新增,2=修改,3=删除")
    private Integer businessType;

    @ApiModelProperty(value = "方法名称")
    @TableField("method")
    @Excel(name = "方法名称")
    private String method;

    @ApiModelProperty(value = "请求方式")
    @TableField("request_method")
    @Excel(name = "请求方式")
    private String requestMethod;

    @ApiModelProperty(value = "操作类别（0其它 1后台用户 2手机端用户）")
    @TableField("operator_type")
    @Excel(name = "操作类别",readConverterExp = "0=其他,1=后台用户,2=手机端用户")
    private Integer operatorType;

    @ApiModelProperty(value = "操作人员")
    @TableField("oper_name")
    @Excel(name = "操作人员")
    private String operName;

    @ApiModelProperty(value = "部门名称")
    @TableField("dept_name")
    @Excel(name = "部门名称")
    private String deptName;

    @ApiModelProperty(value = "请求URL")
    @TableField("oper_url")
    @Excel(name = "请求URL")
    private String operUrl;

    @ApiModelProperty(value = "主机地址")
    @TableField("oper_ip")
    @Excel(name = "主机地址")
    private String operIp;

    @ApiModelProperty(value = "操作地点")
    @TableField("oper_location")
    @Excel(name = "操作地点")
    private String operLocation;

    @ApiModelProperty(value = "请求参数")
    @TableField("oper_param")
    @Excel(name = "请求参数")
    private String operParam;

    @ApiModelProperty(value = "返回参数")
    @TableField("json_result")
    @Excel(name = "返回参数")
    private String jsonResult;

    @ApiModelProperty(value = "操作状态（0正常 1异常）")
    @TableField("status")
    @Excel(name = "操作状态",readConverterExp = "0=正常,1=异常")
    private Integer status;

    @ApiModelProperty(value = "错误消息")
    @TableField("error_msg")
    @Excel(name = "错误消息")
    private String errorMsg;

    @ApiModelProperty(value = "操作时间")
    @TableField("oper_time")
    @Excel(name = "操作时间")
    private LocalDateTime operTime;


}
