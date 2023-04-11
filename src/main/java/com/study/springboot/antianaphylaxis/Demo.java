package com.study.springboot.antianaphylaxis;

import org.springframework.util.StringUtils;

/**
 * @Author liuhao
 * @Date 2023/3/21
 */
public class Demo {
    public static void main(String[] args) {

        String phone = "刘浩";

        System.out.println(DesensitizedUtils.chineseName(null));
        System.out.println(DesensitizedUtils.chineseName("dsji ddafdsd dd"));
        System.out.println(DesensitizedUtils.chineseName(phone));
        System.out.println(DesensitizedUtils.chineseName("ewqyuiewyquiryui"));
        System.out.println(DesensitizedUtils.chineseName(phone+"号   "));
        System.out.println(DesensitizedUtils.chineseName(phone+"哈酒"));
        System.out.println(DesensitizedUtils.chineseName(phone+"哈酒哈哈李"));

        String adress = "如果对方不不重要或时";
        System.out.println(DesensitizedUtils.address(adress));
        System.out.println(DesensitizedUtils.address(null));
        System.out.println(DesensitizedUtils.address(""));
        System.out.println(DesensitizedUtils.address("诊刮是阿斯蒂"));
        System.out.println(DesensitizedUtils.address("诊刮是阿打撒辐射带动范德萨斯蒂收拾收"));
        System.out.println(DesensitizedUtils.address("诊刮1"));

        String eamil = "111@qq.com";
        System.out.println(DesensitizedUtils.email(eamil));
        System.out.println(DesensitizedUtils.email(null));
        System.out.println(DesensitizedUtils.email(""));
        System.out.println(DesensitizedUtils.email("213213121@qq.com"));
        System.out.println(DesensitizedUtils.email("2131@qq.com"));
        System.out.println(DesensitizedUtils.email("21321@qq.com"));
        System.out.println(DesensitizedUtils.email("213211@qq.com"));
        System.out.println(DesensitizedUtils.email(eamil));
        System.out.println(DesensitizedUtils.email("11111"));
        System.out.println(DesensitizedUtils.email("@11111"));

        String num = "1511111";
        System.out.println(DesensitizedUtils.mobilePhone(num));
        System.out.println(DesensitizedUtils.mobilePhone(null));
        System.out.println(DesensitizedUtils.mobilePhone(""));


    }

}
