package com.chen.controller;

import com.chen.entity.Employee;
import com.chen.entity.Leave;
import com.chen.entity.OverTime;
import com.chen.service.CwaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("employee")
public class employeeController {
    @Autowired
    private CwaService cwaService;
    @Autowired
    private com.chen.service.overtimeInfoService overtimeInfoService;
    @Autowired
    private com.chen.mapper.employeeMapper employeeMapper;
    @Autowired
    private com.chen.mapper.leaveInfoMapper leaveInfoMapper;
    @Autowired
    private com.chen.mapper.overtimeInfoMapper overtimeInfoMapper;
    @GetMapping("/queryostatus")
    public  List<OverTime> queryOstatus(int id){

        return overtimeInfoService.queryOvertimeStatus(id);

    }
    @GetMapping("/queryohistory")
    public  List<OverTime> queryohistory(int id){
        return overtimeInfoService.queryOhistory(id);
    }
    @GetMapping("/getOvertimeCheck")
    public  List<OverTime> getOvertimeCheck(int id){
        System.out.println("进入getOvertimeCheck");
        List<OverTime> overtimeCheck = overtimeInfoService.getOvertimeCheck(id);
        System.out.println("审批测试");
//        for (OverTime overTime : overtimeCheck) {
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//            System.out.println(simpleDateFormat.format(overTime.getO_start()));
//        }
        return overtimeCheck;
    }

    @GetMapping("/login")
    public int queryEmployeeList(int account, String password) {
        System.out.println("进入login方法");
        List<Employee> list = employeeMapper.queryEmployeeList();
        for (Employee employee : list) {
            if (employee.getEpnum() == account && employee.getPwd().equals(password)) {
                return employee.getEpnum();
            }
        }
        return 0;
    }


    @GetMapping("/zhuce")
    public int insertEmployee(int account, String name, String pwd, int sex, int spNum, int dNum) {
        System.out.println("进入zhuce方法");
        Employee employee = new Employee();
        employee.setEpnum(account);
        employee.setEname(name);
        employee.setPwd(pwd);
        employee.setSex(sex);
        employee.setSuperior_epnum(spNum);
        employee.setDep_num(dNum);
        employee.setSuperior_mark(0);
        try {
            employeeMapper.insertEmployee(employee);
            return employee.getEpnum();
        } catch (Exception e) {
            return 0;
        }
    }

    @GetMapping("/queryLeaveInfoById")
    public List<Leave> findOne(int id) {
        List<Leave> list = leaveInfoMapper.queryLeaveInfo(id);
        return list;
    }

    @GetMapping("/queryCurrentLeaveInfo")
    public List<Leave> findCurrentLeaveInfo(int id) throws ParseException {
        System.out.println("进入queryCurrentLeaveInfo");
        List<Leave> list = leaveInfoMapper.queryLeaveInfo(id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long currentTime = new Date().getTime();

        for (int i = 0; i < list.size(); i++) {
            if (df.parse(list.get(i).getL_start()).getTime() < currentTime) {
                list.remove(list.get(i));
                i--;
            }
        }
        return list;
    }
    @PostMapping("/overtimeApply")
    public  void overtimeApply(@RequestBody Map<String,Object> map){
        System.out.println(map);
        overtimeInfoMapper.insertOvertimeInfo(map);

        System.out.println("添加请假信息成功");

    }

    @PostMapping("/leaveApply")
    public void apply(@RequestBody Map<String, Object> map) throws ParseException {
        Date currenttime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = df.parse((String) map.get("starttime"));
        Date date2 = df.parse((String) map.get("lasttime"));
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));

        map.put("total", days);
        map.put("mark", 0);
        map.put("currenttime", currenttime);
        map.put("starttime", date1);
        map.put("lasttime", date2);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        leaveInfoMapper.insertLeaveInfo(map);
        System.out.println("添加请假信息成功");

    }

    @GetMapping("/deleteOneLeaveInfo")
    public void deleteOneLeaveInfo(int id, String date) throws ParseException {
        System.out.println("进入deleteOneLeaveInfo");
        leaveInfoMapper.deleteLeaveInfo(id, date);
    }

    @GetMapping("/queryLeaveCheckList")
    public List<Leave> queryLeaveCheckList(int id) throws ParseException {
        System.out.println("进入queryLeaveCheckList");
        List<Leave> list = leaveInfoMapper.queryLeaveCheckList(id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        long currentTime = new Date().getTime();

        for (int i = 0; i < list.size(); i++) {
            if (df.parse(list.get(i).getL_start()).getTime() < currentTime) {
                list.remove(list.get(i));
                i--;
            }
        }
        return list;
    }

    @GetMapping("/queryNameById")
    public String queryNameById(int id) {
        String name = employeeMapper.queryNameById(id);
        return name;
    }

    @GetMapping("/insertCheckInfo")
    public void insertCheckInfo(String name, String desc, int type, int id, String date) {
        System.out.println("进入insertCheckInfo");
        leaveInfoMapper.insertCheckInfo(name, desc, type, id, date);
    }

    @GetMapping("/queryAllEmployeeInfo")
    public List<Employee> queryAllEmployeeInfo(){
        System.out.println("进入queryAllEmployeeInfo");
        List<Employee> employees = employeeMapper.queryEmployeeList();
        return employees;
    }
    @GetMapping("/updateEmployeeInfo")
    public void updateEmployeeInfo(int id, int nId, String nName, int ndNum, String nPwd, int nsNum, int nMark){
        System.out.println("id="+id);
        System.out.println("nId="+nId);
        System.out.println("nName="+nName);
        System.out.println("ndNum="+ndNum);
        System.out.println("nPwd="+nPwd);
        System.out.println("nsNum="+nsNum);
        System.out.println("nMark="+nMark);

        employeeMapper.updateEmployeeInfo(id,nId,nName,ndNum,nPwd,nsNum,nMark);
    }
    @GetMapping("/updateEmployeeInfoself")
    public void updateEmployeeInfoSelf( int nId, String nName, int ndNum, String nPwd, int nsNum, int nMark){

        System.out.println("nId="+nId);
        System.out.println("nName="+nName);
        System.out.println("ndNum="+ndNum);
        System.out.println("nPwd="+nPwd);
        System.out.println("nsNum="+nsNum);
        System.out.println("nMark="+nMark);

        employeeMapper.updateEmployeeInfoSelf(nId,nName,ndNum,nPwd,nsNum,nMark);
    }

    @PostMapping("/getOvertimeCheck")
    public OverTime getOvertimeCheckDetails(OverTime request){
        return overtimeInfoMapper.queryById(request.getEpnum(),request.getApply_time());
    }


    @GetMapping("/queryEmployeeInfoById")
    public Employee queryEmployeeInfoById(int id){
        Employee employee = employeeMapper.queryEmployeeInfoById(id);
        return employee;
    }

    @PostMapping("/saveCwa")
    public void saveCwa(@RequestBody  Map<String,Object> map){

        System.out.println(map);
        System.out.println("打卡创建");
        cwaService.insertCwa(map);


        System.out.println("打卡成功");
        return ;
    }
    @PostMapping("/updateCwa")
    public void updateCwa(@RequestBody Map<String,Object> map){
        System.out.println(map);
        System.out.println("打卡更新");
        cwaService.updateCwa(map);
        System.out.println("更新完成");
        return;
    }
    @PostMapping("/updateCwaend")
    public void updateCwaEnd(@RequestBody Map<String,Object> map){
        System.out.println(map);
        System.out.println("打卡更新");
        cwaService.updateCwaEnd(map);
        System.out.println("更新完成");
        return;
    }
    @PostMapping("/updateOvertime")
    public void updateOvertime(@RequestBody OverTime overTime){
        System.out.println("进入审批更新");
        System.out.println(overTime);
        System.out.println("进入哈哈");
        overtimeInfoService.updateovertime(overTime);
        return;
    }
}
