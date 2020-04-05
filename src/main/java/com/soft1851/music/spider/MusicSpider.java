package com.soft1851.music.spider;

import com.soft1851.music.entity.Music;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/4
 */
public class MusicSpider {
    private static final Integer SUCCESS = 200;

    public static List<Music> getSong() throws Exception{
        List<Music> songs = new ArrayList<>();
        int[] num = {1,2,3,4,5,6,9,10,11,12,13,14,15,16,18,19,20,21,22,23,24,25,26,27,28};
        for (int i = 0;i<num.length;i++){
            //目标地址
            String url = "http://www.xiaoluo666.cn/musicPlayer/webadvice/soarMusic.html?urlCode="+num[i];
            //创建httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //创建get对象
            HttpGet get = new HttpGet(url);
            //创建context对象
            HttpClientContext context = HttpClientContext.create();
            //创建response对象
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(get,context);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //System.out.println(response.getStatusLine());

            //如果请求成功则获取网页源码
            if (response.getStatusLine().getStatusCode() == SUCCESS){
                HttpEntity entity = response.getEntity();
                if (entity != null){
                    String res = EntityUtils.toString(entity);
                    Document document = Jsoup.parse(res);
                    Element element_box =document.getElementById("lyp_rank");
                    Element element_ul = element_box.child(0);
                    Elements elements_li = element_ul.select("li");
                    Elements elements = elements_li.select(".layui-row");

                    // System.out.println(elements.size());
                    for (Element element : elements){
                        Element box1 = element.child(0);
                        String songName = box1.select("span").text();
                        Element box2 = element.child(1);
                        String singer = box2.select("span").text();
                        Element box3 = element.child(2);
                        Elements song_url = box3.select("a");
                        String songUrl = song_url.attr("href");

                        Music song = Music.builder().musicName(songName).singer(singer).url(songUrl)
                                .type(num[i]).build();
                        songs.add(song);
                    }
                }
            }else {
                System.out.println("请求失败");
            }
            try{
                response.close();
                httpClient.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        for (Music song:songs) {
            System.out.println(song);
        }
        return songs;
    }

    public static void main(String[] args)throws Exception {
        System.out.println(getSong());
    }
}
