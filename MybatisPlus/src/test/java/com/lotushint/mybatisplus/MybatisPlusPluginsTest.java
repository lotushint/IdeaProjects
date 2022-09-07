package com.lotushint.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lotushint.mybatisplus.mapper.ProductMapper;
import com.lotushint.mybatisplus.mapper.UserMapper;
import com.lotushint.mybatisplus.pojo.Product;
import com.lotushint.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2022/9/7 16:02
 * @package com.lotushint.mybatisplus
 * @description
 */
@SpringBootTest
public class MybatisPlusPluginsTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    /**
     * 分页插件
     */
    @Test
    public void testPage() {
        //设置分页参数
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
//        System.out.println(page);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    /**
     * 自定义分页
     */
    @Test
    public void testSelectPageVo() {
        //设置分页参数
        Page<User> page = new Page<>(2, 5);
        userMapper.selectPageVo(page, 20);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("每页显示的条数：" + page.getSize());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("是否有上一页：" + page.hasPrevious());
        System.out.println("是否有下一页：" + page.hasNext());
    }

    /**
     * 测试乐观锁
     * 在 MybatisPlus/src/main/java/com/lotushint/mybatisplus/config/MybatisPlusConfig.java 中
     * 配置乐观锁插件
     */
    @Test
    public void testProduct01() {
        //1.小李获取商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为：" + productLi.getPrice());

        //2.小王获取商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小王获取的商品价格为：" + productWang.getPrice());

        //3.小李修改商品价格 +50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        //4.小王修改商品价格 -30
        productWang.setPrice(productWang.getPrice() - 30);
        productMapper.updateById(productWang);

        //5.老板查询商品价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板获取的商品价格为：" + productBoss.getPrice());
    }

    /**
     * 乐观锁解决问题
     */
    @Test
    public void testProduct01Update() {
        //1.小李获取商品价格
        Product productLi = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为：" + productLi.getPrice());

        //2.小王获取商品价格
        Product productWang = productMapper.selectById(1);
        System.out.println("小李获取的商品价格为：" + productWang.getPrice());

        //3.小李修改商品价格 +50
        productLi.setPrice(productLi.getPrice() + 50);
        productMapper.updateById(productLi);

        //4.小王修改商品价格 -30
        productWang.setPrice(productWang.getPrice() - 30);
        int result = productMapper.updateById(productWang);
        if (result == 0) {
            //操作失败，重试
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productNew.getPrice() - 30);
            productMapper.updateById(productNew);
        }

        //5.老板查询商品价格
        Product productBoss = productMapper.selectById(1);
        System.out.println("老板获取的商品价格为：" + productBoss.getPrice());
    }
}
