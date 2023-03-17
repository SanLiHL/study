package com.study.springboot.mybatis.jojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Studentcard {
    private Integer id;
    private Integer studentId;
    private Date startDate;
    private Date endDate;
}
