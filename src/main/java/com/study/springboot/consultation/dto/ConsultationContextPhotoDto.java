package com.study.springboot.consultation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 咨询照片
 * @Author liuhao
 * @Date 2023/4/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultationContextPhotoDto {
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 图片编码base64格式
     */
    private String base64;
}
