package com.sunny.task.core.common.utils;

import com.google.gson.JsonObject;
import com.sunny.task.core.common.exception.TaskException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.utils.HttpHelperUtils
 * @date 2017-06-28 17:25
 * @description:
 */
public class HttpHelperUtils {


    public static JsonObject doGet(String url) {
        CloseableHttpResponse response;
        BufferedReader reader;
        StringBuffer sbf;
        try {
            HttpGet request = new HttpGet(url);
            response = HttpClients.createDefault().execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String lines;
                sbf = new StringBuffer();
                while ((lines = reader.readLine()) != null) {
                    lines = new String(lines.getBytes(), "utf-8");
                    sbf.append(lines);
                }
                return GsonUtils.getJsonObject(sbf.toString());
            } else {
                throw new TaskException("GET请求异常");
            }

        } catch (Exception e) {
            throw new TaskException(1, e);
        }
    }

}
