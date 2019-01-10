package com.pro.two.service.person;

import org.apache.ibatis.annotations.Delete;

import java.util.List;
import java.util.Map;

/**
 * className:PersonService
 * discription:
 * author:sjq
 * createTime:2018-11-28 16:55
 */
public interface PersonService {

    /**
     * 员工列表
     * @return
     */
    //List<Map> personList(Map map);

    /**
     * 员工总数
     * @return
     */
    //int personCount();

    /**
     *  vue雇员列表
     * @param map
     * @return
     */
    List<Map> personListDemo(Map map);

    /**
     * 查询分页总页数
     * @param map
     * @return
     */
    int getPageCount(Map map);

    /**
     * 雇员添加
     * @param map
     * @return
     */
    int  add(Map map);

    /**
     * 雇员修改
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 雇员删除
     * @param user_id
     * @return
     */
    int delete(Integer user_id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDelete(String ids);

    /**
     * 查询职位
     * @return
     */
    List<Map> role();

    /**
     * 更新密码
     * @param map
     * @return
     */
    int updatePassWord(Map map);
}
