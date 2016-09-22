package akshay.example.com.flipimagegrid.presenters;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import akshay.example.com.flipimagegrid.model.Interactors.FeedAPIInteractor;
import akshay.example.com.flipimagegrid.model.Interactors.interactor_interfaces.IFlickrFeedAPIInteractor;
import akshay.example.com.flipimagegrid.model.ViewModel;
import akshay.example.com.flipimagegrid.model.pojo.FlickrImageFeed;
import akshay.example.com.flipimagegrid.presenters.presenter_interfaces.IOnFlickFeedLoadFinisherListener;
import akshay.example.com.flipimagegrid.view.view_interfaces.IMainActivityContract;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

/**
 * Created by akshay on 22/09/16.
 */
public class FeedPresenterTest {

    private FeedPresenter mFeedPresenter;
    private IFlickrFeedAPIInteractor mFeedAPIInteractor;
    private FlickrImageFeed mFlickrImageFeed;
    private IMainActivityContract mContract;

    @Before
    public void setUp() throws Exception {
        mFeedAPIInteractor = mock(FeedAPIInteractor.class);
        mFeedPresenter = new FeedPresenter(mFeedAPIInteractor);
        mFlickrImageFeed = mock(FlickrImageFeed.class);
        mContract = mock(IMainActivityContract.class);


    }

    @Test
    public void testShouldScheduleFlickFeedLoadFromFeedAPIInteractor() {

        mFeedPresenter.fetchFlickrFeed();
        verify(mFeedAPIInteractor).loadFlickrPublicImagesFeed((IOnFlickFeedLoadFinisherListener) anyObject());
    }

    @Test
    public void testShouldCallViewFeedLoadSuccessMethod() {
        mFeedPresenter.setMainActivityContract(mContract);

        mFeedPresenter.onFlickrFeedLoadSuccess(mFlickrImageFeed);

        verify(mContract, times(1)).onFlickrFeedLoadSucess((List<ViewModel>) anyObject());
    }
}
