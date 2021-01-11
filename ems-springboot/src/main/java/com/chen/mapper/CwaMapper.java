package com.chen.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface CwaMapper {

    @Insert("insert into cwa_info(epnum,ename,work_date,work_start,work_end,work_descrip) " +
            "values (#{epnum},#{ename},#{work_date},#{work_start},#{work_end},#{work_descrip})")
    public void insertCwa( Map<String,Object> map);
    @Update("update cwa_info set work_start = #{work_start} where epnum = #{epnum} and work_date= #{work_date}")
    public void updateCwa( Map<String,Object> map);
    @Update("update cwa_info set work_end = #{work_end} where epnum = #{epnum} and work_date= #{work_date}")
    public void updateCwaEd( Map<String,Object> map);
}
