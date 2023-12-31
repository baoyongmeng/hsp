package com.hsp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hsp.entity.PassengerEntity;
import com.hsp.entity.vo.PassengerVo;

/**
 * 乘客
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
public interface PassengerService extends IService<PassengerEntity> {



    boolean addDrivers(PassengerVo passengerVo);
}

