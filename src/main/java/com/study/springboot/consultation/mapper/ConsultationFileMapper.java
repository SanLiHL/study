package com.study.springboot.consultation.mapper;

import com.study.springboot.consultation.entity.ConsultationContextPhoto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author liuhao
 * @Date 2023/4/4
 */
@Mapper
public interface ConsultationFileMapper {

    Integer insertList(List<ConsultationContextPhoto> consultationContextPhotoDtos);

}
