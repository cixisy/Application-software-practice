package com.chen.mapper;

import com.chen.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface adminMapper {

    List<Admin> queryAdminList();
}
