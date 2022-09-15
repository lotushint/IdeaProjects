package com.lotushint.crowd.service.impl;

import com.lotushint.crowd.entity.Menu;
import com.lotushint.crowd.entity.MenuExample;
import com.lotushint.crowd.mapper.MenuMapper;
import com.lotushint.crowd.service.api.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/15 14:36
 * @package com.lotushint.crowd.service.impl
 * @description
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() {
        return menuMapper.selectByExample(new MenuExample());
    }
}
