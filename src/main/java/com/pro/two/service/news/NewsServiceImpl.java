package com.pro.two.service.news;

import com.pro.two.dao.news.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:NewsServiceImpl
 * discription:
 * author:sjq
 * createTime:2018-12-11 09:42
 */
@Service
public class NewsServiceImpl implements NewsService {

    /**
     * 依赖注入
     */
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<Map> newsList(Map map) {
        return newsDao.newsList(map);
    }

    @Override
    public List<Map> newsList2() {
        return newsDao.newsList2();
    }

    @Override
    public int newsCount(Map map) {
        return newsDao.newsCount(map);
    }

    @Override
    public int newsDelete(Integer NEWS_ID) {
        return newsDao.newsDelete(NEWS_ID);
    }

    @Override
    public int batchDelete(String IDS) {
        boolean isAdd=true;
        if(IDS!=null&&!"".equals(IDS)){
            String[] idArr = IDS.split(",");
            for (String id : idArr) {
                int i= newsDao.newsDelete(Integer.valueOf(id));
                if(i<1) isAdd=false;
            }
        }
        if(isAdd) return 1;
        else  return 0;
    }

    @Override
    public int addNews(Map map) {
        return newsDao.addNews(map);
    }

    @Override
    public int updateNews(Map map) {
        return newsDao.updateNews(map);
    }
}
