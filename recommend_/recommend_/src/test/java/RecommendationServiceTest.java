import com.example.recommend_.Repository.UserRatingRepository;
import com.example.recommend_.Service.RecommendationService;
import com.example.recommend_.model.UserRating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecommendationServiceTest {

    @InjectMocks
    private RecommendationService service;

    @Mock
    private UserRatingRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRecommendations() {
        UserRating rating1 = new UserRating("user1", "prod1", 5.0);
        UserRating rating2 = new UserRating("user1", "prod2", 4.0);
        UserRating rating3 = new UserRating("user2", "prod1", 5.0);
        UserRating rating4 = new UserRating("user2", "prod3", 3.0);

        when(repository.findByUserId("user1")).thenReturn(Arrays.asList(rating1, rating2));
        when(repository.findAll()).thenReturn(Arrays.asList(rating1, rating2, rating3, rating4));

        List<String> recommendations = service.getRecommendations("user1", 1);
        assertEquals(1, recommendations.size());
        assertEquals("prod3", recommendations.get(0));
    }
}

