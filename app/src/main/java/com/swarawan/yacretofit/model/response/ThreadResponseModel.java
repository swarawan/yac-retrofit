package com.swarawan.yacretofit.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rioswarawan on 11/24/16.
 */

public class ThreadResponseModel {

    @SerializedName("error")
    private boolean error;

    @SerializedName("message")
    private String message;

    @SerializedName("total")
    private int total;

    @SerializedName("data")
    private List<ThreadData> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<ThreadData> getData() {
        return data;
    }

    public void setData(List<ThreadData> data) {
        this.data = data;
    }

    public class ThreadData {

        @SerializedName("id")
        private int id;

        @SerializedName("title")
        private String title;

        @SerializedName("author_name")
        private String authorName;

        @SerializedName("image")
        private String image;

        @SerializedName("last_active")
        private String date;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
