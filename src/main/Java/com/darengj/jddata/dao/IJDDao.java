package com.darengj.jddata.dao;

import com.darengj.jddata.beans.Album;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Tony on 2016/7/4.
 */
public interface IJDDao {
    public List<Album> queryAlbum(JSONObject q_condition) throws Exception;
}
