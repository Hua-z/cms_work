package com.xj.apps.cms.dao.extend;

import com.xj.apps.cms.bean.extend.ArticleExtend;

import java.util.List;

public interface ArticleExtendMapper{
    List<ArticleExtend> selectAll();
    ArticleExtend selectById(long id);
}
