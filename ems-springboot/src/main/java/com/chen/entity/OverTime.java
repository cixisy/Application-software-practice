package com.chen.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class OverTime {

    private int epnum;
    private int o_type;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date o_start;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date o_end;
    private int o_total;
    private String o_descrip;
    private int o_mark;
    private String o_confirm_person;
    private String o_comfirm_descrip;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date apply_time;

    private static SimpleDateFormat simpleDateFormat;

}
