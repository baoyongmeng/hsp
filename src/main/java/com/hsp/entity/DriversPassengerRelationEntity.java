package com.hsp.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import com.lk.api.annotation.*;
/**
 * 司机乘客关系表
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Data
@TableName("drivers_passenger_relation")
@LKAModel
public class DriversPassengerRelationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    @LKAProperty(value = "",description ="")
    private Integer id;
    @LKAProperty(value = "司机id",description ="司机id")
    private Integer driversId;
    @LKAProperty(value = "乘客id",description ="乘客id")
    private Integer passengerId;

}
