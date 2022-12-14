package cn.tedu.boot03.controller;

import cn.tedu.boot03.entity.Product;
import cn.tedu.boot03.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductMapper mapper;
    @RequestMapping("/insert")
    public String insert(Product product){
        System.out.println("product = " + product);
        mapper.insert(product);
        return "添加完成!<a href='/'>返回首页</a>";
    }
    @RequestMapping("/select")
    public String select(){
        List<Product> list= mapper.select();
        String html="<table border='1' align='center'>";
        html+="<caption>商品列表</caption>";
        html+="<tr><th>id</th><th>标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        for (Product p:list
             ) {
            html += "<tr>";
            html += "<td>" + p.getId() + "</td>";
            html += "<td>" + p.getTitle() + "</td>";
            html += "<td>" + p.getPrice() + "</td>";
            html += "<td>" + p.getNum() + "</td>";
            html += "<td><a href='/delete?id=" + p.getId() + "'>删除</a></td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }
    @RequestMapping("/delete")
    public String delete(int id){
        mapper.delete(id);
        return "删除完成!<a href='/'>点此返回首页</href>";
    }
    @RequestMapping("/update")
    public String update(Product product){
        mapper.update(product);
        return "修改完成!<a href='/select'>返回商品列表页面</a>";
    }
}
