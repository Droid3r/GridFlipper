package akshay.example.com.flipimagegrid.di.modules;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import akshay.example.com.flipimagegrid.model.Interactors.FeedAPIInteractor;
import akshay.example.com.flipimagegrid.model.Interactors.interactor_interfaces.IFlickrFeedAPIInteractor;
import akshay.example.com.flipimagegrid.presenters.presenter_interfaces.IOnFlickFeedLoadFinisherListener;
import akshay.example.com.flipimagegrid.rest.IRetrofitClient;
import akshay.example.com.flipimagegrid.util.AppConstants;
import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by akshay on 21/09/16.
 */
@Module
public class AppModule {


    @Singleton
    @Provides
    IRetrofitClient provideRetrofitClient(Retrofit retrofit) {
        IRetrofitClient retrofitClient;
        retrofitClient = retrofit.create(IRetrofitClient.class);
        return retrofitClient;
    }

    @Singleton
    @Provides
    Retrofit providesRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.FLICKR_FEED_URL)
                .build();
        return retrofit;
    }

    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        return client;
    }

    @Singleton
    @Provides
    IFlickrFeedAPIInteractor providesIFlickrFeedAPIInteractor (IRetrofitClient client) {
        return new FeedAPIInteractor(client);
    }

}
