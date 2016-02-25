# Retrofit2.0-JSONCoverter
Retrofit 2.0 response JSONCoveter

This JSONCoveter only supported Retrofit 2.0-beta3 and higher.

# Usage

## Get a Retrofit Instance
```Java
private static Retrofit initRetrofit() {
        OkHttpClient httpClient = new OkHttpClient();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
        }
        return new Retrofit.Builder()
                .baseUrl(BaseUtil.getApiUrl())
                .addConverterFactory(JsonConverterFactory.create())
                .client(httpClient)
                .build();
    }
```

## ApiService 
``` Java
import retrofit.Call
/*Retrofit 2.0*/

public interfase ApiService{
    @POST("/list")
    Call<JSONObject> loadRepo();
}
```
## asynchronously

``` Java
Call<JSONObject> call = service.loadRepo();
Repo repo = call.excute()
```

## synchronously 
``` Java
Call<JSONObject> call = service.loadRepo();
call.enqueue(new Callback<JSONObject>(){
    @Override
    public void onResponse(Response<JSONObject> response){
        //从response.body()中获取结果
    }
    @Override
    public void onFailure(Throwable t){

    }
});
```
