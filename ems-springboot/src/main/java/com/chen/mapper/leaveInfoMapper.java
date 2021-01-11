package com.chen.mapper;

import com.chen.entity.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface leaveInfoMapper {

    List<Leave> queryLeaveInfo(int id);  //根据id查询请假信息
    void insertLeaveInfo(Map<String,Object> map);   //插入一条请假信息
    void deleteLeaveInfo(int id, String date);     //根据id和申请时间删除一条信息
    List<Leave> queryLeaveCheckList(int id);       //根据id查询此id要审核的信息
    void insertCheckInfo(String name, String desc, int type, int id, String date);   //根据审批操作,更新审批人,审批描述和审批状态

}
