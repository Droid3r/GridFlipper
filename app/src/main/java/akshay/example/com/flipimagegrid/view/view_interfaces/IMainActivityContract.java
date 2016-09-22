package akshay.example.com.flipimagegrid.view.view_interfaces;

import java.util.List;

import akshay.example.com.flipimagegrid.model.ViewModel;
import akshay.example.com.flipimagegrid.model.pojo.FlickrImageFeed;

/**
 * Created by akshay on 21/09/16.
 */
public interface IMainActivityContract {

    void onFlickrFeedLoadSucess(List<ViewModel> feed);
    void onFlickrFeedLoadError(String message);

}
