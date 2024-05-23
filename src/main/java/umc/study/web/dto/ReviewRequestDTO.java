package umc.study.web.dto;

import lombok.Getter;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDTO{
        String review_content;
        Integer review_score;
        Long storeId;
        Long userId;
    }
}
