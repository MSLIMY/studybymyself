package com.studybymyself.candcloud.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author ljj
 * @Description 萤石云接口封装
 * @ClassName CandCloudPortPackaging
 * @date 2019/8/26 17:52
 * @Version 1.0
 */

@RestController
@RequestMapping("/candcloud")
public class CandCloudPortPackaging {



    public static void main(String[] args) throws IOException {
        System.out.println();
    }
/*
    *//**
     * 创建子账户
     * @return
     * @throws IOException
     *//*
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
    }*/





    private static long expireTime = 0;
    private static String accessToken = null;

    /**
     * 根据appKey,appSecret获取accessToken
     *
     * @param appKey
     * @param appSecret
     * @return
     */
    @RequestMapping(value = "/token/creat", method = RequestMethod.POST)
    public static String token(String appKey, String appSecret) {
        String url = "https://open.ys7.com/api/lapp/token/get";
        Map<String, String> map = new HashMap<>();
        map.put("appKey", appKey);
        map.put("appSecret", appSecret);
        //判断是否过期，有效期内不需要重复请求该接口，直接返回accessToken即可。
        if (accessToken == null && expireTime <= System.currentTimeMillis()) {
            String postData = OkHttpUtils.postData(url, map);
            JSONObject jsonObject = JSON.parseObject(postData);
            if ("200".equals(jsonObject.getString("code"))) {
                expireTime = jsonObject.getJSONObject("data").getLongValue("expireTime");
                accessToken = jsonObject.getJSONObject("data").getString("accessToken");
            } else {
                return jsonObject.getString("msg");
            }
        }
        return accessToken;
    }

    /**
     * 添加设备，子账户token无权限请求
     *
     * @param accessToken  授权过程获取的access_token,主账号生成的access_token
     * @param deviceSerial 设备序列号,存在英文字母的设备序列号，字母需为大写
     * @param validateCode 设备验证码，设备机身上的六位大写字母
     * @return
     */
    @RequestMapping(value = "/device/add", method = RequestMethod.POST)
    public static JSONObject deviceAdd(String accessToken, String deviceSerial, String validateCode) {
        String url = "https://open.ys7.com/api/lapp/device/add";
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("deviceSerial", deviceSerial);
        map.put("validateCode", validateCode);
        String postData = OkHttpUtils.postData(url, map);
        JSONObject jsonObject = JSON.parseObject(postData);
        return jsonObject;
    }

    /**
     * 删除设备，子账户token无权限请求
     *
     * @param accessToken  授权过程获取的access_token,主账号生成的access_token
     * @param deviceSerial 设备序列号,存在英文字母的设备序列号，字母需为大写
     * @return
     */
    @RequestMapping(value = "/device/delete", method = RequestMethod.POST)
    public static JSONObject deviceDelete(String accessToken, String deviceSerial) {
        String url = "https://open.ys7.com/api/lapp/device/delete";
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("deviceSerial", deviceSerial);
        String postData = OkHttpUtils.postData(url, map);
        JSONObject jsonObject = JSON.parseObject(postData);
        return jsonObject;
    }

    /**
     * 创建子账号
     *
     * @param accessToken 授权过程获取的access_token,主账号生成的access_token
     * @param accountName 子账户名，4-40位英文字母、阿拉伯数字或下划线
     * @param password    子账户密码，LowerCase(MD5(AppKey#密码明文))
     * @return
     */
    @RequestMapping(value = "/account/create", method = RequestMethod.POST)
    public static JSONObject accountCreate(String accessToken, String accountName, String password) {
        String url = "https://open.ys7.com/api/lapp/ram/account/create";
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("accountName", accountName);
        map.put("password", password);
        String postData = OkHttpUtils.postData(url, map);
        JSONObject jsonObject = JSON.parseObject(postData);
        return jsonObject;
    }


    /**
     * 子账号授权
     *
     * @param accessToken       授权过程获取的access_token,主账号生成的access_token
     * @param accountId         子账户Id
     * @param policy，语法结构详情查看文档  https://open.ys7.com/doc/zh/book/index/account-policy.html#policy%E6%A0%B7%E4%BE%8B
     * @return
     */
    @RequestMapping(value = "/policy/set", method = RequestMethod.POST)
    public static JSONObject policySet(String accessToken, String accountId, String policy) {
        String url = "https://open.ys7.com/api/lapp/ram/policy/set";
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("accountId", accountId);
        map.put("policy", policy);
        String postData = OkHttpUtils.postData(url, map);
        JSONObject jsonObject = JSON.parseObject(postData);
        return jsonObject;
    }

    /**
     * 获取用户下直播视频列表
     *
     * @param accessToken 授权过程获取的access_token,子账号或者主账号生成的access_token
     * @param pageStart   分页起始页，从0开始
     * @param pageSize    分页大小，默认为10，最大为50
     * @return
     */
    @RequestMapping(value = "/video/list", method = RequestMethod.POST)
    public static JSONObject videoList(String accessToken, String pageStart, String pageSize) {
        String url = "https://open.ys7.com/api/lapp/live/video/list";
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("pageStart", pageStart);
        map.put("pageSize", pageSize);
        String postData = OkHttpUtils.postData(url, map);
        JSONObject jsonObject = JSON.parseObject(postData);
        return jsonObject;
    }

    /**
     * 获取指定有效期的直播地址
     *
     * @param accessToken  授权过程获取的access_token,子账号或者主账号生成的access_token
     * @param deviceSerial 设备序列号,存在英文字母的设备序列号，字母需为大写
     * @param channelNo    通道号，IPC设备填1
     * @param expireTime   地址过期时间：单位秒数，最大默认62208000（即720天），最小默认300（即5分钟）。非必选参数，为空时返回对应设备和通道的永久地址
     * @return
     */
    @RequestMapping(value = "/address/limited", method = RequestMethod.POST)
    public static JSONObject addressLimited(String accessToken, String deviceSerial, String channelNo, String expireTime) {
        String url = "https://open.ys7.com/api/lapp/live/address/limited";
        Map<String, String> map = new HashMap<>();
        map.put("accessToken", accessToken);
        map.put("deviceSerial", deviceSerial);
        map.put("channelNo", channelNo);
        map.put("expireTime", expireTime);
        String postData = OkHttpUtils.postData(url, map);
        JSONObject jsonObject = JSON.parseObject(postData);
        return jsonObject;
    }


    /**
     * 获取B模式 子账户accessToken
     *
     * @param accessToken
     * @param accountId
     * @return
     */
    @RequestMapping(value = "/account/token", method = RequestMethod.POST)
    public static JSONObject accountToken(String accessToken, String accountId) {
        String url = "https://open.ys7.com/api/lapp/ram/token/get";
        Map<String,String> map = new HashMap<>();
        map.put("accessToken",accessToken);
        map.put("accountId",accountId);
        String postData = OkHttpUtils.postData(url,map);
        JSONObject jsonObject = JSON.parseObject(postData);
        return jsonObject;

    }














    }
