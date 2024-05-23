package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.ReviewConverter;
import umc.study.domain.Reviews;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;
import umc.study.web.dto.UserRequestDTO;

@RestController
@RequiredArgsConstructor
@Valid
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO .JoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.JoinDTO request){
        Reviews review = reviewCommandService.joinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.tojoinResultDTO(review));
    }
}
