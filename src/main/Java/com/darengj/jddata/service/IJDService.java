package com.darengj.jddata.service;

import com.darengj.jddata.beans.Album;
import net.sf.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Tony on 2016/7/4.
 */
public interface IJDService {
    public List<Album> queryAlbum(JSONObject param) throws Exception;
}
