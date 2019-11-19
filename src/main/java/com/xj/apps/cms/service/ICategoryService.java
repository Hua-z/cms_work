package com.xj.apps.cms.service;

import com.xj.apps.cms.bean.Category;
import com.xj.apps.cms.bean.extend.CategoryExtend;
import com.xj.apps.cms.config.CustomerException;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    List<CategoryExtend> cascadeFindAll();

    CategoryExtend findById(long id);

    void saveOrUpdate(Category category) throws CustomerException;

    void deleteById(long id) throws CustomerException;

    void batchDelete(long[] ids) throws CustomerException;
}
