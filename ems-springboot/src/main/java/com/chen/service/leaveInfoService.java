package com.chen.service;

import com.chen.entity.Leave;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
@Service
public interface leaveInfoService {

    List<Leave> queryLeaveInfo(int id);
    void insertLeaveInfo(Map<String,Object> map);
    void deleteLeaveInfo(int id, Date date);
    List<Leave> queryLeaveCheckList(int id);
    void insertCheckInfo(String name, String desc, int type, int id, String date);
}
