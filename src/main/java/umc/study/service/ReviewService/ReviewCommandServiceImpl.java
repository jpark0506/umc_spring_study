package umc.study.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Reviews;
import umc.study.repository.ReviewRepository;
import umc.study.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;
    private final ReviewConverter reviewConverter;

    @Override
    public Reviews createReview(ReviewRequestDTO.CreateReviewRequestDTO request) {
        Reviews review = reviewConverter.toReview(request);
        return reviewRepository.save(review);
    }

}
