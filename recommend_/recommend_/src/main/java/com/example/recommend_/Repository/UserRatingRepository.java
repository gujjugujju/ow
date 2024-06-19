package com.example.recommend_.Repository;

import com.example.recommend_.model.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRatingRepository extends JpaRepository<UserRating, String> {
    List<UserRating> findByUserId(String userId);
}
