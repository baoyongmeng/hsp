package com.hsp.controller;

import com.hsp.common.R;
import com.hsp.entity.DriversEntity;
import com.hsp.entity.vo.DriversQueryVo;
import com.hsp.service.DriversService;
import com.lk.api.annotation.*;
import com.lk.api.constant.ContentType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

/**
 * 司机
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@LKAType("司机")
@RestController
@SuppressWarnings("javadoc")
@RequestMapping("hsp/drivers")
public class DriversController{
    @Resource
    @SuppressWarnings("all")
    private DriversService driversService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @LKAMethod(value="分页查询司机数据",order = 1)
    @LKAParams({
            @LKAParam(name = "page",value = "当前页",testData = "1"),
            @LKAParam(name = "limit",value = "每页数据",testData = "25")
    })
    @LKAResposes({
            @LKARespose(names= {"code","msg"},values= {"状态码","消息"}),
            @LKARespose(name = "driversEntity",type=DriversEntity.class,
                    parentName="list",parentIsArray=true,grandpaName="page")
    })
    public R list(@RequestParam(value = "origin" ,required = false) String origin,
                  @RequestParam(value = "dest" ,required = false) String dest,
                  @RequestParam(value = "driver" ,required = false) String driver,
                  @RequestParam(value = "goDate" ,required = false) Date goDate){
        return R.ok().put("data", driversService.getList(origin,dest,driver,goDate));
    }


    /**
     * 保存
     */
    @PostMapping("/save")
    @LKAMethod(value="保存司机",order = 2,contentType = ContentType.JSON)
    @LKAParam(name = "drivers",type = DriversEntity.class)
    @LKARespose(names= {"code","msg"},values= {"状态码","消息"})
    public R save( @RequestBody DriversEntity drivers){
        driversService.save(drivers);
        return R.ok();
    }

}
