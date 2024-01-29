package com.example.project_acadeamease1;
<<<<<<< Updated upstream
public class DataClass {

    private String imageURL, caption;

    public DataClass(String string, String caption) {
        // Default constructor required for Firebase
=======

public class DataClass {
    private String imageURL, caption;

    public DataClass(){

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
}
=======

    public DataClass(String imageURL, String caption) {
        this.imageURL = imageURL;
        this.caption = caption;
    }
}
>>>>>>> Stashed changes
