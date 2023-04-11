package com.study.springboot.consultation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 咨询订单
 * @Author liuhao
 * @Date 2023/4/3
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationDto implements Cloneable{
    /**
     * 订单号
     */
    private String consultationOrderId;
    /**
     * 咨询时间 YYYY-MM-DD HH:MM:SS
     */
    private Date consultationDateTime;
    /**
     * 咨询订单类型(理赔,保全)
     */
    private String consultationOrderType;

    /**
     * 咨询订单状态(0-待回复 1-已完成 2-已取消)
     */
    private String consultationOrderState;
    /**
     * 客户ID
     */
    private String customerId;
    /**
     * 客户姓名
     */
    private String customerName;
    /**
     * 咨询内容(不超过200字)
     */
    private String consultationContext;
    /**
     * 处理人核心工号
     */
    private String coreSalerCode;
    /**
     * 处理人辅助工号
     */
    private String assistSalerCode;
    /**
     * 转接方式(0-人工 1-自动)
     */
    private String switchType;
    /**
     * 咨询内容照片id
     */
    private String consultationPhotoId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 照片信息
     */
    private List<ConsultationContextPhotoDto> consultationContextPhotoDtos;

}
