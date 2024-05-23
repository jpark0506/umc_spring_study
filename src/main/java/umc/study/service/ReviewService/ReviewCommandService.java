package umc.study.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.Reviews;
import umc.study.web.dto.ReviewRequestDTO;


public interface ReviewCommandService {

    Reviews joinReview(ReviewRequestDTO.JoinDTO request);

}
