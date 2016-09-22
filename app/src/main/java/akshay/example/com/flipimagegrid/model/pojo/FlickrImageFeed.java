package akshay.example.com.flipimagegrid.model.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akshay on 20/09/16.
 */
public class FlickrImageFeed {

    @JsonProperty("title")
    private String title;
    @JsonProperty("link")
    private String link;
    @JsonProperty("description")
    private String description;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("generator")
    private String generator;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();

    /**
     *
     * @return
     * The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        if (title == null) {
            this.title = "No title!";
        }
        this.title = title;
    }

    /**
     *
     * @return
     * The link
     */
    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The modified
     */
    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     * The modified
     */
    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return
     * The generator
     */
    @JsonProperty("generator")
    public String getGenerator() {
        return generator;
    }

    /**
     *
     * @param generator
     * The generator
     */
    @JsonProperty("generator")
    public void setGenerator(String generator) {
        this.generator = generator;
    }

    /**
     *
     * @return
     * The items
     */
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }


    public class Item {

        @JsonProperty("title")
        private String title;
        @JsonProperty("link")
        private String link;
        @JsonProperty("media")
        private Media media;
        @JsonProperty("date_taken")
        private String dateTaken;
        @JsonProperty("description")
        private String description;
        @JsonProperty("published")
        private String published;
        @JsonProperty("author")
        private String author;
        @JsonProperty("author_id")
        private String authorId;
        @JsonProperty("tags")
        private String tags;

        /**
         *
         * @return
         * The title
         */
        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        @JsonProperty("title")
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The link
         */
        @JsonProperty("link")
        public String getLink() {
            return link;
        }

        /**
         *
         * @param link
         * The link
         */
        @JsonProperty("link")
        public void setLink(String link) {
            this.link = link;
        }

        /**
         *
         * @return
         * The media
         */
        @JsonProperty("media")
        public Media getMedia() {
            return media;
        }

        /**
         *
         * @param media
         * The media
         */
        @JsonProperty("media")
        public void setMedia(Media media) {
            this.media = media;
        }

        /**
         *
         * @return
         * The dateTaken
         */
        @JsonProperty("date_taken")
        public String getDateTaken() {
            return dateTaken;
        }

        /**
         *
         * @param dateTaken
         * The date_taken
         */
        @JsonProperty("date_taken")
        public void setDateTaken(String dateTaken) {
            this.dateTaken = dateTaken;
        }

        /**
         *
         * @return
         * The description
         */
        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         *
         * @return
         * The published
         */
        @JsonProperty("published")
        public String getPublished() {
            return published;
        }

        /**
         *
         * @param published
         * The published
         */
        @JsonProperty("published")
        public void setPublished(String published) {
            this.published = published;
        }

        /**
         *
         * @return
         * The author
         */
        @JsonProperty("author")
        public String getAuthor() {
            return author;
        }

        /**
         *
         * @param author
         * The author
         */
        @JsonProperty("author")
        public void setAuthor(String author) {
            this.author = author;
        }

        /**
         *
         * @return
         * The authorId
         */
        @JsonProperty("author_id")
        public String getAuthorId() {
            return authorId;
        }

        /**
         *
         * @param authorId
         * The author_id
         */
        @JsonProperty("author_id")
        public void setAuthorId(String authorId) {
            this.authorId = authorId;
        }

        /**
         *
         * @return
         * The tags
         */
        @JsonProperty("tags")
        public String getTags() {
            return tags;
        }

        /**
         *
         * @param tags
         * The tags
         */
        @JsonProperty("tags")
        public void setTags(String tags) {
            this.tags = tags;
        }

    }


    public class Media {

        @JsonProperty("m")
        private String m;

        /**
         *
         * @return
         * The m
         */
        @JsonProperty("m")
        public String getM() {
            return m;
        }

        /**
         *
         * @param m
         * The m
         */
        @JsonProperty("m")
        public void setM(String m) {
            this.m = m;
        }

    }
}
