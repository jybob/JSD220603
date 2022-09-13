package cn.tedu.boot03.mapper;

import cn.tedu.boot03.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{price},#{num})")
    void insert(Product product);

    @Select("select * from product")
    List<Product> select();

    @Delete("delete from product where id=#{id}")
    void delete(int id);

    @Update("update product set id=#{id},title=#{title},price=#{price},num=#{num} where id=#{id}")
    void update(Product product);
}
