package com.qf.controller;

import com.mysql.jdbc.Driver;
import com.qf.util.HttpRequest;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;

@Controller
public class CrawlerController {

    private static Connection connection;
    private static PreparedStatement statement;
    private static int count = 0;
    static {
        try {
            DriverManager.registerDriver(new Driver());
            String url = "jdbc:mysql://localhost:3306/running?characterEncoding=utf-8";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            String get = "select count(*) id from realist";
            statement = connection.prepareStatement(get);


            ResultSet set = statement.executeQuery();
            if (set.next()){
                count = set.getInt("id");
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("crawler")
    public String craw(Model model) {
        //System.out.println(count);
        try {
            String url = "https://baijia.baidu.com";
            String html = HttpRequest.sendGet(url, "");
            //System.out.println(html);
            Document doc = Jsoup.parse(html);
            Elements divs = doc.select("#articleList .pictures");
            for (Element element1 : divs) {
                //创建对象
                count++;
                Elements p = element1.select(".picture-list .art-img");
                for (Element element : p) {
                    //图片
                    String img = element.select("a img").attr("src");
                    String sql = "insert into imgbox(img_url,rea_id) " +
                            "value('" + img + "'," + count + ")";
                    statement = connection.prepareStatement(sql);
                    statement.executeUpdate();
                    statement.close();
                    /*System.out.println(img);
                    System.out.println(count);*/
                }
                //标题
                String title = element1.select(".title a").html();
                //System.out.println(title);

                String author = element1.select(".art-other div a").html();
                //System.out.println(author);
                //内容
                String contentUrl = element1.select(".title a").attr("href");
                contentUrl = url + contentUrl;
                //System.out.println(contentUrl);
                String contentHtml = HttpRequest.sendGet(contentUrl, "");
                Document contentDoc = Jsoup.parse(contentHtml);
                Elements contentEle = contentDoc.select("#pageWrapper section .main div .article");
                for (Element element : contentEle) {
                    element.select(".news-content img").attr("width","100%");
                    String content = element.select(".news-content").html();
                    System.out.println(content);
                    String sql = "insert into realist(title,style,author,comment,time,content)" +
                            "values('" + title + "','推荐','" + author + "',0,now(),'" + content + "')";
                    statement=connection.prepareStatement(sql);
                    statement.executeUpdate();
                    statement.close();
                }
            }
            model.addAttribute("message","更新成功");
            return "/admin/new";
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("message","更新失败");
        return "/admin/new";
    }
}
