package com.darengj.jddata.service.impl;

import com.darengj.jddata.beans.Album;
import com.darengj.jddata.dao.IJDDao;
import com.darengj.jddata.service.IJDService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Tony on 2016/7/4.
 */
@Service("jdService")
public class JDService implements IJDService {
    @Autowired
    private IJDDao ijdDao;

    public List<Album> queryAlbum(JSONObject param) throws Exception {
        List<String> titles = Arrays.asList(param.getString("title").split(","));
        List<String> sub_title = Arrays.asList(param.getString("sub_title").split(","));
        int page_size = param.getInt("page_size");
        String author = param.getString("author");
        int page_num = param.getInt("page_num");
        JSONObject q_condition = new JSONObject();
        q_condition.put("title",titles);
        q_condition.put("sub_title",sub_title);
        q_condition.put("author",author);
        q_condition.put("star_position",(page_num-1)*page_size);
        q_condition.put("page_size",page_size);
        return  ijdDao.queryAlbum(q_condition);
    }

    public int queryPageInfo(JSONObject param) throws Exception {
        List<String> titles = Arrays.asList(param.getString("title").split(","));
        List<String> sub_title = Arrays.asList(param.getString("sub_title").split(","));
        int page_size = param.getInt("page_size");
        int page_num = param.getInt("page_num");
        JSONObject q_condition = new JSONObject();
        q_condition.put("title",titles);
        q_condition.put("sub_title",sub_title);
        q_condition.put("star_position",(page_num-1)*page_size);
        q_condition.put("page_size",page_size);
        return  ijdDao.queryPageInfo(q_condition);
    }

}
