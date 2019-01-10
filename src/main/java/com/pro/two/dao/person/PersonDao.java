package com.pro.two.dao.person;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;

/**
 * className:PersonDao
 * discription:
 * author:sjq
 * createTime:2018-11-28 16:39
 */
public interface PersonDao {

    /**
     * 员工列表
     * @return
     */
    List<Map> personList(Map map);

    /**
     * 员工总数
     * @return
     */
    int personCount();

    /**
     * 员工列表
     * @return
     * 重点注意：注解动态sql要加"{}",要加script  大于小于号要&lt; where a.rn &gt; #{start} where rownum &lt; #{end}
     */
    @Select({"<script>" +
            "select * from (select rownum rn,t.*,to_char(user_create_date,'yyyy-MM-hh') as create_date,r.title from tb_user t,tb_role r where t.user_post_id=r.id and rownum &lt; #{end}"
            +"<if test=\"id!=null and id!=''\"> and user_id=#{id} </if>"
            +"<if test=\"name!=null and name!=''\"> and user_name like '%'||#{name}||'%'</if>"
            +"<if test=\"post_id!=null and post_id!=0\"> and user_post_id=#{post_id}</if>"
            +") a where a.rn &gt; #{start}"
            +"</script>"})
    List<Map> personListDemo(Map map);

    /**
     * 查询总条数
     * @param map
     * @return
     */
    @Select({"<script>"+"select count(*) from tb_user <where>" +
            "<if test=\"id!=null and id!=''\"> and user_id=#{id} </if>\n" +
            "<if test=\"name!=null and name!=''\"> and user_name like '%'||#{name}||'%' </if>\n" +
            "<if test=\"post_id!=null and post_id!=0\"> and user_post_id=#{post_id} </if>\n" +
            "</where></script>"})
    int getPageCount(Map map);

    /**
     * 雇员添加
     * @param map
     * @return
     */
    @Insert("insert into tb_user(user_id,user_name,user_gender,user_age,user_post_id,user_phone,user_create_date,user_uname,user_password,user_email,user_state) values(tb_user_id.nextval,#{USER_NAME},#{USER_GENDER},#{USER_AGE},#{USER_POST_ID},#{USER_PHONE},#{CREATE_DATE},#{USER_UNAME},#{USER_PASSWORD},#{USER_EMAIL},#{USER_STATE})")
    int  add(Map map);

    /**
     * 雇员修改
     * @param map
     * @return
     */
    @Update("update tb_user set user_name=#{USER_NAME},user_gender=#{USER_GENDER},user_age=#{USER_AGE},user_post_id=#{USER_POST_ID},user_phone=#{USER_PHONE},user_create_date=#{CREATE_DATE},user_uname=#{USER_UNAME},user_password=#{USER_PASSWORD},user_email=#{USER_EMAIL},user_state=#{USER_STATE} where user_id=#{USER_ID}")
    int update(Map map);
    /**
     * 雇员删除
     * @param user_id
     * @return
     */
    @Delete("delete from tb_user where user_id=#{user_id}")
    int delete(Integer user_id);

    /**
     * 查询职位
     * @return
     */
    @Select("select id,title from tb_role")
    List<Map> role();

    @Update("update tb_user set user_uname=#{userName},user_password=#{passWord} where user_id=#{userId}")
    int updatePassWord(Map map);
}
