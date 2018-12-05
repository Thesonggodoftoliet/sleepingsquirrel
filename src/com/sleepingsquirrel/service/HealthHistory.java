package com.sleepingsquirrel.service;

import com.sleepingsquirrel.instance.Health;

import java.util.List;

public interface HealthHistory {

    List<Health> getHistory(Health health);
}
