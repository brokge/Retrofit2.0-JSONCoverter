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

# License

> Copyright [brokge]

> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
