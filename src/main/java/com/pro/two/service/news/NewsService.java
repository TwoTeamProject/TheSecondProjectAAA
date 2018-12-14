package com.pro.two.service.news;

import java.util.List;
import java.util.Map;

/**
 * className:NewsService
 * discription:
 * author:sjq
 * createTime:2018-12-11 09:42
 */
public interface NewsService {

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
     * 批量删除
     * @param IDS
     * @return
     */
    int batchDelete(String IDS);

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
