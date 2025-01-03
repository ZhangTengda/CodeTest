package com.roger.test.util;

import android.text.TextUtils;
import android.util.ArrayMap;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GsonUtil {

    /**
     * 把一个map变成json字符串
     *
     * @param map
     * @return
     */
    public static String parseMapToJson(Map<?, ?> map) {
        try {
            Gson gson = new Gson();
            return gson.toJson(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String parseListToJson(List<?> list) {
        try {
            Gson gson = new Gson();
            return gson.toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 把一个json字符串变成对象
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> T parseJsonToBean(String json, Class<T> cls) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = gson.fromJson(json, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }


    public static String parseBeanToJson(Object cls) {
        Gson gson = new Gson();
        return gson.toJson(cls);
    }


    /**
     * 把json字符串变成map
     *
     * @param json
     * @return
     */
    public static ArrayMap<String, Object> parseJsonToMap(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<LinkedHashMap<String, Object>>() {
        }.getType();
        ArrayMap<String, Object> map = null;
        try {
            map = gson.fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    public static HashMap<String, String> parseJsonToHashMap(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<LinkedHashMap<String, String>>() {
        }.getType();
        HashMap<String, String> map = null;
        try {
            map = gson.fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * 把json字符串变成集合
     * <p>
     * params: new TypeToken<List<yourbean>>(){}.getType(),
     *
     * @param json
     * @param type new TypeToken<List<yourbean>>(){}.getType()
     * @return
     */
    public static List<?> parseJsonToList(String json, Type type) {
        Gson gson = new Gson();
        List<?> list = gson.fromJson(json, type);
        return list;
    }


    public static <T> List<T> listFromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
    }


    /**
     * 获取json串中某个字段的值，注意，只能获取同一层级的value
     *
     * @param json
     * @param key
     * @return
     */

    public static String getFieldValue(String json, String key) {
        if (TextUtils.isEmpty(json))
            return "";
        if (!json.contains(key))
            return "";
        JSONObject jsonObject = null;
        String value = null;
        try {
            jsonObject = new JSONObject(json);
            value = jsonObject.getString(key);
            if (value.equals("null"))
                value = "";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(json)) {
            Type type = new TypeToken<ArrayList<JsonObject>>() {
            }.getType();
            ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);
            for (JsonObject jsonObject : jsonObjects) {
                arrayList.add(new Gson().fromJson(jsonObject, clazz));
            }
        }
        return arrayList;
    }


    public static <T> ArrayList<T> jsonToArrayStringList(String json, Class<T> clazz) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(json)) {
            Type type = new TypeToken<ArrayList<String>>() {
            }.getType();
            ArrayList<String> jsonObjects = new Gson().fromJson(json, type);
            for (String jsonObject : jsonObjects) {
                arrayList.add(new Gson().fromJson(jsonObject, clazz));
            }
        }
        return arrayList;
    }
}