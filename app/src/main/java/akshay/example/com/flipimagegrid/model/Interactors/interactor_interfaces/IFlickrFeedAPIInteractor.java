package akshay.example.com.flipimagegrid.model.Interactors.interactor_interfaces;

import akshay.example.com.flipimagegrid.presenters.presenter_interfaces.IOnFlickFeedLoadFinisherListener;

/**
 * Created by akshay on 21/09/16.
 */
public interface IFlickrFeedAPIInteractor {

    void loadFlickrPublicImagesFeed(IOnFlickFeedLoadFinisherListener listener);
}
