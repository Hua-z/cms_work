package com.xj.apps.cms.web.controller;

import com.xj.apps.cms.bean.Category;
import com.xj.apps.cms.bean.extend.CategoryExtend;
import com.xj.apps.cms.service.ICategoryService;
import com.xj.apps.cms.utils.Message;
import com.xj.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "栏目相关接口")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @ApiOperation("查询所有栏目及其子父栏目")
    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll(){
        List<CategoryExtend> list = categoryService.cascadeFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("根据ID查栏目及其子父栏目")
    @GetMapping("selectById")
    public Message selectById(long id){
        CategoryExtend categoryExtend = categoryService.findById(id);
        return MessageUtil.success(categoryExtend);
    }

    @ApiOperation("查询所有栏目")
    @GetMapping("findAll")
    public Message findAll(){
        List<Category> list = categoryService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("根据ID删除栏目")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        categoryService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation("批量删除栏目")
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody long[] ids){
        categoryService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }

    @ApiOperation("保存或更新栏目")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(Category category){
        categoryService.saveOrUpdate(category);
        return MessageUtil.success("更新成功");
    }
}
