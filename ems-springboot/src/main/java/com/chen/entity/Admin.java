package com.chen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

    private int adnum;
    private String ename;
    private String pwd;
    private int sex;
    private int dep_num;

    public int getAdnum() {
        return adnum;
    }

    public void setAdnum(int adnum) {
        this.adnum = adnum;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDep_num() {
        return dep_num;
    }

    public void setDep_num(int dep_num) {
        this.dep_num = dep_num;
    }
}
