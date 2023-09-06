package com.hsp.controller;


import com.hsp.entity.PassengerEntity;
import com.hsp.service.PassengerService;
import com.lk.api.annotation.*;
import com.lk.api.constant.ContentType;
import org.springframework.web.bind.annotation.*;

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

}
