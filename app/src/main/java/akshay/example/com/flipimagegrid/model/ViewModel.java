package akshay.example.com.flipimagegrid.model;

/**
 * Created by akshay on 21/09/16.
 */
public class ViewModel {

    String title;
    String imageUrl;
    Boolean flipped;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getFlipped() {
        return flipped;
    }

    public void setFlipped(Boolean flipped) {
        this.flipped = flipped;
    }
}
