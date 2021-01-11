package com.chen.entity;

public class Employee {

    private int epnum;
    private String ename;
    private String pwd;
    private int sex;
    private int superior_epnum;
    private int dep_num;
    private int superior_mark;

    @Override
    public String toString() {
        return "Employee{" +
                "epnum=" + epnum +
                ", ename='" + ename + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", superior_epnum=" + superior_epnum +
                ", dep_num=" + dep_num +
                ", superior_mark=" + superior_mark +
                '}';
    }

    public int getEpnum() {
        return epnum;
    }

    public void setEpnum(int epnum) {
        this.epnum = epnum;
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

    public int getSuperior_epnum() {
        return superior_epnum;
    }

    public void setSuperior_epnum(int superior_epnum) {
        this.superior_epnum = superior_epnum;
    }

    public int getDep_num() {
        return dep_num;
    }

    public void setDep_num(int dep_num) {
        this.dep_num = dep_num;
    }

    public int getSuperior_mark() {
        return superior_mark;
    }

    public void setSuperior_mark(int superior_mark) {
        this.superior_mark = superior_mark;
    }
}
