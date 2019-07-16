package com.laka.libnet.gson.adapter;

import android.util.Log;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @Author:Rayman
 * @Date:2018/12/21
 * @Description:Gson默认Float转换类，假若后台的数字字段返回了null,"",boolean .
 * 通过当前的解析器转换为默认值0F
 */

public class FloatDefaultFormatAdapter extends TypeAdapter<Float> {

    private static final String TAG = "FloatDefaultFormatAdapt";

    @Override
    public void write(JsonWriter out, Float value) throws IOException {
        if (value == null) {
            value = 0F;
        }
        out.value(value);
    }

    @Override
    public Float read(JsonReader in) throws IOException {
        Float value;
        try {
            if (in.peek() == JsonToken.NULL) {
                // 假若返回Null，默认为0F
                in.nextNull();
                value = 0F;
            } else if (in.peek() == JsonToken.BOOLEAN) {
                in.nextBoolean();
                value = 0F;
            } else if (in.peek() == JsonToken.STRING) {
                String jsonStr = in.nextString();
                value = Float.parseFloat(jsonStr);
            } else {
                String str = in.nextString();
                value = Float.valueOf(str);
            }
            //LogUtils.info(GsonUtils.TAG, "进入Float格式转换类：" + value);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            value = 0F;
        }
        return value;
    }
}
