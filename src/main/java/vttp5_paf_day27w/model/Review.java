package vttp5_paf_day27w.model;

import java.util.Date;

public class Review {

    private String user; 
    private int rating; 
    private String comment; 
    private int ID; 
    private Date posted;
    private String name;
    public Review() {
    }
    public Review(String user, int rating, String comment, int iD, Date posted, String name) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
        ID = iD;
        this.posted = posted;
        this.name = name;
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
}

// {
//     "user": "jo yie 2",
//     "rating": 5,
//     "comment": "comment",
//     "ID": 1,
//     "posted": "2025-02-02",
//     "name": "board game"
// }