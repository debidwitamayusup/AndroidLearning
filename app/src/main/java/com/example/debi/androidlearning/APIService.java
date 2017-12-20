package com.example.debi.androidlearning;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by debi on 19/12/17.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("user/login")
    Call<Response> doLogin (@Field("username") String username,
                            @Field("password") String password);


}
