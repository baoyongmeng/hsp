package com.hsp.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import com.lk.api.annotation.*;
/**
 * 乘客
 *
 * @author bym
 * @date 2023-09-06 10:25:40
 */
@Data
@TableName("passenger")
@LKAModel
public class PassengerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    @LKAProperty(value = "",description ="")
    private Integer id;
    @LKAProperty(value = "姓名",description ="姓名")
    private String name;
    @LKAProperty(value = "电话",description ="电话")
    private String phone;
    @LKAProperty(value = "wx号",description ="wx号")
    private String wxNumber;
    @LKAProperty(value = "始发地",description ="始发地")
    private String origin;
    @LKAProperty(value = "目的地",description ="目的地")
    private String dest;
    @LKAProperty(value = "0正在拼 1已拼成",description ="0正在拼 1已拼成")
    // @TableLogic(value = "0", delval = "1")
    private Integer status;
    // 是否包含学具
    @LKAProperty(value = "0 包含 1不包含",description ="0 包含 1不包含")
    private Integer isEquipment;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @LKAProperty(value = "出发日期",description = "yyyy-MM-dd HH:mm:ss")
    private Date goDate;
    @LKAProperty(value = "备注",description ="备注")
    private String remark;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @LKAProperty(value = "",description = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

}
