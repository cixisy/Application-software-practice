package com.chen.entity;

public class Leave {
    private int epnum;
    private int l_type;
    private String l_start;
    private String l_end;
    private int l_total;
    private String l_descrip;
    private int l_mark;
    private String leave_confirm_person;
    private String leave_comfirm_descrip;
    private String apply_time;

    public int getEpnum() {
        return epnum;
    }

    public void setEpnum(int epnum) {
        this.epnum = epnum;
    }

    public int getL_type() {
        return l_type;
    }

    public void setL_type(int l_type) {
        this.l_type = l_type;
    }

    public String getL_start() {
        return l_start;
    }

    public void setL_start(String l_start) {
        this.l_start = l_start;
    }

    public String getL_end() {
        return l_end;
    }

    public void setL_end(String l_end) {
        this.l_end = l_end;
    }

    public int getL_total() {
        return l_total;
    }

    public void setL_total(int l_total) {
        this.l_total = l_total;
    }

    public String getL_descrip() {
        return l_descrip;
    }

    public void setL_descrip(String l_descrip) {
        this.l_descrip = l_descrip;
    }

    public int getL_mark() {
        return l_mark;
    }

    public void setL_mark(int l_mark) {
        this.l_mark = l_mark;
    }

    public String getLeave_confirm_person() {
        return leave_confirm_person;
    }

    public void setLeave_confirm_person(String leave_confirm_person) {
        this.leave_confirm_person = leave_confirm_person;
    }

    public String getLeave_comfirm_descrip() {
        return leave_comfirm_descrip;
    }

    public void setLeave_comfirm_descrip(String leave_comfirm_descrip) {
        this.leave_comfirm_descrip = leave_comfirm_descrip;
    }

    public String getApply_time() {
        return apply_time;
    }

    public void setApply_time(String apply_time) {
        this.apply_time = apply_time;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "epnum=" + epnum +
                ", l_type=" + l_type +
                ", l_start='" + l_start + '\'' +
                ", l_end='" + l_end + '\'' +
                ", l_total=" + l_total +
                ", l_descrip='" + l_descrip + '\'' +
                ", l_mark=" + l_mark +
                ", leave_confirm_person='" + leave_confirm_person + '\'' +
                ", leave_comfirm_descrip='" + leave_comfirm_descrip + '\'' +
                ", apply_time='" + apply_time + '\'' +
                '}';
    }
}
