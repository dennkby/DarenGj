package com.darengj.jddata.controller;

import com.darengj.jddata.beans.Album;
import com.darengj.jddata.service.IJDService;
import common.CommonUtil;
import common.Constants;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Tony on 2016/7/1.
 */
@RestController
public class JDController {
    @Autowired
    private IJDService jdService;


    @Autowired
    private HttpServletRequest request;

    /**
     * 查询专辑列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getAlbum.do",method = RequestMethod.POST)
    public JSONObject getAlbum() throws Exception{
        JSONObject result = new JSONObject();
        request.setCharacterEncoding("utf-8");
        JSONObject param = new JSONObject();
        param.put("title",request.getParameter("title"));
        param.put("sub_title",request.getParameter("sub_title"));
        param.put("page_size",request.getParameter("page_size"));
        param.put("page_num",request.getParameter("page_num"));
        try{
            List<Album> albumList = jdService.queryAlbum(param);
            result.put("code",Constants.RETURN_SUCESS);
            result.put("albumList",albumList);
        }catch (Exception e){
            e.printStackTrace();
            result.put("code",Constants.SERVER_ERROR);
        }
        return result;
    }
}
