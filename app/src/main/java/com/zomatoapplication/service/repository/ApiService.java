package com.zomatoapplication.service.repository;

import com.zomatoapplication.service.model.DataResponse;
import com.zomatoapplication.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

   /* @GET("search")
    Call<DataResponse> getData();
*/

    //for getting all details of restaurant using cityid or lattitude and longitude and collection id
    @Headers("user_key: 4feaa2167c4dc6beadf629319423bd4b")
    @GET("search")
    Call<DataResponse> getData(
            @Query("lat") String lat,
                  @Query("lon") String lon,
                  @Query("sort")String sort);

}
