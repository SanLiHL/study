package com.study.springboot.consultation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 咨询内容照片
 * @Author liuhao
 * @Date 2023/4/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultationContextPhoto {
    /**
     * 主键 uuid
     */
    private String id;
    /**
     * 文件类型 1：语音 2：图片 3：视频
     */
    private String fileType;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件地址
     */
    private String filePath;
    /**
     * 咨询订单ID
     */
    private String consultationNo;
    /**
     * 创建时间 YYYY-MM-DD HH:mm:ss
     */
    private Date createTime;
    /**
     * 更新时间 YYYY-MM-DD HH:mm:ss
     */
    private Date modifyTime;
    /**
     * 状态
     */
    private String state;
}
