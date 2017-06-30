package com.epam.androidlab.instagramclient.entity;


public class Media {
    private int id;
    private String type;
    private String time;
    private Images images;

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // private HashMap<User,User.Position> userInPhoto;
    // private String filter;
    //private String tag;
    /*private ArrayList<User> whoLikes;
    private ArrayList<User> whoComments;


    private String dateOfPublishing;
    private String description;*/

}
