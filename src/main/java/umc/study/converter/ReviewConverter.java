package umc.study.converter;

import org.springframework.beans.factory.annotation.Autowired;
import umc.study.domain.Reviews;
import umc.study.domain.Stores;
import umc.study.domain.Users;
import umc.study.service.StoreService.StoreQueryServiceImpl;
import umc.study.service.UserService.UserQueryServiceImpl;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;


public class ReviewConverter {


    private static UserQueryServiceImpl userQueryService;
    private static StoreQueryServiceImpl storeQueryService;

    public static ReviewResponseDTO.JoinResultDTO tojoinResultDTO(Reviews reviews){
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(reviews.getId())
                .createdAt(reviews.getCreatedAt())
                .build();
    }
    public static Reviews toReview(ReviewRequestDTO.JoinDTO request){

        Users user = userQueryService.findById(request.getUserId());
        Stores store = storeQueryService.findById(request.getStoreId());

        //에러 코드 수정하기(Exception에 맞춰서)
        if(user == null){
            throw new IllegalArgumentException("Invalid Id");
        }
        if(store == null){
            throw new IllegalArgumentException("Invalid Store");
        }

        return Reviews.builder()
                .reviewContent(request.getReview_content())
                .reviewScore(request.getReview_score())
                .user(user)
                .store(store).build();
    }
}
