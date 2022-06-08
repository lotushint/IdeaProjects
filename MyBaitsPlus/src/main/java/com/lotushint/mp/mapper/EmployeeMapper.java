package com.lotushint.mp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lotushint.mp.beans.Employee;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022 2022/4/23 16:25
 * @package com.lotushint.mp.mapper
 * @description Mapper接口
 * <p>
 * 基于Mybatis: 在Mapper接口中编写CRUD相关的方法，提供Mapper所对应的SQL映射文件以及方法对应的SQL语句
 * <p>
 * 基于MP: 让XxxMapper接口继承 BaseMapper 接口即可，
 * BaseMapper<T> : 泛型指定的就是当前Mapper接口所操作的实体类类型
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

}
