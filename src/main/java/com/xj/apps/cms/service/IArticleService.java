package com.xj.apps.cms.service;

import com.xj.apps.cms.bean.Article;
import com.xj.apps.cms.bean.extend.ArticleExtend;
import com.xj.apps.cms.config.CustomerException;

import java.util.List;

public interface IArticleService {
    List<Article> findAll();

    List<ArticleExtend> cascadeFindAll();

    ArticleExtend findById(long id);

    void saveOrUpdate(Article article) throws CustomerException;

    void deleteById(long id) throws CustomerException;

    void batchDelete(long[] ids) throws CustomerException;
}
