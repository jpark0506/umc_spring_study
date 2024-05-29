package umc.study.service.ReviewService;


import umc.study.domain.Reviews;
import umc.study.web.dto.ReviewRequestDTO;


public interface ReviewCommandService {

    Reviews createReview(ReviewRequestDTO.CreateReviewRequestDTO request);

}
