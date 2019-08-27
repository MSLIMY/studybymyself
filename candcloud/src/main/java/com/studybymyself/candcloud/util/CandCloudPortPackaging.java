package com.studybymyself.candcloud.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


/**
 * @author ljj
 * @Description 萤石云接口封装
 * @ClassName CandCloudPortPackaging
 * @date 2019/8/26 17:52
 * @Version 1.0
 */
public class CandCloudPortPackaging {

    /**
     * 创建子账户
     * @return
     * @throws IOException
     */
    private static JSONObject createAccount(String accessToken,String accountName,String password) throws IOException {
        String param = "accessToken=" + accessToken + "&accountName=" + accountName + "&password=" + password;
        //创建http客户端
        HttpClient client = HttpClientBuilder.create().build();
        StringEntity stringEntity = new StringEntity(param);
        HttpPost httpPost = new HttpPost("https://open.ys7.com/api/lapp/ram/account/create");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
        HttpResponse response = client.execute(httpPost);
        String content = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject json = JSON.parseObject(content);
        return json;
    }


    public static void main(String[] args) throws IOException {
        System.out.println();
    }


    }
