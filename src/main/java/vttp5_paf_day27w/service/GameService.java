package vttp5_paf_day27w.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5_paf_day27w.model.Review;
import vttp5_paf_day27w.repo.GameRepo;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo; 

    public List<Review> getAllReviews() {

        return gameRepo.getAllReviews();

    }

    // TASK A
    // check if meets conditions before inserting TODO
    public String insertReview(Map<String, String> data) {

        Review r = mapToReviewPojo(data);

        return gameRepo.insertReview(r);

    }

    // helper method 
    // Map<String, String> --> Review POJO 
    private Review mapToReviewPojo(Map<String, String> data) {

        Review r = new Review(); 
        r.setUser(data.get("user"));
        r.setRating(Integer.valueOf(data.get("rating")));
        r.setComment(data.get("comment"));
        r.setID(Integer.valueOf(data.get("ID")));

        r.setPosted(stringToDate(data.get("posted")));

        r.setName(data.get("name"));

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
    
}
