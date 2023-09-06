package com.hsp.dao;

import com.hsp.entity.DriversPassengerRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 司机乘客关系表
 * 
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Mapper
public interface DriversPassengerRelationDao extends BaseMapper<DriversPassengerRelationEntity> {

    /**
    * 查询包含逻辑删除的数据集合
    *
    * @param driversPassengerRelationEntity 司机乘客关系表对象
    * @return 包含逻辑删除的数据集合
    */
    List<DriversPassengerRelationEntity> listIncludeDel(DriversPassengerRelationEntity driversPassengerRelationEntity);

}
