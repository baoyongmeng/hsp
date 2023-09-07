package com.hsp.service;

import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hsp.entity.DriversEntity;
import com.hsp.entity.vo.DriversQueryVo;

import java.util.Date;
import java.util.List;

/**
 * 司机
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
public interface DriversService extends IService<DriversEntity> {


    List<DriversEntity> getList(String origin,String dest,String driver,Date goDate);


    void updateDrivers(int id);
}

