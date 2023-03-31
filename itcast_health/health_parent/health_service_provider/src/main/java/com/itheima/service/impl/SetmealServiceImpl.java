package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.constant.RedisConstant;
import com.itheima.dao.SetmealDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.Setmeal;
import com.itheima.service.SetmealService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import redis.clients.jedis.JedisPool;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/3/26 13:59
 * @package com.itheima.service.impl
 * @description
 */
@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealDao setmealDao;

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Value("${out_put_path}")
    private String outputPath;//从属性文件中读取要生成的 html 对应的目录

    /**
     * 新增套餐，同时关联检查组
     *
     * @param setmeal
     * @param checkgroupIds
     */
    @Override
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        setmealDao.add(setmeal);

        if (checkgroupIds != null && checkgroupIds.length > 0) {
            //绑定套餐和检查组的多对多关系
            setSetmealAndCheckGroup(setmeal.getId(), checkgroupIds);
        }

        //完成数据库操作后需要将图片名称保存到 Redis
        savePic2Redis(setmeal.getImg());

        //新增套餐后需要重新生成静态页面
        generateMobileStaticHtml();
    }

    /**
     * 生成静态页面
     */
    public void generateMobileStaticHtml() {
        //准备模板文件中所需的数据
        List<Setmeal> setmealList = findAll();
        //生成套餐列表静态页面
        generateMobileSetmealListHtml(setmealList);
        //生成套餐详情静态页面（多个）
        generateMobileSetmealDetailHtml(setmealList);
    }

    /**
     * 生成套餐列表静态页面
     *
     * @param setmealList
     */
    public void generateMobileSetmealListHtml(List<Setmeal> setmealList) {
        HashMap<String, Object> dataMap = new HashMap<>();
        // 为模版提供数据，用于生成静态页面
        dataMap.put("setmealList", setmealList);
        generateHtml("mobile_setmeal.ftl", "m_setmeal.html", dataMap);
    }

    /**
     * 生成套餐详情静态页面（多个）
     *
     * @param setmealList
     */
    public void generateMobileSetmealDetailHtml(List<Setmeal> setmealList) {
        HashMap<String, Object> dataMap = new HashMap<>();
        for (Setmeal setmeal : setmealList) {
            // 注意：此处要调用 findById(setmeal.getId()) 方法，因为查出来的 setmealList 没查套餐对应的检查组信息、检查组对应的检查项信息
            dataMap.put("setmeal", findById(setmeal.getId()));
            generateHtml("mobile_setmeal_detail.ftl", "setmeal_detail_" + setmeal.getId() + ".html", dataMap);
        }
    }

    /**
     * 通用的方法，用于生成静态页面
     *
     * @param templateName 模版名
     * @param htmlPageName html页面名
     * @param dataMap      数据
     */
    public void generateHtml(String templateName, String htmlPageName, Map<String, Object> dataMap) {
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        Writer out = null;
        try {
            // 加载模版文件
            Template template = configuration.getTemplate(templateName);
            // 生成数据
            out = new FileWriter(outputPath + "/" + htmlPageName);
            // 输出文件
            template.process(dataMap, out);

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        Page<Setmeal> page = setmealDao.selectByCondition(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page.getResult());
    }

    @Override
    public List<Setmeal> findAll() {
        return setmealDao.findAll();
    }

    /**
     * 根据id查询套餐信息（套餐基本信息、套餐对应的检查组信息、检查组对应的检查项信息）
     *
     * @param id
     * @return
     */
    @Override
    public Setmeal findById(Integer id) {
        return setmealDao.findById(id);
    }

    /**
     * 将图片名称保存到 Redis
     *
     * @param pic
     */
    private void savePic2Redis(String pic) {
        // TODO 用户添加套餐后，将图片名称保存到 redis
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, pic);
    }

    /**
     * 绑定套餐和检查组的多对多关系
     *
     * @param id
     * @param checkgroupIds
     */
    private void setSetmealAndCheckGroup(Integer id, Integer[] checkgroupIds) {
        Map<String, Integer> map = new HashMap();
        map.put("setmeal_id", id);
        for (Integer checkgroup : checkgroupIds) {
            map.put("checkgroup_id", checkgroup);
            setmealDao.setSetmealAndCheckGroup(map);
        }
    }
}
