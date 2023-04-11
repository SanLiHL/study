package com.study.springboot.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class test {
    private static final Logger LOG = LoggerFactory.getLogger(test.class);
    private static final String SUCCESS_CODE ="200";
    private static final String NO = "0";
    private static final String YES = "1";
    private static final Integer SCORE_DEFAULT = 92;

    public static void main(String[] args) throws IOException {

        HttpClientUtils.post("http://127.0.0.1:38015/sale/api/icon/homePage",new HashMap());
        RequestResult result = new RequestResult();

        CustomerInfoVo customerInfoVo = new CustomerInfoVo();
        //校验入参
        if (ObjectUtils.isEmpty(customerInfoVo)){
            result.setMessage("请求参数为空");
            result.setSuccess(false);
            //return result;
        }

        //开始校验
        //客户姓名
        String customerName = customerInfoVo.getName();
        //需要检测的照片
        String base64 = customerInfoVo.getBase64();
        //身份证号
        String idCardNum = customerInfoVo.getIdCardNum();

        StringBuilder errorStr = new StringBuilder();
        if (!StringUtils.hasText(customerName)){
            errorStr.append("身份校验姓名不能为空;");
        }
        if (!StringUtils.hasText(base64)){
            errorStr.append("身份照片不能为空;");
        }
        if (!StringUtils.hasText(idCardNum)){
            errorStr.append("身份校验身份证号吗不能为空;");
        }
        if (StringUtils.hasText(errorStr.toString())){
            result.setMessage(errorStr.toString());
            result.setSuccess(false);
            //return result;
        }

       IdentityCheckRequest identityCheckRequest = IdentityCheckRequest.builder()
               .realName(customerName)
               .imgData(base64)
               .clientCardNo(idCardNum)
               .faceBase64(base64)
               .directInspection(NO)
               .skipIdCheck(YES)
               .faceDetect(NO)
               .liveDetect(NO)
               .psbCheck(NO)
               .cropImage(NO)
               .hardMode(NO)
               .checkImage(NO)
               .keyAreasOnly(NO)
               .build();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
       String uuid = UUID.randomUUID().toString();
       String date = sdf.format(new Date());
       String transactionUUID = "服务编码"+uuid+date;

       String url = "https://网关域名/应用编码/服务编码/InternalPortsControllerV2/identityVerification";
       String paramStr = JSON.toJSONString(identityCheckRequest);
       String responseStr = HttpClientUtils.post(url,paramStr);
        LOG.info("responseStr=====>{}",responseStr);
        IdentityCheckResponse identityCheckResponse = JSONObject.parseObject(responseStr,IdentityCheckResponse.class);
        if (ObjectUtils.isEmpty(identityCheckResponse)){

        }
        if (SUCCESS_CODE.equals(identityCheckResponse.getCode())){
            //判断相似度
            IdentityCheckResponseDetail identityCheckResponseDetail = identityCheckResponse.getData();
            if (ObjectUtils.isEmpty(identityCheckResponseDetail)){

            }
            //判断相似度是否满足要求值 比如相似度需要大于92%
            String score = identityCheckResponseDetail.getScore();
            Integer scoreInt = Integer.parseInt(score);
            if (scoreInt.compareTo(SCORE_DEFAULT)>-1){
                result.setMessage("认证核验相似度过低,身份校验不通过");
                result.setSuccess(false);
            }else {
                result.setMessage(identityCheckResponseDetail.getResponseMessage());
                result.setSuccess(true);
            }
        }else {
            result.setMessage(identityCheckResponse.getData().getResponseMessage());
            result.setSuccess(false);
        }

        //return result;


    }


    /**
     * 测试POST请求（String入参）
     */
    private void testStringPost() {

        String url = "http://107.12.57.187:8080/sms/post1";
        String str = "{\"english\":\"json\"}";
        try {
            String result = HttpClientUtils.post(url, str);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试POST请求（Map入参）
     */
    private void testMapPost() {
        String url = "http://107.12.57.187:8080/sms/post1";
        HashMap<String, String> map = new HashMap<>();
        map.put("english", "json");
        try {
            String result = HttpClientUtils.post(url, map);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试GET请求
     */
    private void testGet() {
        String url = "http://107.12.57.187:8080/sms/get";
        try {
            String result = HttpClientUtils.get(url);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

