package com.xj.apps.cms.bean.extend;

import com.xj.apps.cms.bean.Category;

import java.util.List;

public class CategoryExtend extends Category {
    private List<Category> categories;
    private Category category;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
