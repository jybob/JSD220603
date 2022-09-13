package cn.tedu.boot021.Controller;

import cn.tedu.boot021.Entity.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class ProductController {
    @RequestMapping("/insert")
    public String insert(Product product) {
        try (Connection conn = DBUtils.getConn();) {
            String sql = "insert into product values(null,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getNum());
            ps.executeUpdate();
            return "添加成功<a href='/'>点此返回首页</a>";
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "添加失败";
    }

    @RequestMapping("/select")
    public String select() {
        ArrayList<Product> list = new ArrayList<>();
        try (Connection conn = DBUtils.getConn();) {
            String sql = "select * from product";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                double price = rs.getDouble("price");
                int num = rs.getInt("num");
                list.add(new Product(id, title, price, num));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String html = "<table border='1' align='center'>";
        html += "<caption>商品列表</caption>";
        html += "<tr><th>id</th><th>商品标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        for (Product p : list) {
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
    public String delete(int id) {
        try (Connection conn = DBUtils.getConn();) {
            String sql = "delete from product where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "删除成功!<a href='/'>返回首页</a>";
    }

    @RequestMapping("/update")
    public String update(Product product) {
        try (Connection conn = DBUtils.getConn();) {
            String sql="update product set title=?,price=?,num=? where id=?";
              PreparedStatement ps=conn.prepareStatement(sql);
              ps.setString(1,product.getTitle());
              ps.setDouble(2,product.getPrice());
              ps.setInt(3,product.getNum());
              ps.setInt(4,product.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "更新完成!<a href='/'>点此返回首页</a>";
    }
}
