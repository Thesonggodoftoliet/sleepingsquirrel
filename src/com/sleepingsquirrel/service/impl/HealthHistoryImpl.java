package com.sleepingsquirrel.service.impl;

import com.sleepingsquirrel.dao.HealthDao;
import com.sleepingsquirrel.dao.impl.HealthDaoImpl;
import com.sleepingsquirrel.instance.Health;
import com.sleepingsquirrel.service.HealthHistory;

import java.util.List;

public class HealthHistoryImpl implements HealthHistory {
    @Override
    public List<Health> getHistory(Health health) {
        HealthDao HD = new HealthDaoImpl();
        return HD.getInfoByuserid(health.getUserid());
    }
}
