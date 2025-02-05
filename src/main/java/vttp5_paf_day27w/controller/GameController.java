package vttp5_paf_day27w.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp5_paf_day27w.service.GameService;

@RestController
public class GameController {

    @Autowired
    private GameService gameService; 

    // get all reviews 
    @GetMapping("")
    public ResponseEntity<Object> getAllReviews() {

        return ResponseEntity.ok()
            .body(gameService.getAllReviews());

    }

    // TASK A 
    // POST /review 
    // Content-Type: application/x-www-form-urlencoded
    @PostMapping(value = "/review", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<Object> addReview(@RequestParam Map<String, String> data) {

        return ResponseEntity.ok()
            .body(gameService.insertReview(data));

        // return null;

    }
    
}
