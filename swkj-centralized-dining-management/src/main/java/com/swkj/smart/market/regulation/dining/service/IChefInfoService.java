package com.swkj.smart.market.regulation.dining.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.model.ChefInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 备案厨师信息表 服务类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
public interface IChefInfoService extends IService<ChefInfo> {
    /**
     * 新增厨师
     * @param chefInfo
     * @return
     */
    int insertChef(ChefInfo chefInfo);

    /**
     * 今日新增的厨师
     * @param pn
     * @return
     */
    IPage<ChefInfo> selectTodayChef(Long pn);

    /**
     * 厨师信息查询
     * @param datedto
     * @param pn
     * @return
     */
    IPage<ChefInfo> selectChef(DateDTO datedto, Long pn);

    /**
     * 厨师信息修改
     * @param chefInfo
     * @return
     */
    int updateChefById(ChefInfo chefInfo);

    /**
     * 厨师信息删除
     * @param id
     * @return
     */
    int deleteChefById(Long id);
}
