package vttp5_paf_day27w.model;

import java.util.Date;

public class RetrieveReview {

    private String user; 
    private int rating; 
    private String comment; 
    private int ID;
    private Date posted; 
    private String name; 
    private Boolean edited; 
    private Date timestamp;
    public RetrieveReview() {
    }
    public RetrieveReview(String user, int rating, String comment, int iD, Date posted, String name, Boolean edited,
            Date timestamp) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
        ID = iD;
        this.posted = posted;
        this.name = name;
        this.edited = edited;
        this.timestamp = timestamp;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public Date getPosted() {
        return posted;
    }
    public void setPosted(Date posted) {
        this.posted = posted;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getEdited() {
        return edited;
    }
    public void setEdited(Boolean edited) {
        this.edited = edited;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
