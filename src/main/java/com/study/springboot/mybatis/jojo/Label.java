package com.study.springboot.mybatis.jojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liuhao
 * @Date 2023/3/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Label {

    private Integer id;
    private String label;
    private int studentId;

}
