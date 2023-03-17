package com.study.springboot.mybatis.jojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author liuhao
 * @Date 2023/3/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lsuserext
{
    /** 用户编码 */
    private String UserCode;
    /** 身份证号 */
    private String IDCard;
    /** 执业证领证日期 */
    private String LicenseDate;
}
