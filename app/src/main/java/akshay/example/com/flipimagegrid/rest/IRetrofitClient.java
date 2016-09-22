package akshay.example.com.flipimagegrid.rest;

import java.util.List;

import akshay.example.com.flipimagegrid.model.pojo.FlickrImageFeed;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by akshay on 21/09/16.
 */
public interface IRetrofitClient {

    @GET("?format=json&nojsoncallback=1")
    Call<FlickrImageFeed> getPublicImageFeed();
}
