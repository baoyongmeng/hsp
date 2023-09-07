package com.hsp.entity.vo;

import com.hsp.entity.PassengerEntity;
import com.lk.api.annotation.LKAProperty;
import lombok.Data;

/**
 * @ClassName: PassengerVo
 * @Description:
 * @Author: 86177
 * @Date: 2023/9/7 10:51
 */
@Data
public class PassengerVo extends PassengerEntity {
    @LKAProperty(value = "司机id",description ="司机id")
    private int driversId;
}
