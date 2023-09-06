package com.hsp.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lk.api.annotation.LKAProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: DriversQueryVo
 * @Description:
 * @Author: 86177
 * @Date: 2023/9/6 10:28
 */
@Data
public class DriversQueryVo {
    @LKAProperty(value = "始发地",description ="始发地")
    private String origin;
    @LKAProperty(value = "目的地",description ="目的地")
    private String dest;
    @LKAProperty(value = "司机",description ="司机")
    private String driver;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @LKAProperty(value = "出发日期",description = "yyyy-MM-dd HH:mm:ss")
    private Date goDate;
}
