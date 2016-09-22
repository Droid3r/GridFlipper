package akshay.example.com.flipimagegrid.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import akshay.example.com.flipimagegrid.ImageGrid;
import akshay.example.com.flipimagegrid.R;
import akshay.example.com.flipimagegrid.model.ViewModel;
import akshay.example.com.flipimagegrid.model.pojo.FlickrImageFeed;
import akshay.example.com.flipimagegrid.presenters.FeedPresenter;
import akshay.example.com.flipimagegrid.util.Utils;
import akshay.example.com.flipimagegrid.view.adapters.FeedGridAdapter;
import akshay.example.com.flipimagegrid.view.view_interfaces.IMainActivityContract;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements IMainActivityContract {

    @Inject
    FeedPresenter mFeedPresenter;

    @InjectView(R.id.image_recycler_view)
    RecyclerView mRecyclerView;

    @InjectView(R.id.error_view)
    TextView mErrorView;

    private FeedGridAdapter mFeedGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        ((ImageGrid)getApplication()).getAppComponent().inject(this);
        initRecyclerView();

        mFeedPresenter.setMainActivityContract(this);

        mFeedPresenter.fetchFlickrFeed();
        Utils.showSimpleProgressDialog(this, getResources().getString(R.string.loading_data)
                , getResources().getString(R.string.loading_msg), false);

    }

    public void initRecyclerView() {

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mRecyclerView.getContext(), 2));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mFeedGridAdapter = new FeedGridAdapter(this);
        mRecyclerView.setAdapter(mFeedGridAdapter);

    }

    @Override
    public void onFlickrFeedLoadSucess(List<ViewModel> imageFeed) {
        Log.d("Main", "success called");
        Utils.removeSimpleProgressDialog();
        hideError();

        mFeedGridAdapter.addItems(imageFeed);
    }

    @Override
    public void onFlickrFeedLoadError(String message) {
        Utils.removeSimpleProgressDialog();
        showError();
    }

    private void hideError() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
    }

    private void showError() {
        mRecyclerView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
    }
}
