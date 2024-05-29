package umc.study.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class CreateReviewRequestDTO {
        String review_content;
        Integer review_score;
        Long storeId;
        Long userId;
    }
}
