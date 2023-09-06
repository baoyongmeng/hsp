package com.hsp.controller;

import com.hsp.service.DriversPassengerRelationService;
import com.lk.api.annotation.LKAType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 司机乘客关系表
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@LKAType("司机乘客关系表")
@RestController
@SuppressWarnings("javadoc")
@RequestMapping("hsp/driverspassengerrelation")
public class DriversPassengerRelationController {
    @Resource
    @SuppressWarnings("all")
    private DriversPassengerRelationService driversPassengerRelationService;
}
