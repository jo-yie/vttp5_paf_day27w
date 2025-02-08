package vttp5_paf_day27w.model;

import java.util.Date;
import java.util.List;

public class ReviewHistory {

    private String user; 
    private int rating; 
    private String comment; 
    private int id; 
    private Date posted; 
    private String name; 
    private List<UpdateReview> edited; 
    private Date timestamp;
    public ReviewHistory() {
    }
    public ReviewHistory(String user, int rating, String comment, int id, Date posted, String name,
            List<UpdateReview> edited, Date timestamp) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
        this.id = id;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public List<UpdateReview> getEdited() {
        return edited;
    }
    public void setEdited(List<UpdateReview> edited) {
        this.edited = edited;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    } 
}
