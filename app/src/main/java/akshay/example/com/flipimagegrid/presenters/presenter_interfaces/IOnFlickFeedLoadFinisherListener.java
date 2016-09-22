package akshay.example.com.flipimagegrid.presenters.presenter_interfaces;

import java.util.List;

import akshay.example.com.flipimagegrid.model.pojo.FlickrImageFeed;

/**
 * Created by akshay on 21/09/16.
 */
public interface IOnFlickFeedLoadFinisherListener {

    void onFlickrFeedLoadSuccess(FlickrImageFeed feedList);
    void onFlickrFeedLoadFailure (String message);

}
