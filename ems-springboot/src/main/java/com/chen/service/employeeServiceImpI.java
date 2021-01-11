package com.chen.service;

import com.chen.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class employeeServiceImpI  implements employeeService{

    private com.chen.mapper.employeeMapper employeeMapper;

    @Override
    public List<Employee> queryEmployeeList() {
        return employeeMapper.queryEmployeeList();
    }

    @Override
    public void insertEmployee(Employee employee) {

    }

    @Override
    public String queryNameById(int id) {
        return employeeMapper.queryNameById(id);
    }

    @Override
    public void updateEmployeeInfo(int id, int nId, String nName, int ndNum, String nPwd, int nsNum, int nMark) {

    }

}
