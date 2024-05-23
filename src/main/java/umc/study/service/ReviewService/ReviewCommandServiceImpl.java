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
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService{

    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Reviews joinReview(ReviewRequestDTO.JoinDTO request) {
        Reviews review = ReviewConverter.toReview(request);
        //Logic이 딱히 필요가 없는거 같은데
        return reviewRepository.save(review);
    }

}
