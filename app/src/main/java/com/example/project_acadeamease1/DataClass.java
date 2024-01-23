package com.example.project_acadeamease1;
public class DataClass {

    private String imageURL, caption;

    public DataClass(String string, String caption) {
        // Default constructor required for Firebase
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
