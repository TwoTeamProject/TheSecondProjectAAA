package com.pro.two.service.person;

import com.pro.two.dao.person.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:PersonServiceImpl
 * discription:
 * author:sjq
 * createTime:2018-11-28 16:56
 */
@Service
public class PersonServiceImpl implements PersonService {

    //依赖注入
    @Autowired
    private PersonDao personDao;

    /**
     * 用户列表
     * @return
     */
   /* @Override
    public List<Map> personList(Map map) {
        map.put("end",10);
        map.put("start",0);
        return personDao.personList(map);
    }*/

    /**
     * 员工总数
     * @return
     */
    /*@Override
    public int personCount() {
        return personDao.personCount();
    }*/

    /**
     * vue雇员列表
     * @param map
     * @return
     */
    @Override
    public List<Map> personListDemo(Map map) {
        return personDao.personListDemo(map);
    }

    /**
     * 查询分页总页数
     * @param map
     * @return
     */
    @Override
    public int getPageCount(Map map) {
        return personDao.getPageCount(map);
    }

    /**
     * 员工添加
     * @param map
     * @return
     */
    @Override
    public int add(Map map) {
        return personDao.add(map);
    }

    /**
     * 删除
     * @param user_id
     * @return
     */
    @Override
    public int delete(Integer user_id) {
        return personDao.delete(user_id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int batchDelete(String ids) {
        boolean isAdd=true;
        if(ids!=null&&!"".equals(ids)){
            String[] idArr = ids.split(",");
            for (String id : idArr) {
                int i= personDao.delete(Integer.valueOf(id));
                if(i<1) isAdd=false;
            }
        }
        if(isAdd) return 1;
        else  return 0;
    }

    /**
     * 查询职位
     * @return
     */
    @Override
    public List<Map> role() {
        return personDao.role();
    }
}
