package vttp5_paf_day27w.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day27w.model.UpdateReview;
import vttp5_paf_day27w.service.ReviewService;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService; 

    // get all reviews 
    @GetMapping("")
    public ResponseEntity<Object> getAllReviews() {

        return ResponseEntity.ok()
            .body(reviewService.getAllReviews());

    }

    // TODO error handling incomplete 
    // throw error if user input is not valid 
    // TASK A 
    // POST /review 
    // Content-Type: application/x-www-form-urlencoded
    @PostMapping(value = "/review", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Object> addReview(@RequestParam Map<String, String> data) {

        return ResponseEntity.ok()
            .body(reviewService.insertReview(data));

    }

    // test game id exists 
    @GetMapping("/test/{review_id}")
    public ResponseEntity<Object> checkReviewIdExists(@PathVariable String review_id) {

        return ResponseEntity.ok()
            .body(reviewService.checkReviewIdExists(review_id));

    }
    
    // TODO error handling incomplete
    // TODO check rating is between 0 and 10 
    // TODO allow empty comment field
    // TASK B 
    // PUT /review/<review_id> 
    // Content-Type: application/json
    @PutMapping("/review/{review_id}") 
    public ResponseEntity<Object> updateReview(@RequestBody UpdateReview updateReview,
        @PathVariable String review_id) {

        if (review_id.length() < 24 || reviewService.checkReviewIdExists(review_id).isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("Error", "Review ID is invalid"));

        } 

        return ResponseEntity.ok()
            .body(reviewService.updateReview(updateReview, review_id));

    }

    // TASK C 
    // GET /review/<review_id>
    // Accept: application/json
    @GetMapping("/review/{review_id}")
    public ResponseEntity<Object> getReviewById(@PathVariable String review_id) {

        if (review_id.length() < 24 || reviewService.checkReviewIdExists(review_id).isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("Error", "Review ID is invalid"));

        } 

        return ResponseEntity.ok()
            .body(reviewService.getReviewById(review_id));

    }

    // TASK D 
    // GET /review/<review_id>/history 
    // Accept: application/json
    @GetMapping("/review/{review_id}/history")
    public ResponseEntity<Object> getReviewHistory(@PathVariable String review_id) {

        if (review_id.length() < 24 || reviewService.checkReviewIdExists(review_id).isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("Error", "Review ID is invalid"));

        } 

        return ResponseEntity.ok()
            .body(reviewService.getReviewHistory(review_id));

    }

}
