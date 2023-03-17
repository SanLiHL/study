package com.study.springboot.mybatis.jojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author liuhao
 * @Date 2023/3/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lsuser implements Serializable {
    // @Field
    /**
     * 用户编码
     */
    private String UserCode;
    /**
     * 用户姓名
     */
    private String UserName;
    /**
     * 分公司机构编码
     */
    private String ComCode;
    /**
     * 用户描述
     */
    private String UserDescription;
    /**
     * 用户状态
     * 01-待审批
     * 02-在职
     * 03-待实名认证
     * 04-待申请执业证
     * 05-审批不通过
     * 06-离职
     */
    private String UserState;
    /**
     * 用户类别
     */
    private String UserType;
    /**
     * 性别
     */
    private String Sex;
    /**
     * 联系电话
     */
    private String Phone;


    private Lsuserext lsuserext;

}
