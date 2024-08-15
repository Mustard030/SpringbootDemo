package org.example.springbootstudy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.springbootstudy.typehandler.AESTypeHandler;

/**
 * 使用MyBatis针对单独某个字段加密的Demo
 */
@Data
@AllArgsConstructor
@TableName(value = "ccc", autoResultMap = true) //必须加上autoResultMap = true
public class Customer {
    @TableId(type = IdType.AUTO)
    Integer customerId;
    int storeId;
    String firstName;
    String LastName;
    @TableField(typeHandler = AESTypeHandler.class) //并且指明typeHandler为AESTypeHandler.class
    String email;
    int addressId;
    boolean active;
}
