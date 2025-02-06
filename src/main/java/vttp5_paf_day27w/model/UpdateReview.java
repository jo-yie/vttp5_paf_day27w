package vttp5_paf_day27w.model;

import java.util.Date;

public class UpdateReview {

    private String comment; 
    private int rating; 
    private Date posted;
    public UpdateReview() {
    }
    public UpdateReview(String comment, int rating, Date posted) {
        this.comment = comment;
        this.rating = rating;
        this.posted = posted;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public Date getPosted() {
        return posted;
    }
    public void setPosted(Date posted) {
        this.posted = posted;
    } 
}
