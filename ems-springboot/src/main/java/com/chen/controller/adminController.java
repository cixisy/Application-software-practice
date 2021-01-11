package com.chen.controller;

import com.chen.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("admin")
public class adminController {
    @Autowired
    private com.chen.mapper.adminMapper adminMapper;

    @GetMapping("/login")
    public int queryadminList(int account, String password){
        System.out.println("进入login方法");
        List<Admin> list = adminMapper.queryAdminList();
        for (Admin admin : list) {
            if (admin.getAdnum()==account && admin.getPwd().equals(password)){
                return admin.getAdnum();
            }
        }
        return 0;
    }
}
