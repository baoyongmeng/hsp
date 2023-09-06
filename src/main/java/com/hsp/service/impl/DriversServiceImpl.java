package com.hsp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hsp.dao.DriversDao;
import com.hsp.entity.DriversEntity;
import com.hsp.entity.vo.DriversQueryVo;
import com.hsp.service.DriversService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 司机
 *
 * @author bym
 * @date 2023-09-06 09:39:44
 */
@Service("driversService")
public class DriversServiceImpl extends ServiceImpl<DriversDao, DriversEntity> implements DriversService {


    @Override
    public List<DriversEntity> getList(String origin, String dest, String driver, Date goDate) {
        QueryWrapper<DriversEntity> qw = new QueryWrapper<>();
        qw.eq("status", 0);

            if (!StringUtils.isEmpty(driver)) {
                qw.like("driver", driver);
            }
            if (!StringUtils.isEmpty(dest)) {
                qw.like("dest", dest);
            }
            if (!StringUtils.isEmpty(origin)) {
                qw.like("origin", origin);
            }
            if (!StringUtils.isEmpty(goDate)) {
                qw.like("go_date", goDate);
            }
        return this.list(qw);
    }
}