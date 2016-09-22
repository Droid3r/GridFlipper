package akshay.example.com.flipimagegrid.model.Interactors;





import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import akshay.example.com.flipimagegrid.model.Interactors.interactor_interfaces.IFlickrFeedAPIInteractor;
import akshay.example.com.flipimagegrid.model.pojo.FlickrImageFeed;
import akshay.example.com.flipimagegrid.presenters.presenter_interfaces.IOnFlickFeedLoadFinisherListener;
import akshay.example.com.flipimagegrid.rest.IRetrofitClient;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by akshay on 21/09/16.
 */
public class FeedAPIInteractor implements IFlickrFeedAPIInteractor {

    private IRetrofitClient mIRetrofitClient;

    @Inject
    public FeedAPIInteractor(IRetrofitClient client) {
        this.mIRetrofitClient = client;
    }

    @Override
    public void loadFlickrPublicImagesFeed(final IOnFlickFeedLoadFinisherListener listener) {
        Log.d("Interactor", "called");
        Call<FlickrImageFeed> imageFeedCall = mIRetrofitClient.getPublicImageFeed();
        imageFeedCall.enqueue(new Callback<FlickrImageFeed>() {
            @Override
            public void onResponse(Response<FlickrImageFeed> response, Retrofit retrofit) {

                Log.d("Interactor", "success");
                FlickrImageFeed imageFeedList = response.body();
                listener.onFlickrFeedLoadSuccess(imageFeedList);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("Interactor", "failure" + t.getMessage());
                listener.onFlickrFeedLoadFailure("Could Not Load the Feed!");
            }
        });
    }



}
