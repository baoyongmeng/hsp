package com.hsp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hsp.dao.PassengerDao;
import com.hsp.entity.DriversEntity;
import com.hsp.entity.DriversPassengerRelationEntity;
import com.hsp.entity.PassengerEntity;
import com.hsp.entity.vo.PassengerVo;
import com.hsp.service.DriversPassengerRelationService;
import com.hsp.service.DriversService;
import com.hsp.service.PassengerService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 乘客
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Service("passengerService")
public class PassengerServiceImpl extends ServiceImpl<PassengerDao, PassengerEntity> implements PassengerService {

    @Resource
    DriversPassengerRelationService driversPassengerRelationService;
    @Resource
    DriversService driversService;
    @Override
    public boolean addDrivers(PassengerVo passengerVo) {
        int driversId = passengerVo.getDriversId();
        DriversEntity drivers = driversService.getById(driversId);
        if (!Objects.isNull(drivers)){
            //学具数
            Integer equipmentNumber = drivers.getEquipmentNumber();
            //人数
            Integer peopleNumber = drivers.getPeopleNumber();

            DriversPassengerRelationEntity  driversPassengerRelationEntity = new DriversPassengerRelationEntity();
            driversPassengerRelationEntity.setDriversId(driversId);
            //查出本车所有人
            List<DriversPassengerRelationEntity>  byDriversId = driversPassengerRelationService.list(new QueryWrapper<DriversPassengerRelationEntity>().eq("drivers_id", driversId));
            PassengerEntity passengerEntity = new PassengerEntity();
            BeanUtils.copyProperties(passengerVo,passengerEntity);
            if (CollectionUtils.isEmpty(byDriversId)){
                this.save(passengerEntity);
                driversPassengerRelationEntity.setPassengerId(passengerEntity.getId());
                driversPassengerRelationService.save(driversPassengerRelationEntity);
                drivers.setStatus(0);
                if (peopleNumber == 1){
                    drivers.setStatus(1);
                }
                driversService.updateById(drivers);
                driversService.updateDrivers(driversId);
                return true;
            }
            List<Integer> passengerIds = byDriversId.stream().map(DriversPassengerRelationEntity::getPassengerId).collect(Collectors.toList());
            Collection<PassengerEntity> passengerEntities = this.listByIds(passengerIds);
            // 所有已带装备上车的人数
            long count = passengerEntities.stream().filter(a -> a.getIsEquipment() == 0).count();
            //人数 装备数 同时小于设定值
            if (byDriversId.size() < peopleNumber && ((count < equipmentNumber)|| passengerVo.getIsEquipment() == 1)){
                this.save(passengerEntity);
                driversPassengerRelationEntity.setPassengerId(passengerEntity.getId());
                driversPassengerRelationService.save(driversPassengerRelationEntity);
                drivers.setStatus(0);
                if (peopleNumber == 1){
                    drivers.setStatus(1);
                }
                driversService.updateById(drivers);
                driversService.updateDrivers(driversId);
                return true;
            }

        }
        return false;
    }
}