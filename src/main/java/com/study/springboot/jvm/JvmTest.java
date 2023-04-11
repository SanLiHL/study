package com.study.springboot.jvm;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuhao
 * @Date 2023/3/30
 */
public class JvmTest {
    public static void main(String[] args) {
        String passWord = "";
        String idCode = "111";
        String phone = "222222222222";
        try {
            if (!StringUtils.isEmpty(idCode) && idCode.length()>=6) {
                passWord = idCode.substring(idCode.length() - 6);
            }else{
                if (!StringUtils.isEmpty(phone) && phone.length()>=6) {
                    passWord = phone.substring(phone.length() - 6);
                }
            }
            if (StringUtils.isEmpty(passWord)){
                System.out.println("********"+passWord);
            }
        }catch (Exception e){
            System.out.println("$$$$$$$$$$$");
        }
        System.out.println("--"+passWord);
    }

    class ReceptionStaff{
        String idCode;
        String mobilePhone;
        String idType;

        public String getIdCode() {
            return idCode;
        }

        public void setIdCode(String idCode) {
            this.idCode = idCode;
        }

        public String getMobilePhone() {
            return mobilePhone;
        }

        public void setMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
        }

        public String getIdType() {
            return idType;
        }

        public void setIdType(String idType) {
            this.idType = idType;
        }
    }
}
