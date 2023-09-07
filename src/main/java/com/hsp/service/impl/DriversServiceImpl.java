package com.hsp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hsp.dao.DriversDao;
import com.hsp.entity.DriversEntity;
import com.hsp.entity.DriversPassengerRelationEntity;
import com.hsp.entity.PassengerEntity;
import com.hsp.entity.vo.DriversQueryVo;
import com.hsp.service.DriversPassengerRelationService;
import com.hsp.service.DriversService;
import com.hsp.service.PassengerService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.time.chrono.IsoChronology;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 司机
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Service("driversService")
public class DriversServiceImpl extends ServiceImpl<DriversDao, DriversEntity> implements DriversService {
    @Resource
    DriversPassengerRelationService driversPassengerRelationService;
    @Resource
    PassengerService passengerService;

    @Override
    public List<DriversEntity> getList(String origin, String dest, String driver, Date goDate) {
        QueryWrapper<DriversEntity> qw = new QueryWrapper<>();
        qw.eq("status", 0);

            if (!StringUtils.isEmpty(driver)) {
                qw.like("driver", driver);
            }
            if (!StringUtils.isEmpty(dest)) {
                qw.like("dest", dest);
            }
            if (!StringUtils.isEmpty(origin)) {
                qw.like("origin", origin);
            }
            if (!StringUtils.isEmpty(goDate)) {
                qw.like("go_date", goDate);
            }
        return this.list(qw);
    }

    @Override
    public void updateDrivers(int id) {
        DriversEntity byId = this.getById(id);
        if (!Objects.isNull(byId)){
            List<DriversPassengerRelationEntity>  byDriversId = driversPassengerRelationService.list(new QueryWrapper<DriversPassengerRelationEntity>().eq("drivers_id", id));
            int peopleNumber = byDriversId.size();
            long equipmentNumber = 0;
            List<Integer> byPassengerId= byDriversId.stream().map(DriversPassengerRelationEntity::getPassengerId).collect(Collectors.toList());
            Collection<PassengerEntity> passengerEntities = passengerService.listByIds(byPassengerId);
            if (!CollectionUtils.isEmpty(passengerEntities)){
                equipmentNumber = passengerEntities.stream().filter(a -> a.getIsEquipment() == 0).count();
            }
            if (peopleNumber == byId.getPeopleNumber() && equipmentNumber == byId.getEquipmentNumber()){
                byId.setStatus(1);
                this.updateById(byId);
            }
        }
    }
}