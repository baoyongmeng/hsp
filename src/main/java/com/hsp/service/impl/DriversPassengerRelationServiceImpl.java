package com.hsp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hsp.dao.DriversPassengerRelationDao;
import com.hsp.entity.DriversPassengerRelationEntity;
import com.hsp.service.DriversPassengerRelationService;
import org.springframework.stereotype.Service;

/**
 * 司机乘客关系表
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Service("driversPassengerRelationService")
public class DriversPassengerRelationServiceImpl extends ServiceImpl<DriversPassengerRelationDao, DriversPassengerRelationEntity> implements DriversPassengerRelationService {



}