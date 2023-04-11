package com.study.springboot.consultation.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Base64;

/**
 * 上传下载图片
 * base64互相转换
 * @Author liuhao
 * @Date 2023/4/6
 */
@Slf4j
public class UploadAndDownloadPhotoUtil {

    /**
     * base64图片存到本地文件
     * @param base64
     * @param filePath
     * @return
     */
    public static boolean savePhoto(String base64,String filePath){

        if (StringUtils.isEmpty(base64) || StringUtils.isEmpty(filePath)) {
            return false;
        }
        File file = new File(filePath).getParentFile();
        if (!file.exists()) {
            log.info("============ parentFile is not exist, mkdirs=================");
            file.mkdirs();
        }
        try {
            Files.write(Paths.get(filePath), Base64.getMimeDecoder().decode(base64), StandardOpenOption.CREATE);
            log.info("========= 上传成功 =========== [filePath]={}", filePath);
            return true;
        } catch (IOException ioException) {
            log.error("base64 transform method Base64.getMimeDecoder error", ioException);
        }
        return false;

    }

    /**
     * 根据图片路径将图片转换成base64编码
     * @param imagePath
     * @return
     */
    public static String base64ToPhoto(String imagePath){

        if (StringUtils.isEmpty(imagePath)) {
            log.warn("==== file is not exist , imagePath={}", imagePath);
            return null;
        }
        File file = new File(imagePath);
        if (!file.exists()) {
            log.warn("==== file is not exist , imagePath={}", imagePath);
            return null;
        }
        String type = imagePath.substring(imagePath.lastIndexOf(".") + 1);

        String imageString = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();
            imageString = Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return imageString;

    }


}
