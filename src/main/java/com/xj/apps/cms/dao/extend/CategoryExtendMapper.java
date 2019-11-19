package com.xj.apps.cms.dao.extend;

import com.xj.apps.cms.bean.extend.CategoryExtend;

import java.util.List;

public interface CategoryExtendMapper {
    CategoryExtend selectById(long id);
    List<CategoryExtend> selectAll();
}
