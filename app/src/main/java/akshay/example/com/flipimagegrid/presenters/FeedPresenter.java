package akshay.example.com.flipimagegrid.presenters;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import akshay.example.com.flipimagegrid.model.Interactors.interactor_interfaces.IFlickrFeedAPIInteractor;
import akshay.example.com.flipimagegrid.model.ViewModel;
import akshay.example.com.flipimagegrid.model.pojo.FlickrImageFeed;
import akshay.example.com.flipimagegrid.presenters.presenter_interfaces.IOnFlickFeedLoadFinisherListener;
import akshay.example.com.flipimagegrid.view.view_interfaces.IMainActivityContract;

/**
 * Created by akshay on 21/09/16.
 */
public class FeedPresenter implements IOnFlickFeedLoadFinisherListener {

    private IFlickrFeedAPIInteractor mFeedAPIInteractor;
    private IMainActivityContract mIMainActivityContract;

    @Inject
    public FeedPresenter(IFlickrFeedAPIInteractor interactor) {
        this.mFeedAPIInteractor = interactor;
    }

    public void setMainActivityContract(IMainActivityContract contract) {
        this.mIMainActivityContract = contract;
    }

    public void fetchFlickrFeed() {
        mFeedAPIInteractor.loadFlickrPublicImagesFeed(this);
    }


    @Override
    public void onFlickrFeedLoadSuccess(FlickrImageFeed feed) {
        List<ViewModel> modelList = new ArrayList<>();
        for (FlickrImageFeed.Item item : feed.getItems()) {
            ViewModel model = new ViewModel();
            model.setFlipped(false);
            model.setImageUrl(item.getMedia().getM());
            String title = item.getTitle();
            if (title != null && !title.trim().isEmpty()) {
                model.setTitle(item.getTitle());
            } else {
                model.setTitle("No Title!");
            }
            modelList.add(model);

        }
        mIMainActivityContract.onFlickrFeedLoadSucess(modelList);
    }

    @Override
    public void onFlickrFeedLoadFailure(String message) {
        mIMainActivityContract.onFlickrFeedLoadError(message);
    }
}
