package com.zeng.bjt.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * adjustsalary
 * @author 
 */
@Data
public class Politicsstatus implements Serializable {
    private Integer id;

    private Integer eid;

    /**
     * 调薪日期
     */
    private Date asdate;

    /**
     * 调前薪资
     */
    private Integer beforesalary;

    /**
     * 调后薪资
     */
    private Integer aftersalary;

    /**
     * 调薪原因
     */
    private String reason;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}