package com.chen.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
@Data
public class Cwa {


    private int epnum;
    private String ename;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date work_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date work_start;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date work_end;
    private String work_descrip;
    private static SimpleDateFormat simpleDateFormat;

}
