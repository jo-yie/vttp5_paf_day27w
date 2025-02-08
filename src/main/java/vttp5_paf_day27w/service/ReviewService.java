package vttp5_paf_day27w.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5_paf_day27w.model.RetrieveReview;
import vttp5_paf_day27w.model.Review;
import vttp5_paf_day27w.model.UpdateReview;
import vttp5_paf_day27w.repo.ReviewRepo;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepo reviewRepo; 

    public List<Review> getAllReviews() {

        return reviewRepo.getAllReviews();

    }

    // TASK A
    public String insertReview(Map<String, String> data) {

        Review r = mapToReviewPojo(data);

        if (checkReview(r) != null) {
            return checkReview(r);

        }

        return reviewRepo.insertReview(r);

    }

    // helper method 
    // Map<String, String> --> Review POJO 
    private Review mapToReviewPojo(Map<String, String> data) {

        Review r = new Review(); 
        r.setUser(data.get("user"));
        r.setRating(Integer.valueOf(data.get("rating")));
        r.setComment(data.get("comment"));

        int gameId = Integer.valueOf(data.get("ID"));
        r.setID(gameId);

        r.setPosted(new java.util.Date());

        r.setName(getGameNameById(gameId));

        return r;

    }

    // helper method 
    // String --> Date 
    private Date stringToDate(String dateString) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateNew = new Date();

        try {
            dateNew = sdf.parse(dateString);

        } catch (ParseException e) {
            System.out.println(e.getMessage());

        }

        return dateNew;

    }
    
    // helper method 
    // check if conditions are met for valid Review insert
    public String checkReview(Review review) {

        // user --> not null 
        String user = review.getUser();
        if (user.isEmpty() || user.isBlank()) {
            return "User name field cannot be empty";

        }

        // rating --> not null & between 0 and 10 
        else if (Integer.valueOf(review.getRating()) == null) {
            return "Rating field cannot be empty";

        }

        else if (Integer.valueOf(review.getRating()) > 10 || Integer.valueOf(review.getRating()) < 0) {
            return "Rating must be between 0 and 10";

        }

        // game id --> must be valid game id from games collection
        else if (checkGameIdExists(review.getID()) == null) {
            return "Game ID doesn't exist";

        }

        return null;

    }

    // helper method 
    // check if valid game id from game collection 
    // set game name based on id 
    public Document checkGameIdExists(int gameId) {

        Optional<Document> document = reviewRepo.checkGameIdExists(gameId);

        if (document.isEmpty()) {
            return null;

        } else {
            return document.get();

        }

    }

    // helper method 
    public String getGameNameById(int gameId) {

        Document document = checkGameIdExists(gameId);
        String gameName = document.getString("name");
        return gameName;

    }

    // TASK B 
    public int updateReview(UpdateReview updateReview, String reviewId) {

        updateReview.setPosted(new java.util.Date());
        return reviewRepo.updateReview(updateReview, reviewId);

    } 

    // helper method 
    // check review "_id" exists
    public Optional<Document> checkReviewIdExists(String id) {

        return reviewRepo.checkReviewIdExists(id);

    }

    // TASK C 
    public RetrieveReview getReviewById(String reviewId) {

        Document document = reviewRepo.checkReviewIdExists(reviewId).get();
        return documentToRetrieveReviewPojo(document);

    }

    // helper method 
    // Document --> RetrieveReview POJO 
    public RetrieveReview documentToRetrieveReviewPojo(Document document) {

        RetrieveReview r = new RetrieveReview(); 

        r.setUser(document.getString("user"));
        r.setRating(document.getInteger("rating"));
        r.setComment(document.getString("comment"));
        r.setID(document.getInteger("ID"));
        r.setPosted(document.getDate("posted"));
        r.setName(document.getString("name"));

        if (document.get("edited") != null) {
            r.setEdited(true);
        } else {
            r.setEdited(false);
        }

        r.setTimestamp(new Date());

        return r;

    }

}
