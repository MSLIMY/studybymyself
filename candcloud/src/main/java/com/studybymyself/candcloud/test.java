package com.studybymyself.candcloud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Iterator;
import java.util.List;

/**
 * @author ljj
 * @Description TODO
 * @ClassName test
 * @date 2019/9/24 15:25
 * @Version 1.0
 */
public class test {

    public static void main1(String[] args) {
        String text = "{\n" +
                "    \"scene\": [\n" +
                "        {\n" +
                "            \"name\": \"Google\",\n" +
                "            \"id\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Baidu\",\n" +
                "            \"id\": \"2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"SoSo\",\n" +
                "            \"id\": \"3\"\n" +
                "        }\n" +
                "    ],\n" +
                "\n" +
                "\"device\": [\n" +
                "        {\n" +
                "            \"name\": \"Google\",\n" +
                "            \"id\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Baidu\",\n" +
                "            \"id\": \"2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"SoSo\",\n" +
                "            \"id\": \"3\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(text);
        System.out.println(jsonObject);

        JSONArray scene = jsonObject.getJSONArray("scene");
        JSONArray device = jsonObject.getJSONArray("device");

        if(null!=scene){
            for (Iterator iterator = scene.iterator(); iterator.hasNext();) {
                System.out.println("场景："+iterator.next());
            }
        }
        if(null!=device) {
            for (Iterator iterator = device.iterator(); iterator.hasNext(); ) {
                System.out.println("设备：" + iterator.next());
            }
        }
    }


    public static void main(String[] args) {
        String text = "{\n" +
                "    \"scene\": [\n" +
                "        {\n" +
                "            \"name\": \"Google\",\n" +
                "            \"id\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Baidu\",\n" +
                "            \"id\": \"2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"SoSo\",\n" +
                "            \"id\": \"3\"\n" +
                "        }\n" +
                "    ],\n" +
                "\n" +
                "\"device\": [\n" +
                "        {\n" +
                "            \"name\": \"Google\",\n" +
                "            \"id\": \"1\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"Baidu\",\n" +
                "            \"id\": \"2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"SoSo\",\n" +
                "            \"id\": \"3\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject jsonObject = JSON.parseObject(text);
        System.out.println(jsonObject);

        JSONArray sceneArray = jsonObject.getJSONArray("scene");
        JSONArray deviceArray = jsonObject.getJSONArray("device");
        //方法1 直接遍历
        if (null != sceneArray) {
            for (Iterator iterator = sceneArray.iterator(); iterator.hasNext(); ) {
                System.out.println("方法一场景：" + iterator.next());
            }
        }
        if (null != deviceArray) {
            for (Iterator iterator = deviceArray.iterator(); iterator.hasNext(); ) {
                System.out.println("方法一设备：" + iterator.next());
            }
        }

        //方法2 先转成list数组，在遍历list
        //JSONArray转list数组
        List<scene> sceneList = JSONObject.parseArray(sceneArray.toJSONString(), scene.class);
        List<device> deviceList = JSONObject.parseArray(deviceArray.toJSONString(), device.class);

        for (scene scene : sceneList) {
            System.out.println("方法二场景：" + scene.toString())
            ;
        }

        for (device device : deviceList) {
            System.out.println("方法二设备：" + device.toString());
        }


    }
}

class scene {
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "scene{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class device {
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "device{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }




}
