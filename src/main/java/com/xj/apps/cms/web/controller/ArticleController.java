package com.xj.apps.cms.web.controller;

import com.xj.apps.cms.bean.Article;
import com.xj.apps.cms.bean.extend.ArticleExtend;
import com.xj.apps.cms.service.IArticleService;
import com.xj.apps.cms.utils.Message;
import com.xj.apps.cms.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "文章相关接口")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @ApiOperation("查询所有文章")
    @GetMapping("findAll")
    public Message findAll(){
        List<Article> list = articleService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("级联查询(查询出评论等相关等信息)")
    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll(){
        List<ArticleExtend> list = articleService.cascadeFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation("根据id查询文章")
    @GetMapping("findById")
    public Message findById(long id){
        ArticleExtend articleExtend = articleService.findById(id);
        return MessageUtil.success(articleExtend);
    }

    @ApiOperation("保存或修改")
    @PostMapping("saveOrUpdate")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "标题",required = true,paramType = "query"),
            @ApiImplicitParam(name = "content",value = "内容",required = true,paramType = "query"),
            @ApiImplicitParam(name = "source",value = "源内容",required = true,paramType = "query"),
            @ApiImplicitParam(name = "categoryId",value = "栏目ID",required = true,paramType = "query"),
            @ApiImplicitParam(name = "authorId",value = "作者ID",required = true,paramType = "query")
    })
    public Message saveOrUpdate(
            Long id,
            String title,
            String content,
            String source,
            Long categoryId,
            Long authorId
    ){
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setCategoryId(categoryId);
        article.setAuthorId(authorId);
        articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation("根据ID值删除")
    @GetMapping("deleteById")
    public Message deleteById(long id){
        articleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation("根据ID值批量删除")
    @PostMapping("batchDelete")
    public Message batchDelete(@RequestBody long[] ids){
        articleService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}
