package com.pro.two.controller.news;

import com.pro.two.service.news.NewsService;
import com.pro.two.util.FileUtil;
import com.pro.two.util.FtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:NewsController
 * discription:
 * author:sjq
 * createTime:2018-12-11 09:44
 */
@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private FtpUtil ftpUtil;

    private ResourceLoader resourceLoader;

    @Value("${ftp.remoteIp}")
    private String remoteIp;
    @Value("${ftp.ftpUserName}")
    private String ftpUserName;
    @Value("${ftp.ftpPassWord}")
    private String ftpPassWord;
    @Value("${ftp.remotePath}")
    private String remotePath;

    @Value("${ftp.localPath}")
    private String filePath; // D:/images/

    @Autowired
    public NewsController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @RequestMapping("toList")
    public Object toList(){
        return "/news/newsList";
    }

    /**
     * 新闻列表
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/listInterface")
    public Object listInterface(){
        return newsService.newsList2();
    };

    /**
     * 新闻列表
     * @param map
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping("/list")
    public Object newsList(@RequestBody Map map){
        Map map1 = new HashMap();
        map1.put("data",newsService.newsList(map));
        map1.put("total",newsService.newsCount(map));
        return map1;
    };

    /**
     * 删除
     * @param NEWS_ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete/{NEWS_ID}")
    public Object newsDelete(@PathVariable Integer NEWS_ID){
        return newsService.newsDelete(NEWS_ID);
    }
    /**
     * 批量删除
     * @param IDS
     * @return
     */
    @ResponseBody
    @RequestMapping("/batchDelete/{IDS}")
    public Object batchDel(@PathVariable String IDS){
        return newsService.batchDelete(IDS);
    }


    /**
     * 更新新闻
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("updateNews")
    public Object updateNews(@RequestBody Map map){
        System.out.println(map);
        return newsService.updateNews(map);
    }

    /**
     *添加使用ftp 上传新闻
     * @param map
     * @return
     */
    @ResponseBody
    @RequestMapping("/addNews")
    public Object addUseFtp(@RequestBody Map map){
        return newsService.addNews(map);
    }


    /**
     * 图片显示方法
     * @param
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity show(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            Resource resource = resourceLoader.getResource("file:" + filePath + fileName);
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 图片显示方法
     * @param fileName
     * @return
     */
    @RequestMapping("showFtp")
    public ResponseEntity showFtp(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
//            System.out.println("ftp://"+ftpUserName+":"+ftpPassWord+"@"+remoteIp+remotePath+fileName+"1111");
            Resource resource = resourceLoader.getResource("ftp://"+ftpUserName+":"+ftpPassWord+"@"+remoteIp+remotePath+fileName);
            return ResponseEntity.ok(resourceLoader.getResource("ftp://"+ftpUserName+":"+ftpPassWord+"@"+remoteIp+remotePath+fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("ftpUserName:"+ftpUserName);
        return "";
    }

    @ResponseBody
    @RequestMapping("/uploadPic")
    public Object uploadPic(@RequestParam MultipartFile file){
        /*System.out.println(file.getOriginalFilename()+"..............");*/
        final String s =  ftpUtil.upLoad(file);
        return s;
    }

}
