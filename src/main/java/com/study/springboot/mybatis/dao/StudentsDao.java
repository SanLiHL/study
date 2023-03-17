package com.study.springboot.mybatis.dao;

import com.study.springboot.mybatis.jojo.Label;
import com.study.springboot.mybatis.jojo.Studentcard;
import com.study.springboot.mybatis.jojo.Students;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author liuhao
 * @Date 2023/3/13
 */
@Mapper
@Repository
public interface StudentsDao {

    @Select("select * from students")
    @Results(id="studentPage",value = {
            @Result(id = true,column = "id",property = "id",jdbcType = JdbcType.INTEGER),
            @Result(column = "name",property = "name",jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex",property = "sex",jdbcType = JdbcType.INTEGER),
            @Result(column = "cardId",property = "cardId",jdbcType = JdbcType.INTEGER)
    })
    List<Students> selectPageAll();

    @Select("select * from students")
    @Results(id="studentMap",value = {
            @Result(id = true,column = "id",property = "id",jdbcType = JdbcType.INTEGER),
            @Result(column = "name",property = "name",jdbcType = JdbcType.VARCHAR),
            @Result(column = "sex",property = "sex",jdbcType = JdbcType.INTEGER),
            @Result(column = "cardId",property = "cardId",jdbcType = JdbcType.INTEGER),
            @Result(column = "name",property = "nameElse",jdbcType = JdbcType.VARCHAR),
            @Result(property = "studentcard",column = "cardId", one = @One(select = "com.study.springboot.mybatis.dao.StudentsDao.selectByIdStudentCard", fetchType = FetchType.LAZY)),
            @Result(property = "labelList", column = "id",many = @Many(select = "selectLabel"))
    })
    List<Students> selectAll(RowBounds rowBounds);

    @Select("select * from students where id=#{id}")
    @ResultMap(value = "studentMap")
    Students selectById(Integer id);

    @Select("select * from studentcard where id=#{cardId}")
    @Results(id="studentCard",value = {
         @Result(id = true,column = "id",property = "id",jdbcType = JdbcType.INTEGER),
         @Result(column = "studentId",property = "studentId",jdbcType = JdbcType.INTEGER),
         @Result(column = "startDate",property = "startDate",jdbcType = JdbcType.DATE),
         @Result(column = "endDate",property = "endDate",jdbcType = JdbcType.DATE)
    })
    Studentcard selectByIdStudentCard(Integer cardId);

    @Insert("insert into students(name,sex,cardId) values (#{name},#{sex},#{cardId})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",keyColumn = "id",resultType= Integer.class,before=false)
    int insert(Students students);

    //@Update("update students set name=#{name},sex=#{sex} where id=#{id}")
    int update(Students students);

    @Insert("insert into Studentcard(studentId,startDate,endDate) values (#{studentId},#{startDate},#{endDate})")
    int insertStudentCard(Studentcard studentcard);

    @Delete("delete from studentcard where studentId = #{studentId}")
    int deleteStudentCard(Studentcard studentcard);

    List<Students> selectXml();

    @Select("select * from label where student_id=#{id}")
    @Results(id = "labelMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "label",property = "label",jdbcType = JdbcType.VARCHAR),
            @Result(column = "studdent_id",property = "studentId",jdbcType = JdbcType.INTEGER)
    })
    List<Label> selectLabel(Label label);

    int insertXml(Students students);

}


