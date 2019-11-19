package com.xj.apps.cms.service.impl;

import com.xj.apps.cms.bean.Category;
import com.xj.apps.cms.bean.CategoryExample;
import com.xj.apps.cms.bean.extend.CategoryExtend;
import com.xj.apps.cms.config.CustomerException;
import com.xj.apps.cms.dao.CategoryMapper;
import com.xj.apps.cms.dao.extend.CategoryExtendMapper;
import com.xj.apps.cms.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private CategoryExtendMapper categoryExtendMapper;

    @Override
    public List<CategoryExtend> cascadeFindAll() {
        return categoryExtendMapper.selectAll();
    }

    @Override
    public CategoryExtend findById(long id) {
        return categoryExtendMapper.selectById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(new CategoryExample());
    }

    @Override
    public void saveOrUpdate(Category category) throws CustomerException {
        if(category.getId()!=null){
            categoryMapper.updateByPrimaryKey(category);
        }else{
            CategoryExample categoryExample = new CategoryExample();
            categoryExample.createCriteria().andNameEqualTo(category.getName());
            List<Category> list = categoryMapper.selectByExample(categoryExample);
            if(list.size()>0){
                throw new CustomerException("栏目名不可重复");
            }
            categoryMapper.insert(category);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        Category category = categoryMapper.selectByPrimaryKey(id);
        if(category==null){
            throw new CustomerException("栏目名不存在");
        }
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(long[] ids) throws CustomerException {
        for(long id : ids){
            deleteById(id);
        }
    }
}
