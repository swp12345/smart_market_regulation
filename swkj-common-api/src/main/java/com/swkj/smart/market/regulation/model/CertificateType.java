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
 * 
 * </p>
 *
 * @author hy
 * @since 2019-11-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CertificateType对象", description="")
public class CertificateType extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "证照类别名称")
    @TableField("type_name")
    private String typeName;
    


}
