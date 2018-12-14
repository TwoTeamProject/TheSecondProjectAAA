package com.pro.two.dao.news;

import java.util.List;
import java.util.Map;

/**
 * className:NewsDao
 * discription:
 * author:sjq
 * createTime:2018-12-11 09:38
 */
public interface NewsDao {

    /**
     * 获取新闻列表
     * @return
     */
    List<Map> newsList(Map map);
    List<Map> newsList2();

    /**
     * 查询总条数
     * @return
     */
    int newsCount(Map map);

    /**
     * 新闻删除
     * @param NEWS_ID
     * @return
     */
    int newsDelete(Integer NEWS_ID);

    /**
     * 添加新闻
     * @param map
     * @return
     */
    int addNews(Map map);

    /**
     * 更新新闻
     * @param map
     * @return
     */
    int updateNews(Map map);
}
