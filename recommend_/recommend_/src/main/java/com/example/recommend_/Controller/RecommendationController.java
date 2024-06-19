package com.example.recommend_.Controller;


import com.example.recommend_.Service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecommendationController {
    @Autowired
    private RecommendationService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/recommend")
    public String recommend(String userId, int numOfProducts, Model model) {
        try {
            model.addAttribute("recommendations", service.getRecommendations(userId, numOfProducts));
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "index";
    }
}

