package com.hsp.controller;


import com.hsp.common.R;
import com.hsp.entity.PassengerEntity;
import com.hsp.entity.vo.PassengerVo;
import com.hsp.service.PassengerService;
import com.lk.api.annotation.*;
import com.lk.api.constant.ContentType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

/**
 * 乘客
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@LKAType("乘客")
@RestController
@SuppressWarnings("javadoc")
@RequestMapping("hsp/passenger")
public class PassengerController {
    @Resource
    @SuppressWarnings("all")
    private PassengerService passengerService;

    @RequestMapping("/addToDrivers")
    public R addToDrivers(@RequestBody PassengerVo passengerVo) {
        boolean b = passengerService.addDrivers(passengerVo);
        if (b)return R.ok();
        return R.error("添加失败");
    }

}
