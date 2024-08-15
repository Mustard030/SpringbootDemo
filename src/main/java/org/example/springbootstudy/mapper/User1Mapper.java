package org.example.springbootstudy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.springbootstudy.entity.User1;

@Mapper
public interface User1Mapper extends BaseMapper<User1> {

//    @Select("select * from user where id=#{id}")
//    User findUserById(int id);
}
