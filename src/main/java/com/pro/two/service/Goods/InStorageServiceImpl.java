package com.pro.two.service.Goods;

import com.pro.two.dao.Goods.InStorageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * className:InStorageServiceImpl
 * discription:
 * author:Ryb
 * createTime:2018-12-06 21:47
 */
@Service
public class InStorageServiceImpl implements InStorageService {

    @Autowired
    private InStorageDao inStorageDao;

    @Override
    public int addStorage(Map map) {
        String[] GOODS_ID = (map.get("GOODS_ID") + "").split(",");
        String[] GOODS_SURP = (map.get("GOODS_SURP") + "").split(",");
        String[] GOODS_DATEINPRO = (map.get("GOODS_DATEINPRO") + "").split(",");
        String[] GOODS_EXP = (map.get("GOODS_EXP") + "").split(",");
        for (int i = 0; i < GOODS_ID.length; i++) {
            map.put("GOODS_ID",GOODS_ID[i]);
            map.put("GOODS_SURP",GOODS_SURP[i]);
            map.put("GOODS_DATEINPRO",GOODS_DATEINPRO[i]);
            map.put("GOODS_EXP",GOODS_EXP[i]);
            inStorageDao.addStorage(map);
        }
        inStorageDao.updateState(map);
        return 0;
    }
}
