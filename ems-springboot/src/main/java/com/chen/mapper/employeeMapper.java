package com.chen.mapper;

import com.chen.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface employeeMapper {

    List<Employee> queryEmployeeList();  //查询所有员工信息

    void insertEmployee(Employee employee);  //插入一条员工信息

    String queryNameById(int id);    //通过id查询姓名

    void updateEmployeeInfo(int id, int nId, String nName, int ndNum, String nPwd, int nsNum, int nMark);   //根据id修改员工信息

    @Select("select * from employee_info where epnum = #{id}")
    Employee queryEmployeeInfoById(int id);

    void updateEmployeeInfoSelf(int nId, String nName, int ndNum, String nPwd, int nsNum, int nMark);
}
