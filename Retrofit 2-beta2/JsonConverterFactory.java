package retrofit;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;
import org.json.JSONObject;
import retrofit.Converter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class JsonConverterFactory extends Converter.Factory {

    public static JsonConverterFactory create() {
        return new JsonConverterFactory ();
    }

    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new JsonResponseBodyConverter<JSONObject>();
    }

    public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new JsonRequestBodyConverter<JSONObject>();
    }
}
