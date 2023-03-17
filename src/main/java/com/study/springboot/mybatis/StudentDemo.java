package com.study.springboot.mybatis;

import com.study.springboot.mybatis.dao.StudentsDao;
import com.study.springboot.mybatis.jojo.Students;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author liuhao
 * @Date 2023/3/13
 */
public class StudentDemo {
    private static final Logger log = LoggerFactory.getLogger(StudentDemo.class);

    public static void main(String[] args) throws IOException {

        SqlSession sqlSession = null;

        try{
            String source = "mybatis/mybatis-config.xml";

            InputStream inputStream = Resources.getResourceAsStream(source);

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();

            StudentsDao studentsDao = sqlSession.getMapper(StudentsDao.class);

            //获取主键
            /*Students students2 = Students.builder().name("liuhao").sex(0).cardId(11).build();
            studentsDao.insert(students2);
            log.info("插入成功,插入主键是{}",students2.getId());
            studentsDao.insertXml(students2);
            log.info("插入成功,插入主键是{}",students2.getId());*/



            /*List<Students> studentList = studentsDao.selectXml();

            List<Students> students = studentsDao.selectAll();

            log.info("====list==={}",students);

            Students students1 = studentsDao.selectById(1);

            log.info("====student==={}",studentList);
            log.info("====student==={}",students1);
            //学生证表
            *//*Studentcard studentcard = Studentcard.builder().studentId(6).endDate(new Date()).startDate(new Date()).build();
            int j = studentsDao.insertStudentCard(studentcard);*//*

            Students students2 = Students.builder().id(7).name("liuhao").sex(0).cardId(11).build();
            //int i = studentsDao.insert(students2);
            log.info("插入成功,插入主键是{}",i);


            students2.setName("lxy2");
            students2.setId(19);
            students2.setSex(1);
            studentsDao.update(students2);




            log.info("====list==={}");*/

            //分页查询
            //PageHelper.startPage(1,10);
            List<Students> pageList = studentsDao.selectAll(new RowBounds(0,5));
            //PageInfo<Students> pageInfo = new PageInfo<>(pageList);


            //log.info("===page1:{}",pageInfo);
            log.info("===page:{}",pageList);
            log.info("===pageSize:{}",pageList.size());

        }catch (Exception e){
            log.error("--",e);
        }finally {
            if (null!=sqlSession){
                sqlSession.commit();
                sqlSession.close();
            }
        }



    }


}
