package com.study.springboot.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 人证核身(图片) 响应实体
 * @Author liuhao
 * @Date 2023/4/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentityCheckResponse {
    /**
     * 状态码
     */
    private String code;
    /**
     * 响应信息
     */
    private String msg;

    /**
     * 数据对象-响应详情
     */
    private IdentityCheckResponseDetail data;


}
