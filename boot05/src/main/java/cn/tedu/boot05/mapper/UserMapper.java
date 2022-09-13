package cn.tedu.boot05.mapper;

import cn.tedu.boot05.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface UserMapper {

    @Select("select password from user where username=#{username}")
    User selectByUsername(String username);
}
