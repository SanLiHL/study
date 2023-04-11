package com.study.springboot.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 人证核身(图片) 请求实体
 * @Author liuhao
 * @Date 2023/4/11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdentityCheckRequest {
    /**
     * 交易渠道
     */
    private String transactionChannel;
    /**
     * 交易类型
     */
    private String transactionType;
    /**
     * 唯一标识流水号
     * 应用编码+服务编码+UUID(16字节128位长的数字)+年月日(Long)
     */
    private String transactionUUID;
    /**
     * 核心客户号
     */
    private String coreCustomerNo;
    /**
     * 客户姓名
     */
    private String realName;
    /**
     * Base64图片编码
     */
    private String imgData;
    /**
     * 客户身份证号
     */
    private String clientCardNo;
    /**
     * 人脸图像base64格式参数，优先读取，三选一
     */
    private String faceBase64;
    /**
     * 是否直接进行核身查验
     */
    private String  directInspection;
    /**
     * 是否跳过身份证质检
     */
    private String skipIdCheck;
    /**
     * 是否人脸特征检测
     */
    private String  faceDetect;
    /**
     * 是否活体检测/易道
     */
    private String liveDetect;
    /**
     * 活体检测失败后是否进行公安核验
     */
    private String psbCheck;
    /**
     * 是否需要切图
     */
    private String cropImage;
    /**
     * 是否开启hard模式
     */
    private String  hardMode;
    /**
     * 是否对图像进行合法性校验
     */
    private String  checkImage;
    /**
     * 是否只检测关键区域光斑和遮挡
     */
    private String  keyAreasOnly;
    /**
     * 要忽略的合法性校验的项的列表，可忽略的项包括：
     * 1：复印件，2：拍屏，3：假证件，4：有水印，5：遮挡，6：切边，7：卡变形，8：有光斑，9：未检测到身份证，10：模糊
     * ignoreList 切边检测的阈值，身份证质检时，身份证留边低于该阈值会被判定为切边告警
     */
    private String cropCheckTh;
    /**
     * 强制进行所有合法性校验
     */
    private String checkAllRisks;
    /**
     * 秘钥key
     */
    private String   appKey;
    /**
     * 秘钥value
     */
    private String  appSecret;
}
