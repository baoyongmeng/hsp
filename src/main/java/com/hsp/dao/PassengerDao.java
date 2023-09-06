package com.hsp.dao;

import com.hsp.entity.PassengerEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 乘客
 * 
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Mapper
public interface PassengerDao extends BaseMapper<PassengerEntity> {

    /**
    * 查询包含逻辑删除的数据集合
    *
    * @param passengerEntity 乘客对象
    * @return 包含逻辑删除的数据集合
    */
    List<PassengerEntity> listIncludeDel(PassengerEntity passengerEntity);

}
