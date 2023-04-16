package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Category;
import com.itheima.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lotushint
 * @version 1.0
 * @date 2023/4/13 16:43
 * @package com.itheima.reggie.controller
 * @description
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 新增分类
     *
     * @param category
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody Category category) {
        log.info("category:{}", category);
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 分类分页查询
     *
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/page")
    public R<IPage> page(int page, int pageSize) {
        log.info("page = {}, pageSize = {}", page, pageSize);
        IPage<Category> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);
        categoryService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    @DeleteMapping("/{ids}")
    public R<String> delete(@PathVariable(name = "ids") Long id) {
        log.info("删除分类id:{}", id);

//        categoryService.removeById(id);
        categoryService.remove(id);
        return R.success("分类信息删除成功");
    }

    /**
     * 根据 id 修改分类信息
     *
     * @param category
     * @return
     */
    @PutMapping
    public R<String> update(@RequestBody Category category) {
        log.info("修改分类信息为:{}", category);

        categoryService.updateById(category);
        return R.success("修改分类信息成功");
    }

    /**
     * 根据条件来查询我们的分类数据
     * <p>
     * 前端传来的是 type，
     * 1. 此方法参数既可以用 String 类型接受，
     * 2. 也可以使用 Category 接收，会被封装到 Category 属性中，
     * 推荐使用后者，因为后者通用性更强：可能接收的不只是 type
     *
     * @param category
     * @return
     */
    @GetMapping("/list")
    public R<List<Category>> list(Category category) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        queryWrapper.eq(category.getType() != null, Category::getType, category.getType());
        //添加排序条件
        queryWrapper.orderByAsc(Category::getSort).orderByDesc(Category::getUpdateTime);
        //查询数据
        List<Category> list = categoryService.list(queryWrapper);
        //返回数据
        return R.success(list);
    }
}
