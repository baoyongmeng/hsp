package com.hsp.schedule;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hsp.entity.DriversEntity;
import com.hsp.service.DriversService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: DriversSchedule
 * @Description:
 * @Author: 86177
 * @Date: 2023/9/7 16:10
 */
@Component
public class DriversSchedule {

    @Resource
    DriversService driversService;

    @Scheduled(cron ="0 */1 * * * ?")
    public void run(){
        System.out.println("====================开始失效过期速拼=========================");
        UpdateWrapper<DriversEntity> uw = new UpdateWrapper<>();
        uw.lt("go_date",new Date());
        uw.eq("status",0);
        uw.set("status",2);
        driversService.update(uw);
    }
}
