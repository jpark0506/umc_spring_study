package umc.study.converter;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import umc.study.domain.Reviews;
import umc.study.domain.Users;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter
{
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(Users user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Users toUser(UserRequestDTO.JoinDTO request){
        Gender gender = null;
        switch(request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }
        return Users.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .gender(gender)
                .address(request.getAddress())
                .userFoodPreferences(new ArrayList<>())
                .build();

    }

    public static UserResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Reviews review){
        return UserResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getUser().getName())
                .score(review.getReviewScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getReviewContent())
                .build();
    }

    public static UserResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Reviews> reviewList){
        List<UserResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(UserConverter::reviewPreViewDTO).collect(Collectors.toList());

        return UserResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }


}
