package com.study.springboot.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 人证核身(图片) 响应详情实体
 * @Author liuhao
 * @Date 2023/4/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentityCheckResponseDetail {
    /**
     * 业务返回码
     */
    private String responseCode;
    /**
     * 业务返回信息
     */
    private String responseMessage;
    /**
     * 消费方唯一流水号
     */
    private String transactionUUID;
    /**
     * 相似度得分
     */
    private String score;
    /**
     * 认证结果描述
     */
    private String desc;

}
