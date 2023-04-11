package com.study.springboot.consultation;

import com.study.springboot.consultation.entity.ConsultationContextPhoto;
import com.study.springboot.consultation.mapper.ConsultationFileMapper;
import com.study.springboot.consultation.util.UploadAndDownloadPhotoUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author liuhao
 * @Date 2023/4/4
 */
public class UploadPhotoMain {
    private static final Logger LOG = LoggerFactory.getLogger(UploadPhotoMain.class);

    private static String filePath="D:\\photo";

    public static void main(String[] args) throws IOException {

        String sqlSessionUrl = "mybatis/mybatis-config.xml";

        InputStream inputStream = Resources.getResourceAsStream(sqlSessionUrl);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        ConsultationFileMapper  consultationFileMapper = sqlSession.getMapper(ConsultationFileMapper.class);


        String base64="";

        //java 8中这样写也可以
        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\Users\\11929\\Desktop\\base64.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                base64 = line;
            }
        }


        String uuid = UUID.randomUUID().toString().replaceAll("-","");

        String id = UUID.randomUUID().toString();

        String fileName = "111.png";
        String prex = fileName.substring(fileName.lastIndexOf("."));

        String path = new StringBuilder().append(filePath)
                .append(File.separator)
                .append(uuid)
                .append(prex)
                .toString();

        ConsultationContextPhoto consultationContextPhotoDto = ConsultationContextPhoto.builder()
                .id(id)
                .consultationNo(id)
                .fileType("2")
                .fileName("111.png")
                .filePath(path)
                .createTime(new Date())
                .state("1")
                .build();

        UploadAndDownloadPhotoUtil.savePhoto(base64,consultationContextPhotoDto.getFilePath());

        List<ConsultationContextPhoto> consultationContextPhotoList = new ArrayList<>();
        consultationContextPhotoList.add(consultationContextPhotoDto);

        consultationFileMapper.insertList(consultationContextPhotoList);


        String base64Last = UploadAndDownloadPhotoUtil.base64ToPhoto(consultationContextPhotoDto.getFilePath());
        LOG.info("图片转换成base64编码:");
        LOG.info(base64Last);

        String s = UUID.randomUUID().toString().replaceAll("-","");
        path = new StringBuilder().append(filePath)
                .append(File.separator)
                .append(s)
                .append(prex)
                .toString();
        consultationContextPhotoDto.setFilePath(path);

        UploadAndDownloadPhotoUtil.savePhoto(base64Last,consultationContextPhotoDto.getFilePath());



        sqlSession.commit();
        sqlSession.close();



    }

    /**
     *
     */

}
