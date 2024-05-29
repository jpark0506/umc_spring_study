package umc.study.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.study.domain.Reviews;
import umc.study.domain.Stores;
import umc.study.domain.Users;
import umc.study.service.StoreService.StoreQueryServiceImpl;
import umc.study.service.UserService.UserQueryServiceImpl;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

@Component
public class ReviewConverter {

    @Autowired
    private UserQueryServiceImpl userQueryService;
    @Autowired
    private StoreQueryServiceImpl storeQueryService;

    public static ReviewResponseDTO.CreateReviewResponseDTO tojoinResultDTO(Reviews reviews){
        return ReviewResponseDTO.CreateReviewResponseDTO.builder()
                .reviewId(reviews.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public Reviews toReview(ReviewRequestDTO.CreateReviewRequestDTO request){

        Users user = userQueryService.findById(request.getUserId());
        Stores store = storeQueryService.findById(request.getStoreId());

        return Reviews.builder()
                .reviewContent(request.getReview_content())
                .reviewScore(request.getReview_score())
                .user(user)
                .store(store).build();
    }
}
