package com.chen.mapper;

import com.chen.entity.OverTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface overtimeInfoMapper {
    List<OverTime> queryOvertimeStatus(int id);  //根据id查询请假信息状态
    void insertOvertimeInfo(Map<String,Object> map);   //插入一条请假信息

    List<OverTime> queryOhistory(int id);       //根据id查询此id历史
    List<OverTime> getOvertimeCheck(int id); //获取审批表

    @Select("select * from overtime_info where epnum=#{id} and apply_time=#{apply_time}")
    OverTime queryById(int id, Date apply_time);
    @Update("update overtime_info set o_mark = #{o_mark}, o_confirm_person =#{o_confirm_person}" +
            " ,o_comfirm_descrip=#{o_comfirm_descrip} " +
            "where epnum = #{epnum} and apply_time= #{apply_time}")
    void updateovertime(OverTime overTime);
}
