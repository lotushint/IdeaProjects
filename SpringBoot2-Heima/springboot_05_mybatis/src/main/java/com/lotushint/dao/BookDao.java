package com.lotushint.dao;


import com.lotushint.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/20 17:28
 * @package com.lotushint.dao
 * @description
 */
@Mapper
public interface BookDao {
    @Select("select * from tbl_book where id=#{id}")
    public Book getById(Integer id);
}
