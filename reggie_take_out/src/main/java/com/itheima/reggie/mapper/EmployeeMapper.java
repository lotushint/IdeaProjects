package com.itheima.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/11 12:20
 * @package com.itheima.reggie.mapper
 * @description
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
