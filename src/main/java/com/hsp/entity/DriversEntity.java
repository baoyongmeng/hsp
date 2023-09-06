package com.hsp.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import com.lk.api.annotation.*;
/**
 * 司机
 *
 * @author bym
 * @date 2023-09-06 10:25:40
 */
@Data
@TableName("drivers")
@LKAModel
public class DriversEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    @LKAProperty(value = "",description ="")
    private Integer id;
    @LKAProperty(value = "司机",description ="司机")
    private String driver;
    @LKAProperty(value = "电话",description ="电话")
    private String phone;
    @LKAProperty(value = "wx号",description ="wx号")
    private String wxNumber;
    @LKAProperty(value = "始发地",description ="始发地")
    private String origin;
    @LKAProperty(value = "目的地",description ="目的地")
    private String dest;
    @LKAProperty(value = "装备数",description ="装备数")
    private Integer equipmentCount;
    @LKAProperty(value = "人数",description ="人数")
    private Integer pCount;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @LKAProperty(value = "出发日期",description = "yyyy-MM-dd HH:mm:ss")
    private Date goDate;
    @LKAProperty(value = "备注",description ="备注")
    private String remake;
    @LKAProperty(value = "0正在拼 1已拼成",description ="0正在拼 1已拼成")
    @TableLogic(value = "0", delval = "1")
    private Integer status;

}
