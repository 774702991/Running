package com.qf.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VideoCrawleUtil {


    public static void main(String[] args) {
        String url = "http://www.gotokeep.com/plans/599fc84c2df6fc0af14dd0da";
        String html = HttpRequest.sendGet(url,"");
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select(".inner div .step");
        for (Element element : elements) {
           String img =  element.select("a div").attr("data-background");
           String title = element.select("a .name").html();
           String video_url = element.select("a").attr("href");
           video_url = "http://www.gotokeep.com"+video_url;
            System.out.println(img);
            System.out.println(title);
            String video_html = HttpRequest.sendGet(video_url,"");
            Document video_doc = Jsoup.parse(video_html);
            String video = video_doc.select(".video-wrapper").attr("data-src");
            System.out.println(video);
            System.out.println();
            /*try {
                String sql = "insert into video(video_url,style,author,time,img_url)" +
                        "values('"+video+"','视频','小编',now(),'"+img+"')";
                statement.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
        }
    }
}
