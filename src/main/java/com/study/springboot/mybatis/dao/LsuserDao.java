package com.study.springboot.mybatis.dao;

import com.study.springboot.mybatis.jojo.Lsuser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author liuhao
 * @Date 2023/3/13
 */
@Mapper
@Repository
public interface LsuserDao {

    List<Lsuser> select(Lsuser lsuser);

    List<Lsuser> selectBy(Lsuser lsuser);

    @Insert("insert into lsuser(usercode,username) values(#{usercode},#{username})")
    void insert(Lsuser lsuser);




}
