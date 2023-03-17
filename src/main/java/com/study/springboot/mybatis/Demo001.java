package com.study.springboot.mybatis;

import com.study.springboot.mybatis.dao.LsuserDao;
import com.study.springboot.mybatis.jojo.Lsuser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Demo001 {
    private static final Logger LOG = LoggerFactory.getLogger(Demo001.class);
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = null;
        try{
            //获取sqlSessionFactory对象
            String source = "mybatis/mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(source);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession= sqlSessionFactory.openSession();
            LsuserDao lsuserDao = sqlSession.getMapper(LsuserDao.class);
            Lsuser lsuser = new Lsuser();
            lsuser.setUserCode("110000");
            List<Lsuser> lsusers = lsuserDao.select(lsuser);
            LOG.info("=======:{}",lsusers);

            List<Lsuser> lsusers2 = lsuserDao.selectBy(lsuser);
            LOG.info("=======:{}",lsusers2);


        }catch (Exception e){
            LOG.error("error ss{}",e);
        }finally {
            if (null != sqlSession){
                sqlSession.close();
            }
        }



    }
}


    /*Scanner scanner = new Scanner(System.in);
    int n=scanner.nextInt();
    int i=0;
    int overWord = 0;
        while(i<n&&n>0){
        Scanner scannerWords = new Scanner(System.in);
        int words = scannerWords.nextInt();
        if (words>60){
        overWord++;
        }
        i++;
        }
        System.out.println((0.1*(n-overWord))+(0.2*overWord));*/
