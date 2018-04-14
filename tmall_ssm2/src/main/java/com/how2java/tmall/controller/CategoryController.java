package com.how2java.tmall.controller;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired//自动注入
    CategoryService categoryService;//接口
    @RequestMapping("admin_category_list")
    public String list(Model model, Page page){
        List<Category> cs = categoryService.list(page);
        int total= categoryService.total();
        page.setTotal(total);
        model.addAttribute("page",page);
        model.addAttribute("cs",cs);
        return  "admin/listCategory";
    }
}
