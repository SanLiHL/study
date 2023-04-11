package com.study.springboot.consultation.service;

import com.study.springboot.consultation.dto.ConsultationDto;
import com.study.springboot.consultation.dto.R;
import org.springframework.stereotype.Service;

/**
 * 咨询订单业务逻辑处理
 * @Author liuhao
 * @Date 2023/4/7
 */
@Service
public interface ConsultationService {

    R saveConsultation(ConsultationDto consultationDto);

    R updateConsultation(ConsultationDto consultationDto);

}
