package com.qf.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrawlerUtil {

    private static Connection connection;
    private static Statement statement;

    public static String aaa() {
        String url = "https://baijia.baidu.com";
        String html = HttpRequest.sendGet(url, "");
        System.out.println(html);
        return html;
    }

    public static void main(String[] args) throws SQLException {
        String url = "https://baijia.baidu.com";
        String html = HttpRequest.sendGet(url, "");
        System.out.println(html);
        /*int count = 1;
        String url = "https://baijia.baidu.com";
        String html = HttpRequest.sendGet(url,"");
        //System.out.println(html);
        Document doc = Jsoup.parse(html);
        Elements divs = doc.select("#articleList .pictures");
        for (Element element1 : divs) {
            //创建对象
            Elements p = element1.select(".picture-list .art-img");
            for (Element element : p) {
                //图片
                String img = element.select("a img").attr("src");
                String sql = "insert into imgbox(img_url,rea_id) " +
                        "value('"+img+"',"+count+")";
                statement.execute(sql);
                System.out.println(img);
                System.out.println(count);
            }
            //标题
            String title = element1.select(".title a").html();
            System.out.println(title);

            String author = element1.select(".art-other div a").html();
            System.out.println(author);
            count++;
            //内容
            String contentUrl = element1.select(".title a").attr("href");
            contentUrl = url + contentUrl;
            //System.out.println(contentUrl);
            String contentHtml = HttpRequest.sendGet(contentUrl,"");
            Document contentDoc = Jsoup.parse(contentHtml);
            Elements contentEle = contentDoc.select("#pageWrapper section .main div .article");
            for (Element element : contentEle) {
                String content  = element.select(".news-content").html();
                System.out.println(content);
                String sql = "insert into realist(title,style,author,comment,time,content)" +
                        "values('"+title+"','推荐','"+author+"',0,now(),'"+content+"')";
                statement.execute(sql);
            }

        }*/
    }
}
