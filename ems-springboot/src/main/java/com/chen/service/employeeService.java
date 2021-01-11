package com.chen.service;

import com.chen.entity.Employee;

import java.util.List;

public interface employeeService {

    List<Employee> queryEmployeeList();
    void insertEmployee(Employee employee);
    String queryNameById(int id);
    void updateEmployeeInfo(int id, int nId, String nName, int ndNum, String nPwd, int nsNum, int nMark);
}
