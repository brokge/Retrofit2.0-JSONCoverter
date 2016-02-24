package cn.dxy.inderal.component.retrofit;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import java.io.IOException;

final class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    JsonResponseBodyConverter() {

    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        JSONObject jsonObj;
        try {
            jsonObj = new JSONObject(value.string());
            return (T) jsonObj;
        } catch(JSONException e) {
            return null;
        }
    }
}
