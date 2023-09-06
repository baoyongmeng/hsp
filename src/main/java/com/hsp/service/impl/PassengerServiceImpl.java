package com.hsp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hsp.dao.PassengerDao;
import com.hsp.entity.PassengerEntity;
import com.hsp.service.PassengerService;
import org.springframework.stereotype.Service;

/**
 * 乘客
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Service("passengerService")
public class PassengerServiceImpl extends ServiceImpl<PassengerDao, PassengerEntity> implements PassengerService {



}