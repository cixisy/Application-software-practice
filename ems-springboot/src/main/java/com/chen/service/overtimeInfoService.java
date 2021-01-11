package com.chen.service;

import com.chen.entity.OverTime;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface overtimeInfoService {
    void insertOvertimeInfo(Map<String,Object> map);
    List<OverTime> queryOvertimeStatus(int id);
    List<OverTime> queryOhistory(int id);
    List<OverTime> getOvertimeCheck(int id); //获取审批表

    void updateovertime(OverTime overTime);
}
