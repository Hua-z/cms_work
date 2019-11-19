package com.xj.apps.cms.bean.extend;

import com.xj.apps.cms.bean.Article;
import com.xj.apps.cms.bean.Category;
import com.xj.apps.cms.bean.Comment;

import java.util.List;

public class ArticleExtend extends Article {
    public static final String STATUS_UNCHECKED="未审核";
    public static final String STATUS_CHECKED_PASS="审核通过";
    public static final String STATUS_CHECKED_NOPASS="审核不通过";

    private Category category;
    private List<Comment> comments;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
