package com.xj.apps.cms.service.impl;

import com.xj.apps.cms.bean.Article;
import com.xj.apps.cms.bean.ArticleExample;
import com.xj.apps.cms.bean.extend.ArticleExtend;
import com.xj.apps.cms.config.CustomerException;
import com.xj.apps.cms.dao.ArticleMapper;
import com.xj.apps.cms.dao.extend.ArticleExtendMapper;
import com.xj.apps.cms.service.IArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleExtendMapper articleExtendMapper;

    @Override
    public List<Article> findAll() {
        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public List<ArticleExtend> cascadeFindAll() {
        return articleExtendMapper.selectAll();
    }

    @Override
    public ArticleExtend findById(long id) {
        return articleExtendMapper.selectById(id);
    }

    @Override
    public void saveOrUpdate(Article article) throws CustomerException {
        if(article.getId()!=null){
            articleMapper.updateByPrimaryKey(article);
        }else{
            //对article初始化之前判断是否title相同，如果相同则抛出异常不进行保存
            ArticleExample articleExample = new ArticleExample();
            articleExample.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> list = articleMapper.selectByExample(articleExample);
            if(list.size()>0){
                throw new CustomerException("文章标题不能重复");
            }
            //对article进行初始化
            article.setStatus(ArticleExtend.STATUS_UNCHECKED);
            article.setThumpUp(0L);
            article.setThumpDown(0L);
            article.setPublishTime(new Date().getTime());
            article.setReadTimes(0L);
            articleMapper.insert(article);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        Article article = articleMapper.selectByPrimaryKey(id);
        if(article==null){
            throw new CustomerException("该文章不存在");
        }
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDelete(long[] ids) throws CustomerException {
        for(long id : ids){
            deleteById(id);
        }
    }
}
