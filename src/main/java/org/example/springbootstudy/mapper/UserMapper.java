package org.example.springbootstudy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.springbootstudy.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
