
package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
     List<Category> list(Page  page);//创建接口   只做查询
    public  int total();
    void add(Category category);
    void delete(int  id);
    Category get(int id);
    void update(Category category);
}