package com.study.springboot.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liuhao
 * @Date 2023/4/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoVo {
    /**
     * 姓名
     */
    private String name;
    /**
     * 照片base64编码
     */
    private String base64;
    /**
     * 身份证号
     */
    private String idCardNum;

}
