package com.chen.service;

import com.chen.entity.Admin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class adminServiceImpI implements adminService{
    private com.chen.mapper.adminMapper adminMapper;


    @Override
    public List<Admin> queryAdminList() {
        return adminMapper.queryAdminList();
    }
}
