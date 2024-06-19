package com.example.recommend_.Service;


import com.example.recommend_.Repository.UserRatingRepository;
import com.example.recommend_.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    @Autowired
    private UserRatingRepository repository;

    public List<String> getRecommendations(String userId, int numOfProducts) {
        List<UserRating> userRatings = repository.findByUserId(userId);
        Map<String, List<UserRating>> productRatings = repository.findAll().stream()
                .collect(Collectors.groupingBy(UserRating::getProdId));

        // Convert to a matrix-like structure
        Map<String, Map<String, Double>> ratingsMatrix = new HashMap<>();
        for (UserRating rating : repository.findAll()) {
            ratingsMatrix
                    .computeIfAbsent(rating.getUserId(), k -> new HashMap<>())
                    .put(rating.getProdId(), rating.getRating());
        }

        // Calculate cosine similarity and get recommendations
        List<String> recommendations = new ArrayList<>();
        // Similarity and recommendation logic

        return recommendations;
    }
}


/*package com.example.recommender.service;

import com.example.recommender.model.UserRating;
import com.example.recommender.repository.UserRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserRatingRepository repository;

    public List<String> getRecommendations(String userId, int numOfProducts) {
        List<UserRating> userRatings = repository.findByUserId(userId);
        Map<String, List<UserRating>> productRatings = repository.findAll().stream()
                .collect(Collectors.groupingBy(UserRating::getProdId));

        // Convert to a matrix-like structure
        Map<String, Map<String, Double>> ratingsMatrix = new HashMap<>();
        for (UserRating rating : repository.findAll()) {
            ratingsMatrix
                    .computeIfAbsent(rating.getUserId(), k -> new HashMap<>())
                    .put(rating.getProdId(), rating.getRating());
        }

        // Calculate cosine similarity and get recommendations
        List<String> recommendations = new ArrayList<>();
        // Similarity and recommendation logic

        return recommendations;
    }
}
*/