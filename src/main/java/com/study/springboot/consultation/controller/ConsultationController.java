package com.study.springboot.consultation.controller;

import com.alibaba.fastjson.JSON;
import com.study.springboot.consultation.dto.ConsultationDto;
import com.study.springboot.consultation.dto.R;
import com.study.springboot.consultation.service.ConsultationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 咨询订单提供给前端
 * @Author liuhao
 * @Date 2023/4/7
 */
@Controller
@RequestMapping("/consultation")
public class ConsultationController {
    private static final Logger LOG = LoggerFactory.getLogger(ConsultationController.class);
    @Autowired
    private ConsultationService consultationService;

    /**
     * 新增
     */
    @PostMapping("/save")
    public R saveConsultation(@RequestBody ConsultationDto consultationDto){
        LOG.info("saveConsultation input:{}", JSON.toJSONString(consultationDto));
        consultationService.saveConsultation(consultationDto);

        return new R();
    }
    /**
     * 修改
     */
    @PostMapping("/update")
    public R updateConsultation(@RequestBody ConsultationDto consultationDto){
        LOG.info("saveConsultation output:{}", JSON.toJSONString(consultationDto));
        consultationService.updateConsultation(consultationDto);

        return new R();
    }

}
