package com.example.nurerkizilkaya.albumphoto.webservices;

import com.example.nurerkizilkaya.albumphoto.model.Photos;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by a s u s on 24.9.2017.
 */
public interface PhotoMethods {
    @GET("photos")
    Call<Photos[]> getItemPhotos();

}
