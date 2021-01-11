package com.chen.service;

import com.chen.entity.OverTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class overtimeInfoServiceImpl implements overtimeInfoService {
    @Autowired
    private com.chen.mapper.overtimeInfoMapper overtimeInfoMapper;
    @Override
    public void insertOvertimeInfo(Map<String,Object> map) {

    }

    @Override
    public List<OverTime> queryOvertimeStatus(int id) {
        List<OverTime> overTimes = overtimeInfoMapper.queryOvertimeStatus(id);
        return overTimes;
    }

    @Override
    public List<OverTime> queryOhistory(int id) {
        List<OverTime> overTimes = overtimeInfoMapper.queryOhistory(id);
        return overTimes;
    }

    @Override
    public List<OverTime> getOvertimeCheck(int id) {
        List<OverTime> overTimes = overtimeInfoMapper.getOvertimeCheck(id);
        return overTimes;
    }

    @Override
    public void updateovertime(OverTime overTime) {
        overtimeInfoMapper.updateovertime(overTime);
        return;
    }


}
