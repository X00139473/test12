package CA2.app.dogfostering;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.DELETE;
import retrofit2.http.PATCH;

import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface jsonPlaceHolderAPI {


    @PUT("/api/Dogs/{id}")
    Call<Dogs> putPost(@Path("id") String id, @Body Dogs dog);

    @POST("/api/Dogs/")
    Call<Dogs>createPost(@Body Dogs dog);

    @DELETE("/api/Dogs/{id}")
    Call<Void> delete(@Path("id") String id);
}