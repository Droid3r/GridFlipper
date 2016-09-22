package akshay.example.com.flipimagegrid.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import akshay.example.com.flipimagegrid.R;
import akshay.example.com.flipimagegrid.model.ViewModel;
import akshay.example.com.flipimagegrid.model.pojo.FlickrImageFeed;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by akshay on 21/09/16.
 */
public class FeedGridAdapter extends RecyclerView.Adapter<FeedGridAdapter.ViewHolder> {
    private List<ViewModel> mFeedList;
    private Context mContext;
    private int flippedPosition = -1;

    public FeedGridAdapter(Context context) {
        this.mFeedList = new ArrayList<>();
        this.mContext = context;
    }
    public void addItems(List<ViewModel> newFeed) {
        mFeedList.addAll(newFeed);
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String title = mFeedList.get(position).getTitle();
        final int clickPosition = position;
        if (title.length() > 50) title = title.substring(0, 50);
        holder.tvImageTitle.setText(title);
        Picasso.with(mContext)
                .load(mFeedList.get(position).getImageUrl())
                .fit()
                .centerCrop()
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error)
                .into(holder.ivFeedImage);

        holder.vfImageFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flippedPosition == clickPosition) {
                    notifyItemChanged(flippedPosition);
                    flippedPosition = -1;
                } else {
                    notifyItemChanged(flippedPosition);
                    flippedPosition = clickPosition;
                    notifyItemChanged(flippedPosition);
                }

            }

        });
        if (flippedPosition == position) {
            holder.vfImageFlipper.setDisplayedChild(1);
        } else {
            holder.vfImageFlipper.setDisplayedChild(0);
        }

    }

    @Override
    public int getItemCount() {
        return mFeedList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        @InjectView(R.id.image_title)
        TextView tvImageTitle;
        @InjectView(R.id.feed_image)
        ImageView ivFeedImage;

        @InjectView(R.id.view_flipper)
        ViewFlipper vfImageFlipper;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);

        }
    }
}
