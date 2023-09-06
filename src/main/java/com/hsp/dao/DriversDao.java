package com.hsp.dao;

import com.hsp.entity.DriversEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 司机
 * 
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Mapper
public interface DriversDao extends BaseMapper<DriversEntity> {

    /**
    * 查询包含逻辑删除的数据集合
    *
    * @param driversEntity 司机对象
    * @return 包含逻辑删除的数据集合
    */
    List<DriversEntity> listIncludeDel(DriversEntity driversEntity);

}
