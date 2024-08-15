package org.example.springbootstudy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.springbootstudy.entity.Customer;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {

}
