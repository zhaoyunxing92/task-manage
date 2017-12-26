package com.sunny.task.core.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.utils.GsonUtils
 * @date 2017-06-28 17:42
 * @description:
 */
public class GsonUtils {
    private GsonUtils(){
        super();
    }
    /**
     * 获取 JsonObject对象
     * @param json
     * @return
     */
    public static JsonObject getJsonObject(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.fromJson(json,JsonObject.class);
    }

    public static Gson getGson(){
         return new GsonBuilder().setPrettyPrinting().create();
    }
}
