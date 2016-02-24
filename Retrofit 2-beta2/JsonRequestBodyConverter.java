package retrofit;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import retrofit.Converter;
import java.io.IOException;

final class JsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    JsonRequestBodyConverter() {

    }

    public RequestBody convert(T value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, value.toString());
    }
}
