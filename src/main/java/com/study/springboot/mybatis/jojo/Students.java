package com.study.springboot.mybatis.jojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author liuhao
 * @Date 2023/3/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Students {
    private Integer id;
    private String name;
    private int sex;
    private Integer cardId;

    private String nameElse;

    private Studentcard studentcard;

    private List<Label> labelList;


}
